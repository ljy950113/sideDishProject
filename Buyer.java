package team4;

import java.util.Scanner;

public class Buyer {

	public static void buyerPrint() {

		int[] buyNo = null; //고객번호
		String[] productName = null; //구매 제품명
		int[] productCount = null; //제품 구매 수량
		
		int money = 0; //고객 소지 금액
		String yesOrNo = null; //계속 구매 여부
		String rating = null; //평점 부여 여부

		boolean run = true; //반복문 변수

		Scanner sc = new Scanner(System.in);

		System.out.println("                   <<고객 모드>>               ");
		System.out.println("~반찬가게에 오신 것을 환영합니다~");
		System.out.println("*원하시는 반찬을 입력하여 주세요.*");
		System.out.println(" 반찬명 | 반찬수량 | 반찬가격 (개당) ");
		//~관리자 모드에서 입력한 반찬 리스트 출력~

		//소지금액 입력
		System.out.println("현재 소지금액을 입력해주세요.");
		System.out.print("입력 > ");
		money = sc.nextInt();

		//반찬구매 	반복문 (소지금액 - 구매금액 = 잔돈)

		for(int i = 0; i < productName.length; i++) {
			for(int j = 0; j <productCount.length; j++) {

				while(run) {
					System.out.println("구매하시는 반찬을 입력해주세요. > ");
					productName[i] = sc.nextLine();
					
					System.out.println("구매 수량을 입력해주세요. > ");
					productCount[j] = sc.nextInt();
					
					System.out.println("계속 구매를 희망하시는 경우 Y를 입력해주시고,");
					System.out.println("더 이상 구매를 희망하지 않는 경우 N을 입력해주세요.");
					System.out.print("입력 > ");
					yesOrNo = sc.nextLine();
					
					if(yesOrNo.equals("Y")) {
						continue;
					}  else if (yesOrNo.equals("N")) {
						break;
					} else {
						System.out.println("Y 또는 N으로만 입력해주세요.");
						
					}
				}
			} 
		}

		//고객번호 등록화면
		System.out.println("*고객번호 등록화면*");
		System.out.println("고객님의 휴대번호 뒷자리 4개를 입력해주세요.");
		System.out.println("입력하시면 포인트가 적립됩니다. (적립을 원하지 않으시면 N을 입력하세요)");
		System.out.print("입력 > ");
		//buyNo = sc.nextLine();
		
		if(buyNo != null) {
			System.out.println("포인트가 적립되었습니다.");
			System.out.println("현재 고객님의 잔여 포인트는 " + " 포인트입니다.");
			System.out.println("잔돈 " + "원 받아주세요.");
		} else if () {
			System.out.println("잔돈 " + "원 받아주세요.");
		} 
		
		//포인트 화면 & 잔돈 화면
		//위의 고객번호 등록화면에서 포인트를 적립하는 경우 해당 화면, 적립하지 않으면 잔돈만 출력
		System.out.println("포인트가 적립되었습니다.");
		System.out.println("현재 고객님의 잔여 포인트는 " + " 포인트입니다.");
		
		
		System.out.println("잔돈 " + "원 받아주세요.");

		//평점
		System.out.println("*해당 제품에 대한 평점을 남기시겠습니까?*");
		System.out.print("(Y/N) > ");
		rating = sc.nextLine();

		//Y를 누른 경우
		if(rating.equals("Y")) {
			
			System.out.println("평점을 입력해주세요. (숫자 소수점 첫째자리까지 입력 가능)");
			System.out.print("평점 > ");
			rating = sc.nextLine();
			
			System.out.println("평점 입력이 완료되었습니다.");
			System.out.println("~이용해주셔서 감사합니다.~");
			
		} else if(rating.equals("N")){
			//N을 누른 경우
			System.out.println("~이용해주셔서 감사합니다~");
			
		} else {
			System.out.println("Y 또는 N 으로만 입력하여 주세요.");
		}
	}
}
