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
	boolean flag = true;
	
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
			case 2: Buyer.buyerPrint();; break;
			case 3: System.out.println("시스템을 종료합니다."); flag = false; break;
			default : System.out.println("메뉴를 다시 선택하세요");
			}
		}while(flag);
	}
	
	public void password() {
			int comparition = 1;
			for(int i=0; i < comparition; i++) {
				System.out.println("패스워드를 입력해주세요");
				int pw = sc.nextInt();
				if(password == pw) {
					System.out.println("관리자가 맞습니다.");
					managerMode();
				}else {
					System.out.println("패스워드가 옳바르지 않습니다. 다시 입력하세요");
					comparition++;
					if(comparition ==4) {
						System.out.println("3회 이상 틀렸습니다. 메인으로 돌아갑니다.");
						start();
						break;
					}
				}
			}
	}
	public void managerMode() {
			
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
	public void entering() {
		boolean run = true;
			while(run) {
			System.out.println("<<입고>>");
			System.out.println("1. 국  2. 반찬");
			System.out.println("선택>");
			int select = sc.nextInt();
			
			switch(select) {
			case 1: 
				System.out.println("1. " + soupName[0] +" | " +  " 2. " + soupName[1] + " | " +
											" 3. "  +soupName[2] + " | " + " 4. " +soupName[3] +" | " + 
											" 5. " + soupName[4]);
				System.out.println("선택>");
				int selectNo = sc.nextInt();
				for(int i=0; i < soupName.length; i++) {
					if(selectNo == i+1) {
						System.out.println((i+1)+ ". " +soupName[i]);
						System.out.println("수량 입력>");
						soupAmount[i] = sc.nextInt();
						System.out.println("가격 입력>");
						soupPrice[i] = sc.nextInt();
					}
				}
				System.out.println("계속 하시겠습니까?(Y/N)");
				String ys = sc.next();
				if(ys.equals("n") || ys.equals("N")) managerMode();
				break;
			case 2:
				System.out.println("1. " + sideName[0] +" | " +  " 2. " + sideName[1] + " | " +
						" 3. "  +sideName[2] + " | " + " 4. " +sideName[3] +" | " + 
						" 5. " + sideName[4]);
				System.out.println("선택>");
				selectNo = sc.nextInt();
				for(int i=0; i < sideName.length; i++) {
					if(selectNo == i+1) {
						System.out.println((i+1)+ ". " +sideName[i]);
						System.out.println("수량입력>");
						sideAmount[i] = sc.nextInt();
						System.out.println("가격입력>");
						sidePrice[i] = sc.nextInt();
					}
			
				}
				System.out.println("계속 하시겠습니까?(Y/N)");
				ys = sc.next();
				if(ys.equals("n") || ys.equals("N")) managerMode();
				break;
			default : System.out.println("잘못입력하셨습니다. 다시 입력해주세요"); break;
			}
			run = false;
		}
	}

	public void search() {
			int i;
			System.out.println("---------------<<제품 조회>>--------------------");
			System.out.println("------------------<<국류>>------------------------");
			System.out.println("반찬명 | 반찬 수량 | 폐기 갯수 | 반찬평점");
			for (  i = 0; i < soupName.length; i++) {
				System.out.println(sideName[i] + " | " + sideAmount[i] + " | " + "폐기개수" + " | " + "반찬평점");
			}
			System.out.println();
			System.out.println("------------------<<반찬류>>------------------------");
			System.out.println("반찬명 | 반찬 수량 | 폐기 갯수 | 반찬평점");
			for (  i = 0; i < soupName.length; i++) {
				System.out.println(soupName[i] + " | " + soupAmount[i] + " | " + "폐기개수" + " | " + "반찬평점");
			}
			System.out.println();
			System.out.println("돌아가기-->");
			String yn = sc.next();
			if(yn.equals("y") || yn.equals("Y")) {managerMode();}
	}
	public void delete() {
		System.out.println("<<삭제>>");
		System.out.println("1 국  2. 반찬");
		System.out.println("선택 > ");
		int selectNo = sc.nextInt();
		if(selectNo == 1) {
			System.out.println("1. " + soupName[0] +" | " +  " 2. " + soupName[1] + " | " +
					" 3. "  +soupName[2] + " | " + " 4. " +soupName[3] +" | " + 
					" 5. " + soupName[4]);
			System.out.println("삭제하실 제품을 선택하세요");
			System.out.println("선택>");
			int select = sc.nextInt();
			
			if(select == 1 || select ==2 || select==3 || select==4 || select==5) {
				System.out.println("폐기하실 개수를 정해주세요");
				int termin = sc.nextInt();
			}
		}
		if(selectNo == 2) {
			System.out.println("1. " + sideName[0] +" | " +  " 2. " + sideName[1] + " | " +
					" 3. "  +sideName[2] + " | " + " 4. " +sideName[3] +" | " + 
					" 5. " + sideName[4]);
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
