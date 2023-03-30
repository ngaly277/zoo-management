package fa.intern.mock.bean;

public class Inventory {
	private int id;
	private String name;
	private String address;
	private int idType;
	public Inventory(int id, String name, String address, int idType) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.idType = idType;
	}
	public Inventory() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getIdType() {
		return idType;
	}
	public void setIdType(int idType) {
		this.idType = idType;
	}
}
