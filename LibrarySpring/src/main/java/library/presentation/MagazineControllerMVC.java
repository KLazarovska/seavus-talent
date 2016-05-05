package library.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import library.domain.Magazine;
import library.domain.Publication;
import library.service.PublicationServices;

@Controller
@RequestMapping("/magazines")
public class MagazineControllerMVC {

	@Autowired
	PublicationServices service;

	@ModelAttribute("magazines")
	public List<Magazine> magazines() {
		return service.listMagazine();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listAllMagazines() {
		return "magazines";
	}
	
	@ModelAttribute("magazine")
	public Magazine magazine() {
		return new Magazine();
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST, params="action=save")
	public String saveMagazine(@ModelAttribute("magazine") Magazine magazine) {
		Publication publication = new Magazine(magazine.getIssn(), magazine.getTitle());
		service.save(publication);
		return "redirect:/magazines";
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST, params="action=delete")
	public String deleteMagazine(@ModelAttribute("magazine") Magazine magazine) {
		service.deleteMagazine(magazine.getIssn());
		return "redirect:/magazines";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST, params="action=update")
	public String updateMagazine(@ModelAttribute("magazine") Magazine magazine) {
		service.updateMagazine(magazine.getIssn(), magazine.getTitle());
		return "redirect:/magazines";
	}
	
}