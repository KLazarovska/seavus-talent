package twitter.service;

import java.util.List;

import twitter.domain.Tweets;

public interface TwitterServices{

	public void save(Tweets tweet);

	public void delete(Tweets tweet);

	public List<Tweets> listTweetsFromUser(String username);
	
	public List<Tweets> listAllTweets();
	
	public void deleteTweet(Long id);

}
