package team4prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Buyer3 extends Manager3{

	static List<String>list1 = new ArrayList<String>();
	static int [] buyNo = new int [1]; //����ȣ ���� �迭
	static String[] buyerName = new String [1]; //���� ���� �迭
	static String buyerInput; //���� �񱳺���
	static int customerTel; //����ȣ ��ȸ
	static int numbuyer = 0; //����ȣ ����

	

	static String productName; //���� ��ǰ��
	static int productCount; //��ǰ ���� ����


	static int money = 0; //�� ���� �ݾ�
	static int change = 0; //�� �ܵ� 
	static int[] point = new int[1];
	
	static String yesOrNo = null; //��� ���� ����

	static boolean run = true; //�ݺ��� ����

	static int buyerSum = 0; //�� ���űݾ� 
	
	
	public void useList() {
		list1.add("������");
		list1.add("������");
		list1.add("�����");
		list1.add("��ġ�");
		list1.add("�δ��");
	}
	public static void buyerMode() { //�� ����ȭ��
		Manager3 Manager3 = new Manager3();

		System.out.println(" [ �� ��� ] ");
		System.out.println("1. ���");
		System.out.println("2. ����");
		System.out.println("3. ��ȸ");
		System.out.println("4. ����");
		System.out.print("���� >");
		int select = Business3.sc.nextInt();
		switch(select) {
		case 1: buyerNumber(); break;
		case 2: buyerPurchase(); break;
		case 3: break;
		case 4: Manager3.start();break;

		default : System.out.println("�ٽ� �Է����ּ���"); break;
		}
	}
	public static void buyerNumber() { //����ȣ ���ȭ��


		System.out.println("*�ű԰� ���ȭ��*");
		System.out.println("������ �̸��� �Է����ּ���.");
		System.out.print("�Է� >");
		buyerInput = Business3.sc.next();
		if(buyerInput.equals(buyerName[0])) {
			System.out.println("�̹� ��ϵ� ���Դϴ�.");
			System.out.println();
			buyerMode();

		} else {

			buyerName[0] = buyerInput;	
			System.out.println("������ �޴��ȣ ���ڸ� 4���� �Է����ּ���.");
			System.out.print("�Է� >");
			buyNo[0] = Business3.sc.nextInt();
			//buyNo[numbuyer] = sc.nextInt();
			//numbuyer++; //���� 1�� �̻����� ����Ҷ� ���
			System.out.println("�ű� ������ ��ϵǼ̽��ϴ� !!!");
			System.out.println();
			buyerMode();

		}
	}

	public static void buyerPurchase() { //Manager3�� �ִ� customerSearch �Ȱ���. ����ȭ��

		System.out.println("���� ���� �ƴϽö�� ���� 3�� �Է����ּ���!!");
		System.out.print("����ȣ�� �Է����ּ���. >");
		try { //���ڰ��ƴ� �ٸ����ڸ� �Է������� ����ó��
			customerTel = Business3.sc.nextInt();
		} catch(InputMismatchException e) {
			System.err.println("���������� �����Դϴ�. �ý����� �ٽ� �������ּ���.");
			System.exit(0);
		}
		if(customerTel == buyNo[0]) {
			
			System.out.println();
			System.out.println(buyerName[0] + "���� ���� �������Ը� �湮���ּż� �����մϴ�!");
			System.out.println();
		}else {
			buyNo[0]=0001;
		}

			System.out.println("                             <<���� ���>>                   ");
			System.out.println();
			System.out.println("--------------------------------------------------------------------");
			System.out.println("|     �޴���          |      ���� ����           |      ����           |      ��õ�޴�         |");
			System.out.println("--------------------------------------------------------------------");
			for(int i = 0; i < 5; i++) {
				System.out.println("\t" + Manager3.soupName.get(i) + "\t\t" + Manager3.rest1[i]+ "��" + "\t\t" + Manager3.soupPrice[i]+"��"+ "\t\t" + "��õ�޴�");
				
			}

			System.out.println("--------------------------------------------------------------------");

			for(int i = 0; i < 5; i++) {

				System.out.println("\t" + Manager3.sideName.get(i) + "\t\t" + Manager3.rest2[i]+ "��" + "\t\t" + Manager3.sidePrice[i]+"��"+ "\t\t" + "��õ�޴�");
			}


			if(run) {
			System.out.println("���� �����ݾ��� �Է����ּ���.");
			System.out.print("�Է� > ");
			change = Business3.sc.nextInt();
			run = false;
			}

			System.out.println("[�����ϱ�] 1. ���� | 2. ����  | 3. ���ư���");
			System.out.print("���� >");
			int select = Business3.sc.nextInt();
			int sum = 0;
			int i;
			switch(select) {
			case 1:  System.out.println("                             <<���� ���>>                   ");
			System.out.println();
			System.out.println("--------------------------------------------------------------------");
			System.out.println("|     �޴���          |      ���� ����           |      ����           |      ��õ�޴�         |");
			System.out.println("--------------------------------------------------------------------");
			for( i = 0; i < 5; i++) {
				System.out.println("\t" + Manager3.soupName.get(i) + "\t\t" + Manager3.rest1[i]+ "��" + "\t\t" + Manager3.soupPrice[i]+"��"+ "\t\t" + "��õ�޴�");
			}
			
			
			System.out.println("�����Ͻ� ��ǰ���� �Է����ּ���");
			productName = Business3.sc.next();
			System.out.println("�����Ͻ� ��ǰ�� ������ �Է����ּ���");
			productCount = Business3.sc.nextInt();
			
			//moneyPoket[i]-=Manager3.soupPrice[i]*productCount; // ���� �����ݾ� - ������*�� ����
			for( i=0; i<5; i++) {
			if(productName.equals(Manager3.soupName.get(i))) {
				Manager3.rest1[i]-=productCount;
				change -= Manager3.soupPrice[i]*productCount;
			if(change < (Manager3.soupPrice[i]*productCount)&& change == 0) {
				
				System.out.println("�ܾ��� �����մϴ�."); }
			if(!productName.equals(Manager3.soupName.get(i))) 
				System.out.println("�ش� ��ǰ�� ���� ���Կ� ���� �ʽ��ϴ�.");
			}
			}
		
			System.out.print("��� �Ͻðڽ��ϱ�?(Y/N)");
			String ys = Business3.sc.next();
			if(ys.equals("n") || ys.equals("N")) {
				run = false;
				buyerMode();
			}else if(ys.equals("y") || ys.equals("Y")) {
				buyerPurchase();
			}else {
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���."); break;
			}
//�ι�° if
			/*if(productName.equals(Manager3.soupName.get(i))) {
				Manager3.rest1[1]-=productCount;
				
				if(change < (Manager3.sidePrice[1]*productCount) && change == 0) 	System.out.println("�ܾ��� �����մϴ�.");
					change -= Manager3.sidePrice[1]*productCount;
			}else {
				System.out.println("�ش� ��ǰ�� ���� ���Կ� ���� �ʽ��ϴ�.");
			}*/
		
			System.out.print("��� �Ͻðڽ��ϱ�?(Y/N)");
			ys = Business3.sc.next();
			if(ys.equals("n") || ys.equals("N")) {
				run = false;
				buyerMode();
			}else if(ys.equals("y") || ys.equals("Y")) {
				buyerPurchase();
			}else {
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���."); break;
			}
//����°
			/*if(productName.equals(Manager3.soupName[2])) {
				Manager3.rest1[2]-=productCount;
				change = Manager3.sidePrice[2]*productCount;
				if(change < Manager3.sidePrice[2]*productCount) 	System.out.println("�ܾ��� �����մϴ�."); 
			}else {
				System.out.println("�ش� ��ǰ�� ���� ���Կ� ���� �ʽ��ϴ�.");
			}*/
		
			System.out.print("��� �Ͻðڽ��ϱ�?(Y/N)");
			 ys = Business3.sc.next();
			if(ys.equals("n") || ys.equals("N")) {
				run = false;
				buyerMode();
			}else if(ys.equals("y") || ys.equals("Y")) {
				buyerPurchase();
			}else {
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���."); break;
			}
			case 2:
				System.out.println("                             <<���� ���>>                   ");
				System.out.println();
				System.out.println("--------------------------------------------------------------------");
				System.out.println("|     �޴���          |      ���� ����           |      ����           |      ��õ�޴�         |");
				System.out.println("--------------------------------------------------------------------");
				for( i = 0; i < 5; i++) {
					System.out.println("\t" + Manager3.sideName.get(i) + "\t\t" + Manager3.rest2[i]+ "��" + "\t\t" + Manager3.sidePrice[i]+"��"+ "\t\t" + "��õ�޴�");
				}
				System.out.println("�����Ͻ� ��ǰ���� �Է����ּ���");
				productName = Business3.sc.next();
				System.out.println("�����Ͻ� ��ǰ�� ������ �Է����ּ���");
				productCount = Business3.sc.nextInt();
				
				for( i=0; i<5; i++) {
					if(productName.equals(Manager3.sideName.get(i))) {
						Manager3.rest2[i]-=productCount;
						
					if(change < (Manager3.sidePrice[i]*productCount) && change == 0) {
						change -= Manager3.sidePrice[i]*productCount;
						System.out.println("�ܾ��� �����մϴ�.");} 
					if(!productName.equals(Manager3.sideName.get(i))) 
						System.out.println("�ش� ��ǰ�� ���� ���Կ� ���� �ʽ��ϴ�.");
					}
					}
				System.out.print("��� �Ͻðڽ��ϱ�?(Y/N)");
				ys = Business3.sc.next();
				if(ys.equals("n") || ys.equals("N")) {
					run = false;
					buyerMode();
				}else if(ys.equals("y") || ys.equals("Y")) {
					buyerPurchase();
				}else {
					System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���."); break;
				}
					
					/*if(productName.equals(Manager3.soupName[1])) {
						Manager3.rest1[1]-=productCount;
				
					if(!productName.equals(Manager3.soupName[1])) {
							System.out.println("�ش� ��ǰ�� ���� ���Կ� ���� �ʽ��ϴ�.");
						}
					}
					if(Manager3.rest1[1] < productCount) {
						System.out.println("�����Ͻ÷��� ��ǰ�� ��� �����մϴ�.");
					}
					
					if(productName.equals(Manager3.soupName[2])) {
						Manager3.rest1[2]-=productCount;
				
					if(!productName.equals(Manager3.soupName[2])) {
							System.out.println("�ش� ��ǰ�� ���� ���Կ� ���� �ʽ��ϴ�.");
						}
					}
					if(Manager3.rest1[2] < productCount) {
						System.out.println("�����Ͻ÷��� ��ǰ�� ��� �����մϴ�.");
					}
					
					if(productName.equals(Manager3.soupName[3])) {
						Manager3.rest1[3]-=productCount;
				
					if(!productName.equals(Manager3.soupName[3])) {
							System.out.println("�ش� ��ǰ�� ���� ���Կ� ���� �ʽ��ϴ�.");
						}
					}
					if(Manager3.rest1[3] < productCount) {
						System.out.println("�����Ͻ÷��� ��ǰ�� ��� �����մϴ�.");
					}
					
					if(productName.equals(Manager3.soupName[4])) {
						Manager3.rest1[4]-=productCount;
				
					if(!productName.equals(Manager3.soupName[4])) {
							System.out.println("�ش� ��ǰ�� ���� ���Կ� ���� �ʽ��ϴ�.");
						}
					}
					if(Manager3.rest1[4] < productCount) {
						System.out.println("�����Ͻ÷��� ��ǰ�� ��� �����մϴ�.");
					}*/
					break;
			case 3: buyerMode(); break;
			default :System.out.println("�߸��Է��ϼ̽��ϴ�."); buyerPurchase(); break;
			}
	}//end purchase
	public void search() {
		System.out.println("<<���ų���>>");
		System.out.println("-------------------------------------------------");
		System.out.println("");
	}
	
	}


