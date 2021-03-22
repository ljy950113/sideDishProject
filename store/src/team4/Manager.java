package team4;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Manager extends Calculator implements Food{

	Scanner sc = new Scanner(System.in);
	

	int managerPassword = 1234;
	int pwTest;
	


	@Override
	public void search() {


	}



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
		
		case 1: break;
		case 2: break;
		case 3: break;
		case 4: break;
		case 5: start(); break;
		default : break;
			
		}

	}
	
	
	
	@Override
	public void password() { //관리자 비밀번호 입력 메소드

		int repeat = 1;//반복횟수 담는 변수
		
		for(int i = 0; i<repeat; i++) {
			
			System.out.println("패스워드를 입력하세요 >");
			pwTest = sc.nextInt();
			if(managerPassword == pwTest) {
				System.out.println("관리자 입니다!!!");
				managerMenu();
				
			}else { 
				System.out.println("패스워드가 올바르지 않습니다. 다시 입력해주세요");
				repeat++;
				if(repeat == 6) {
					System.out.println("패스워드를 5회 이상 틀리셨습니다. 메인 화면으로 돌아갑니다");
					start();
					break;
				}
			}
			
		}
		
		
		
		
	}

}
