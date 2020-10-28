package com.luv2code.asr.emagzine.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="magazine")
public class Magazine {
	@Id
	@Column(name = "mid", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
	@GenericGenerator(name = "incrementDomain", strategy = "increment")
	private int mid;
	
	private String mname;
	private String mcategory;
	private String mlanguage;
	private String mtype;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date mdate;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMcategory() {
		return mcategory;
	}
	public void setMcategory(String mcategory) {
		this.mcategory = mcategory;
	}
	public String getMlanguage() {
		return mlanguage;
	}
	public void setMlanguage(String mlanguage) {
		this.mlanguage = mlanguage;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	@Override
	public String toString() {
		return "Magazine [mid=" + mid + ", mname=" + mname + ", mcategory=" + mcategory + ", mlanguage=" + mlanguage
				+ ", mtype=" + mtype + ", mdate=" + mdate + "]";
	}
}
