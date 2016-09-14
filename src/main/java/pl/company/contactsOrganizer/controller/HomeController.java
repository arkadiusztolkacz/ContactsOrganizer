package pl.company.contactsOrganizer.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.company.contactsOrganizer.model.Contact;
import pl.company.contactsOrganizer.model.User;
import pl.company.contactsOrganizer.services.ContactsService;
import pl.company.contactsOrganizer.services.UsersService;

@Controller
public class HomeController {

	@Autowired
	private ContactsService cService;
	@Autowired
	UsersService uService;

	@RequestMapping(value = "/main/submitNewContact", method = RequestMethod.POST)
	public ModelAndView submitNew(@Valid @ModelAttribute("contact") Contact contact, BindingResult result) {

		ModelAndView model;
		if (!result.hasErrors()) {
			cService.addNewContact(contact);
			model = new ModelAndView("redirect:/main");
		} else {
			model = new ModelAndView("mainPage");
			List<Contact> contactsList = cService.findCurrentContacts();
			model.addObject("list", contactsList);
			model.addObject("Visible", true);
			if (uService.isUserAdmin()) {
				model.addObject("isUserAdmin", true);
			}
		}
		return model;
	}

	@RequestMapping(value = "/main/", method = RequestMethod.GET)
	public ModelAndView redirectToMainPage() {

		ModelAndView model = new ModelAndView("redirect:mainPage");
		return model;
	}

	@RequestMapping(value = "/main/admin", method = RequestMethod.GET)
	public ModelAndView goToAdminPage(Principal principal) {

		ModelAndView model = new ModelAndView("adminPage");
		List<User> usersList = uService.findCurrentUsers();
		model.addObject("usersList", usersList);

		String userName = principal.getName();
		model.addObject("adminName", userName);
		return model;
	}

	@RequestMapping(value = "/main/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editContact(@PathVariable("id") int id, ModelAndView model) {

		Contact contact = cService.getContact(id);
		model = new ModelAndView("editPage");
		model.addObject("contact", contact);
		model.addObject("originalContact", contact);

		return model;
	}
}
