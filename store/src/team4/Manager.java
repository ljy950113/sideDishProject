package team4;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Manager implements Food{
	
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
		
	}
	
	@Override
	public void password() {
		
		System.out.println("패스워드를 입력하세요 >");
		pwTest = sc.nextInt();
		if(managerPassword == pwTest) {
			System.out.println("관리자 입니다!!!!");
			managerMenu();
		}else System.out.println("패스워드가 올바르지 않습니다. 다시 입력해주세요");
	}
}
