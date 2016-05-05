package library.domain;

import javax.persistence.*;

@Entity
public class Membership extends EntityClass {

	@OneToOne
	private Member member;

	@Column(name = "membershipType")
	private String membershipType;
	
	@Column(name = "startDate")
	private String startDate;
	
	@Column(name = "endDate")
	private String endDate;

	public Membership() {

	}

	public Membership(Member member, String membershipType, String string,
			String string2) {
		super();
		this.member = member;
		this.membershipType = membershipType;
		this.startDate = string;
		this.endDate = string2;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
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
