package jike.book.pojo;

import java.util.Date;

public class Visit {
	private Integer VisitID;
	private JiKeUser jikeUser;
	private Date visitDate;
	private String visitIP;
	public Integer getVisitID() {
		return VisitID;
	}
	public void setVisitID(Integer visitID) {
		VisitID = visitID;
	}
	public JiKeUser getJikeUser() {
		return jikeUser;
	}
	public void setJikeUser(JiKeUser jikeUser) {
		this.jikeUser = jikeUser;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public String getVisitIP() {
		return visitIP;
	}
	public void setVisitIP(String visitIP) {
		this.visitIP = visitIP;
	}
	
}
