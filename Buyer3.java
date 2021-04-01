package team4prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Buyer3 extends Manager3{

	static List<String>list1 = new ArrayList<String>();
	static int [] buyNo = new int [1]; //고객번호 담을 배열
	static String[] buyerName = new String [1]; //고객명 담을 배열
	static String buyerInput; //고객명 비교변수
	static int customerTel; //고객번호 조회
	static int numbuyer = 0; //고객번호 증가

	

	static String productName; //구매 제품명
	static int productCount; //제품 구매 수량


	static int money = 0; //고객 소지 금액
	static int change = 0; //고객 잔돈 
	static int[] point = new int[1];
	
	static String yesOrNo = null; //계속 구매 여부

	static boolean run = true; //반복문 변수

	static int buyerSum = 0; //총 구매금액 
	
	
	public void useList() {
		list1.add("갈비탕");
		list1.add("육개장");
		list1.add("된장찌개");
		list1.add("김치찌개");
		list1.add("부대찌개");
	}
	public static void buyerMode() { //고객 메인화면
		Manager3 Manager3 = new Manager3();

		System.out.println(" [ 고객 모드 ] ");
		System.out.println("1. 등록");
		System.out.println("2. 구매");
		System.out.println("3. 조회");
		System.out.println("4. 종료");
		System.out.print("선택 >");
		int select = Business3.sc.nextInt();
		switch(select) {
		case 1: buyerNumber(); break;
		case 2: buyerPurchase(); break;
		case 3: break;
		case 4: Manager3.start();break;

		default : System.out.println("다시 입력해주세요"); break;
		}
	}
	public static void buyerNumber() { //고객번호 등록화면


		System.out.println("*신규고객 등록화면*");
		System.out.println("고객님의 이름을 입력해주세요.");
		System.out.print("입력 >");
		buyerInput = Business3.sc.next();
		if(buyerInput.equals(buyerName[0])) {
			System.out.println("이미 등록된 고객입니다.");
			System.out.println();
			buyerMode();

		} else {

			buyerName[0] = buyerInput;	
			System.out.println("고객님의 휴대번호 뒷자리 4개를 입력해주세요.");
			System.out.print("입력 >");
			buyNo[0] = Business3.sc.nextInt();
			//buyNo[numbuyer] = sc.nextInt();
			//numbuyer++; //고객을 1명 이상으로 등록할때 사용
			System.out.println("신규 고객으로 등록되셨습니다 !!!");
			System.out.println();
			buyerMode();

		}
	}

	public static void buyerPurchase() { //Manager3에 있던 customerSearch 옴겼어요. 구매화면

		System.out.println("기존 고객이 아니시라면 숫자 3을 입력해주세요!!");
		System.out.print("고객번호를 입력해주세요. >");
		try { //숫자가아닌 다른문자를 입력했을때 예외처리
			customerTel = Business3.sc.nextInt();
		} catch(InputMismatchException e) {
			System.err.println("비정상적인 접근입니다. 시스템을 다시 시작해주세요.");
			System.exit(0);
		}
		if(customerTel == buyNo[0]) {
			
			System.out.println();
			System.out.println(buyerName[0] + "고객님 저희 반찬가게를 방문해주셔서 감사합니다!");
			System.out.println();
		}else {
			buyNo[0]=0001;
		}

			System.out.println("                             <<구매 모드>>                   ");
			System.out.println();
			System.out.println("--------------------------------------------------------------------");
			System.out.println("|     메뉴명          |      남은 수량           |      가격           |      추천메뉴         |");
			System.out.println("--------------------------------------------------------------------");
			for(int i = 0; i < 5; i++) {
				System.out.println("\t" + Manager3.soupName.get(i) + "\t\t" + Manager3.rest1[i]+ "개" + "\t\t" + Manager3.soupPrice[i]+"원"+ "\t\t" + "추천메뉴");
				
			}

			System.out.println("--------------------------------------------------------------------");

			for(int i = 0; i < 5; i++) {

				System.out.println("\t" + Manager3.sideName.get(i) + "\t\t" + Manager3.rest2[i]+ "개" + "\t\t" + Manager3.sidePrice[i]+"원"+ "\t\t" + "추천메뉴");
			}


			if(run) {
			System.out.println("현재 소지금액을 입력해주세요.");
			System.out.print("입력 > ");
			change = Business3.sc.nextInt();
			run = false;
			}

			System.out.println("[구매하기] 1. 국류 | 2. 반찬  | 3. 돌아가기");
			System.out.print("선택 >");
			int select = Business3.sc.nextInt();
			int sum = 0;
			int i;
			switch(select) {
			case 1:  System.out.println("                             <<구매 모드>>                   ");
			System.out.println();
			System.out.println("--------------------------------------------------------------------");
			System.out.println("|     메뉴명          |      남은 수량           |      가격           |      추천메뉴         |");
			System.out.println("--------------------------------------------------------------------");
			for( i = 0; i < 5; i++) {
				System.out.println("\t" + Manager3.soupName.get(i) + "\t\t" + Manager3.rest1[i]+ "개" + "\t\t" + Manager3.soupPrice[i]+"원"+ "\t\t" + "추천메뉴");
			}
			
			
			System.out.println("구매하실 상품명을 입력해주세요");
			productName = Business3.sc.next();
			System.out.println("구매하실 상품의 수량을 입력해주세요");
			productCount = Business3.sc.nextInt();
			
			//moneyPoket[i]-=Manager3.soupPrice[i]*productCount; // 고객의 소지금액 - 국가격*국 수량
			for( i=0; i<5; i++) {
			if(productName.equals(Manager3.soupName.get(i))) {
				Manager3.rest1[i]-=productCount;
				change -= Manager3.soupPrice[i]*productCount;
			if(change < (Manager3.soupPrice[i]*productCount)&& change == 0) {
				
				System.out.println("잔액이 부족합니다."); }
			if(!productName.equals(Manager3.soupName.get(i))) 
				System.out.println("해당 제품은 저희 가게에 있지 않습니다.");
			}
			}
		
			System.out.print("계속 하시겠습니까?(Y/N)");
			String ys = Business3.sc.next();
			if(ys.equals("n") || ys.equals("N")) {
				run = false;
				buyerMode();
			}else if(ys.equals("y") || ys.equals("Y")) {
				buyerPurchase();
			}else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요."); break;
			}
//두번째 if
			/*if(productName.equals(Manager3.soupName.get(i))) {
				Manager3.rest1[1]-=productCount;
				
				if(change < (Manager3.sidePrice[1]*productCount) && change == 0) 	System.out.println("잔액이 부족합니다.");
					change -= Manager3.sidePrice[1]*productCount;
			}else {
				System.out.println("해당 제품은 저희 가게에 있지 않습니다.");
			}*/
		
			System.out.print("계속 하시겠습니까?(Y/N)");
			ys = Business3.sc.next();
			if(ys.equals("n") || ys.equals("N")) {
				run = false;
				buyerMode();
			}else if(ys.equals("y") || ys.equals("Y")) {
				buyerPurchase();
			}else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요."); break;
			}
//세번째
			/*if(productName.equals(Manager3.soupName[2])) {
				Manager3.rest1[2]-=productCount;
				change = Manager3.sidePrice[2]*productCount;
				if(change < Manager3.sidePrice[2]*productCount) 	System.out.println("잔액이 부족합니다."); 
			}else {
				System.out.println("해당 제품은 저희 가게에 있지 않습니다.");
			}*/
		
			System.out.print("계속 하시겠습니까?(Y/N)");
			 ys = Business3.sc.next();
			if(ys.equals("n") || ys.equals("N")) {
				run = false;
				buyerMode();
			}else if(ys.equals("y") || ys.equals("Y")) {
				buyerPurchase();
			}else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요."); break;
			}
			case 2:
				System.out.println("                             <<구매 모드>>                   ");
				System.out.println();
				System.out.println("--------------------------------------------------------------------");
				System.out.println("|     메뉴명          |      남은 수량           |      가격           |      추천메뉴         |");
				System.out.println("--------------------------------------------------------------------");
				for( i = 0; i < 5; i++) {
					System.out.println("\t" + Manager3.sideName.get(i) + "\t\t" + Manager3.rest2[i]+ "개" + "\t\t" + Manager3.sidePrice[i]+"원"+ "\t\t" + "추천메뉴");
				}
				System.out.println("구매하실 상품명을 입력해주세요");
				productName = Business3.sc.next();
				System.out.println("구매하실 상품의 수량을 입력해주세요");
				productCount = Business3.sc.nextInt();
				
				for( i=0; i<5; i++) {
					if(productName.equals(Manager3.sideName.get(i))) {
						Manager3.rest2[i]-=productCount;
						
					if(change < (Manager3.sidePrice[i]*productCount) && change == 0) {
						change -= Manager3.sidePrice[i]*productCount;
						System.out.println("잔액이 부족합니다.");} 
					if(!productName.equals(Manager3.sideName.get(i))) 
						System.out.println("해당 제품은 저희 가게에 있지 않습니다.");
					}
					}
				System.out.print("계속 하시겠습니까?(Y/N)");
				ys = Business3.sc.next();
				if(ys.equals("n") || ys.equals("N")) {
					run = false;
					buyerMode();
				}else if(ys.equals("y") || ys.equals("Y")) {
					buyerPurchase();
				}else {
					System.out.println("잘못된 입력입니다. 다시 입력해주세요."); break;
				}
					
					/*if(productName.equals(Manager3.soupName[1])) {
						Manager3.rest1[1]-=productCount;
				
					if(!productName.equals(Manager3.soupName[1])) {
							System.out.println("해당 제품은 저희 가게에 있지 않습니다.");
						}
					}
					if(Manager3.rest1[1] < productCount) {
						System.out.println("구매하시려는 물품의 재고가 부족합니다.");
					}
					
					if(productName.equals(Manager3.soupName[2])) {
						Manager3.rest1[2]-=productCount;
				
					if(!productName.equals(Manager3.soupName[2])) {
							System.out.println("해당 제품은 저희 가게에 있지 않습니다.");
						}
					}
					if(Manager3.rest1[2] < productCount) {
						System.out.println("구매하시려는 물품의 재고가 부족합니다.");
					}
					
					if(productName.equals(Manager3.soupName[3])) {
						Manager3.rest1[3]-=productCount;
				
					if(!productName.equals(Manager3.soupName[3])) {
							System.out.println("해당 제품은 저희 가게에 있지 않습니다.");
						}
					}
					if(Manager3.rest1[3] < productCount) {
						System.out.println("구매하시려는 물품의 재고가 부족합니다.");
					}
					
					if(productName.equals(Manager3.soupName[4])) {
						Manager3.rest1[4]-=productCount;
				
					if(!productName.equals(Manager3.soupName[4])) {
							System.out.println("해당 제품은 저희 가게에 있지 않습니다.");
						}
					}
					if(Manager3.rest1[4] < productCount) {
						System.out.println("구매하시려는 물품의 재고가 부족합니다.");
					}*/
					break;
			case 3: buyerMode(); break;
			default :System.out.println("잘못입력하셨습니다."); buyerPurchase(); break;
			}
	}//end purchase
	public void search() {
		System.out.println("<<구매내역>>");
		System.out.println("-------------------------------------------------");
		System.out.println("");
	}
	
	}


