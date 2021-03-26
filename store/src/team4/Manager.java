package team4;

import java.util.Scanner;

public class Manager implements Food{
	Scanner sc = new Scanner(System.in);
	
	String[] soupName = {"갈비탕", "육개장", "된장찌개", "김치찌개","부대찌개"}; // 탕종류 배열 0열에 육개장 1열에 김치찌개 이런식
	int[] soupPrice = new int[6];
	int[] soupAmount = new int[6]; // 0갈비탕 1육개장 2된장찌개 3김치찌개 4부대찌개
	String[] sideName = {"무말랭이", "메추리알", "콩자반", "멸치볶음","배추김치"};// 반찬류 배열 0열에 배추김치, 1열에 갓김치
	int[] sidePrice  = new int[6];
	int[] sideAmount = new int[6];
	int[] remove = new int[6];
	int[] rest1 = new int[6]; // 국 잔여량
	int[] rest2 = new int[6]; // 반찬 잔여량
	
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
			case 2: Buyer.buyerPrint(); break;
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
				System.out.println("1. " + soupName[0] +" | " +  " 2. " + soupName[1] + " | " + " 3. "  +soupName[2] + " | " + " 4. " +soupName[3] +" | " + 	" 5. " + soupName[4]);
				System.out.println("선택>");
				int selectNo = sc.nextInt();
				for(int i=0; i < soupName.length; i++) {
					if(selectNo == i+1) {
						System.out.println((i+1)+ ". " +soupName[i]);
						System.out.println("수량 입력>");
						soupAmount[i] += sc.nextInt();
						System.out.println("가격 입력>");
						soupPrice[i] = sc.nextInt();
					}//selectNo if문 끝
					if(selectNo > soupName.length) {
						System.out.println("1번부터 5번중에 선택해주세요");
						entering();
					}//6번찍었을때 돌아가기
				}//for문
				System.out.println("계속 하시겠습니까?(Y/N)");
				String ys = sc.next();
				if(ys.equals("n") || ys.equals("N")) {
					run = false;managerMode();
				}//ys 문
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
						sideAmount[i] += sc.nextInt();
						System.out.println("가격입력>");
						sidePrice[i] = sc.nextInt();
					}
					if(selectNo > sideName.length) {
						System.out.println("1번부터 5번중에 선택해주세요");
						entering();
						}//6번찍으면 돌아가기
				}//for문끝
				System.out.println("계속 하시겠습니까?(Y/N)");
				  ys = sc.next();
				if(ys.equals("n") || ys.equals("N")) {
				run = false;
				managerMode();
				}
				break;
			default : System.out.println("잘못입력하셨습니다. 다시 입력해주세요"); break;
			}
		}//while문 끝
	}


	public void delete() {
		boolean run = true;
		
			while(run) {
			System.out.println("<<삭제>>");
			System.out.println("1 국  2. 반찬");
			System.out.println("선택 > ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				System.out.println("1. " + soupName[0] +" | " +  " 2. " + soupName[1] + " | " +
											" 3. "  +soupName[2] + " | " + " 4. " +soupName[3] +" | " + 
											" 5. " + soupName[4]);
				System.out.println("선택>");
				int selectNo = sc.nextInt();
				for( int i=0; i < soupAmount.length; i++) {
					if(selectNo == i+1) {
						System.out.println((i+1)+ ". " +soupName[i]);
						System.out.println("몇개 폐기 하실래요?");
						remove[i] += sc.nextInt();
						rest1[i] = soupAmount[i]-remove[i];
						if(rest1[i] <=0) {
							System.out.println("뺄수없습니다.");
							rest1[i] = 0;
							}
						}//ifselct끝
					if(selectNo > soupName.length) {
					System.out.println("1번부터 5번중에 선택해주세요");
					delete();
					}//6번찍었을때
				}//for문 끝
				System.out.println("돌아가기-->(Y or N)");
				String yn = sc.next();
				if(yn.equals("y") || yn.equals("Y")) managerMode();
				if(yn.equals("n") || yn.equals("N")) delete();
				else System.out.println("잘못입력하셨습니다."); 	
				break;
			case 2:
				System.out.println("1. " + sideName[0] +" | " +  " 2. " + sideName[1] + " | " +
											" 3. " + sideName[2] + " | " + " 4. " +sideName[3] +" | " + 
											" 5. " + sideName[4]);
				System.out.println("선택>");
					selectNo = sc.nextInt();
				for( int i=0; i < sideAmount.length; i++) {
					if(selectNo == i+1) {
						System.out.println((i+1)+ ". " + sideName[i]);
						System.out.println("몇개 폐기 하실래요?");
						remove[i] += sc.nextInt();
						rest2[i] = sideAmount[i]-remove[i];
						if(rest2[i] <=0) {
							System.out.println("뺄수없습니다.");
							rest2[i] = 0;	}
						}
					if(selectNo > sideName.length) {
						System.out.println("1번부터 5번중에 선택해주세요");
						delete();
					}//6번찍었을때
			}//for문 끝
			System.out.println("돌아가기-->(Y or N)");
				yn = sc.next();
			if(yn.equals("y") || yn.equals("Y")) managerMode();
			if(yn.equals("n") || yn.equals("N")) delete();
			else System.out.println("잘못입력하셨습니다."); 
			break;
			default : System.out.println("잘못입력하셨습니다."); delete(); break;
			}//end switch
		}//end while
	}//end delete
	
	public void customer() {
		System.out.println("<<고객관리>>");
		System.out.println("고객No. | 총 포인트");
		
	}
	public void search() {
		int i;
		System.out.println("---------------<<제품 조회>>----------------------------");
		System.out.println("------------------<<국류>>-------------------------------");
		System.out.println("반찬명 | 입고 수량 |  잔여 갯수 | 반찬평점");
		for (  i = 0; i < soupName.length; i++) {
			System.out.println( soupName[i] + " | " + soupAmount[i] + " | " + rest1[i] + " | " + "반찬평점");
		}
		
		System.out.println();
		System.out.println("------------------<<반찬류>>-----------------------------");
		System.out.println("반찬명 | 반찬 수량 | 총 액수 | 잔여 갯수 | 반찬평점");
	
		for (  i = 0; i < sideName.length; i++) {
			System.out.println(sideName[i] + " | " + sideAmount[i]  + " | " + rest2[i] + " | " + "반찬평점");
		}
		System.out.println();
		
		System.out.println("돌아가기-->");
		String yn = sc.next();
		if(yn.equals("y") || yn.equals("Y")) {
			managerMode();
			}else {
				search();
			}
	}
	public  void customerSearch() {
		for(int i = 0; i < soupName.length; i++) {
			System.out.println(soupName[i] + " | " + soupAmount[i] + " | " + soupPrice[i]);
			System.out.println(sideName[i] + " | " + sideAmount[i] + " | " + sidePrice[i]);
		}
	}
}