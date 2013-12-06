package com.academy.clubs;

public class Announcement {
	String title;
	String body;
	Club club;
	//later add one for image?
	
	/**
	 * Constructor for Announcement
	 * @param t title
	 * @param c club
	 */
	public Announcement(String t, Club c)	{
		title = t;
		body = "";
		club = c;
	}
	
	/**
	 * Constructor for Announcement
	 * @param t title
	 * @param b body
	 * @param c club
	 */
	public Announcement(String t, String b, Club c)	{
		title = t;
		body = b;
		club = c;
	}

	/**
	 * Gets the title
	 * @return title;
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the body text
	 * @return body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * Sets the body text
	 * @param body
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * Gets the club
	 * @return club
	 */
	public Club getClub() {
		return club;
	}

	/**
	 * Sets the club
	 * @param club
	 */
	public void setClub(Club club) {
		this.club = club;
	}
	
}
