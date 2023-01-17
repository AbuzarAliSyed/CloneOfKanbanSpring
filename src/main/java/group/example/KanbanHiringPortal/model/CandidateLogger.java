package group.example.KanbanHiringPortal.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class CandidateLogger {

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="log_id_seq")
	@SequenceGenerator(name="log_id_seq",allocationSize = 1)
    int logId;
	
	@Column(name="candidateId")
	String candidateId;
	
	@Column(name="dasId")
	String dasId;
	
	@Column(name = "previousStatus")
	String previousStatus;
	
	@Column(name = "candidateLog")
	String candidateLog;
	
	@Column(name = "currentStatus")
	String currentStatus;
	
	@Column(name = "timeOfStatusChange")
	Timestamp timeOfStatusChange;

	public CandidateLogger(int v1, String v2, String v3, String v4, String v5,
			String v6, Timestamp v7) {
		this.logId = v1;
		this.candidateId = v2;
		this.dasId = v3;
		this.previousStatus = v4;
		this.candidateLog = v5;
		this.currentStatus = v6;
		this.timeOfStatusChange = v7;
	}

	public CandidateLogger() {
	}

	/**
	 * @return the logId
	 */
	public int getLogId() {
		return logId;
	}

	/**
	 * @param logId the logId to set
	 */
	public void setLogId(int logId) {
		this.logId = logId;
	}

	/**
	 * @return the candidateId
	 */
	public String getCandidateId() {
		return candidateId;
	}

	/**
	 * @param candidateId the candidateId to set
	 */
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}


	/**
	 * @return the dasId
	 */
	public String getDasId() {
		return dasId;
	}

	/**
	 * @param dasId the dasId to set
	 */
	public void setDasId(String dasId) {
		this.dasId = dasId;
	}

	/**
	 * @return the previousStatus
	 */
	public String getPreviousStatus() {
		return previousStatus;
	}

	/**
	 * @param previousStatus the previousStatus to set
	 */
	public void setPreviousStatus(String previousStatus) {
		this.previousStatus = previousStatus;
	}

	/**
	 * @return the candidateLog
	 */
	public String getCandidateLog() {
		return candidateLog;
	}

	/**
	 * @param candidateLog the candidateLog to set
	 */
	public void setCandidateLog(String candidateLog) {
		this.candidateLog = candidateLog;
	}

	/**
	 * @return the currentStatus
	 */
	public String getCurrentStatus() {
		return currentStatus;
	}

	/**
	 * @param currentStatus the currentStatus to set
	 */
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	/**
	 * @return the timeOfStatusChange
	 */
	public Timestamp getTimeOfStatusChange() {
		return timeOfStatusChange;
	}

	/**
	 * @param timeOfStatusChange the timeOfStatusChange to set
	 */
	public void setTimeOfStatusChange(Timestamp timeOfStatusChange) {
		this.timeOfStatusChange = timeOfStatusChange;
	}

	/**
	 * @return the timeOfStatusChange
	 */

	
}
