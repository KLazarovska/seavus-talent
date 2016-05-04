package library.domain;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Member extends EntityClass {

	@OneToOne(mappedBy = "member")
	private Membership membership;

	@OneToMany(mappedBy = "member")
	private Set<Loan> loans;

	@Column(name = "email")
	private String email;
	
	@Column(name = "name")
	private String name;

	public Member() {
	}

	public Member(String name, String email) {
		this.email = email;
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
