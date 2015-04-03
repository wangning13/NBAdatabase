package vo;

public class TeamMonthMatchVO {
	String date;
	String host;
	String guest;
	String score;
	String first;
	String second;
	String third;
	String fourth;
	public TeamMonthMatchVO(String date, String host, String guest,
			String score, String first, String second, String third,
			String fourth) {
		super();
		this.date = date;
		this.host = host;
		this.guest = guest;
		this.score = score;
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getGuest() {
		return guest;
	}
	public void setGuest(String guest) {
		this.guest = guest;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
	public String getThird() {
		return third;
	}
	public void setThird(String third) {
		this.third = third;
	}
	public String getFourth() {
		return fourth;
	}
	public void setFourth(String fourth) {
		this.fourth = fourth;
	}
	

}
