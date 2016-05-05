package library.domain;

import javax.persistence.*;

@Entity
public class Loan extends EntityClass {

	@ManyToOne
	private Member member;

	@ManyToOne
	private Publication publication;

	@Column(name = "startDate")
	private String startDate;
	@Column(name = "endDate")
	private String endDate;

	public Loan() {
	}

	public Loan(Member member, Publication publication, String startDate, String endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.member = member;
		this.publication = publication;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
