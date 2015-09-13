package train.domain.controller.khachhang;

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

import train.domain.model.KhachHang;
import train.domain.service.khachhang.KhachHangService;

@Controller
@RequestMapping(value = "khachhang")
public class KhachHangController {
	private static final String VIEW_FORM_PATH = "khachhang/viewForm";
	private static final String MODIFY_FORM_PATH = "khachhang/modifyForm";
	private static final String REDIRECT_SEARCH = "redirect:/khachhang/view";

	@Inject
	KhachHangService khachhangService;
	@Inject
	Mapper beanMapper;

	@ModelAttribute
	public KhachHangForm setUpAccountForm() {
		KhachHangForm form = new KhachHangForm();
		return form;
	}

	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String displaySearch(@ModelAttribute KhachHangForm employeeForm,
			Model model) {
		List<KhachHang> khachhangList = khachhangService.findAll();
		model.addAttribute("khachhangList", khachhangList);
		return VIEW_FORM_PATH;
	}

	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String displayModify(@RequestParam("id") Integer id, Model model,
			RedirectAttributes redirectAttr) {
		KhachHangForm obj = new KhachHangForm();
		KhachHang khachhang = khachhangService.findOne(id);
		obj = beanMapper.map(khachhang, KhachHangForm.class);

		if (null != khachhang) {
			model.addAttribute("khachHangForm", obj);
			return MODIFY_FORM_PATH;
		} else {
			return "redirect:/khachhang/view";
		}
	}

	public String displayModify(KhachHangForm khachhangForm, Model model) {
		model.addAttribute("khachhangForm", khachhangForm);
		return MODIFY_FORM_PATH;
	}

	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String processModify(
			@Validated @ModelAttribute KhachHangForm khachhangForm,
			BindingResult result, RedirectAttributes redirectAttr, Model model) {
		if (result.hasErrors()) {
			return displayModify(khachhangForm, model);
		}
		KhachHang khachHang = beanMapper.map(khachhangForm, KhachHang.class);
		boolean update = khachhangService.modify(khachHang);
		if (update) {
			return REDIRECT_SEARCH;
		} else {
			return REDIRECT_SEARCH;
		}
	}

	@RequestMapping(value = "delete")
	public String processDelete(@RequestParam("id") Integer id, Model model,
			RedirectAttributes redirectAttr) {

		boolean deleted = khachhangService.delete(id);
		if (deleted) {
			redirectAttr.addFlashAttribute("message", "deleteSuccess");
		} else {
			redirectAttr.addFlashAttribute("message", "delete Fail");
			return REDIRECT_SEARCH;
		}
		return REDIRECT_SEARCH;
	}

}
