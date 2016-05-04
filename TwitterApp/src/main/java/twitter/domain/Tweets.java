package twitter.domain;

import javax.persistence.*;

@Entity
public class Tweets {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "date")
	private String date;

	public Tweets() {
	}

	public Tweets(String username, String text) {
		super();
		this.username = username;
		this.text = text;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public Long getId(){
		return id;
	}

}
