package jdbc.mvc.controller;

import java.util.List;

import jdbc.mvc.dto.BookDTO;
import jdbc.mvc.service.BookServiceImpl;
import jdbc.mvc.view.View;

/*
 * 작성일 : 2025.6.18
 * 작성장 : 김영래
 * 설명 : 컨트롤러 - 고객의 요구사항(비지니스 로직)에 대한 흐름제어를 담당한다.
 * 			Book 정보에 대한 추가, 수정, 삭제, 도서아이디 조회, 도서목록 조회, 전체목록 조회메뉴의 흐름 제어
 * 		BookController -> BookServiceImpl -> BookDAOImpl
 */ 
public class BookController {
	View view = new View();
	BookServiceImpl service = new BookServiceImpl();
	
	//1. 도서 추가
	public void bookAdd(BookDTO dto) {
		System.out.println("<<< bookAdd()>>>");
		System.out.println(dto.toString());
		
		int insertCnt = service.bookInsert(dto);
		if(insertCnt ==1) {
			System.out.println("도서 정보 추가 성공"+ insertCnt);
		}else {
			view.bookErrorMsg("insert");
		}
		
	}
	//2. 도서 수정
	public void bookUpdate(BookDTO dto) {
		System.out.println("<<< bookUpdate()>>>");
		System.out.println(dto.toString());
		
		int UpdateCnt = service.bookUpdate(dto);
		if(UpdateCnt ==1) {
			System.out.println("도서 정보 수정 성공"+ UpdateCnt);
		}else {
			view.bookErrorMsg("update");
		}
	}
	
	//3. 도서 삭제
	public void bookDelete(int bookId) {
		System.out.println("<<< bookDelete()>>>");
		
		int DeleteCnt = service.bookDelete(bookId);
		if(DeleteCnt == 1) {
			System.out.println("도서 정보 수정 성공"+ DeleteCnt);
		}else {
			view.bookErrorMsg("delete");
		}
	}
	
	//4. 도서아이디 조회
	public void bookSelectId(int bookId) {
		System.out.println("<<< bookSelectId >>>");
		BookDTO dto = service.bookSelectById(bookId);
		if(bookId == dto.getBookId()) {
			view.bookSelect(dto);
		}else {
			view.bookErrorMsg("select");
		}
	}
	
	
	//5. 도서목록 조회
	public void bookSelectTitle(String bookTitle) {
		System.out.println("<<< bookSelectTitle()>>>");
		List<BookDTO> list = service.bookSelectByTitle(bookTitle);
//		if(list != null) {
//			view.bookListAll(list);
//		}else {
//			view.bookErrorMsg("select");
//			
//		}
		if(list.isEmpty()) {
			view.boardErrorMsg("select");
		}else {
			view.bookListAll(list);
		}
		
	}
	//6. 전체목록 조회
	public void bookSelectAll() {
		System.out.println("<<<bookSelectAll()>>>");
		List<BookDTO> list = service.bookSelectAll();
		view.bookListAll(list);
		
	}
}
