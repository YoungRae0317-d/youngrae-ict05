package jdbc.mvc.service;

public interface StoreService {
	
	//1. 가게 정보 추가
	public int storeInsert(StoreDTO dto);
	
	//2. 가게 정보 수정
	public int storeUpdate(StoreDTO dto);
	
	//3. 가게이름으로 정보 삭제
	public String storeDelete(String storeName);
	
	//4. 지역별 가게 조회
	public List<StoreDTO> storeSelectByRegion(String storeRegion);
	
	//5. 음식별 가게 조회
	public List<StoreDTO> storeSelectByFood(String storeFood);

	//6. 전체 조회
	public List<StoreDTO> storeSelectAll();
	
}
