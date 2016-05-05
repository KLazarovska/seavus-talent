package library.presentation;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import library.domain.Member;
import library.domain.Membership;
import library.service.MemberServices;

@Controller
@RequestMapping("/members")
public class MemberControllerMVC {

	@Autowired
	MemberServices service;
	
	@ModelAttribute("members")
	public List<Membership> members() {
		return service.listMemberships();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listAllMembers() {
		return "members";
	}
	
	@ModelAttribute("member")
	public Member member() {
		return new Member();
	}
	
	@RequestMapping(value="/editMember", method=RequestMethod.POST, params="action=save")
	public String saveMember(@ModelAttribute("member") Member member) {
		Membership membership = new Membership(member, "standard",
				ZonedDateTime.now().format(
						DateTimeFormatter.ISO_LOCAL_DATE),
				ZonedDateTime.now().plusYears(1L)
						.format(DateTimeFormatter.ISO_LOCAL_DATE));
		service.save(member);
		service.saveMembership(membership);
		return "redirect:/members";
	}
	
	@RequestMapping(value="/editMember", method=RequestMethod.POST, params="action=update")
	public String updateMember(@ModelAttribute("member") Member member) {
		service.update(member.getEmail(), member.getName());
		return "redirect:/members";
	}
}
