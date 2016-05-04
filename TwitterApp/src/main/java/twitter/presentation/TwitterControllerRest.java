package twitter.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import twitter.domain.Tweets;
import twitter.service.TwitterServices;

@RestController
@RequestMapping("/api/tweets")
public class TwitterControllerRest {

	@Autowired
	TwitterServices service;

	@RequestMapping(method = RequestMethod.GET)
	public List<Tweets> listBooks() {
		return service.listAllTweets();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Tweets registerTweet(@RequestBody Tweets tweet) {
		service.save(tweet);
		return tweet;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String unregisterBook(@PathVariable("id") Long id) {
		service.deleteTweet(id);
		return "Success";
	}

}
