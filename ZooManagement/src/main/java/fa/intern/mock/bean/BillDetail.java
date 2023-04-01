package fa.intern.mock.bean;

import java.util.Date;

public class BillDetail {
	private int id;
	private int idBill;
	private int amountTransfer;
	private Date transferDate;
	private Bill bill;
	public BillDetail(int id, int idBill, int amountTransfer, Date transferDate) {
		super();
		this.id = id;
		this.idBill = idBill;
		this.amountTransfer = amountTransfer;
		this.transferDate = transferDate;
	}
	public BillDetail(int id, int idBill, int amountTransfer, Date transferDate, Bill bill) {
		super();
		this.id = id;
		this.idBill = idBill;
		this.amountTransfer = amountTransfer;
		this.transferDate = transferDate;
		this.bill = bill;
	}
	public BillDetail() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdBill() {
		return idBill;
	}
	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}
	public int getAmountTransfer() {
		return amountTransfer;
	}
	public void setAmountTransfer(int amountTransfer) {
		this.amountTransfer = amountTransfer;
	}
	public Date getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
}
