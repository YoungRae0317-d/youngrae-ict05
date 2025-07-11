package jdbc.mvc.view;

import java.util.Iterator;
import java.util.List;

import jdbc.mvc.dto.BoardDTO;
import jdbc.mvc.dto.BookDTO;

/*
 * 뷰 - 결과화면
 * 		Book에 정보 출력, Book 에러메시지, Book 결과 조회
 */
public class View {
	//에러메시지
	public void bookErrorMsg(String msg) {
		switch(msg) {
		case"insert":
			
			System.out.println("도서 추가 실패");
			
			break;
			
		case"update" :
			System.out.println("도서 수정 실패");
			break;

		case"delete" :
			System.out.println("도서 삭제 실패");
			break;

		case"select" :
			System.out.println("도서 조회 실패");
			break;
		default :
			System.out.println("Error");
		}
		
	}
	
	// 전체 도서목록
	public void bookListAll(List<BookDTO> list) {
		// 방법1. 향상된 for문 조회
		for (BookDTO dto1 : list) {
//			System.out.println("도서ID : "+ dto1.getBookId());
//			System.out.println("타이틀 : " + dto1.getTitle());
//			System.out.println("저자 : " + dto1.getAuthor());
//			System.out.println("출판사 : "+ dto1.getPublisher());
//			System.out.println("가격 : "+ dto1.getPrice());
//			System.out.println("출판일 : "+ dto1.getPubdate());
			System.out.println();
			bookSelect(dto1);
		}
		// 방법2. Iterator 조회
		Iterator<BookDTO> iterator = list.iterator();
		while (iterator.hasNext()) {
			BookDTO dto2 = iterator.next();
			System.out.println("도서ID : " + dto2.getBookId());
	        System.out.println("타이틀 : " + dto2.getTitle());
	        System.out.println("저자   : " + dto2.getAuthor());
	        System.out.println("출판사 : " + dto2.getPublisher());
	        System.out.println("가격   : " + dto2.getPrice());
	        System.out.println("출판일 : " + dto2.getPubdate());
	        System.out.println();
		}
	}
	
	//1건 데이터 조회
	public void bookSelect(BookDTO dto) {
		System.out.println("도서ID : "+ dto.getBookId());
		System.out.println("타이틀 : " + dto.getTitle());
		System.out.println("저자 : " + dto.getAuthor());
		System.out.println("출판사 : "+ dto.getPublisher());
		System.out.println("가격 : "+ dto.getPrice());
		System.out.println("출판일 : "+ dto.getPubdate());
	}
	

//-----------------------------------------------------------------------


	//에러메시지
	public void boardErrorMsg(String msg) {
		switch(msg) {
		case"insert":
			System.out.println("게시판 추가 실패");
			break;
			
		case"update" :
			System.out.println("게시판 수정 실패");
			break;

		case"delete" :
			System.out.println("게시판 삭제 실패");
			break;

		case"select" :
			System.out.println("게시판 조회 실패");
			break;
		default :
			System.out.println("Error");
		}
		
	}
	
	// 전체 게시판 목록
	public void boardListAll(List<BoardDTO> list) {
		// 방법1. 향상된 for문 조회
		for (BoardDTO dto1 : list) {
//			System.out.println("도서ID : "+ dto1.getBookId());
//			System.out.println("타이틀 : " + dto1.getTitle());
//			System.out.println("저자 : " + dto1.getAuthor());
//			System.out.println("출판사 : "+ dto1.getPublisher());
//			System.out.println("가격 : "+ dto1.getPrice());
//			System.out.println("출판일 : "+ dto1.getPubdate());
			System.out.println();
			boardSelect(dto1);
		}
		// 방법2. Iterator 조회
//		Iterator<BoardDTO> iterator = list.iterator();
//		while (iterator.hasNext()) {
//			BoardDTO dto2 = iterator.next();
//			System.out.println("글번호 : "+ dto2.getBoardNo());
//			System.out.println("글제목 : " + dto2.getBoardTitle());
//			System.out.println("글내용 : " + dto2.getBoardContent());
//			System.out.println("작성자 : "+ dto2.getBoardId());
//			System.out.println("작성일 : "+ dto2.getBoardRegDate());
//	        System.out.println();
//		}
	}
	
	//1건 데이터 조회
	public void boardSelect(BoardDTO dto) {
		System.out.println("글번호 : "+ dto.getBoardNo());
		System.out.println("글제목 : " + dto.getBoardTitle());
		System.out.println("글내용 : " + dto.getBoardContent());
		System.out.println("작성자 : "+ dto.getBoardId());
		System.out.println("작성일 : "+ dto.getBoardRegDate());
	}
	
}