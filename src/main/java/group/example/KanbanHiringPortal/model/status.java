package group.example.KanbanHiringPortal.model;

public class status {
	public String status;
	public String id;
	public String prevContainer;
	
	public status() {}
	
	public status(String v1,String v2,String v3) {
		status=v1;
		id=v2;
		prevContainer=v3;
	}

	public String getStatus() {
		return status;
	}

	/**
	 * @return the prevContainer
	 */
	public String getPrevContainer() {
		return prevContainer;
	}

	/**
	 * @param prevContainer the prevContainer to set
	 */
	public void setPrevContainer(String prevContainer) {
		this.prevContainer = prevContainer;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
