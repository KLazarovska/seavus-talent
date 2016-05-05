package library.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import library.domain.Publication;
import library.service.PublicationServices;

@RestController
@RequestMapping("/api/publications")
public class PublicationControllerRest {

	@Autowired
	PublicationServices service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Publication> listPublications() {
		return service.listPublications();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Publication savePublication(@RequestBody Publication publication) {
		service.save(publication);
		return publication;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deletePublication(@PathVariable("id") Long id) {
		service.deletePublication(id);
		return "Success";
	}
}
