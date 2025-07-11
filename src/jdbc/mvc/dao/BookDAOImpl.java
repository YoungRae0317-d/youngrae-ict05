package jdbc.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.mvc.dto.BookDTO;

//DAO - DB 처리(DB연결, 데이터 CRUD)
public class BookDAOImpl implements BookDAO{
	//싱글톤
	private static BookDAOImpl dao = new BookDAOImpl();
	private BookDAOImpl() {};
	public static BookDAOImpl getInstance(){
		if(dao ==null) {
			dao = new BookDAOImpl();
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
	
	
	//1. 도서 추가
	@Override
	public int bookInsert(BookDTO dto) {
		System.out.println("BookDAOImpl - bookInsert()");
		int insertCnt = 0;
		String qurey = "INSERT INTO mvc_book_tbl(bookid, title, author, publisher, price) "
			+ " VALUES((SELECT NVL(MAX(bookId)+1,1) FROM mvc_book_tbl), ?, ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPassword); //오라클 연결
			pstmt = conn.prepareStatement(qurey);	// SQL문 작성
			pstmt.setString(1, dto.getTitle()); // 1은 물음표 위치, 
			pstmt.setString(2, dto.getAuthor());
			pstmt.setString(3, dto.getPublisher());
			pstmt.setInt(4, dto.getPrice());
			
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

	//2. 도서 수정
	@Override
	public int bookUpdate(BookDTO dto) {
		System.out.println("BookDAOImpl - bookUpdate()");
		int updateCnt = 0;
		String qurey2 = "UPDATE mvc_book_tbl "
			+ " Set title = ?,author = ?,publisher = ?,price = ?,pubdate = sysdate " + " WHERE bookId = ?";
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPassword); //오라클 연결
			pstmt = conn.prepareStatement(qurey2);	// SQL문 작성
			pstmt.setString(1, dto.getTitle()); 
			pstmt.setString(2, dto.getAuthor());
			pstmt.setString(3, dto.getPublisher());
			pstmt.setInt(4, dto.getPrice()); 
			pstmt.setInt(5, dto.getBookId());
			
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

	//3. 도서 삭제
	@Override
	public int bookDelete(int bookId) {
		System.out.println("BookDAOImpl - bookDelete()");
		int deleteCnt = 0;
		String qurey3 = "delete from mvc_book_tbl " + " where bookId = ?";
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPassword);
			pstmt = conn.prepareStatement(qurey3);
			pstmt.setInt(1, bookId);
			
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
	
	//4. 도서아이디 조회
	@Override
	public BookDTO bookSelectById(int bookId) {
		System.out.println("BookDAOImpl - bookSelectById()");

		String qurey4 = "select * from mvc_book_tbl where bookId = ?";
		BookDTO dto = new BookDTO();
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPassword);
			pstmt = conn.prepareStatement(qurey4);
			pstmt.setInt(1, bookId);
			rs = pstmt.executeQuery();
				if(rs.next()) {
					dto.setBookId(rs.getInt("bookId")); 		// dto.setter (컬럼의 값)
					dto.setTitle(rs.getString("title"));
					dto.setAuthor(rs.getString("author"));		
					dto.setPublisher(rs.getString("publisher"));
					dto.setPrice(rs.getInt("price"));
					dto.setPubdate(rs.getString("pubdate"));
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
	
	//5. 도서목록 조회
	@Override
	public List<BookDTO> bookSelectByTitle(String title) {
		
		System.out.println("BookDAOImpl - bookSelectByTitle()");
		String qurey5 = "select * from mvc_book_tbl where title like ?";
		List<BookDTO> list = new ArrayList<BookDTO>();
		String ti = "%"+title+"%";
		BookDTO dto = new BookDTO();
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPassword);
			pstmt = conn.prepareStatement(qurey5);
			pstmt.setString(1, ti);
			rs = pstmt.executeQuery();
				while(rs.next()) {
					dto.setBookId(rs.getInt("bookId")); 		// dto.setter (컬럼의 값)
					dto.setTitle(rs.getString("title"));
					dto.setAuthor(rs.getString("author"));		
					dto.setPublisher(rs.getString("publisher"));
					dto.setPrice(rs.getInt("price"));
					dto.setPubdate(rs.getString("pubdate"));
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
	
	//6. 전체목록 조회
	@Override
	public List<BookDTO> bookSelectAll() {
		System.out.println("BookDAOImpl - bookSelectAll()");
		String qurey6 = "select * from mvc_book_tbl order by bookId asc";
		
		List<BookDTO> list = new ArrayList<BookDTO>();
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPassword);
			pstmt = conn.prepareStatement(qurey6);
			rs = pstmt.executeQuery();
				while(rs.next()){
					
					BookDTO dto = new BookDTO();
					dto.setBookId(rs.getInt("bookId")); 		// dto.setter (컬럼의 값)
					dto.setTitle(rs.getString("title"));
					dto.setAuthor(rs.getString("author"));		
					dto.setPublisher(rs.getString("publisher"));
					dto.setPrice(rs.getInt("price"));
					dto.setPubdate(rs.getString("pubdate"));
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
