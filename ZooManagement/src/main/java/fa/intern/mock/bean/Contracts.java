package fa.intern.mock.bean;

public class Contracts {
	private int idContract;
	private String details;
	public int getIdContract() {
		return idContract;
	}
	public void setIdContract(int idContract) {
		this.idContract = idContract;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Contracts(int idContract, String details) {
		super();
		this.idContract = idContract;
		this.details = details;
	} 
	
	public Contracts() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Contracts [idContract=" + idContract + ", details=" + details + "]";
	}
	
}
