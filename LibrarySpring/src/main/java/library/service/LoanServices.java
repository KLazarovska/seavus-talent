package library.service;

import java.util.List;

import library.domain.Loan;
import library.domain.Member;
import library.domain.Publication;

public interface LoanServices {
	
	public void save(Loan loan);
	
	public List<Loan> list();
	
	public Member findMember(Long id);
	
	public Publication findPublication(Long id);
}
