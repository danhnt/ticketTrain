package train.domain.controller.tintuc;

import java.util.List;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import train.domain.model.Tintuc;
import train.domain.service.tintuc.TintucService;

@Controller
@RequestMapping(value = "tintuc")
public class TintucController {
	private static final String VIEW_FORM_PATH = "tintuc/viewForm";
	private static final String MODIFY_FORM_PATH = "tintuc/modifyForm";
	private static final String REDIRECT_SEARCH = "redirect:/tintuc/view";

	@Inject
	TintucService tintucService;
	@Inject
	Mapper beanMapper;

	@ModelAttribute
	public TintucForm setUpTintucForm() {
		TintucForm form = new TintucForm();
		return form;
	}

	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String displaySearch(@ModelAttribute TintucForm tintucForm,
			Model model) {
		List<Tintuc> tintucList = tintucService.findAll();
		model.addAttribute("tintucList", tintucList);
		return VIEW_FORM_PATH;
	}

	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String displayModify(@RequestParam("id") Integer id, Model model,
			RedirectAttributes redirectAttr) {
		TintucForm obj = new TintucForm();
		Tintuc tintuc = tintucService.findOne(id);
		obj = beanMapper.map(tintuc, TintucForm.class);

		if (null != tintuc) {
			model.addAttribute("tintucForm", obj);
			return MODIFY_FORM_PATH;
		} else {
			return "redirect:/tintuc/view";
		}
	}

	public String displayModify(TintucForm tintucForm, Model model) {
		model.addAttribute("tintucForm", tintucForm);
		return MODIFY_FORM_PATH;
	}

	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String processModify(
			@Validated @ModelAttribute TintucForm tintucForm,
			BindingResult result, RedirectAttributes redirectAttr, Model model) {
		if (result.hasErrors()) {
			return displayModify(tintucForm, model);
		}
		Tintuc khachHang = beanMapper.map(tintucForm, Tintuc.class);
		boolean update = tintucService.modify(khachHang);
		if (update) {
			return REDIRECT_SEARCH;
		} else {
			return REDIRECT_SEARCH;
		}
	}

	@RequestMapping(value = "delete")
	public String processDelete(@RequestParam("id") Integer id, Model model,
			RedirectAttributes redirectAttr) {

		boolean deleted = tintucService.delete(id);
		if (deleted) {
			redirectAttr.addFlashAttribute("message", "deleteSuccess");
		} else {
			redirectAttr.addFlashAttribute("message", "delete Fail");
			return REDIRECT_SEARCH;
		}
		return REDIRECT_SEARCH;
	}

}
