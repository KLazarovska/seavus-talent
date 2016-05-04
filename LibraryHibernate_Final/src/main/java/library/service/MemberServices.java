package library.service;

import library.domain.Member;
import library.domain.Membership;

public interface MemberServices {

	public void save(Member member);
	
	public void update(String name, String email);
	
	public void listMembers();

	public void saveMembership(Membership membership);
	
	public void listMemberships();

}
