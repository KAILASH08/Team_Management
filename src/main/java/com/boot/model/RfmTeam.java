/* 
 * 
 * @author Kailash Nirmal 
 */
  
package com.boot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "rfmTeam")
public class RfmTeam {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column(name = "emp_no")
	String empNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birth_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	java.util.Date birthDate;

	@NotNull
	@Column(name = "first_name")
	String firstName;

	@Column(name = "last_name")
	String lastName;

	public RfmTeam() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name = "gender")
	String gendEr;

	@Column(name = "qualification")
	String qualifiCation;

	@Column(name = "current_experience")
	String currentExperience;

	@Column(name = "designation")
	String desigNation;

	@Column(name = "skills")
	String sKills;

	@Column(name = "self_ratings")
	Integer selfRatings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGendEr() {
		return gendEr;
	}

	public void setGendEr(String gendEr) {
		this.gendEr = gendEr;
	}

	public String getQualifiCation() {
		return qualifiCation;
	}

	public void setQualifiCation(String qualifiCation) {
		this.qualifiCation = qualifiCation;
	}

	public String getCurrentExperience() {
		return currentExperience;
	}

	public void setCurrentExperience(String currentExperience) {
		this.currentExperience = currentExperience;
	}

	public String getDesigNation() {
		return desigNation;
	}

	public void setDesigNation(String desigNation) {
		this.desigNation = desigNation;
	}

	public String getsKills() {
		return sKills;
	}

	public void setsKills(String sKills) {
		this.sKills = sKills;
	}

	public Integer getSelfRatings() {
		return selfRatings;
	}

	public void setSelfRatings(Integer selfRatings) {
		this.selfRatings = selfRatings;
	}

	@Override
	public String toString() {
		return "RfmTeam [id=" + id + ", empNo=" + empNo + ", birthDate=" + birthDate + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gendEr=" + gendEr + ", qualifiCation=" + qualifiCation
				+ ", currentExperience=" + currentExperience + ", desigNation=" + desigNation + ", sKills=" + sKills
				+ ", selfRatings=" + selfRatings + "]";
	}

}
