package jdbc.mvc.dto;

public class StoreDTO {
	private int storeNo;			//가게고유번호
	private String storeName;		//가게이름
	private String storeFood;		//가게음식
	private String storeAddress;	//가게주소(위치)
	private String storeContent;	//가게설명
	private String storePhone;			//가게전화번호
	private String storeTime;		//오픈클로즈시간
	
	
	public StoreDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StoreDTO(int storeNo, String storeName, String storeFood, String storeAddress, String storeContent,
			String storePhone, String storeTime) {
		super();
		this.storeNo = storeNo;
		this.storeName = storeName;
		this.storeFood = storeFood;
		this.storeAddress = storeAddress;
		this.storeContent = storeContent;
		this.storePhone = storePhone;
		this.storeTime = storeTime;
	}


	public int getStoreNo() {
		return storeNo;
	}


	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}


	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	public String getStoreFood() {
		return storeFood;
	}


	public void setStoreFood(String storeFood) {
		this.storeFood = storeFood;
	}


	public String getStoreAddress() {
		return storeAddress;
	}


	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}


	public String getStoreContent() {
		return storeContent;
	}


	public void setStoreContent(String storeContent) {
		this.storeContent = storeContent;
	}


	public String getStorePhone() {
		return storePhone;
	}


	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}


	public String getStoreTime() {
		return storeTime;
	}


	public void setStoreTime(String storeTime) {
		this.storeTime = storeTime;
	}


	@Override
	public String toString() {
		return "StoreDTO [storeNo=" + storeNo + ", storeName=" + storeName + ", storeFood=" + storeFood
				+ ", storeAddress=" + storeAddress + ", storeContent=" + storeContent + ", storePhone=" + storePhone
				+ ", storeTime=" + storeTime + "]";
	}


	
	
}
