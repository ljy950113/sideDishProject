package team4;

public class Calculator { // 계산관련 로직을 담는 객체
	
	
	double result; //고객이 입력한 평점을 계산하고 변수에 결과 값을 담음
	
	
	void evaluation(int jumsu) { //고객이 입력한 평점을 계산하는 메소드
		
		result = jumsu / 2.0;
		System.out.println("해당 상품의 평점은 " + result + "입니다.");
		
		
	}
	
	
	
	void point() { //고객의 포인트 적립 계산 메소드
		
	}

}
