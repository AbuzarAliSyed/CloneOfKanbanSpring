package group.example.KanbanHiringPortal.model;

public class customTag {
	String value;
	String columnName;
	String id;
	
	public customTag() {}
	
	
	public customTag(String v1,String v2,String v3) {
		value=v1;
		columnName=v2;
		id=v3;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getColumnName() {
		return columnName;
	}


	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	
}
