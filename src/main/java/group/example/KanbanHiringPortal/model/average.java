package group.example.KanbanHiringPortal.model;

public class average {
	String location;
	int avgDays;
	
	public average() {
		
	}
	
	public average(String v1,int v2) {
		location=v1;
		avgDays=v2;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getAvgDays() {
		return avgDays;
	}

	public void setAvgDays(int avgDays) {
		this.avgDays = avgDays;
	}
	
}
