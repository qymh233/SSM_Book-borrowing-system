package library.pojo;

public class Book {

	private int bid;
	private String bname;
	private int quantity;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", quantity=" + quantity + "]";
	}
	
}
