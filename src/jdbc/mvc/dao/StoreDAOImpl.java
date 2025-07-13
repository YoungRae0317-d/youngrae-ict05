package jdbc.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.mvc.dto.BoardDTO;
import jdbc.mvc.dto.StoreDTO;

public class StoreDAOImpl implements StoreDAO{
	private static StoreDAOImpl dao = new StoreDAOImpl();
	private StoreDAOImpl() {};
	public static StoreDAOImpl getInstance() {
		if(dao==null) {
			dao = new StoreDAOImpl();
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

	//1. 가게 정보 추가
	@Override
	public int storeInsert(StoreDTO dto) {
		int insertCnt = 0;
		String qurey = "INSERT INTO mvc_store_tbl(storeNo, storeName, storeFood, storeAddress, storeContent, storePhone, storeTime) "
			+ " VALUES((SELECT NVL(MAX(storeNo)+1,1) FROM mvc_store_tbl), ?, ?, ?, ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPassword); //오라클 연결
			pstmt = conn.prepareStatement(qurey);	// SQL문 작성
			pstmt.setString(1, dto.getStoreName()); // 1은 물음표 위치, 
			pstmt.setString(2, dto.getStoreFood());
			pstmt.setString(3, dto.getStoreAddress());
			pstmt.setString(4, dto.getStoreContent());
			pstmt.setString(5, dto.getStorePhone());
			pstmt.setString(6, dto.getStoreTime());
			
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

	//2. 가게 정보 수정
	@Override
	public int storeUpdate(StoreDTO dto) {
		int updateCnt = 0;
		String qurey2 = "UPDATE mvc_board_tbl "
			+ " Set storeName = ?, storeFood = ?, storeAddress = ?, storeContent = ?, storePhone = ?, storeTime = ? " + " WHERE boardNo = ? " + " WHERE storeNo = ?";
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPassword); //오라클 연결
			pstmt = conn.prepareStatement(qurey2);	
			pstmt.setString(1, dto.getStoreName()); 
			pstmt.setString(2, dto.getStoreFood());
			pstmt.setString(3, dto.getStoreAddress());
			pstmt.setString(4, dto.getStoreContent());
			pstmt.setString(5, dto.getStorePhone());
			pstmt.setString(6, dto.getStoreTime());
			
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

	//3. 가게이름으로 삭제
	@Override
	public String storeDelete(String storeName) {
		// TODO Auto-generated method stub
		return null;
	}

	//4. 지역으로 가게 조회
	@Override
	public StoreDTO storeSelectByRegion(String storeAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	//5. 음식으로 가게 조회
	@Override
	public List<StoreDTO> storeSelectByFood(String storeFood) {
		String qurey5 = "select * from mvc_store_tbl where storeFood like ?";
		List<StoreDTO> list = new ArrayList<StoreDTO>();
		String ti = "%"+storeFood+"%";
		StoreDTO dto = new StoreDTO();
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPassword);
			pstmt = conn.prepareStatement(qurey5);
			pstmt.setString(1, ti);
			rs = pstmt.executeQuery();
				while(rs.next()) {
					dto.setStoreNo(rs.getInt("storeNo")); 		// dto.setter (컬럼의 값)
					dto.setStoreName(rs.getString("storeName"));
					dto.setStoreFood(rs.getString("storeFood"));		
					dto.setStoreAddress(rs.getString("storeAddress"));
					dto.setStoreContent(rs.getString("storeContent"));
					dto.setStorePhone(rs.getString("storePhone"));
					dto.setStoreTime(rs.getString("storeTime"));
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

	//6. 전체 조회
	@Override
	public List<StoreDTO> storeSelectAll() {
		String qurey6 = "select * from mvc_store_tbl order by boardNo asc";
		
		List<StoreDTO> list = new ArrayList<StoreDTO>();
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPassword);
			pstmt = conn.prepareStatement(qurey6);
			rs = pstmt.executeQuery();
				while(rs.next()){
					
					StoreDTO dto = new StoreDTO();
					dto.setStoreNo(rs.getInt("storeNo")); 		// dto.setter (컬럼의 값)
					dto.setStoreName(rs.getString("storeName"));
					dto.setStoreFood(rs.getString("storeFood"));		
					dto.setStoreAddress(rs.getString("storeAddress"));
					dto.setStoreContent(rs.getString("storeContent"));
					dto.setStorePhone(rs.getString("storePhone"));
					dto.setStoreTime(rs.getString("storeTime"));
					list.add(dto);
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
