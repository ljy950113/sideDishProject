package team4;

import java.util.Scanner;

public class Calculator { // 계산관련 로직을 담는 객체
	
	int choice; //선택하는 값
	double result; //고객이 입력한 평점을 계산하고 변수에 결과 값을 담음
	int sumpoint; //고객의 총 포인트 금액
	
	void start() {
		
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		Buyer buyer = new Buyer();
		Manager manager = new Manager();
		
		do {
			
			System.out.println("<< 반찬가게 관리 시스템 >>");
			System.out.println("1. 관리자 모드");
			System.out.println();
			System.out.println("2. 고객 모드");
			System.out.println();
			System.out.println("3. 프로그램 종료");
			System.out.print("선택 >");
			int choice = sc.nextInt();

			switch(choice) {
			case 1:  manager.password(); flag = false; break;
			case 2:  //buyer.search(); break;
			case 3: flag = false; System.out.println("반찬가게 관리 시스템을 종료합니다."); break;
				default : System.out.println("메뉴 선택을 다시하세요.");
			}
		} while(flag);
		
		
	}
	
	
	void evaluation(int jumsu) { //고객이 입력한 평점을 계산하는 메소드
		
		System.out.println("평점을 입력해 주세요.");
		System.out.println();
		System.out.print("평점 >");
		
		System.out.println();
		System.out.println("평점 입력이 완료되었습니다.");
		System.out.println("~이용 해주셔서 감사합니다~");
		
		
	}
	
	
	
	void point() { //고객의 포인트 적립 계산 메소드 반찬류 2%, 국류 3%
		// 반찬포인트 = 가격 * 0.2, 국류포인트는 = 가격 * 0.3
		// 총포인트 += 포인트;
		
		
	}

}
