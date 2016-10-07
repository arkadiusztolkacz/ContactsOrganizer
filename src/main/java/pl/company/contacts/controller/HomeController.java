package pl.company.contacts.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.company.contacts.domain.Contact;
import pl.company.contacts.domain.User;
import pl.company.contacts.services.ContactsService;
import pl.company.contacts.services.UsersService;

@Controller
@RequestMapping(value="/main")
public class HomeController {

	@Autowired
	private ContactsService cService;
	@Autowired
	UsersService uService;
	
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
	public String submitNew(@Valid @ModelAttribute("contact") Contact contact, BindingResult result, HttpServletRequest request, Model model) {

		if (!result.hasErrors()) {
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			cService.addNewContact(contact);
			cService.attachContactPic(contact, rootDirectory);
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
