package fa.intern.mock.bean;

public class Staff {
	private int idStaff;
	protected String staffName;
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public int getIdStaff() {
		return idStaff;
	}
	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}
	public Staff() {
		super();
	}
	public Staff(String staffName) {
		super();
		this.staffName = staffName;
	}

	

}
