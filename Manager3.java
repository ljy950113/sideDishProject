package team4prac;

import java.util.*;

public class Manager3 implements Food {
	static List<String>soupName = new ArrayList<String>();
	static List<String>sideName = new ArrayList<String>();
	static int[] soupPrice = new int[5];
	static int[] soupAmount = new int[5];
	static int[] sidePrice  = new int[5];
	static int[] sideAmount = new int[5];
	static int[] remove = new int[5];
	static int[] rest1 = new int[5]; // 국 잔여량
	static int[] rest2 = new int[5]; // 반찬 잔여량
	
	boolean flag = true;
	
	void add() {
		
	}
	public void start() { //첫 시작화면


		do {
			System.out.println("[ 반찬가게 관리 시스템  ]");
			System.out.println();
			System.out.println("1. 관리자 모드");
			System.out.println();
			System.out.println("2. 고객 모드");
			System.out.println();
			System.out.println("3. 프로그램 종료");
			System.out.print("선택 >");
			int select = Business3.sc.nextInt();

			switch(select) {
			case 1: password();  break;
			case 2: Buyer3.buyerMode();break;  
			case 3: System.out.println("시스템을 종료합니다."); flag = false; break;
			default : System.out.println("메뉴를 다시 선택하세요");
			}
		}while(flag);
	}
	
	public void password() { //관리자 비밀번호 입력화면
		int comparition = 1;
		for(int i=0; i < comparition; i++) {
			System.out.print("패스워드를 입력해주세요. >");
			int pw = Business3.sc.nextInt();
			if(password == pw) {
				System.out.println("관리자가 맞습니다.");
				managerMode();
			}else {
				System.out.println("패스워드가 옳바르지 않습니다. 다시 입력하세요");
				comparition++;
				if(comparition ==4) {
					System.out.println("3회 이상 틀렸습니다. 시작화면으로 돌아갑니다.");
					start();
					break;
				}
			}
		}
	}
	public void managerMode() { //매니저 메뉴

		System.out.println(" [ 관리자 모드 ] ");
		System.out.println("1. 입고");
		System.out.println("2. 삭제");
		System.out.println("3. 제품조회");
		System.out.println("4. 고객관리");
		System.out.println("5. 돌아가기");
		System.out.print("선택 >");
		int select = Business3.sc.nextInt();
		switch(select) {
		case 1: entering();  break;
		case 2: delete();	break;
		case 3: search();	break;
		case 4: customer();	break;
		case 5: start(); break;

		default : System.out.println("다시 입력해주세요"); break;
		}
	}
	public void entering() { //메뉴 입고화면
		boolean run = true;
		int select = 0;
		soupName.add("갈비탕"); 
		soupName.add("육개장");
		soupName.add("된장찌개");
		soupName.add("김치찌개");
		soupName.add("부대찌개");
		
		sideName.add("무말랭이");
		sideName.add("메추리알");
		sideName.add("콩자반");
		sideName.add("멸치볶음");
		sideName.add("배추김치");

		while(run) {
			
			
				System.out.println("[ 입고  ]");
				System.out.println("1. 국  2. 반찬");
				System.out.print("선택>");
				select = Business3.sc.nextInt();

			switch(select) {

			case 1: //국 입고
				System.out.println("                  < 입고 가능 목록  >                  ");
				System.out.println("1." + soupName.get(0) + " | " +  "2." + soupName.get(1) + " | " + 
											"3."  +soupName.get(2) + " | " + "4." +soupName.get(3) +" | " + 
											"5." + soupName.get(4));
				
				System.out.print("선택 >");
				int selectNo = Business3.sc.nextInt();
				for(int i=0; i < soupName.size(); i++) {
					if(selectNo == i+1) {
						System.out.println();
						System.out.println((i+1)+ "." +soupName.get(i));
						System.out.print("수량 입력 >");
						soupAmount[i] += Business3.sc.nextInt();
						rest1[i] = soupAmount[i];
						System.out.print("가격 입력 >");
						soupPrice[i] = Business3.sc.nextInt();
					}//selectNo if문 끝
					if(selectNo > soupName.size()) {
						System.out.println("1번부터 5번중에 선택해주세요");
						entering();
					}//6번찍었을때 돌아가기
				}//for문끝
				System.out.print("계속 하시겠습니까?(Y/N)");
				String ys = Business3.sc.next();
				if(ys.equals("n") || ys.equals("N")) {
					run = false;
					managerMode();
					break;
				}else if(ys.equals("y") || ys.equals("Y")) {
					break;
				}else {
					System.out.println("잘못된 입력입니다. 다시 입력해주세요."); break;
				}


			case 2: //반찬 입고
				System.out.println("                  < 입고 가능 목록  >                  ");
				System.out.println("1." + sideName.get(0) + " | " +  "2." + sideName.get(1) + " | " + 
											"3."  +sideName.get(2) + " | " + "4." +sideName.get(3) +" | " + 
											"5." + sideName.get(4));
				System.out.print("선택 >");
				selectNo = Business3.sc.nextInt();
				for(int i=0; i < sideName.size(); i++) {
					if(selectNo == i+1) {
						System.out.println();
						System.out.println((i+1)+ "." +sideName.get(i));
						System.out.print("수량 입력 >");
						sideAmount[i] += Business3.sc.nextInt();
						rest2[i] = sideAmount[i];
						System.out.print("가격 입력 >");
						sidePrice[i] = Business3.sc.nextInt();
					}//selectNo if문 끝
					if(selectNo > sideName.size()) {
						System.out.println("1번부터 5번중에 선택해주세요");
						entering();
					}//6번찍었을때 돌아가기
				}//for문끝
				System.out.print("계속 하시겠습니까?(Y/N)");
				ys = Business3.sc.next();
				if(ys.equals("n") || ys.equals("N")) {
					run = false;
					managerMode();
					break;
				}else if(ys.equals("y") || ys.equals("Y")) {
					break;
				}else {
					System.out.println("잘못된 입력입니다. 다시 입력해주세요."); break;
				}
			default : System.out.println("잘못입력하셨습니다. 다시 입력해주세요"); break;
			}
		}//while문 끝
	}
	
	public void delete() { //메뉴 삭제 화면
		boolean run = true;

		while(run) {
			System.out.println("[ 삭제  ]");
			System.out.println("1 국  2. 반찬");
			System.out.print("선택 > ");
			int select = Business3.sc.nextInt();

			switch(select) {


			case 1: //국 삭제
				System.out.println("1." + soupName.get(0) + " | " +  "2." + soupName.get(1) + " | " + 
						"3."  +soupName.get(2) + " | " + "4." +soupName.get(3) +" | " + 
						"5." + soupName.get(4));
				System.out.print("선택 >");
				int selectNo = Business3.sc.nextInt();
				for( int i=0; i < soupAmount.length; i++) {
					if(selectNo == i+1) {
						System.out.println((i+1)+ ". " +soupName.get(i));
						System.out.print("몇개 폐기 하실래요? >");
						remove[i] += Business3.sc.nextInt();
						rest1[i] = soupAmount[i]-remove[i];
						if(rest1[i] <=0) {
							System.out.println("뺄수없습니다.");
							rest1[i] = 0;
						}
					}//ifselct끝
					if(selectNo > soupName.size()) {
						System.out.println("1번부터 5번중에 선택해주세요");
						delete();
					}//6번찍었을때
				}//for문 끝
				System.out.print("돌아가기(Y or N) -->");
				String yn = Business3.sc.next();
				if(yn.equals("y") || yn.equals("Y")) managerMode();
				if(yn.equals("n") || yn.equals("N")) delete();
				else System.out.println("잘못입력하셨습니다."); 	
				break;


			case 2: //반찬 삭제
				System.out.println("1." + sideName.get(0) + " | " +  "2." + sideName.get(1) + " | " + 
						"3."  +sideName.get(2) + " | " + "4." +sideName.get(3) +" | " + 
						"5." + sideName.get(4));
				System.out.print("선택 >");
				selectNo = Business3.sc.nextInt();
				for( int i=0; i < sideAmount.length; i++) {
					if(selectNo == i+1) {
						System.out.println((i+1)+ ". " + sideName.get(i));
						System.out.print("몇개 폐기 하실래요? >");
						remove[i] += Business3.sc.nextInt();
						rest2[i] = sideAmount[i]-remove[i];
						if(rest2[i] <=0) {
							System.out.println("뺄수없습니다.");
							rest2[i] = 0;	}
					}
					if(selectNo > sideName.size()) {
						System.out.println("1번부터 5번중에 선택해주세요");
						delete();
					}//6번찍었을때
				}//for문 끝
				System.out.print("돌아가기(Y or N) -->");
				yn = Business3.sc.next();
				if(yn.equals("y") || yn.equals("Y")) managerMode();
				if(yn.equals("n") || yn.equals("N")) delete();
				else System.out.println("잘못입력하셨습니다."); 
				break;
			default : System.out.println("잘못입력하셨습니다."); delete(); break;
			}//end switch
		}//end while
	}//end delete
	

	public void customer() { //고객 관리 화면
		System.out.println("[ 고객관리  ]");
		System.out.println("고객No. | 총 포인트");
	}



	public void search() { //입고된 메뉴 조회 화면    사실상 돌아가겠습니까? 물어볼 필요가없이 돌아가야할거같습니다.
		int i;
		soupName.add("갈비탕"); 
		soupName.add("육개장");
		soupName.add("된장찌개");
		soupName.add("김치찌개");
		soupName.add("부대찌개");
		
		sideName.add("무말랭이");
		sideName.add("메추리알");
		sideName.add("콩자반");
		sideName.add("멸치볶음");
		sideName.add("배추김치");
		
		System.out.println("                       [ 제품 조회  ]                       ");
		System.out.println();
		System.out.println("                         <<국류>>                         ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("|     메뉴명          |     입고 수량          |     잔여 갯수          |     메뉴평점          |");
		System.out.println("--------------------------------------------------------------------");
		for (  i = 0; i < 5; i++) {
			System.out.println("\t" + soupName.get(i) + "\t\t" + soupAmount[i]+ "개" + "\t\t" + rest1[i]+ "개" + "\t\t" + "메뉴평점");
			
		}
		
		
		System.out.println();
		System.out.println("                        <<반찬류>>                        ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("|     메뉴명          |     입고 수량          |     잔여 갯수          |     메뉴평점          |");
		System.out.println("--------------------------------------------------------------------");
		for (  i = 0; i < 5; i++) {
			System.out.println("\t" + sideName.get(i) + "\t\t" + sideAmount[i]+ "개" + "\t\t" + rest2[i]+ "개" + "\t\t" + "메뉴평점");
		}
		System.out.println();
		managerMode();
	}


	public void customerSearch() { //고객한테 보일 메뉴판
		
		System.out.println("                   <<고객 모드>>                   ");
		System.out.println();
		System.out.println("---------------------------------------------------");
		System.out.println("|     메뉴명          |      남은 수량           |      가격           |");
		System.out.println("---------------------------------------------------");
		for(int i = 0; i < soupName.size(); i++) {
			System.out.println("\t" + soupName.get(i) + "\t\t" + rest1[i]+ "개" + "\t\t" + soupPrice[i]+"원");
		}
		System.out.println("---------------------------------------------------");
		for(int i = 0; i < sideName.size(); i++) {
			System.out.println("\t" + sideName.get(i) + "\t\t" + rest2[i]+ "개" + "\t\t" + sidePrice[i]+"원");
		}
		System.out.println("---------------------------------------------------");
		
		
		
		
	}
	
	
	
}
