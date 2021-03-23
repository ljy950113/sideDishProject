package team4;

import java.util.Scanner;

public class Manager implements Food{
	Scanner sc = new Scanner(System.in);
	
	String[] soupName = {"갈비탕", "육개장", "된장찌개", "김치찌개","부대찌개"}; // 탕종류 배열 0열에 육개장 1열에 김치찌개 이런식
	int[] soupPrice = new int[5];
	int[] soupAmount = new int[5]; // 0갈비탕 1육개장 2된장찌개 3김치찌개 4부대찌개
	String[] sideName = {"무말랭이", "메추리알", "콩자반", "멸치볶음","배추김치"};// 반찬류 배열 0열에 배추김치, 1열에 갓김치
	int[] sidePrice  = new int[5];
	int[] sideAmount = new int[5];
	int password = 1234;
	boolean flag = true;
	
	public void password() {
			do{
				System.out.println("패스워드를 입력해주세요");
				int pw = sc.nextInt();
				this.password = password;
				if(pw == password) {
				System.out.println("환영합니다.");
				managerMode();
				}else {
				System.out.println("관리자가 아닙니다.");
				start();
			}
		}while(flag);
	}
	public void start() {

		Buyer buyer = new Buyer();
		
		do {
			System.out.println("<<반찬가게 관리 시스템>>");
			System.out.println("1. 관리자 모드");
			System.out.println();
			System.out.println("2. 고객 모드");
			System.out.println();
			System.out.println("3. 프로그램 종료");
			System.out.println("선택 > ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1: password();  break;
			case 2: buyer.search(); break;
			case 3: System.out.println("시스템을 종료합니다."); break;
			default : System.out.println("메뉴를 다시 선택하세요");
			}
		}while(flag);
	}
	public void managerMode() {
			
			while(flag){
				System.out.println("<<관리자 모드>>");
				System.out.println("1. 입고");
				System.out.println("2. 삭제");
				System.out.println("3. 제품조회");
				System.out.println("4. 고객관리");
				System.out.println("5. 돌아가기");
				int select = sc.nextInt();
				switch(select) {
				case 1: entering();  break;
				case 2: delete();	break;
				case 3: search();	break;
				case 4: customer();	break;
				case 5: start();
							break;
				default : System.out.println("다시 입력해주세요"); break;
				}
			}
	}
	public void entering() {
		boolean run = true;
		while(run) {
			System.out.println("<<입고>>");
			System.out.println("1. 국  2. 반찬");
			System.out.println("선택>");
			int select = sc.nextInt();
			
			switch(select) {
			case 1: 
				System.out.println("1. 갈비탕 | 2. 육개장 | 3. 된장찌개 | 4. 김치찌개 | 5. 부대찌개 ");
				System.out.println("선택>");
				int selectNo = sc.nextInt();
				if(selectNo == 1) {
					System.out.println("1. 갈비탕");
					System.out.println("수량 입력>");
					soupAmount[0] = sc.nextInt();
					System.out.println("가격 입력>");
					soupPrice[0] = sc.nextInt();
				}else if(selectNo ==2) {
					System.out.println("2번 육개장");
					System.out.println("수량입력>");
					soupAmount[1] = sc.nextInt();
					System.out.println("가격입력>");
					soupAmount[1] = sc.nextInt();
				}else if(selectNo ==3) {
					System.out.println("3번 된장찌개");
					System.out.println("수량입력>");
					soupAmount[2] = sc.nextInt();
					System.out.println("가격입력>");
					soupAmount[2] = sc.nextInt();
				}else if(selectNo ==4) {
					System.out.println("4번 김치찌개");
					System.out.println("수량입력>");
					soupAmount[3] = sc.nextInt();
					System.out.println("가격입력>");
					soupAmount[3] = sc.nextInt();
				}else if(selectNo ==5) {
					System.out.println("5번 부대찌개");
					System.out.println("수량입력>");
					soupAmount[4] = sc.nextInt();
					System.out.println("가격입력>");
					soupAmount[4] = sc.nextInt();
				}else {
					System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
				}
				System.out.println("계속 하시겠습니까?(Y/N)");
				String ys = sc.next();
				if(ys.equals("y")) run = true;
				if(ys.equals("n")) run = false;
				break;
			case 2:
				System.out.println("1. 무말랭이 | 2. 메추리알 | 3. 콩자반 | 4. 멸치볶음 | 5.배추김치");
				System.out.println("선택>");
					selectNo = sc.nextInt();
				if(selectNo == 1) {
					System.out.println("1. 무말랭이");
					System.out.println("수량 입력>");
					sideAmount[0] = sc.nextInt();
					System.out.println("가격 입력>");
					sidePrice[0] = sc.nextInt();
				}else if(selectNo ==2) {
					System.out.println("2번 메추리알");
					System.out.println("수량입력>");
					sideAmount[1] = sc.nextInt();
					System.out.println("가격입력>");
					sideAmount[1] = sc.nextInt();
				}else if(selectNo ==3) {
					System.out.println("3번 콩자반");
					System.out.println("수량입력>");
					sideAmount[2] = sc.nextInt();
					System.out.println("가격입력>");
					sideAmount[2] = sc.nextInt();
				}else if(selectNo ==4) {
					System.out.println("4번 멸치볶음");
					System.out.println("수량입력>");
					sideAmount[3] = sc.nextInt();
					System.out.println("가격입력>");
					sideAmount[3] = sc.nextInt();
				}else if(selectNo ==5) {
					System.out.println("5번 멸치볶음");
					System.out.println("수량입력>");
					sideAmount[4] = sc.nextInt();
					System.out.println("가격입력>");
					sideAmount[4] = sc.nextInt();
				}else {
					System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
				}
				System.out.println("계속 하시겠습니까?(Y/N)");
				ys = sc.next();
				if(ys.equals("y")) flag = true;
				break;
			default : System.out.println("잘못입력하셨습니다. 다시입력하세요"); break;
			}
		}
	}
	public void search() {
			System.out.println("---------------<<제품 조회>>--------------------");
			System.out.println("반찬명 | 반찬 수량 | 폐기 갯수 | 반찬평점");
			System.out.println("------------------<<국류>>------------------------");
			System.out.println("1. 갈비탕 |" + soupAmount[0] + " ," +"??" + "??");
			System.out.println("2. 육개장 |" + soupAmount[1] + " ," + "??" + "??");
			System.out.println("3. 된장찌개 |" + soupAmount[2] +  ", " +"??" + "??");
			System.out.println("4. 김치찌개 |" + soupAmount[3] + " ," + "??" + "??");
			System.out.println("5. 부대찌개 |" + soupAmount[4] + " ," + "??" + "??");
			System.out.println("------------------<<반찬류>>------------------------");
			System.out.println("1. 무말랭이 |" + sideAmount[0] +  ", " +"??" + "??");
			System.out.println("2. 메추리알 |" + sideAmount[1] +  " ," +"??" + "??");
			System.out.println("3. 콩자반 |" + sideAmount[2] +  " ," +"??" + "??");
			System.out.println("4. 멸치볶음 |" + sideAmount[3] +  ", " +"??" + "??");
			System.out.println("5. 배추김치 |" + sideAmount[4] +  ", " +"??" + "??");
	}
	public void delete() {
		System.out.println("<<삭제>>");
		System.out.println("1 국  2. 반찬");
		System.out.println("선택 > ");
		int selectNo = sc.nextInt();
		if(selectNo == 1) {
			System.out.println("1. 갈비탕 | 2. 육개장 | 3. 된장찌개 | 4. 김치찌개 | 5.부대찌개");
			System.out.println("삭제하실 제품을 선택하세요");
			System.out.println("선택>");
			int select = sc.nextInt();
			
			if(select == 1 || select ==2 || select==3 || select==4 || select==5) {
				System.out.println("폐기하실 개수를 정해주세요");
				int termin = sc.nextInt();
			}
		}
		if(selectNo == 2) {
			System.out.println("1. 무말랭이 | 2. 메추리알 | 3. 콩자반 | 4. 멸치볶음 | 5. 배추김치");
			System.out.println("삭제하실 제품을 선택하세요");
			System.out.println("선택>");
			int select = sc.nextInt();
			
			if(select == 1 || select ==2 || select==3 || select==4 || select==5) {
				System.out.println("폐기하실 개수를 정해주세요");
				int termin = sc.nextInt();
			}
		}
	}
	public void customer() {
		System.out.println("<<고객관리>>");
		System.out.println("고객No. | 총 포인트");
		
	}
	
}
