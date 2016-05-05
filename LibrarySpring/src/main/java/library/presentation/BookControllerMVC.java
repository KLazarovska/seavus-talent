package library.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import library.domain.Book;
import library.domain.Publication;
import library.service.PublicationServices;

@Controller
@RequestMapping("/books")
public class BookControllerMVC {

	@Autowired
	PublicationServices service;
	
	@ModelAttribute("books")
	public List<Book> books() {
		return service.listBooks();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listAllBooks() {
		return "books";
	}
	
	@ModelAttribute("book")
	public Book book() {
		return new Book();
	}
	
	@RequestMapping(value="/editBook", method=RequestMethod.POST, params="action=save")
	public String saveBook(@ModelAttribute("book") Book book) {
		Publication publication = new Book(book.getIsbn(), book.getTitle());
		service.save(publication);
		return "redirect:/books";
	}

	@RequestMapping(value="/editBook", method=RequestMethod.POST, params="action=delete")
	public String deleteBook(@ModelAttribute("book") Book book) {
		service.deleteBook(book.getIsbn());
		return "redirect:/books";
	}
	
	@RequestMapping(value="/editBook", method=RequestMethod.POST, params="action=update")
	public String updateBook(@ModelAttribute("book") Book book) {
		service.updateBook(book.getIsbn(), book.getTitle());
		return "redirect:/books";
	}
	
}