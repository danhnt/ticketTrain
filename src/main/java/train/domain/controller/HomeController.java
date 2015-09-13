package train.domain.controller;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.validation.groups.Default;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import train.domain.controller.HomeController;
import train.domain.controller.TodoForm;
import train.domain.controller.TodoForm.TodoCreate;
import train.domain.model.Todo;
import train.domain.service.todo.TodoService;

@Controller
public class HomeController {
	@Inject
	TodoService todoService;

	@Inject
	Mapper beanMapper;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "welcome/home";
	}

	@ModelAttribute
	public TodoForm setUpForm() {
		TodoForm form = new TodoForm();
		return form;
	}

	@RequestMapping(value = "list", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String list(Model model) {
		Collection<Todo> todos = todoService.findAll();
		model.addAttribute("todos", todos);
		return "welcome/home";
	}

	//
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(
			@Validated({ Default.class, TodoCreate.class }) TodoForm todoForm,
			BindingResult bindingResult, Model model,
			RedirectAttributes attributes) {

		if (bindingResult.hasErrors()) {
			return list(model);
		}

		System.out.println(todoForm.getTodoTitle() + "test");

		Todo todo = beanMapper.map(todoForm, Todo.class);

		try {
			todoService.create(todo);
		} catch (Exception e) {
			model.addAttribute(e.getMessage());
			return list(model);
		}

		attributes.addFlashAttribute("Insert successfully!");
		return "redirect:/list";
	}
}
