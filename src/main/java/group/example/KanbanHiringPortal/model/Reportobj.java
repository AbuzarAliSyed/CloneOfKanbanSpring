package group.example.KanbanHiringPortal.model;

public class Reportobj {
	String filterValue;
	String inputValue;
	
	public Reportobj(){
		
	}
	public Reportobj(String v1,String v2) {
		filterValue=v1;
		inputValue=v2;
	}
	public String getFilterValue() {
		return filterValue;
	}
	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}
	public String getInputValue() {
		return inputValue;
	}
	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}
	
	
}
