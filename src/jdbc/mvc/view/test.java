package jdbc.mvc.view;

import jdbc.mvc.dto.BoardDTO;

public class test {
	
	// 3. 지역맛집 메뉴
		public void store_menu() {
				System.out.println("*--------------------------------------------*");
				System.out.println("	1. 추가	2. 수정 	3. 삭제  4. 도시별 조회 5.음식 조회 6. 전체 조회	7. 종료");
				System.out.println("*--------------------------------------------*");
				System.out.print("▶ 메뉴선택 : ");
				int menuNo = scan.nextInt();
				scan.nextLine();
				
				switch(menuNo) {
				case 1 :
					bc3.storeAdd(storeInput());
					break;
					
				case 2 :
					bc3.storeUpdate(storeUpdat());
					break;
					
				case 3 :
					bc3.storeDelete(storeDelet());
					break;

				case 4 :
					bc3.storeSelectRegion(storeRegion());
					break;

				case 5 :
					bc3.storeSelectFood(storeFood());
					break;

				case 6 :
					bc3.storeSelectAll();
					break;
				case 7 :
					System.out.println("프로그램을 종료합니다.");
					System.out.println();
					return;
				default :
					System.out.println("메뉴를 다시 선택해주세요.");
				}
		}
		
		public String storeRegion() {
			System.out.println("도시 입력 : ");
			return scan.nextLine();
		}
		public String storeFood() {
			System.out.println("음식 입력 : ");
			return scan.nextLine();
		}

		
//--아직수정안함(DTO만들고 수정할 예정)------------------------------------------------		
		
		// 3-1. 가게 추가
		public StoreDTO storeInput() {
			
			System.out.print("가게 이름 : ");
			String storeName = scan.nextLine();
			dto3.setStoreName(storeName);
			
			System.out.print("가게 음식 : ");
			String storeFood = scan.nextLine();
			dto3.setStoreFood(storeFood);
			
			System.out.print("가게 위치 : ");
			String storeAddress = scan.nextLine();
			dto3.setStoreAddress(storeAddress);
			
			System.out.print("가게 설명 : ");
			String storeContent = scan.nextLine();
			dto3.setStoreContent(storeContent);
			
			System.out.print("가게 전화번호 : ");
			String storePhone = scan.nextLine();
			dto3.setStorePhone(storePhone);
			
			System.out.print("가게 오픈클로즈시간 : ");
			String storeTime = scan.nextLine();
			dto3.setStoreTime(storeTime);
			
			return dto3;
			
		}
		//3-2. 가게 수정
		public StoreDTO storeUpdat() {
			System.out.print("가게 번호 : ");
			int storeNo = scan.nextInt();
			dto3.setStoreNo(storeNo);
			String asdqwe = scan.nextLine(); 
			
			System.out.print("가게 이름 : ");
			String storeName = scan.nextLine();
			dto3.setStoreName(storeName);
			
			System.out.print("가게 음식 : ");
			String storeFood = scan.nextLine();
			dto3.setStoreFood(storeFood);
			
			System.out.print("가게 위치 : ");
			String storeAddress = scan.nextLine();
			dto3.setStoreAddress(storeAddress);
			
			System.out.print("가게 설명 : ");
			String storeContent = scan.nextLine();
			dto3.setStoreContent(storeContent);
			
			System.out.print("가게 전화번호 : ");
			String storePhone = scan.nextLine();
			dto3.setStorePhone(storePhone);
			
			System.out.print("가게 오픈클로즈시간 : ");
			String storeTime = scan.nextLine();
			dto3.setStoreTime(storeTime);
			
			return dto3;
		}
		
		//3-3. 가게 삭제 (int -> string)
		public String storeDelet() {
			System.out.print("가게 이름 : ");
			String storeName = scan.nextLine();
			dto3.setStoreName(storeName);
			
			return storeName;
		}
		
		//3-4. storeRegion 조회
		public String storeRegion() {
			System.out.println("예시) 서울 경기도 부산 대구 ");
			System.out.println("인천 광주 대전 울산 세종 강원 ");
			System.out.println("충청북도 충청남도 전라북도 전라남도");
			System.out.println("경상북도 경상남도 제주");
			System.out.println("원하는 도시지역 입력 : ");
			return scan.nextLine();
		}
		
		//3-5. storeFood 조회
		public String storeFood() {
			System.out.println("원하는 음식 입력 : ");
			return scan.nextLine();
		}

}
