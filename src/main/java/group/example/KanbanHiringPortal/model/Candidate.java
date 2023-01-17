package group.example.KanbanHiringPortal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Candidate {
	
	@Column(name="candidateId")
	@Id
	String candidateId;
	
	@Column(name="candidateName")
	String candidateName;
	
	@Column(name="age")
	int age;
	
	
	@Column(name="totalExperiance")
	int totalExperiance;
	
	@Column(name="relevantExperiance")
	int relevantExperiance;
	
	@Column(name="expectedLwd")
	String expectedLwd;
	
	@Column(name="location")
	String location;
	
	@Column(name="skills")
	String skills;
	
	@Column(name="technology")
	String technology;
	
	@Column(name="maritialStatus")
	String maritialStatus;
	
	@Column(name="status")
	String status;
	
	@Column(name="gcm")
	String gcm;
	
	@Column(name="position")
	String position;
	
	@Column(name="duedate")
	String duedate;
	
	@Column(name="project")
	String project;
	
	@CreationTimestamp
	@Column(name="date")
	java.sql.Date date;
	
	@CreationTimestamp
    @Column(name="timestamp")
     java.sql.Timestamp timestamp;
	
	
	



	/**
	 * @return the timestamp
	 */
	public java.sql.Timestamp getTimestamp() {
		return timestamp;
	}



	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(java.sql.Timestamp timestamp) {
		this.timestamp = timestamp;
	}



	public java.sql.Date getDate() {
		return date;
	}



	public void setDate(java.sql.Date date) {
		this.date = date;
	}



	public Candidate() {}
	
	
	
	public Candidate(String v1,String v2,int v3,int v4,int v5,String v6,String v7,String v8,String v9,String v10,String v11,String v12,String v13,
			String v14,String v15) {
		candidateId=v1;
		candidateName=v2;
		age=v3;
		totalExperiance=v4;
		relevantExperiance=v5;
		expectedLwd=v6;
		location=v7;
		skills=v8;
		technology=v9;
		maritialStatus=v10;
		status=v11;
		gcm=v12;
		position=v13;
		duedate=v14;
		project=v15;
	}
	
	
	public String getStatus() {
		return status;
	}


	public String getGcm() {
		return gcm;
	}



	public void setGcm(String gcm) {
		this.gcm = gcm;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public String getDuedate() {
		return duedate;
	}



	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}



	public String getProject() {
		return project;
	}



	public void setProject(String project) {
		this.project = project;
	}



	public void setStatus(String status) {
		this.status = status;
	}


	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTotalExperiance() {
		return totalExperiance;
	}

	public void setTotalExperiance(int totalExperiance) {
		this.totalExperiance = totalExperiance;
	}

	public int getRelevantExperiance() {
		return relevantExperiance;
	}

	public void setRelevantExperiance(int relevantExperiance) {
		this.relevantExperiance = relevantExperiance;
	}

	public String getExpectedLwd() {
		return expectedLwd;
	}

	public void setExpectedLwd(String expectedLwd) {
		this.expectedLwd = expectedLwd;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getMaritialStatus() {
		return maritialStatus;
	}

	public void setMaritialStatus(String maritialStatus) {
		this.maritialStatus = maritialStatus;
	}

	
	
	
	
}
