package pl.company.contactsOrganizer.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.company.contactsOrganizer.model.Contact;
import pl.company.contactsOrganizer.services.ContactsService;
import pl.company.contactsOrganizer.services.UsersService;

@Controller
public class LoginController {

	@Autowired
	private ContactsService cService;

	@Autowired
	private UsersService uService;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView showMainPage(ModelAndView model, Principal principal) {

		model.setViewName("mainPage");

		List<Contact> contactsList = cService.findCurrentContacts();
		model.addObject("list", contactsList);

		String name = principal.getName();
		uService.setAuthority(name);

		if (uService.isUserAdmin()) {
			model.addObject("isUserAdmin", true);
		}

		return model;
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public ModelAndView loginerror(ModelAndView model) {

		model.setViewName("loginPage");
		model.addObject("error", true);
		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(ModelAndView model) {

		uService.logoutUser();
		model.setViewName("loginPage");
		return model;
	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView model) {
		model.setViewName("loginPage");

		return model;
	}
}
