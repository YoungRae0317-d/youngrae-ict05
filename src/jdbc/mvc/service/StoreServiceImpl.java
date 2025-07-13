package jdbc.mvc.service;

public class StoreServiceImpl implements StoreService{
	StoreDAOImpl dao = StoreDAOImpl.getInstance();

	//1. 가게 정보 추가
	@Override
	public int storeInsert(StoreDTO dto) {
		int insertCnt = dao.storeInsert(dto);
		return insertCnt;
	}
	
	//2. 가게 정보 수정
	@Override
	public int storeUpdate(StoreDTO dto) {
		int updateCnt = dao.storeUpdate(dto);
		return updateCnt;
	}
	
	//3. 가게이름으로 정보 삭제
	@Override
	public String storeDelete(String storeName) {
		String deleteCnt = dao.storeDelete(storeName);
		return deleteCnt;
	}

	//4. 지역으로 가게 조회
	@Override
	public List<StoreDTO> storeSelectByRegion(String storeRegion) {
		List<StoreDTO> list = dao.storeSelectByRegion(storeRegion);
		return list;
	}

	//5. 음식으로 가게 조회
	@Override
	public List<StoreDTO> storeSelectByFood(String storeFood) {
		List<StoreDTO> list = dao.storeSelectByFood(storeFood);
		return list;
	}
	
	//6. 전체 조회
	@Override
	public List<StoreDTO> storeSelectAll() {
		List<StoreDTO> dto = dao.storeSelectAll();
		return dto;
	}
	

}
