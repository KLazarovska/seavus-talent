package library.service;

import library.domain.Loan;

public interface LoanServices {
	
	public void save(Loan loan);
	
	public void list();
}
