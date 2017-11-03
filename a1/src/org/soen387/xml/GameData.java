package org.soen387.xml;

public class GameData {
	
	private String id;
	private String gameTitle;
	private String releaseDate;
	private String platform;
	private String overview;
	private String num_players;
	private String coop;
	private String genre;
	private String developer;
	private String publisher;
	private String front_box_art;
	private String back_box_art;
	private String logo;
	private String developer_logo;
	private String comments;
	
	GameData(){
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGameTitle() {
		return this.gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getNum_players() {
		return num_players;
	}

	public void setNum_players(String num_players) {
		this.num_players = num_players;
	}

	public String getCoop() {
		return coop;
	}

	public void setCoop(String coop) {
		this.coop = coop;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getFront_box_art() {
		return front_box_art;
	}

	public void setFront_box_art(String front_box_art) {
		this.front_box_art = front_box_art;
	}

	public String getBack_box_art() {
		return back_box_art;
	}

	public void setBack_box_art(String back_box_art) {
		this.back_box_art = back_box_art;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDeveloper_logo() {
		return developer_logo;
	}

	public void setDeveloper_logo(String developer_logo) {
		this.developer_logo = developer_logo;
	}
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
