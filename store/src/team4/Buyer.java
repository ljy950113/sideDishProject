package team4;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Buyer extends Manager{

	public static void buyerPrint() {

		Manager manager = new Manager();

		CharSequence[] buyNo = null; //고객번호 담을 배열
		CharSequence customerTel = null; //고객번호 조회
		int change = 0; //고객 잔돈 
		
		String[] productName = null; //구매 제품명
		int[] productCount = null; //제품 구매 수량
		int[] productPrice = null; //제품 구매 가격

		int money = 0; //고객 소지 금액
		String yesOrNo = null; //계속 구매 여부
		String rating = null; //평점 부여 여부
		double[] rate = null; //평점 담을 배열

		boolean run = true; //반복문 변수

		Scanner sc = new Scanner(System.in);

		System.out.println("                   <<고객 모드>>               ");
		System.out.println("~반찬가게에 오신 것을 환영합니다~");
		System.out.println("*원하시는 반찬을 입력하여 주세요.*");
		System.out.println(" 반찬명 | 반찬수량 | 반찬가격 (개당) ");
		manager.customerSearch();
		
		/* 
		 Manager에서 오버라이딩이 안되어서 제가 따로 Manager 클래스 안에 고객용 출력 메소드 따로 만들었어요.
		 아래가 그 메소드에요 ↓
		 	public void customerSearch() {
		for(int i = 0; i < soupName.length; i++) {
			System.out.println(soupName[i] + " | " + soupAmount[i] + " | " + soupPrice[i]);
			System.out.println(sideName[i] + " | " + sideAmount[i] + " | " + sidePrice[i]);
		}
	}
		 */
		
		//소지금액 입력
		System.out.println("현재 소지금액을 입력해주세요.");
		System.out.print("입력 > ");
		money = sc.nextInt();

		//반찬구매 	반복문 (소지금액 - 구매금액 = 잔돈)
		//밑에는 그냥 제가 말도 안되게 넣어봤어요..ㅎ
		productName = manager.soupName;
		productName = manager.sideName;
		productCount = manager.soupAmount;
		productCount = manager.sideAmount;
		productPrice = manager.soupPrice;
		productPrice = manager.sidePrice;

		for(int i = 0; i < productName.length; i++) {
			for(int j = 0; j <productCount.length; j++) {

				while(run) {
					System.out.println("구매하시는 반찬을 입력해주세요. > ");
					productName[i] = sc.nextLine();

					System.out.println("구매 수량을 입력해주세요. > ");
					productCount[j] = sc.nextInt();
					
					//돈 계산 식 구현을 어떻게 해야할까요.....................
					//change -= productPrice; 

					System.out.println("계속 구매를 희망하시는 경우 Y를 입력해주시고,");
					System.out.println("더 이상 구매를 희망하지 않는 경우 N을 입력해주세요.");
					System.out.print("입력 > ");
					yesOrNo = sc.nextLine();

					if(yesOrNo.equals("Y") || yesOrNo.equals("y")) {
						continue;
					}  else if (yesOrNo.equals("N") || yesOrNo.equals("n")) {
						break;
					} else {
						System.out.println("Y 또는 N으로만 입력해주세요.");
					}
				}
			} 
		}

		//고객번호 등록화면
		//고객번호가 기존에 등록되어 있을 때 재입력 하지 않고 적립되게
		// -> 고객 번호를 동일하게 입력받고 그 후 기존회원인지 신규회원인지를 출력하기.
		//for 문 = pcInfo 에 등록
		System.out.println("*고객번호 입력화면*");
		System.out.println("고객님의 휴대번호 뒷자리 4개를 입력해주세요.");
		System.out.println("입력하시면 포인트가 적립됩니다. (적립을 원하지 않으시면 N을 입력하세요)");
		System.out.print("입력 > ");
		customerTel = sc.next();
		
		//포인트 화면 & 잔돈 화면
		//위의 고객번호 등록화면에서 포인트를 적립하는 경우 해당 화면, 적립하지 않으면 잔돈만 출력
		String regExp = "[0123456789]{4}"; //숫자 정규식을 통해 4자리만 받게끔 설정
		boolean result = Pattern.matches(regExp, customerTel);
		if(result) {
			//buyNo = customerTel; //배열 담기 확인 필요
			System.out.println("포인트가 적립되었습니다.");
			System.out.println("현재 고객님의 잔여 포인트는 " + " 포인트입니다.");
			System.out.println("잔돈 " + "원 받아주세요.");
		} else if (customerTel.equals("N") || customerTel.equals("n")) {
			System.out.println("잔돈 " + "원 받아주세요.");
		} else {
			System.out.println("휴대전화 뒷자리 4개 또는 N만 입력해주세요.");
		}


		//평점
		System.out.println("*해당 제품에 대한 평점을 남기시겠습니까?*");
		System.out.print("(Y/N) > ");
		rating = sc.nextLine();

		//Y를 누른 경우(메뉴마다 평점이 들어가야해서 배열로 이용해야 할 듯)
		if(rating.equals("Y") || rating.equals("y")) {
			//평점 배열
			for(int i = 0; i < rate.length; i++) {
				System.out.println("평점을 입력해주세요. (숫자 소수점 첫째자리까지 입력 가능)");
				System.out.print("평점 > ");
				rate[i] = sc.nextDouble(); //평점은 배열에 넣었는데 제품명이랑 어떻게 이어야할지 모르겠어요..
				
				System.out.println("평점 입력이 완료되었습니다.");
				System.out.println("~이용해주셔서 감사합니다.~");
			}
		} else if(rating.equals("N") || rating.equals("n")){
			//N을 누른 경우
			System.out.println("~이용해주셔서 감사합니다~");
		} else {
			System.out.println("Y 또는 N 으로만 입력하여 주세요.");
		}
	}
}