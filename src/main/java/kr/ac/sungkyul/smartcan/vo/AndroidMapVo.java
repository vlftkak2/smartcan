package kr.ac.sungkyul.smartcan.vo;

public class AndroidMapVo {

	private String name;
	private double localx;
	private double localy;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return "AndroidMapVo [name=" + name + ", localx=" + localx + ", localy=" + localy + "]";
	}
	
	
	
}
