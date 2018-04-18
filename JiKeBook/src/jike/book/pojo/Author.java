package jike.book.pojo;

public class Author {
	private Integer id;
	private JiKeUser jikeUser;
	private String realName;
	private String IDCard;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public JiKeUser getJikeUser() {
		return jikeUser;
	}
	public void setJikeUser(JiKeUser jikeUser) {
		this.jikeUser = jikeUser;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	
	
}
