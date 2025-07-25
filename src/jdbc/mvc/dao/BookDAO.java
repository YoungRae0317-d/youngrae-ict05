package jdbc.mvc.dao;

import java.util.List;

import jdbc.mvc.dto.BookDTO;

public interface BookDAO {
	
	//1. 도서 추가
	public int bookInsert(BookDTO dto);
	
	//2. 도서 수정
	public int bookUpdate(BookDTO dto);
	
	//3. 도서 삭제
	public int bookDelete(int bookId);
	
	//4. 도서아이디로 조회
	public BookDTO bookSelectById(int bookId);
	
	//5. 도서목록으로 조회
	public List<BookDTO> bookSelectByTitle(String title);
	
	//6. 전체목록 조회
	public List<BookDTO> bookSelectAll();

}
