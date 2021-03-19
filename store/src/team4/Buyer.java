package team4;

import java.util.Scanner;

public class Buyer extends Calculator implements Food{
	
	Scanner sc = new Scanner(System.in);
	int jumsu;
	
	
	
	
	
	@Override
	public void search() {
		
		System.out.println("평점을 입력하세요 (1~5점) >");
		jumsu = sc.nextInt();
		evaluation(jumsu);
		
	}
	
	

}
