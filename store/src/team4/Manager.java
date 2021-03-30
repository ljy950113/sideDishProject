package team4;


import java.util.Scanner;

public class Manager implements Food{

	
	
	Scanner sc = new Scanner(System.in);

	static String[] soupName = { "갈비탕", "육개장" , "된장찌개" , "김치찌개" , "부대찌개" }; // 탕종류 배열 0열에 육개장 1열에 김치찌개 이런식
	static int[] soupPrice = new int[5];
	static int[] soupAmount = new int[5]; // 0갈비탕 1육개장 2된장찌개 3김치찌개 4부대찌개
	static String[] sideName = { "무말랭이" , "메추리알" , "콩자반" , "멸치볶음" , "배추김치" };// 반찬류 배열 0열에 배추김치, 1열에 갓김치
	static int[] sidePrice  = new int[5];
	static int[] sideAmount = new int[5];
	static int[] remove = new int[5]; 
	static int[] rest1 = new int[5]; // 국 잔여량
	static int[] rest2 = new int[5]; // 반찬 잔여량

	boolean flag = true;



	





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
			int select = sc.nextInt();

			switch(select) {
			case 1: password();  break;
			case 2: Buyer.buyerMode(); break;  
			case 3: System.out.println("시스템을 종료합니다."); flag = false; break;
			default : System.out.println("메뉴를 다시 선택하세요");
			}
		}while(flag);
	}






	public void password() { //관리자 비밀번호 입력화면
		int comparition = 1;
		for(int i=0; i < comparition; i++) {
			System.out.print("패스워드를 입력해주세요. >");
			int pw = sc.nextInt();
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
		int select = sc.nextInt();
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

		while(run) {
			
				System.out.println("[ 입고  ]");
				System.out.println("1. 국  2. 반찬");
				System.out.print("선택>");
				select = sc.nextInt();

			switch(select) {

			case 1: //국 입고
				System.out.println("                  < 입고 가능 목록  >                  ");
				System.out.println("1." + soupName[0] + " | " +  "2." + soupName[1] + " | " + "3."  +soupName[2] + " | " + "4." +soupName[3] +" | " + "5." + soupName[4]);
				System.out.print("선택 >");
				int selectNo = sc.nextInt();
				for(int i=0; i < soupName.length; i++) {
					if(selectNo == i+1) {
						System.out.println();
						System.out.println((i+1)+ "." +soupName[i]);
						System.out.print("수량 입력 >");
						soupAmount[i] += sc.nextInt();
						rest1[i] = soupAmount[i];
						System.out.print("가격 입력 >");
						soupPrice[i] = sc.nextInt();
					}//selectNo if문 끝
					if(selectNo > soupName.length) {
						System.out.println("1번부터 5번중에 선택해주세요");
						entering();
					}//6번찍었을때 돌아가기
				}//for문끝
				System.out.print("계속 하시겠습니까?(Y/N)");
				String ys = sc.next();
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
				System.out.println("1." + sideName[0] + " | " +  "2." + sideName[1] + " | " + "3."  +sideName[2] + " | " + "4." +sideName[3] +" | " + "5." + sideName[4]);
				System.out.print("선택 >");
				selectNo = sc.nextInt();
				for(int i=0; i < sideName.length; i++) {
					if(selectNo == i+1) {
						System.out.println();
						System.out.println((i+1)+ "." +sideName[i]);
						System.out.print("수량 입력 >");
						sideAmount[i] += sc.nextInt();
						rest2[i] = sideAmount[i];
						System.out.print("가격 입력 >");
						sidePrice[i] = sc.nextInt();
					}//selectNo if문 끝
					if(selectNo > sideName.length) {
						System.out.println("1번부터 5번중에 선택해주세요");
						entering();
					}//6번찍었을때 돌아가기
				}//for문끝
				System.out.print("계속 하시겠습니까?(Y/N)");
				ys = sc.next();
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
			int select = sc.nextInt();

			switch(select) {


			case 1: //국 삭제
				System.out.println("1. " + soupName[0] +" | " +  " 2. " + soupName[1] + " | " +
						" 3. "  +soupName[2] + " | " + " 4. " +soupName[3] +" | " + 
						" 5. " + soupName[4]);
				System.out.print("선택 >");
				int selectNo = sc.nextInt();
				for( int i=0; i < soupAmount.length; i++) {
					if(selectNo == i+1) {
						System.out.println((i+1)+ ". " +soupName[i]);
						System.out.print("몇개 폐기 하실래요? >");
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
				System.out.print("돌아가기(Y or N) -->");
				String yn = sc.next();
				if(yn.equals("y") || yn.equals("Y")) managerMode();
				if(yn.equals("n") || yn.equals("N")) delete();
				else System.out.println("잘못입력하셨습니다."); 	
				break;


			case 2: //반찬 삭제
				System.out.println("1. " + sideName[0] +" | " +  " 2. " + sideName[1] + " | " +
						" 3. " + sideName[2] + " | " + " 4. " +sideName[3] +" | " + 
						" 5. " + sideName[4]);
				System.out.print("선택 >");
				selectNo = sc.nextInt();
				for( int i=0; i < sideAmount.length; i++) {
					if(selectNo == i+1) {
						System.out.println((i+1)+ ". " + sideName[i]);
						System.out.print("몇개 폐기 하실래요? >");
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
				System.out.print("돌아가기(Y or N) -->");
				yn = sc.next();
				if(yn.equals("y") || yn.equals("Y")) managerMode();
				if(yn.equals("n") || yn.equals("N")) delete();
				else System.out.println("잘못입력하셨습니다."); 
				break;
			default : System.out.println("잘못입력하셨습니다."); delete(); break;
			}//end switch
		}//end while
	}//end delete


	public void customer() { //고객 관리 화면
		System.out.println("                  [ 고객 관리  ]                      ");
		System.out.println("---------------------------------------------------");
		System.out.println("|     No.     |      고객명           |     총 구매금액          |");
		System.out.println("---------------------------------------------------");
		
		
		
		for(int i = 0; i<=Buyer.numbuyer; i++) {
			System.out.println("\t" +Buyer.buyNo[i] + "\t\t" + Buyer.buyerName[i] + "\t\t" + Buyer.buyerSum);
		}
	}



	public void search() { //입고된 메뉴 조회 화면
		int i;
		System.out.println("                    [ 제품 조회  ]                    ");
		System.out.println();
		System.out.println("                      <<국류>>                      ");
		System.out.println("---------------------------------------------------");
		System.out.println("|     메뉴명          |     입고 수량          |     잔여 갯수          |");
		System.out.println("---------------------------------------------------");
		for (  i = 0; i < soupName.length; i++) {
			System.out.println("\t" + soupName[i] + "\t\t" + soupAmount[i]+ "개" + "\t\t" + rest1[i]+ "개");
		}

		
		System.out.println();
		System.out.println("                        <<반찬류>>                   ");
		System.out.println("---------------------------------------------------");
		System.out.println("|     메뉴명          |     입고 수량          |     잔여 갯수          |");
		System.out.println("---------------------------------------------------");
		for (  i = 0; i < sideName.length; i++) {
			System.out.println("\t" + sideName[i] + "\t\t" + sideAmount[i]+ "개" + "\t\t" + rest2[i]+ "개");
		}
		System.out.println();
		managerMode();
		/*System.out.print("돌아가기(Y/N)-->");
		String yn = sc.next();
		if(yn.equals("y") || yn.equals("Y")) {
			managerMode();
		}else {
			search();
		}*/
	}


	






}