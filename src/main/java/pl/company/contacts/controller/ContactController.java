package pl.company.contacts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.company.contacts.domain.Contact;
import pl.company.contacts.services.ContactsService;

@Controller
@RequestMapping(value="/main/contact")
public class ContactController {

	@Autowired
	private ContactsService cService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String editContact(@RequestParam("id") int id, Model model) {

		Contact contact = cService.getContact(id);
		model.addAttribute("contact", contact);
		model.addAttribute("originalContact", contact);

		return "contactPage";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("id") int id) {

		Contact contact = cService.getContact(id);
		cService.removeContact(contact);
		return "redirect:/main";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result, Model model) {

		if (!result.hasErrors()) {
			cService.updateContact(contact);
			return "redirect:/main/contact?id=" + contact.getId();
		} else {
			model.addAttribute("contact", contact);
			int id = contact.getId();
			Contact originalContact = cService.getContact(id);
			model.addAttribute("originalContact", originalContact);
			return "contactPage";
		}
	}
	
	@RequestMapping(value="/uploadPic", method = RequestMethod.POST)
	public String uploadPic(@ModelAttribute("contact") Contact contact, HttpServletRequest request, Model model){
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//		System.out.println(rootDirectory);
//		String substring = rootDirectory.substring(0, rootDirectory.indexOf("."));
//		System.out.println(substring);
//		String substring2 = rootDirectory.substring(rootDirectory.indexOf("Contacts"));
//		String substring3 = substring + substring2;
//		System.out.println(substring3);
		cService.attachContactPic(contact, rootDirectory);		
		return "redirect:/main/contact?id=" + contact.getId();
	}
}
