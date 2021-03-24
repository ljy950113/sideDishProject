package team4;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Manager extends Calculator implements Food{

	Scanner sc = new Scanner(System.in);



	int pwTest; //비밀번호를 입력받는 변수
	//String[][] menuName = { {"무말랭이", "메추리알", "콩자반", "멸치볶음", "배추김치"}, {"갈비탕", "육개장", "된장찌개", "김치찌개", "부대찌개"} };//메뉴 이름 2차원배열
	String[] soupName = {"갈비탕", "육개장", "된장찌개", "김치찌개","부대찌개"}; // 탕종류 배열 0열에 육개장 1열에 김치찌개 이런식
	int[] soupPrice = new int[5];
	int[] soupAmount = new int[5];

	String[] sideName = {"무말랭이", "메추리알", "콩자반", "멸치볶음","배추김치"};// 반찬류 배열 0열에 배추김치, 1열에 갓김치
	int[] sidePrice  = new int[5];
	int[] sideAmount = new int[5];






	@Override
	public void search() { //제품 현황 조회
		System.out.println("<< 제품 조회 >>");
		System.out.println();
		System.out.println("메뉴명  |  메뉴수량  |  메뉴가격  |  폐기갯수  | 메뉴평점");
		System.out.println("-----------------------------------");
		for(int i=0; i<sideName.length;i++) {
			System.out.println(sideName[i] + " | " + sideAmount[i] + " | " + sidePrice[i] +  "|" + "폐기갯수" + " | " + "반찬평점");
			//System.out.println("------------------------------------------------------------------------");
			//System.out.println(soupName[i] + " | " + soupAmount[i] + " | " + "폐기갯수" + " | " + "반찬평점");
		}
		System.out.println("------------------------------------");
		for(int i=0; i<soupName.length;i++) {
			System.out.println(soupName[i] + " | " + soupAmount[i] + " | " + soupPrice[i] +  "|" + "폐기갯수" + " | " + "반찬평점");
		}
		managerMenu();

	}//end search



	void managerMenu() {

		System.out.println("<< 관리자 모드 >>");
		System.out.println();
		System.out.println("1. 입고");
		System.out.println();
		System.out.println("2. 삭제");
		System.out.println();
		System.out.println("3. 제품 조회");
		System.out.println();
		System.out.println("4. 고객 관리");
		System.out.println();
		System.out.println("5. 뒤로 가기");
		System.out.print("선택 >");
		choice = sc.nextInt();

		switch(choice) {

		case 1: entering();break;
		case 2: break;
		case 3: search();break;
		case 4: break;
		case 5: start(); break;
		default : break;

		}

	}//end managerMenu



	@Override
	public void password() { //관리자 비밀번호 입력 메소드

		int repeat = 1;//반복횟수 담는 변수

		for(int k = 0; k<repeat; k++) {

			System.out.print("패스워드를 입력하세요 >");
			pwTest = sc.nextInt();
			if(password == pwTest) {
				System.out.println("관리자 입니다!!!");
				managerMenu();

			}else { 
				System.out.println("패스워드가 올바르지 않습니다. 다시 입력해주세요");
				repeat++;
				if(repeat == 4) {
					System.out.println("패스워드를 3회 이상 틀리셨습니다. 메인 화면으로 돌아갑니다");
					start();
					break;
				}
			}

		}	
	}//end password



	@Override
	public void entering() {
		boolean run = true;

		String choice; //선택 테스트용 변수입니다.
		while(run) {
			System.out.println("<<  입고  >>");
			System.out.println("1. 국  2. 반찬");
			System.out.println("선택>");
			int select = sc.nextInt();

			switch(select) {
			case 1: 
				System.out.println("------------------<< 국류 입고 가능 목록  >>------------------");
				System.out.println("1. 갈비탕 | 2. 육개장 | 3. 된장찌개 | 4. 김치찌개 | 5. 부대찌개 ");
				for(int i = 0; i<soupName.length; i++) {
					System.out.println(soupName[i] + "을(를) 입고하시겠습니까?");
					System.out.print("Y/N  >");
					choice = sc.next();
					if(choice.equals("Y") || choice.equals("y")) {
						System.out.print("수량 입력>");
						soupAmount[i] += sc.nextInt();
						System.out.print("가격 입력>");
						soupPrice[i] = sc.nextInt();
					}else if(choice.equals("N") || choice.equals("n")) {

					}else {
						System.err.println("잘못된 선택입니다.");
						break;
					}

				}
				managerMenu();
				break;
				
				/*System.out.println("반찬을 입고하시겠습니까?(Y/N)");
				String ys = sc.next();
				if(ys.equals("y") || ys.equals("Y")) {

				} else if(ys.equals("n") || ys.equals("N")) {
					run = false;
					managerMenu();
					break;
				} else {
					System.err.println("<시스템오류> 관리자 모드로 돌아갑니다.");
					managerMenu();
					break;
				}*/


			case 2:
				System.out.println("------------------<< 반찬류 입고 가능 목록  >>------------------");
				System.out.println("1. 무말랭이 | 2. 메추리알 | 3. 콩자반 | 4. 멸치볶음 | 5.배추김치");
				for(int i = 0; i<sideName.length; i++) {
					System.out.println(sideName[i] + "을(를) 입고하시겠습니까?");
					System.out.print("Y/N  >");
					choice = sc.next();
					if(choice.equals("Y") || choice.equals("y")) {
						System.out.print("수량 입력>");
						sideAmount[i] += sc.nextInt();
						System.out.print("가격 입력>");
						sidePrice[i] = sc.nextInt();
					}else if(choice.equals("N") || choice.equals("n")) {

					}else {
						System.err.println("잘못된 선택입니다.");
						break;
					}

				}
				managerMenu();
				break;
				
				
				
				
				
			default : System.out.println("잘못입력하셨습니다. 다시입력하세요"); break;
			}
		}
	}//end entering












}


