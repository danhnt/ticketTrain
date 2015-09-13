package train.domain.controller.account;

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

import train.domain.model.Account;
import train.domain.service.account.AccountService;

@Controller
@RequestMapping(value = "account")
public class AccountController {
	private static final String VIEW_FORM_PATH = "account/viewForm";
	private static final String MODIFY_FORM_PATH = "account/modifyForm";
	private static final String REDIRECT_SEARCH = "redirect:/account/view";

	@Inject
	AccountService accountService;
	@Inject
	Mapper beanMapper;

	@ModelAttribute
	public AccountForm setUpAccountForm() {
		AccountForm form = new AccountForm();
		return form;
	}

	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String displaySearch(@ModelAttribute AccountForm accountForm,
			Model model) {
		List<Account> accountList = accountService.findAll();
		model.addAttribute("accountList", accountList);
		return VIEW_FORM_PATH;
	}

	/**
	 * Return to edit a domainDesign screen
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String displayModify(@RequestParam("id") Integer id, Model model,
			RedirectAttributes redirectAttr) {
		AccountForm obj = new AccountForm();
		Account account = accountService.findOne(id);
		obj = beanMapper.map(account, AccountForm.class);

		if (null == account) {
			return "redirect:/account/view";
		} else {
			model.addAttribute("accountForm", obj);
			return MODIFY_FORM_PATH;
		}
	}

	public String displayModify(AccountForm domainForm, Model model) {
		model.addAttribute("accountForm", domainForm);
		return MODIFY_FORM_PATH;
	}

	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String processModify(
			@Validated @ModelAttribute AccountForm accountForm,
			BindingResult result, RedirectAttributes redirectAttr, Model model) {
		if (result.hasErrors()) {
			return displayModify(accountForm, model);
		}
		Account acount = beanMapper.map(accountForm, Account.class);
		boolean update = accountService.modify(acount);
		if (update) {
			return REDIRECT_SEARCH;
		} else {
			return REDIRECT_SEARCH;
		}
	}

	@RequestMapping(value = "delete")
	public String processDelete(@RequestParam("id") Integer id, Model model,
			RedirectAttributes redirectAttr) {

		boolean deleted = accountService.delete(id);
		if (deleted) {
			redirectAttr.addFlashAttribute("message", "deleteSuccess");
		} else {
			redirectAttr.addFlashAttribute("message", "delete Fail");
			return REDIRECT_SEARCH;
		}
		return REDIRECT_SEARCH;
	}

}
