package pl.company.contacts.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.company.contacts.domain.Contact;
import pl.company.contacts.domain.User;
import pl.company.contacts.services.impl.ContactsServiceImpl;
import pl.company.contacts.services.impl.UsersServiceImpl;

@Controller
@RequestMapping(value="/main")
public class HomeController {

	@Autowired
	private ContactsServiceImpl cService;
	@Autowired
	UsersServiceImpl uService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showMainPage(Model model, Principal principal) {

		List<Contact> contactsList = cService.findCurrentContacts();
		model.addAttribute("list", contactsList);

		String name = principal.getName();
		uService.setAuthority(name);

		if (uService.isUserAdmin()) {
			model.addAttribute("isUserAdmin", true);
		}
		return "mainPage";
	}

	@RequestMapping(value = "/submitNewContact", method = RequestMethod.POST)
	public String submitNew(@Valid @ModelAttribute("contact") Contact contact, BindingResult result, Model model) {

		if (!result.hasErrors()) {
			cService.addNewContact(contact);
			return "redirect:/main";
		} else {
			List<Contact> contactsList = cService.findCurrentContacts();
			model.addAttribute("list", contactsList);
			model.addAttribute("Visible", true);
			if (uService.isUserAdmin()) {
				model.addAttribute("isUserAdmin", true);
			}
			return "mainPage";
		}		
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String goToAdminPage(Model model, Principal principal) {

		List<User> usersList = uService.findCurrentUsers();
		model.addAttribute("usersList", usersList);

		String userName = principal.getName();
		model.addAttribute("adminName", userName);
		return "adminPage";
	}
}
