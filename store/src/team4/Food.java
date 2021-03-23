package team4;

public interface Food {
	
	
	static int password = 1234; //관리자 비밀번호임
	
	
	abstract void search(); //조회 관련 추상메소드   매니저, 바이어 두 클래스에서 재정의 한다.
	
	default void entering() {
		//입고 관련 디폴트메소드
	}
	
	default void delete() {
		//삭제 관련 디폴트메소드
	}
	
	default void customer() {
		//고객관리 관련 디폴트메소드
	}
	
	default void password() {
		//관리자 암호입력 관련 디폴트메소드
	}
	
	
	
}
