package jdbc.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.mvc.dto.BoardDTO;

public class BoardDAOImpl implements BoardDAO{
	private static BoardDAOImpl dao = new BoardDAOImpl();
	private BoardDAOImpl() {};
	public static BoardDAOImpl getInstance(){
		if(dao ==null) {
			dao = new BoardDAOImpl();
		}
		return dao;
	}
	// DB 연결
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
	String dbID = "scott_05"; 		//계정
	String dbPassword = "tiger"; 	//비밀번호
	
	Connection conn = null; 		// 오라클 연결
	PreparedStatement pstmt = null; // SQL 문장
	ResultSet rs = null; 	//SQL 실행 결과(SELECT절에서만 사용)
	
	//1. 게시판 추가
	@Override
	public int boardInsert(BoardDTO dto) {
		System.out.println("BoardDAOImpl - boardInsert()");
		int insertCnt = 0;
		String qurey = "INSERT INTO mvc_board_tbl(boardNo, boardTitle, boardContent, boardId) "
			+ " VALUES((SELECT NVL(MAX(boardNo)+1,1) FROM mvc_board_tbl), ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPassword); //오라클 연결
			pstmt = conn.prepareStatement(qurey);	// SQL문 작성
			pstmt.setString(1, dto.getBoardTitle()); // 1은 물음표 위치, 
			pstmt.setString(2, dto.getBoardContent());
			pstmt.setString(3, dto.getBoardId());
			
			insertCnt = pstmt.executeUpdate(); // executeUpdate() => I,U,D의 SQL 실행 => 1: 성공, 0: 실패
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return insertCnt;
	}

	//2. 게시판 수정
	@Override
	public int boardUpdate(BoardDTO dto) {
		System.out.println("BoardDAOImpl - boardUpdate()");
		int updateCnt = 0;
		String qurey2 = "UPDATE mvc_board_tbl "
			+ " Set boardTitle = ?,boardContent = ?,boardId = ?,boardRegDate = sysdate " + " WHERE boardNo = ?";
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPassword); //오라클 연결
			pstmt = conn.prepareStatement(qurey2);	// SQL문 작성
			pstmt.setString(1, dto.getBoardTitle()); 
			pstmt.setString(2, dto.getBoardContent());
			pstmt.setString(3, dto.getBoardId());
			pstmt.setInt(4, dto.getBoardNo()); 
			
			updateCnt = pstmt.executeUpdate(); // executeUpdate() => I,U,D의 SQL 실행 => 1: 성공, 0: 실패
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return updateCnt;
	}

	//3. 게시판 삭제
	@Override
	public int boardDelete(int boardNo) {
		System.out.println("BoardDAOImpl - boardDelete()");
		int deleteCnt = 0;
		String qurey3 = "delete from mvc_board_tbl " + " where boardNo = ?";
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPassword);
			pstmt = conn.prepareStatement(qurey3);
			pstmt.setInt(1, boardNo);
			
			deleteCnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		return deleteCnt;
	}

	//4. 게시판번호 조회
	@Override
	public BoardDTO boardSelectByNo(int boardNo) {
		System.out.println("BoardDAOImpl - boardSelectByNo()");

		String qurey4 = "select * from mvc_board_tbl where boardNo = ?";
		BoardDTO dto = new BoardDTO();
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPassword);
			pstmt = conn.prepareStatement(qurey4);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
				if(rs.next()) {
					dto.setBoardNo(rs.getInt("boardNo")); 		// dto.setter (컬럼의 값)
					dto.setBoardTitle(rs.getString("boardTitle"));
					dto.setBoardContent(rs.getString("boardContent"));		
					dto.setBoardId(rs.getString("boardId"));
					dto.setBoardRegDate(rs.getDate("boardRegDate"));
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		return dto;
	}

	//5. 게시판제목 조회
	@Override
	public List<BoardDTO> boardSelectByTitle(String boardTitle) {
		System.out.println("BoardDAOImpl - boardSelectByTitle()");
		String qurey5 = "select * from mvc_board_tbl where boardTitle like ?";
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String ti = "%"+boardTitle+"%";
		BoardDTO dto = new BoardDTO();
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPassword);
			pstmt = conn.prepareStatement(qurey5);
			pstmt.setString(1, ti);
			rs = pstmt.executeQuery();
				while(rs.next()) {
					dto.setBoardNo(rs.getInt("boardNo")); 		// dto.setter (컬럼의 값)
					dto.setBoardTitle(rs.getString("boardTitle"));
					dto.setBoardContent(rs.getString("boardContent"));		
					dto.setBoardId(rs.getString("boardId"));
					dto.setBoardRegDate(rs.getDate("boardRegDate"));
					list.add(dto);
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;
	}
	//6. 게시판 전체목록 조회
	@Override
	public List<BoardDTO> boardSelectAll() {
		System.out.println("BoardDAOImpl - boardSelectAll()");
		String qurey6 = "select * from mvc_board_tbl order by boardNo asc";
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPassword);
			pstmt = conn.prepareStatement(qurey6);
			rs = pstmt.executeQuery();
				while(rs.next()){
					
					BoardDTO dto = new BoardDTO();
					dto.setBoardNo(rs.getInt("boardNo")); 		// dto.setter (컬럼의 값)
					dto.setBoardTitle(rs.getString("boardTitle"));
					dto.setBoardContent(rs.getString("boardContent"));		
					dto.setBoardId(rs.getString("boardId"));
					dto.setBoardRegDate(rs.getDate("boardRegDate"));
					list.add(dto);
					//DTO 생성 -> rs -> setter로 담는다. -> list에 추가
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;
	}
	

}
