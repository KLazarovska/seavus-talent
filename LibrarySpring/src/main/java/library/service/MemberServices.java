package library.service;

import java.util.List;

import library.domain.Member;
import library.domain.Membership;

public interface MemberServices {

	public void save(Member member);
	
	public void update(String name, String email);
	
	public List<Member> listMembers();

	public void saveMembership(Membership membership);
	
	public List<Membership> listMemberships();

}
