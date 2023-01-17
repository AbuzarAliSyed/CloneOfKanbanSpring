package group.example.KanbanHiringPortal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int pId;
	
	@Column(name="id")
	public String id;
	
	@Column(name="comment")
	public String comment;
	
	@Column(name="month")
	public String month;
	
	@Column(name="date")
	public int date;
	
	@Column(name="hours")
	public int hours;
	
	@Column(name="minutes")
	public int minutes;
	
	@Column(name="meridian")
	public String meridian;
	
	public comment() {
		
	}
	
	public comment(String v1,String v2,String v3,int v4,int v5,int v6,String v7) {
		id=v1;
		comment=v2;
		month=v3;
		date=v4;
		hours=v5;
		minutes=v6;
		meridian=v7;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String getMeridian() {
		return meridian;
	}

	public void setMeridian(String meridian) {
		this.meridian = meridian;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
