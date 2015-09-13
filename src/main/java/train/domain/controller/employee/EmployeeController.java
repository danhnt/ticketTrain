package train.domain.controller.employee;

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

import train.domain.model.NhanVien;
import train.domain.service.employee.EmployeeService;

@Controller
@RequestMapping(value = "employee")
public class EmployeeController {
	private static final String VIEW_FORM_PATH = "employee/viewForm";
	private static final String MODIFY_FORM_PATH = "employee/modifyForm";
	private static final String REDIRECT_SEARCH = "redirect:/employee/view";

	@Inject
	EmployeeService employeeService;
	@Inject
	Mapper beanMapper;

	@ModelAttribute
	public EmployeeForm setUpAccountForm() {
		EmployeeForm form = new EmployeeForm();
		return form;
	}

	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String displaySearch(@ModelAttribute EmployeeForm employeeForm,
			Model model) {
		List<NhanVien> employeeList = employeeService.findAll();
		model.addAttribute("employeelist", employeeList);
		return VIEW_FORM_PATH;
	}

	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String displayModify(@RequestParam("id") Integer id, Model model,
			RedirectAttributes redirectAttr) {
		EmployeeForm obj = new EmployeeForm();
		NhanVien nhanvien = employeeService.findOne(id);
		obj = beanMapper.map(nhanvien, EmployeeForm.class);

		if (null != nhanvien) {
			model.addAttribute("employeeForm", obj);
			return MODIFY_FORM_PATH;
		} else {
			return "redirect:/employee/view";
		}
	}

	public String displayModify(EmployeeForm employeeForm, Model model) {
		model.addAttribute("employeeForm", employeeForm);
		return MODIFY_FORM_PATH;
	}

	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String processModify(
			@Validated @ModelAttribute EmployeeForm employeeForm,
			BindingResult result, RedirectAttributes redirectAttr, Model model) {
		if (result.hasErrors()) {
			return displayModify(employeeForm, model);
		}
		NhanVien nhanvien = beanMapper.map(employeeForm, NhanVien.class);
		boolean update = employeeService.modify(nhanvien);
		if (update) {
			return REDIRECT_SEARCH;
		} else {
			return REDIRECT_SEARCH;
		}
	}

	@RequestMapping(value = "delete")
	public String processDelete(@RequestParam("id") Integer id, Model model,
			RedirectAttributes redirectAttr) {

		boolean deleted = employeeService.delete(id);
		if (deleted) {
			redirectAttr.addFlashAttribute("message", "deleteSuccess");
		} else {
			redirectAttr.addFlashAttribute("message", "delete Fail");
			return REDIRECT_SEARCH;
		}
		return REDIRECT_SEARCH;
	}

}
