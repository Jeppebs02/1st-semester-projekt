package model;

public class Copy {
	private String serialNr;

	public Copy(String serialNr) {
		this.serialNr = serialNr;
	}
	
	public String getSerialNr() throws NullPointerException {
		if (serialNr == null) {
			throw new NullPointerException("serial number cant be Null");
		}
		return serialNr;
		
	}
	
}
