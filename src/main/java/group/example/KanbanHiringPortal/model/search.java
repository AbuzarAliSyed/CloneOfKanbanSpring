package group.example.KanbanHiringPortal.model;

public class search {
	public String filterValue;
	public String inputData;
	
	public search() {}
	
	public search(String v1, String v2) {
		filterValue = v1;
		inputData = v2;
	}

	public String getFilterValue() {
		return filterValue;
	}

	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}

	public String getInputData() {
		return inputData;
	}

	public void setInputData(String inputData) {
		this.inputData = inputData;
	}
	
	
}
