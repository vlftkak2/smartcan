package kr.ac.sungkyul.smartcan.vo;

public class MapBoardVo {
	
	private Long no;
	private String name;
	private String address;
	private double localx;
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
	private double localy;
	private Long regionno;
	private Double amount;
	
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
	public Long getRegionno() {
		return regionno;
	}
	
	public void setRegionno(Long regionno) {
		this.regionno = regionno;
	}
	
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "MapBoardVo [no=" + no + ", name=" + name + ", address=" + address + ", localx=" + localx + ", localy="
				+ localy + ", regionno=" + regionno + ", amount=" + amount + "]";
	}

	
	
	
	
	
	

}
