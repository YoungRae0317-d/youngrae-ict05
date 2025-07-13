package jdbc.mvc.view;

import java.util.Scanner;

import jdbc.mvc.controller.BoardController;
import jdbc.mvc.controller.BookController;
import jdbc.mvc.dto.BoardDTO;
import jdbc.mvc.dto.BookDTO;

public class Menu {
	
	//입력을 위한 스캐너
	Scanner scan = new Scanner(System.in);
	BookController bc = new BookController();
	BookDTO dto = new BookDTO();
	BoardController bc2 = new BoardController();
	BoardDTO dto2 = new BoardDTO();
	//1. 도서관리 2. 게시판 3. 지역맛집 4. 종료
	public void displayMenu() {
		while(true) {
			System.out.println("*--------------------------------------------*");
			System.out.println("	1. 도서관리	2. 게시판 	3. 지역맛집  4. 종료   ");
			System.out.println("*--------------------------------------------*");
			System.out.print("▶ 메뉴선택 : ");
			int menuNo = scan.nextInt();
			scan.nextLine();
			
			switch(menuNo) {
			case 1 :
				book_menu();
				break;
			case 2 :
				board_menu();
				break;
			case 3 :
				break;
			case 4 :
				System.out.println("프로그램을 종료합니다.");
				System.out.println();
				return;
			default :
				System.out.println("메뉴를 다시 선택해주세요.");
				break;
			}
		}
	}
	// -----------------------------------------------
	// 1. 도서관리 메뉴
	public void book_menu() {
//		while(true) {
			System.out.println("<<< book_menu >>>");
			System.out.println("*--------------------------------------------*");
			System.out.println("	1. 추가	2. 수정 	3. 삭제  4. 도서아이디 조회 5.도서목록 조회 6. 전체목록 조회	7. 종료");
			System.out.println("*--------------------------------------------*");
			System.out.print("▶ 메뉴선택 : ");
			int menuNo = scan.nextInt();
			scan.nextLine();
			
			switch(menuNo) {
			case 1 :
				bc.bookAdd(bookInput());
				break;
				
			case 2 :
				bc.bookUpdate(bookUpdat());
				break;
				
			case 3 :
				bc.bookDelete(bookDelet());
				break;

			case 4 :
				bc.bookSelectId(bookId());
				break;

			case 5 :
				bc.bookSelectTitle(bookTitle());
				break;

			case 6 :
				bc.bookSelectAll();
				break;
			case 7 :
				System.out.println("프로그램을 종료합니다.");
				System.out.println();
				return;
			default :
				System.out.println("메뉴를 다시 선택해주세요.");
			}
//		}
	}
	
	public int bookId() {
		System.out.println("도서 ID입력 : ");
		return Integer.parseInt(scan.nextLine()); //String -> int
	}
	
	public String bookTitle() {
		System.out.println("도서 타이틀 입력 : ");
		return scan.nextLine();
	}
	
	
	
	// 1-1. book 추가
	public BookDTO bookInput() {
		
		//콘솔에서 입력받은 값 -> setter로 BookDTO 멤버변수에 전달
		// BookDTO 생성

		
		System.out.print("도서명 : ");
		String title = scan.nextLine();
		dto.setTitle(title);
		
		System.out.print("저자 : ");
		String author = scan.nextLine();
		dto.setAuthor(author);
		
		System.out.print("출판사 : ");
		String publisher = scan.nextLine();
		dto.setPublisher(publisher);
		
		System.out.print("가격 : ");
		int price = scan.nextInt();
		dto.setPrice(price);
		
		return dto;
		
	}
	//1-2. Book 수정
	public BookDTO bookUpdat() {
		System.out.print("책번호 : ");
		int bookid = scan.nextInt();
		dto.setBookId(bookid);
		String asdqwe = scan.nextLine(); 
		
		System.out.print("도서명 : ");
		String title = scan.nextLine();
		dto.setTitle(title);
		
		System.out.print("저자 : ");
		String author = scan.nextLine();
		dto.setAuthor(author);
		
		System.out.print("출판사 : ");
		String publisher = scan.nextLine();
		dto.setPublisher(publisher);
		
		System.out.print("가격 : ");
		int price = scan.nextInt();
		dto.setPrice(price);
		
		return dto;
	}
	
	//1-3. Book 삭제
	public int bookDelet() {
		System.out.print("책번호 : ");
		int bookid = scan.nextInt();
		dto.setBookId(bookid);
		
		return bookid;
	}
	
	//1-4. BookID 조회
	public int bookSelect() {
		System.out.println("책번호 : ");
		int bookid = scan.nextInt();
		dto.setBookId(bookid);
		return bookid;
	}
	
	// -----------------------------------------------
	// 2. 게시판 메뉴
	public void board_menu() {
//		while(true) {
			System.out.println("<<< board_menu >>>");
			System.out.println("*--------------------------------------------*");
			System.out.println("	1. 추가	2. 수정 	3. 삭제  4. 게시판번호 조회 5.게시판제목 조회 6. 전체목록 조회	7. 종료");
			System.out.println("*--------------------------------------------*");
			System.out.print("▶ 메뉴선택 : ");
			int menuNo = scan.nextInt();
			scan.nextLine();
			
			switch(menuNo) {
			case 1 :
				bc2.boardAdd(boardInput());
				break;
				
			case 2 :
				bc2.boardUpdate(boardUpdat());
				break;
				
			case 3 :
				bc2.boardDelete(boardDelet());
				break;

			case 4 :
				bc2.boardSelectNo(boardNo());
				break;

			case 5 :
				bc2.boardSelectTitle(boardTitle());
				break;

			case 6 :
				bc2.boardSelectAll();
				break;
			case 7 :
				System.out.println("프로그램을 종료합니다.");
				System.out.println();
				return;
			default :
				System.out.println("메뉴를 다시 선택해주세요.");
			}
//		}
	}
	
	public int boardNo() {
		System.out.println("게시판 번호입력 : ");
		return Integer.parseInt(scan.nextLine()); //String -> int
	}
	
	public String boardTitle() {
		System.out.println("게시판 타이틀 입력 : ");
		return scan.nextLine();
	}
	
	
	
	// 1-1. 게시판 추가
	public BoardDTO boardInput() {
		
		//콘솔에서 입력받은 값 -> setter로 BookDTO 멤버변수에 전달
		// BookDTO 생성

		
		System.out.print("글제목 : ");
		String boardTitle = scan.nextLine();
		dto2.setBoardTitle(boardTitle);
		
		System.out.print("글내용 : ");
		String boardContent = scan.nextLine();
		dto2.setBoardContent(boardContent);
		
		System.out.print("작성자 : ");
		String boardId = scan.nextLine();
		dto2.setBoardId(boardId);
		
		return dto2;
		
	}
	//1-2. 게시판 수정
	public BoardDTO boardUpdat() {
		System.out.print("글번호 : ");
		int boardNo = scan.nextInt();
		dto2.setBoardNo(boardNo);
		String asdqwe = scan.nextLine(); 
		
		System.out.print("글제목 : ");
		String boardTitle = scan.nextLine();
		dto2.setBoardTitle(boardTitle);
		
		System.out.print("글내용 : ");
		String boardContent = scan.nextLine();
		dto2.setBoardContent(boardContent);
		
		System.out.print("작성자 : ");
		String boardId = scan.nextLine();
		dto2.setBoardId(boardId);
		
		return dto2;
	}
	
	//1-3. 게시판 삭제
	public int boardDelet() {
		System.out.print("글번호 : ");
		int boardNo = scan.nextInt();
		dto2.setBoardNo(boardNo);
		
		return boardNo;
	}
	
	//1-4. BoardNo 조회
	public int boardSelect() {
		System.out.println("글번호 : ");
		int boardNo = scan.nextInt();
		dto2.setBoardNo(boardNo);
		return boardNo;
	}
	
}
