package team4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Buyer extends Manager{

	// <구매내역 조회가 되기위해 배열리스트를 작성>
	static List<String> buySoup = new ArrayList<String>(); //구매 국명 차례로 담기
	static List<String> buySide = new ArrayList<String>(); //구매 반찬명 차례로 담기
	static List<Integer> priceSp = new ArrayList<Integer>(); //구매 국가격 차례로 담기
	static List<Integer> priceSe = new ArrayList<Integer>(); //구매 반찬가격 차례로 담기 
	static int totalNum = 0; //고객이 구매를 한 횟수
	static int soupNum = 0; //국을 구매한 횟수
	static int sideNum = 0; //반찬을 구매한 횟수
	

	static int [] buyNo = new int [1]; //고객번호 담을 배열
	static String[] buyerName = new String [1]; //고객명 담을 배열
	static String buyerInput; //고객명 비교변수
	static int customerTel; //고객번호 조회
	static int numbuyer = 0; //고객번호 증가
	static double point = 0.0; //고객 포인트
	static int change = 0; //고객 잔돈 

	static String productName; //구매 제품명
	static int productCount = 0; //제품 구매 수량

	static int[] productPrice = null; //제품 구매 가격

	static int money = 0; //고객 소지 금액
	static String yesOrNo = null; //계속 구매 여부

	static boolean run = true; //반복문 변수

	static int buyerSum = 0; //총 구매금액 

	static boolean bFlag = true; // 금액 입력을 처음에만 받기 위함.
	
	static int banbok = 1; //반복문 테스트 입니다!!! 구매반복



	public static void buyerPurchase() { //Manager에 있던 customerSearch 옴겼어요. 구매화면

		System.out.println("기존 고객이 아니시라면 숫자 3을 입력해주세요!!");
		System.out.print("고객번호를 입력해주세요. >");
		try { //숫자가아닌 다른문자를 입력했을때 예외처리
			customerTel = Business.sc.nextInt();
		} catch(InputMismatchException e) {
			System.err.println("비정상적인 접근입니다. 시스템을 다시 시작해주세요.");
			System.exit(0);
		}
		if(customerTel == buyNo[0]) {

			System.out.println();
			System.out.println(buyerName[0] + "고객님 저희 반찬가게를 방문해주셔서 감사합니다!");
			System.out.println();


			System.out.println("                             <<구매 모드>>                   ");
			System.out.println();
			System.out.println("--------------------------------------------------------------------");
			System.out.println("|     메뉴명          |      남은 수량           |      가격           |      추천메뉴         |");
			System.out.println("--------------------------------------------------------------------");
			for(int i = 0; i < Manager.soupName.length; i++) {
				System.out.println("\t" + Manager.soupName[i] + "\t\t" + Manager.rest1[i]+ "개" + "\t\t" + Manager.soupPrice[i]+"원"+ "\t\t" + "추천메뉴");

			}

			System.out.println("--------------------------------------------------------------------");

			for(int i = 0; i < Manager.sideName.length; i++) {

				System.out.println("\t" + Manager.sideName[i] + "\t\t" + Manager.rest2[i]+ "개" + "\t\t" + Manager.sidePrice[i]+"원"+ "\t\t" + "추천메뉴");
			}

			if(bFlag) {

				System.out.println("현재 소지금액을 입력해주세요.");
				System.out.print("입력 > ");
				money = Business.sc.nextInt();
				change = money;
				bFlag = false;

			}
			
			System.out.println("고객님의 현재 잔액은 " + change + "원 입니다.");
			System.out.println("[구매하기] 1. 국류 | 2. 반찬  | 3. 돌아가기");
			System.out.print("선택 >");
			int select = Business.sc.nextInt();

			if(select == 1) {
				System.out.print("구매하시는 국명을 입력해주세요. >");
				productName = Business.sc.next();
				System.out.print("구매하실 수량을 입력하세요. >");
				productCount = Business.sc.nextInt();
				
				
				if(productName.equals(Manager.soupName[0])) {


					if(Manager.rest1[0] < productCount) {
						System.out.println("구매하시려는 물품의 재고가 부족합니다.");
						buyerMode();
					} else if(change < (Manager.soupPrice[0] * productCount)) { //잔액 < 메뉴가격 * 구매하고자 하는 수량  (x)
						System.out.println("고객님의 잔액이 부족합니다.");
						buyerMode();
						
					}
					else {
						Manager.rest1[0] -= productCount;
						buyerSum += Manager.soupPrice[0] * productCount;
						change -= Manager.soupPrice[0] * productCount;
						buySoup.add(productName);
						priceSp.add(productCount);
						soupNum++;
						totalNum++;
						point += (Manager.soupPrice[0] * productCount) * 0.03;
						buyerMode();
					}
				} else if(productName.equals(Manager.soupName[1])) {

					if(Manager.rest1[1] < productCount) {
						System.out.println("구매하시려는 물품의 재고가 부족합니다.");
						buyerMode();
					}else if(change < (Manager.soupPrice[1] * productCount)) {
						System.out.println("고객님의 잔액이 부족합니다.");
						buyerMode();
						
					}
					else {

						Manager.rest1[1] -= productCount;
						buyerSum += Manager.soupPrice[1] * productCount;
						change -= Manager.soupPrice[1] * productCount;
						buySoup.add(productName);
						priceSp.add(productCount);
						soupNum++;
						totalNum++;
						point += (Manager.soupPrice[1] * productCount) * 0.03;
						buyerMode();
					}
				} else if(productName.equals(Manager.soupName[2])) {

					if(Manager.rest1[2] < productCount) {
						System.out.println("구매하시려는 물품의 재고가 부족합니다.");
						buyerMode();
					}else if(change < (Manager.soupPrice[2] * productCount)) {
						System.out.println("고객님의 잔액이 부족합니다.");
						buyerMode();
						
					}
					else {
						Manager.rest1[2] -= productCount;
						buyerSum += Manager.soupPrice[2] * productCount;
						change -= Manager.soupPrice[2] * productCount;
						buySoup.add(productName);
						priceSp.add(productCount);
						soupNum++;
						totalNum++;
						point += (Manager.soupPrice[2] * productCount) * 0.03;
						buyerMode();
					}
				} else if(productName.equals(Manager.soupName[3])) {

					if(Manager.rest1[3] < productCount) {
						System.out.println("구매하시려는 물품의 재고가 부족합니다.");
						buyerMode();
					}else if(change < (Manager.soupPrice[3] * productCount)) {
						System.out.println("고객님의 잔액이 부족합니다.");
						buyerMode();
						
					}
					else {

						Manager.rest1[3] -= productCount;
						buyerSum += Manager.soupPrice[3] * productCount;
						change -= Manager.soupPrice[3] * productCount;
						buySoup.add(productName);
						priceSp.add(productCount);
						soupNum++;
						totalNum++;
						point += (Manager.soupPrice[3] * productCount) * 0.03;
						buyerMode();

					}
				} else if(productName.equals(Manager.soupName[4])) {

					if(Manager.rest1[4] < productCount) {
						System.out.println("구매하시려는 물품의 재고가 부족합니다.");
						buyerMode();
					}else if(change < (Manager.soupPrice[4] * productCount)) {
						System.out.println("고객님의 잔액이 부족합니다.");
						buyerMode();
						
					}
					else {
						Manager.rest1[4] -= productCount;
						buyerSum += Manager.soupPrice[4] * productCount;
						change -= Manager.soupPrice[4] * productCount;
						buySoup.add(productName);
						priceSp.add(productCount);
						soupNum++;
						totalNum++;
						point += (Manager.soupPrice[4] * productCount) * 0.03;
						buyerMode();
					}
				}
				
				else {
					System.err.println("구매하실 메뉴가 없습니다.");
				}
				
				
				//반찬 시작
			} else if(select == 2) {
				System.out.print("구매하시는 반찬명을 입력해주세요. >");
				productName = Business.sc.next();
				System.out.print("구매하실 수량을 입력하세요. >");
				productCount = Business.sc.nextInt();

				if(productName.equals(Manager.sideName[0])) {

					if(Manager.rest2[0] < productCount) {
						System.out.println("구매하시려는 물품의 재고가 부족합니다.");
						buyerMode();
					}else if(change < (Manager.sidePrice[0] * productCount)) {
						System.out.println("고객님의 잔액이 부족합니다.");
						buyerMode();
						
					}
					else {

						Manager.rest2[0] -= productCount; 
						buyerSum += Manager.sidePrice[0] * productCount;
						change -= Manager.sidePrice[0] * productCount;
						buySide.add(productName);
						priceSe.add(productCount);
						sideNum++;
						totalNum++;
						point += (Manager.sidePrice[0] * productCount) * 0.02;
						buyerMode();
					}
				} else if(productName.equals(Manager.sideName[1])) {

					if(Manager.rest2[1] < productCount) {
						System.out.println("구매하시려는 물품의 재고가 부족합니다.");
						buyerMode();
					}else if(change < (Manager.sidePrice[1] * productCount)) {
						System.out.println("고객님의 잔액이 부족합니다.");
						buyerMode();
						
					}
					else {

						Manager.rest2[1] -= productCount;
						buyerSum += Manager.sidePrice[1] * productCount;
						change -= Manager.sidePrice[1] * productCount;
						buySide.add(productName);
						priceSe.add(productCount);
						sideNum++;
						totalNum++;
						point += (Manager.sidePrice[1] * productCount) * 0.02;
						buyerMode();

					}
				} else if(productName.equals(Manager.sideName[2])) {

					if(Manager.rest2[2] < productCount) {
						System.out.println("구매하시려는 물품의 재고가 부족합니다.");
						buyerMode();
					}else if(change < (Manager.sidePrice[2] * productCount)) {
						System.out.println("고객님의 잔액이 부족합니다.");
						buyerMode();
						
					}
					else {

						Manager.rest2[2] -= productCount;
						buyerSum += Manager.sidePrice[2] * productCount;
						change -= Manager.sidePrice[2] * productCount;
						buySide.add(productName);
						priceSe.add(productCount);
						sideNum++;
						totalNum++;
						point += (Manager.sidePrice[2] * productCount) * 0.02;
						buyerMode();

					}

				} else if(productName.equals(Manager.sideName[3])) {

					if(Manager.rest2[3] < productCount) {
						System.out.println("구매하시려는 물품의 재고가 부족합니다.");
						buyerMode();
					}else if(change < (Manager.sidePrice[3] * productCount)) {
						System.out.println("고객님의 잔액이 부족합니다.");
						buyerMode();
						
					}
					else {

						Manager.rest2[3] -= productCount;
						buyerSum += Manager.sidePrice[3] * productCount;
						change -= Manager.sidePrice[3] * productCount;
						buySide.add(productName);
						priceSe.add(productCount);
						sideNum++;
						totalNum++;
						point += (Manager.sidePrice[3] * productCount) * 0.02;
						buyerMode();

					}

				} else if(productName.equals(Manager.sideName[4])) {

					if(Manager.rest2[4] < productCount) {
						System.out.println("구매하시려는 물품의 재고가 부족합니다.");
						buyerMode();
					}else if(change < (Manager.sidePrice[4] * productCount)) {
						System.out.println("고객님의 잔액이 부족합니다.");
						buyerMode();
						
					}
					else {

						Manager.rest2[4] -= productCount;
						buyerSum += Manager.sidePrice[4] * productCount;
						change -= Manager.sidePrice[4] * productCount;
						buySide.add(productName);
						priceSe.add(productCount);
						sideNum++;
						totalNum++;
						point += (Manager.sidePrice[4] * productCount) * 0.02;
						buyerMode();

					}


				} else {
					System.out.println("구매하실 메뉴가 없습니다.");
				}


			} else if(select == 3) {
				buyerMode();
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}

		}else if(customerTel == 3) {
			buyerNumber();
		}else {
			System.out.println("[ 안내  ]");
			System.out.println("저희 반찬가게는 고객등록이 필수입니다!!!");
			System.out.println("신규고객으로 등록해주세요.");
		}





	}


	public static void buyerMode() { //고객 메인화면


		System.out.println(" [ 고객 모드 ] ");
		System.out.println("1. 등록");
		System.out.println("2. 구매");
		System.out.println("3. 조회");
		System.out.println("4. 종료");
		System.out.print("선택 >");
		int select = Business.sc.nextInt();
		switch(select) {
		case 1: buyerNumber(); break;
		case 2: buyerPurchase(); break;
		case 3: buyerSearch(); break;
		case 4: break;

		default : System.out.println("다시 입력해주세요"); break;
		}
	}


	public static void buyerNumber() { //고객번호 등록화면


		System.out.println("*신규고객 등록화면*");
		System.out.println("고객님의 이름을 입력해주세요.");
		System.out.print("입력 >");
		buyerInput = Business.sc.next();
		if(buyerInput.equals(buyerName[0])) {
			System.out.println("이미 등록된 고객입니다.");
			System.out.println();
			buyerMode();

		} else {

			buyerName[0] = buyerInput;	
			System.out.println("고객님의 휴대번호 뒷자리 4개를 입력해주세요.");
			System.out.print("입력 >");
			buyNo[0] = Business.sc.nextInt();
			//buyNo[numbuyer] = sc.nextInt();
			//numbuyer++; //고객을 1명 이상으로 등록할때 사용
			System.out.println("신규 고객으로 등록되셨습니다 !!!");
			System.out.println();
			buyerMode();

		}

	}




	public static void buyerSearch() { //고객 조회화면

		System.out.print("고객님의 휴대폰번호 뒷자리 4개를 입력해주세요. >");
		customerTel = Business.sc.nextInt();
		if(customerTel == buyNo[0]) {

			System.out.println("[고객 No." + buyNo[0] +"]");
			System.out.println(buyerName[0] + " 고객님 반갑습니다.");
			System.out.println();


			//조회 부분

			if(totalNum == 0) {

				System.out.println(" 고객님의 구매내역은 비어있습니다 구매하러 가볼까요~? ");
				System.out.println();
				buyerMode(); //조회 후 고객모드로 돌아옴

			} else {
				System.out.println(" [ 고객 조회 ] ");
				if(soupNum == 0) { //고객이 국을 구매하지 않았다면 


					System.out.println("국은 구매하지 않으셨습니다.");
					System.out.println();

				}else {

					for(int i = 0; i<soupNum; i++) { //고객이 국을 구매했다면

						System.out.println("구매 국명: " + buySoup.get(i) +"\t" + "구매 개수: " + priceSp.get(i)+ "개");

					}	
					System.out.println("--------------------------------------------------------------------------");
				}
				if(sideNum == 0) { //고객이 반찬을 구매하지 않았다면

					System.out.println("반찬은 구매하지 않으셨습니다.");
					System.out.println();
				}

				else {
					for(int i = 0; i<sideNum; i++) { //고객이 반찬을 구매했다면

						System.out.println("구매 반찬명: " + buySide.get(i) +"\t" + "구매 개수: " + priceSe.get(i)+ "개");
						System.out.println();

					}

				}
				System.out.println("--------------------------------------------------------------------------");
				System.out.println("고객님의 총 구매금액은 " + buyerSum + "원 이며 잔액은 " + (money-buyerSum) + "원 입니다.");
				System.out.println("고객님의 잔여포인트는 " + point + "점 입니다.");
				System.out.println(" * 이용해주셔서 감사합니다. * ");

				System.out.println();
				buyerMode(); //조회 후 고객모드로 돌아옴
			}

		} else {
			System.out.println("등록된 회원만 조회 가능합니다.");
		}



	}













}