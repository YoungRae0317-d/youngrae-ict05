package jdbc.mvc.controller;

import java.util.List;

import jdbc.mvc.dto.BoardDTO;
import jdbc.mvc.service.BoardServiceImpl;
import jdbc.mvc.view.View;

public class StoreController {
	View view = new View();
	StoreServiceImpl service = new StoreServiceImpl();
	
	//1. 가게 추가
	public void storeAdd(storeDTO dto) {
		System.out.println(dto.toString());
		 
		int insertCnt = service.storeInsert(dto);
		if(insertCnt ==1) {
			System.out.println("가게 정보 추가 성공"+ insertCnt);
		}else {
			view.storeErrorMsg("insert");
		}
		
	}
	//2. 가게정보 수정
	public void storeUpdate(StoreDTO dto) {
		System.out.println(dto.toString());
		
		int UpdateCnt = service.storeUpdate(dto);
		if(UpdateCnt ==1) {
			System.out.println("가게 정보 수정 성공"+ UpdateCnt);
		}else {
			view.storeErrorMsg("update");
		}
	}
	
	//3. 가게 정보 삭제
	public void storeDelete(String storeName) {
		
		int DeleteCnt = service.storeDelete(storeName);
		if(DeleteCnt == 1) {
			System.out.println("가게 정보 삭제 성공"+ DeleteCnt);
		}else {
			view.storeErrorMsg("delete");
		}
	}
	
	//4. 가게 지역으로 조회
	public void storeSelectRegion(String storeRegion) {
		StoreDTO dto = service.storeSelectByRegion(storeRegion);
		if(storeRegion == dto.getStoreRegion()) {
			view.storeSelect(dto);
		}else {
			view.storeErrorMsg("select");
		}
	}
	
	
	//5. 가게 음식으로 조회
	public void storeSelectFood(String storeFood) {
		List<StoreDTO> list = service.storeSelectByFood(storeFood);
		
		if(list == null || list.isEmpty()) {
			view.storeErrorMsg("select");
		}else {
			view.storeListAll(list);
		}
	}
	//6. 전체목록 조회
	public void storeSelectAll() {
		List<StoreDTO> list = service.storeSelectAll();
		view.storeListAll(list);
		
	}

}
