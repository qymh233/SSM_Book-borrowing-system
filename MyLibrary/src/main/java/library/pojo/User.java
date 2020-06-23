package library.pojo;

public class User {

	private int uid;
	private String upw;
	private String uname;
	private String bname;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", bname=" + bname + "]";
	}
	
}
