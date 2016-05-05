package library.presentation;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import library.domain.Loan;
import library.domain.Member;
import library.service.LoanServices;
import scala.annotation.meta.setter;

@Controller
@RequestMapping("/loans")
public class LoanControllerMVC {

	@Autowired
	LoanServices service;

	@ModelAttribute("loans")
	public List<Loan> books() {
		return service.list();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listAllLoans() {
		return "loans";
	}

	@ModelAttribute("loan")
	public Loan loan() {
		return new Loan();
	}

	@RequestMapping(value = "/editLoans", method = RequestMethod.POST, params = "action=save")
	public String saveLoan(@ModelAttribute("loan") Loan loan) {
		Loan newLoan = new Loan(service.findMember(loan.getMember().getId()),
				service.findPublication(loan.getPublication().getId()),
				ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE),
				ZonedDateTime.now().plusMonths(5L).format(DateTimeFormatter.ISO_LOCAL_DATE));
		service.save(newLoan);
		return "redirect:/loans";
	}
}
