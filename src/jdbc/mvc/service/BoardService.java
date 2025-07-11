package jdbc.mvc.service;

import java.util.List;

import jdbc.mvc.dto.BoardDTO;

public interface BoardService {
	
	//1. 게시판 추가
	public int boardInsert(BoardDTO dto);
	//2. 게시판 수정 
	public int boardUpdate(BoardDTO dto);
	
	//3. 게시판 삭제
	public int boardDelete(int boardNo);
	
	//4. 게시판번호 조회
	public BoardDTO boardSelectByNo(int boardNo);
	
	//5. 게시판목록 조회
	public List<BoardDTO> boardSelectByTitle(String boardTitle);
	//6. 전체목록 조회
	public List<BoardDTO> boardSelectAll();

}
