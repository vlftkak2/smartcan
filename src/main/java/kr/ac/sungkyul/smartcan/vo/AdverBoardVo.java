package kr.ac.sungkyul.smartcan.vo;

public class AdverBoardVo {
	private Long no;
	private String title;
	private String content;
	private Integer count;
	private Integer groupNo;
	private Integer groupOrderNo;
	private Integer depth;
	private Long UserNo;
	private String regdate;
	private String name;
	private String UserName;
	private Integer orderNo;
	private String keyword;
	private String category;
	private String imageurl;

	
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(Integer groupNo) {
		this.groupNo = groupNo;
	}
	public Integer getGroupOrderNo() {
		return groupOrderNo;
	}
	public void setGroupOrderNo(Integer groupOrderNo) {
		this.groupOrderNo = groupOrderNo;
	}
	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	public Long getUserNo() {
		return UserNo;
	}
	public void setUserNo(Long userNo) {
		UserNo = userNo;
	}
	
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	@Override
	public String toString() {
		return "CustomBoardVo [no=" + no + ", title=" + title + ", content=" + content + ", count=" + count
				+ ", groupNo=" + groupNo + ", groupOrderNo=" + groupOrderNo + ", depth=" + depth + ", UserNo=" + UserNo
				+ ", regdate=" + regdate + ", name=" + name + ", UserName=" + UserName + ", orderNo=" + orderNo
				+ ", keyword=" + keyword + ", category=" + category + ", imageurl=" + imageurl + "]";
	}

	


}

