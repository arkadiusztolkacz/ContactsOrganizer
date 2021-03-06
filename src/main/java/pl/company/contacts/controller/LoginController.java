package pl.company.contacts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.company.contacts.services.UsersService;

@Controller
public class LoginController {

	@Autowired
	private UsersService uService;

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {

		model.addAttribute("error", true);
		return "loginPage";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {

		uService.logoutUser();
		return "loginPage";
	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String home() {

		return "loginPage";
	}
}
