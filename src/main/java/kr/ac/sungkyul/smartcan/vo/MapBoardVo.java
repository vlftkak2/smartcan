package kr.ac.sungkyul.smartcan.vo;

public class MapBoardVo {
	
	private Long no;
	private String name;
	private String address;
	private double localx;
	private double localy;
	private double amount;
	private Long regionno;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
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
	public double getLocalx() {
		return localx;
	}
	public void setLocalx(double localx) {
		this.localx = localx;
	}
	public double getLocaly() {
		return localy;
	}
	public void setLocaly(double localy) {
		this.localy = localy;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Long getRegionno() {
		return regionno;
	}
	public void setRegionno(Long regionno) {
		this.regionno = regionno;
	}
	
	@Override
	public String toString() {
		return "MapBoardVo [no=" + no + ", name=" + name + ", address=" + address + ", localx=" + localx + ", localy="
				+ localy + ", amount=" + amount + ", regionno=" + regionno + "]";
	}
	
	
	
	

}
