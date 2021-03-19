package team4;

import java.util.Scanner;

public class Business {

	public static void main(String[] args) {
		
		Buyer buyer = new Buyer();
		Manager manager = new Manager();

		Scanner sc = new Scanner(System.in);
		boolean flag = true;


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
			case 2:  break;
			case 3: flag = false; System.out.println("반찬가게 관리 시스템을 종료합니다."); break;
				default : System.out.println("메뉴 선택을 다시하세요.");
			}
		} while(flag);

	}

}
