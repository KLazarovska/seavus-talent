package twitter.presentation;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import twitter.domain.Tweets;
import twitter.service.TwitterServices;

@Controller
@RequestMapping("/tweets")
public class TwitterControllerMVC {

	@Autowired
	TwitterServices service;

	@ModelAttribute("tweets")
	public List<Tweets> tweets() {
		return service.listAllTweets();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listTweets() {
		return "tweets";
	}

	@ModelAttribute("tweet")
	public Tweets tweet() {
		return new Tweets();
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST, params="action=save")
	public String save(@ModelAttribute("tweet") Tweets tweet) {
		tweet.setDate(ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE).toString());
		service.save(tweet);
		return "redirect:/tweets";
	}

	@RequestMapping(value="/edit", method=RequestMethod.POST, params="action=delete")
	public String delete(@ModelAttribute("tweet") Tweets tweet) {
		service.delete(tweet);
		return "redirect:/tweets";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST, params="action=list")
	public String list(@ModelAttribute("tweet") Tweets tweet, Model model) {
		model.addAttribute("tweets", service.listTweetsFromUser(tweet.getUsername()));
		return "tweets";
	}
	
}
