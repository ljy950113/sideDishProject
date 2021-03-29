package team4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Buyer{

	Scanner sc = new Scanner(System.in);
	
	
	

	static CharSequence[] buyNo = null; //고객번호 담을 배열
	static CharSequence customerTel = null; //고객번호 조회
	static int change = 0; //고객 잔돈 

	static String productName; //구매 제품명
	static int productCount; //제품 구매 수량
	static int[] productPrice = null; //제품 구매 가격

	static int money = 0; //고객 소지 금액
	static String yesOrNo = null; //계속 구매 여부
	static String rating = null; //평점 부여 여부
	static double[] rate = null; //평점 담을 배열
	static boolean run = true; //반복문 변수
	
	
	

	
	
	public static void buyerMethod() { 

		Scanner sc = new Scanner(System.in); 
		//소지금액 입력
		System.out.println("현재 소지금액을 입력해주세요.");
		System.out.print("입력 > ");
		money += sc.nextInt();
		
		System.out.println("구매하기 .. 1. 국류 | 2. 반찬");
		int select = sc.nextInt();
		
		if(select == 1) {
			System.out.print("구매하시는 국명을 입력해주세요. >");
			productName = sc.next();
			//입고된 soupName 배열에서 방금 입력받은 productName을 찾는다.
			//만약 입고된 내용에 있다면 해당 soupAmount 에서 구매수량 만큼 차감시킨다.
			System.out.print("구매하실 수량을 입력하세요. >");
			productCount = sc.nextInt();
			int result = Arrays.binarySearch(Manager.soupName, productName);
			
			switch(result) {
			case 0: Manager.rest1[0] -= productCount; break;
			case 1: Manager.rest1[1] -= productCount; break;
			case 2: Manager.rest1[2] -= productCount; break;
			case 3: Manager.rest1[3] -= productCount; break;
			case 4: Manager.rest1[4] -= productCount; break;
			}
			
		} else if(select == 2) {
			System.out.print("구매하시는 반찬명을 입력해주세요. >");
			productName = sc.next();
			System.out.print("구매하실 수량을 입력하세요. >");
			productCount = sc.nextInt();
			//입고된 soupName 배열에서 방금 입력받은 productName을 찾는다.
			//만약 입고된 내용에 있다면 해당 soupAmount 에서 구매수량 만큼 차감시킨다.
			int result = Arrays.binarySearch(Manager.sideName, productName);
			switch(result) {
			case 0: Manager.rest2[0] -= productCount; break;
			case 1: Manager.rest2[1] -= productCount; break;
			case 2: Manager.rest2[2] -= productCount; break;
			case 3: Manager.rest2[3] -= productCount; break;
			case 4: Manager.rest2[4] -= productCount; break;
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

	}




	public void point() { //포인트 화면 & 잔돈 화면

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

	}

	
	public void evaluation() { //평점
		
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


	}//평점 끝
	
	
	
	
	
	

}