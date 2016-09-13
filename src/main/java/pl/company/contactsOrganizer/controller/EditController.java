package pl.company.contactsOrganizer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.company.contactsOrganizer.model.Contact;
import pl.company.contactsOrganizer.services.ContactsService;

@Controller
public class EditController {

	@Autowired
	private ContactsService cService;

	@RequestMapping(value = "/main/edit/delete", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam("id") int id) {

		ModelAndView model;
		Contact contact = cService.getContact(id);
		cService.removeContact(contact);
		model = new ModelAndView("redirect:/main");
		return model;
	}

	@RequestMapping(value = "/main/edit/update", method = RequestMethod.POST)
	public ModelAndView updateContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result) {

		ModelAndView model;
		if (!result.hasErrors()) {
			cService.updateContact(contact);
			model = new ModelAndView("redirect:/main");
		} else {
			model = new ModelAndView("editPage");
			model.addObject("contact", contact);
			int id = contact.getId();
			Contact originalContact = cService.getContact(id);
			model.addObject("originalContact", originalContact);
		}
		return model;
	}

	@RequestMapping(value = "/main/edit/goBack", method = RequestMethod.GET)
	public ModelAndView backToMainPage() {
		ModelAndView model = new ModelAndView("redirect:/main");
		return model;
	}
}
