package jdbc.mvc.service;

import java.util.List;

import jdbc.mvc.dao.BoardDAOImpl;
import jdbc.mvc.dto.BoardDTO;

public class BoardServiceImpl implements BoardService{
	BoardDAOImpl dao = BoardDAOImpl.getInstance();
	//1. 게시판 추가
	@Override
	public int boardInsert(BoardDTO dto) {
		System.out.println("BoardServiceImpl-boardInsert()");
		int insertCnt = dao.boardInsert(dto);
		return insertCnt;
	}
	//2. 게시판 수정
	@Override
	public int boardUpdate(BoardDTO dto) {
		System.out.println("BoardServiceImpl-boardUpdate()");
		int updateCnt = dao.boardUpdate(dto);
		return updateCnt;
	}
	//3. 게시판 삭제
	@Override
	public int boardDelete(int boardNo) {
		System.out.println("BoardServiceImpl-boardDelete()");
		int deleteCnt = dao.boardDelete(boardNo);
		return deleteCnt;
	}
	//4. 게시판번호 조회
	@Override
	public BoardDTO boardSelectByNo(int boardNo) {
		System.out.println("BoardServiceImpl-boardSelectByNo()");
		BoardDTO dto = dao.boardSelectByNo(boardNo);
		return dto;
	}
	//5. 게시판제목 조회
	@Override
	public List<BoardDTO> boardSelectByTitle(String boardTitle) {
		System.out.println("BoardServiceImpl-boardSelectById()");
		List<BoardDTO> list = dao.boardSelectByTitle(boardTitle);
		return list;
	}
	//6. 전체목록 조회
	@Override
	public List<BoardDTO> boardSelectAll() {
		System.out.println("BoardServiceImpl-boardSelectById()");
		List<BoardDTO> dto = dao.boardSelectAll();
		return dto;
	}


}
