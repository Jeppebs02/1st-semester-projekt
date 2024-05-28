package model;

//@author: Ali Barakji, Jeppe B. Sørensen, Kasper Mikkelsen, Magnus Tomra Engberg, Matias Holm Nielsen, Oscar Seistrup Hermann
//@date: 31/5/2024
//@description: this class holds information about a copy of a 
//specific product
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
