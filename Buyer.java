package team4;

import java.util.Scanner;

public class Buyer {

	public static void buyerPrint() {

		int[] buyNo = null; //����ȣ
		String[] productName = null; //���� ��ǰ��
		int[] productCount = null; //��ǰ ���� ����
		
		int money = 0; //�� ���� �ݾ�
		String yesOrNo = null; //��� ���� ����
		String rating = null; //���� �ο� ����

		boolean run = true; //�ݺ��� ����

		Scanner sc = new Scanner(System.in);

		System.out.println("                   <<�� ���>>               ");
		System.out.println("~�������Կ� ���� ���� ȯ���մϴ�~");
		System.out.println("*���Ͻô� ������ �Է��Ͽ� �ּ���.*");
		System.out.println(" ������ | �������� | �������� (����) ");
		//~������ ��忡�� �Է��� ���� ����Ʈ ���~

		//�����ݾ� �Է�
		System.out.println("���� �����ݾ��� �Է����ּ���.");
		System.out.print("�Է� > ");
		money = sc.nextInt();

		//�������� 	�ݺ��� (�����ݾ� - ���űݾ� = �ܵ�)

		for(int i = 0; i < productName.length; i++) {
			for(int j = 0; j <productCount.length; j++) {

				while(run) {
					System.out.println("�����Ͻô� ������ �Է����ּ���. > ");
					productName[i] = sc.nextLine();
					
					System.out.println("���� ������ �Է����ּ���. > ");
					productCount[j] = sc.nextInt();
					
					System.out.println("��� ���Ÿ� ����Ͻô� ��� Y�� �Է����ֽð�,");
					System.out.println("�� �̻� ���Ÿ� ������� �ʴ� ��� N�� �Է����ּ���.");
					System.out.print("�Է� > ");
					yesOrNo = sc.nextLine();
					
					if(yesOrNo.equals("Y")) {
						continue;
					}  else if (yesOrNo.equals("N")) {
						break;
					} else {
						System.out.println("Y �Ǵ� N���θ� �Է����ּ���.");
						
					}
				}
			} 
		}

		//����ȣ ���ȭ��
		System.out.println("*����ȣ ���ȭ��*");
		System.out.println("������ �޴��ȣ ���ڸ� 4���� �Է����ּ���.");
		System.out.println("�Է��Ͻø� ����Ʈ�� �����˴ϴ�. (������ ������ �����ø� N�� �Է��ϼ���)");
		System.out.print("�Է� > ");
		//buyNo = sc.nextLine();
		
		if(buyNo != null) {
			System.out.println("����Ʈ�� �����Ǿ����ϴ�.");
			System.out.println("���� ������ �ܿ� ����Ʈ�� " + " ����Ʈ�Դϴ�.");
			System.out.println("�ܵ� " + "�� �޾��ּ���.");
		} else if () {
			System.out.println("�ܵ� " + "�� �޾��ּ���.");
		} 
		
		//����Ʈ ȭ�� & �ܵ� ȭ��
		//���� ����ȣ ���ȭ�鿡�� ����Ʈ�� �����ϴ� ��� �ش� ȭ��, �������� ������ �ܵ��� ���
		System.out.println("����Ʈ�� �����Ǿ����ϴ�.");
		System.out.println("���� ������ �ܿ� ����Ʈ�� " + " ����Ʈ�Դϴ�.");
		
		
		System.out.println("�ܵ� " + "�� �޾��ּ���.");

		//����
		System.out.println("*�ش� ��ǰ�� ���� ������ ����ðڽ��ϱ�?*");
		System.out.print("(Y/N) > ");
		rating = sc.nextLine();

		//Y�� ���� ���
		if(rating.equals("Y")) {
			
			System.out.println("������ �Է����ּ���. (���� �Ҽ��� ù°�ڸ����� �Է� ����)");
			System.out.print("���� > ");
			rating = sc.nextLine();
			
			System.out.println("���� �Է��� �Ϸ�Ǿ����ϴ�.");
			System.out.println("~�̿����ּż� �����մϴ�.~");
			
		} else if(rating.equals("N")){
			//N�� ���� ���
			System.out.println("~�̿����ּż� �����մϴ�~");
			
		} else {
			System.out.println("Y �Ǵ� N ���θ� �Է��Ͽ� �ּ���.");
		}
	}
}
