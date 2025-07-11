package jdbc.mvc.controller;

import java.util.List;

import jdbc.mvc.dto.BoardDTO;
import jdbc.mvc.service.BoardServiceImpl;
import jdbc.mvc.view.View;

public class BoardController {
	View view = new View();
	BoardServiceImpl service = new BoardServiceImpl();
	
	//1. 게시판 추가
	public void boardAdd(BoardDTO dto) {
		System.out.println("<<< boardAdd()>>>");
		System.out.println(dto.toString());
		
		int insertCnt = service.boardInsert(dto);
		if(insertCnt ==1) {
			System.out.println("게시판 정보 추가 성공"+ insertCnt);
		}else {
			view.boardErrorMsg("insert");
		}
		
	}
	//2. 게시판 수정
	public void boardUpdate(BoardDTO dto) {
		System.out.println("<<< boardUpdate()>>>");
		System.out.println(dto.toString());
		
		int UpdateCnt = service.boardUpdate(dto);
		if(UpdateCnt ==1) {
			System.out.println("게시판 정보 수정 성공"+ UpdateCnt);
		}else {
			view.boardErrorMsg("update");
		}
	}
	
	//3. 게시판 삭제
	public void boardDelete(int boardNo) {
		System.out.println("<<< boardDelete()>>>");
		
		int DeleteCnt = service.boardDelete(boardNo);
		if(DeleteCnt == 1) {
			System.out.println("게시판 정보 삭제 성공"+ DeleteCnt);
		}else {
			view.boardErrorMsg("delete");
		}
	}
	
	//4. 게시판 번호 조회
	public void boardSelectNo(int boardNo) {
		System.out.println("<<< boardSelectNo >>>");
		BoardDTO dto = service.boardSelectByNo(boardNo);
		if(boardNo == dto.getBoardNo()) {
			view.boardSelect(dto);
		}else {
			view.boardErrorMsg("select");
		}
	}
	
	
	//5. 게시판 제목 조회
	public void boardSelectTitle(String boardTitle) {
		System.out.println("<<< boardSelectTitle()>>>");
		List<BoardDTO> list = service.boardSelectByTitle(boardTitle);
		
		if(list == null || list.isEmpty()) {
			view.boardErrorMsg("select");
		}else {
			view.boardListAll(list);
		}
	}
	//6. 전체목록 조회
	public void boardSelectAll() {
		System.out.println("<<<boardSelectAll()>>>");
		List<BoardDTO> list = service.boardSelectAll();
		view.boardListAll(list);
		
	}
	
	

}
