package group.example.KanbanHiringPortal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tags {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int p_id;
	
	@Column(name="candidate_id")
	String candidate_id;
	
	@Column(name="tags")
	String tags;

	public Tags(int v1, String v2, String v3) {
		this.p_id = v1;
		this.candidate_id = v2;
		this.tags = v3;
	}

	public Tags() {
	}

	/**
	 * @return the p_id
	 */
	public int getP_id() {
		return p_id;
	}

	/**
	 * @param p_id the p_id to set
	 */
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	/**
	 * @return the candidate_id
	 */
	public String getCandidate_id() {
		return candidate_id;
	}

	/**
	 * @param candidate_id the candidate_id to set
	 */
	public void setCandidate_id(String candidate_id) {
		this.candidate_id = candidate_id;
	}

	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

}
