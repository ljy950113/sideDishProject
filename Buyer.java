package team4;

import java.util.*;

public class Buyer extends Manager{

	static List<String>list1 = new ArrayList<String>(); //��ǰ ��� �迭
	static String [] buyNo = new String [1]; //����ȣ ���� �迭
	static String[] buyerName = new String [1]; //���� ���� �迭
	static String buyerInput; //���� �񱳺���
	static String customerTel; //����ȣ ��ȸ
	static int numbuyer = 0; //����ȣ ����

	static List<String> buySoup = new ArrayList<String>(); //���� ���� ���ʷ� ���
	static List<String> buySide = new ArrayList<String>(); //���� ������ ���ʷ� ���
	static List<Integer> priceSp = new ArrayList<Integer>(); //���� ������ ���ʷ� ���
	static List<Integer> priceSe = new ArrayList<Integer>(); //���� �������� ���ʷ� ��� 
	static int totalNum = 0; //���� ���Ÿ� �� Ƚ��
	static int soupNum = 0; //���� ������ Ƚ��
	static int sideNum = 0; //������ ������ Ƚ��

	static String productName; //���� ��ǰ��
	static int productCount; //��ǰ ���� ����

	static int money = 0; //�� ���� �ݾ�
	static int change = 0; //�� �ܵ� 
	static int point; //����Ʈ 
	static int[] pointTotal = new int[1];
	static int rate; //���� ���� ����
	static int[] rating = new int[1];

	static String yesOrNo = null; //��� ���� ����

	static boolean run = true; //�ݺ��� ����
	static boolean flag = true; //�ݺ��� ����2

	static int buyerSum = 0; //�� ���űݾ� 

	public static void buyerMode() { //�� ����ȭ��
		
		
		System.out.println(" [ �� ��� ] ");
		System.out.println("1. ���");
		System.out.println("2. ����");
		System.out.println("3. ��ȸ");
		System.out.println("4. ����");
		System.out.print("���� >");
		int select = Business.sc.nextInt();

		switch(select) {
		case 1: buyerNumber(); break;
		case 2: buyerPurchase(); break;
		case 3: Search(); break;
		case 4: run = false; break;
		default : System.out.println("�ٽ� �Է����ּ���"); buyerMode(); break;
		}
	}

	public static void buyerNumber() { //����ȣ ���ȭ��

		System.out.println("[ �ű԰� ���ȭ�� ]");
		System.out.println("������ �̸��� �Է����ּ���.");
		System.out.print("�Է� >");
		buyerInput = Business.sc.next();

		if(buyerInput.equals(buyerName[0])) {
			System.out.println("�̹� ��ϵ� ���Դϴ�.");
			System.out.println();
			buyerMode();
		} else {
			buyerName[0] = buyerInput;	
			System.out.println("������ �޴��ȣ ���ڸ� 4���� �Է����ּ���.");
			System.out.print("�Է� >");
			buyNo[0] = Business.sc.next();

			System.out.println("�ű� ������ ��ϵǼ̽��ϴ� !!!");
			System.out.println();
			buyerMode();
		}
	}

	public static void buyerPurchase() { //����ȭ��

		System.out.println("�ű� �� �� �� ����� ���Ͻø� ���� 3���� �Է����ֽð�,");
		System.out.println("����� ������ �����ôٸ� '0000'�� �Է��Ͽ� ������ �ּ���.");
		System.out.println("����ȣ�� �Է����ּ���.");
		System.out.print("�Է� > ");

		try { //���ڰ� �ƴ� �ٸ� ���ڸ� �Է����� �� ����ó��
			customerTel = Business.sc.next();
		} catch(InputMismatchException e) {
			System.err.println("���������� �����Դϴ�. �ý����� �ٽ� ������ �ּ���.");
			System.exit(0);
		}

		if(customerTel.equals(buyNo[0])) {
			
			System.out.println();
			System.out.println(buyerName[0] + "���� ���� �������Ը� �湮���ּż� �����մϴ�!");
			System.out.println();
			
		} else if (customerTel .equals("0000")) { 
			buyNo[0] = "0000";
			System.out.println();
			System.out.println("�̵�ϰ��� ���� �������Ը� �湮���ּż� �����մϴ�!");
			System.out.println();
			
		} else if(customerTel.equals("3")) { 
			buyerNumber();
		} else {
			System.out.println("��ȣ�� �ٽ� �Է��� �ֽñ� �ٶ��ϴ�.");
			buyerMode();
		}

		System.out.println("                             [ ���� ��� ]                   ");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("|     �޴���          |      ���� ����           |      ����           |             ");
		System.out.println("------------------------------------------------------------------------------");

		for(int i = 0; i <  soupAmount.length; i++) {
			if(Manager.soupName.size()== 0) {
				System.out.println("��ǰ�԰�ȵ�");
				buyerMode();
			}else {
			System.out.println("\t" + Manager.soupName.get(i) + "\t\t" + Manager.rest1[i]+ "��" + "\t\t" + Manager.soupPrice[i]+"��"+ "\t\t" + "��õ�޴�");
			}
		}

		System.out.println("--------------------------------------------------------------------");

		for(int i = 0; i < soupAmount.length; i++) {
			if(Manager.sideName.size() == 0) {
				System.out.println("��ǰ�԰�ȵ�");
				buyerMode();
			}else {
			System.out.println("\t" + Manager.sideName.get(i) + "\t\t" + (Manager.rest2[i])+ "��" + "\t\t" + Manager.sidePrice[i]+"��"+ "\t\t" + "��õ�޴�");
			}
		}
		

		if(flag) {
			System.out.println("���� �����ݾ��� �Է����ּ���.");
			System.out.print("�Է� > ");
			change = Business.sc.nextInt();
			flag = false;
		}

		while(run) {

			//����ȭ�� �ݺ�
			System.out.println("[�����ϱ�]  1. ���� | 2. ����  | 3. ���ư���");
			System.out.print("���� >");
			int select = Business.sc.nextInt();
			int i;

			switch(select) {
			case  1 :
				System.out.println("                             [ ���� ��� ]                   ");
				System.out.println();
				System.out.println("------------------------------------------------------------------------------");
				System.out.println("|     �޴���          |      ���� ����           |      ����           |             ");
				System.out.println("------------------------------------------------------------------------------");

				for( i = 0; i < soupAmount.length; i++) {
					System.out.println("\t" + Manager.soupName.get(i) + "\t\t" + Manager.rest1[i]+ "��" + "\t\t" + Manager.soupPrice[i]+"��"+ "\t\t" + "��õ�޴�");
				}

				System.out.println("�����Ͻ� ��ǰ���� �Է����ּ���.");
				System.out.print("�Է� > ");
				productName = Business.sc.next();

				System.out.println("�����Ͻ� ��ǰ�� ������ �Է����ּ���.");
				System.out.print("�Է� > ");
				productCount = Business.sc.nextInt();

				for( i = 0;  i < soupAmount.length; i++) {
					if(productName.equals(Manager.soupName.get(i))) { 
						//��ȸ�κ��̶� �����Ϸ��� �������� ����ߴ� ������ ���� �־����. ������ �ʿ��Ҽ��� �ִ� �κ��̶� �ּ����� ����ϴ�.
						if(Manager.rest1[i] < productCount) {
							System.out.println("��� �����մϴ�.");
							buyerMode();
							break;
						} else if(change < (Manager.soupPrice[i]* productCount)){
							System.out.println("������ �ܾ��� �����մϴ�.");
							buyerMode();
						}else if( ! productName.equals(Manager.soupName.get(i))) {
							System.out.println("�ش� ��ǰ�� ���� ���Կ� ���� �ʽ��ϴ�.");
						}else {						
							Manager.rest1[i]-=productCount;
							change -= Manager.soupPrice[i] * productCount;
							buyerSum += Manager.soupPrice[i] * productCount;
							point += Manager.soupPrice[i] * 0.03;
							pointTotal[0] = point;

							buySoup.add(productName);
							priceSp.add(productCount);
							soupNum++;
							totalNum++;
						}	
				}
				}

				System.out.println("��� �����Ͻðڽ��ϱ�?");
				System.out.print("�Է�(Y/N) >");
				String ys = Business.sc.next();
				if(ys.equals("n") || ys.equals("N")) {
					point();
					buyerMode();
					//buyerMode(); �̰� �ϸ� �籸�� ���ϴµ� �޴����� �������� �ּ�ó���߾��.
				}else if(ys.equals("y") || ys.equals("Y")) {
					run = true; 
					// �� buyerPurchase() �籸�Žÿ� �ڵ�����ȣ�� �ٽ� ����°ͺ��� �����ؼ� ������ ���� ����� �����ϴ°Ŷ� ���ʿ��� �������Ƽ� �����߾��.
				}else {
					System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��� �ּ���."); break;
				}
				break;
//����
			case 2 :
				System.out.println("                             [ ���� ��� ]                   ");
				System.out.println();
				System.out.println("------------------------------------------------------------------------------");
				System.out.println("|     �޴���          |      ���� ����           |      ����           |             ");
				System.out.println("------------------------------------------------------------------------------");

				for( i = 0; i < soupAmount.length; i++) {
					System.out.println("\t" + Manager.sideName.get(i) + "\t\t" + Manager.rest2[i]+ "��" + "\t\t" + Manager.sidePrice[i]+"��"+ "\t\t" + "��õ�޴�");
				}

				System.out.println("�����Ͻ� ��ǰ���� �Է��� �ּ���.");
				System.out.print("�Է� > ");
				productName = Business.sc.next();

				System.out.println("�����Ͻ� ��ǰ�� ������ �Է��� �ּ���. ");
				System.out.print("�Է� > ");
				productCount = Business.sc.nextInt();

				for( i = 0; i < soupAmount.length; i++) {
					if(productName.equals(Manager.sideName.get(i))) { 							
						//��ȸ�κ��̶� �����Ϸ��� �������� ����ߴ� ������ ���� �־����. ������ �ʿ��Ҽ��� �ִ� �κ��̶� �ּ����� ����ϴ�.
						if(rest2[i] == 0) {
							System.out.println("��� �����մϴ�.");
							break;
						} else {
							Manager.rest2[i]-=productCount;
							change -= Manager.sidePrice[i] * productCount;
							buyerSum += Manager.sidePrice[i] * productCount;
							point += Manager.sidePrice[i] * 0.02;
							pointTotal[0] = point;

							buySide.add(productName);
							priceSe.add(productCount);
							sideNum++;
							totalNum++;
						}
						if(change < (Manager.sidePrice[i]*productCount) && change == 0) {
							change -= Manager.sidePrice[i]*productCount;
							System.out.println("�ܾ��� �����մϴ�.");
						}
						
					}else	if(!productName.equals(Manager.sideName.get(i))) {
						System.out.println("�ش� ��ǰ�� ���� ���Կ� ���� �ʽ��ϴ�.");
					} 
				}
				System.out.println("��� �����Ͻðڽ��ϱ�?");
				System.out.print("�Է�(Y/N) >");
				ys = Business.sc.next();

				if(ys.equals("y") || ys.equals("Y")) {
					run = true;
					//buyerMode(); �̰� �ϸ� �籸�� ���ϴµ� �޴����� �������� �ּ�ó���߾��.
				}else if(ys.equals("n") || ys.equals("N")) {
					point();
					buyerMode();
					// �� buyerPurchase() �籸�Žÿ� �ڵ�����ȣ�� �ٽ� ����°ͺ��� �����ؼ� ������ ���� ����� �����ϴ°Ŷ� ���ʿ��� �������Ƽ� �����߾��.
				}else {
					System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��� �ּ���."); break;
				}
				break;

			case 3 :
				buyerMode();
				break;

			default : 
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��� �ּ���.");
				buyerPurchase(); 
				break;
			} //switch�� ��
		} //while�� ��

		//����Ʈ ���� ȭ��
	}
	public static void point() {
		System.out.println("                             [ ��� ȭ�� ]                   ");
		System.out.println("������ �����Ͻ� �ݾ��� " + buyerSum + "�� �Դϴ�.");
		System.out.println("�ܵ� " + change  + "�� �Դϴ�.");
		
		if(customerTel.equals("0000")) {
			System.out.println("==================");
		}else if(customerTel.equals(buyNo[0])) {
		System.out.println(pointTotal[0] + " ����Ʈ�� �����Ǿ����ϴ�.");
		} else {
			System.out.println();
		}
			

		//�� ȭ��
		System.out.println("                             [ �� ȭ�� ]                   ");
		System.out.println("�� �������Կ� ���� ������ �򰡸� �ް� �ֽ��ϴ�.");
		System.out.println("�򰡸� ����Ͻô� ��� Y�� ������� ������ N�� �����ּ���.");
		System.out.print("�Է� (Y/N) >");
		yesOrNo = Business.sc.next();

		if(yesOrNo.equals("y") | yesOrNo.equals("y")) {
			System.out.println("�򰡿� �������ּż� �����մϴ�. �� ��Ź�帳�ϴ�.");
			System.out.println(" 5. ���� ���Ҵ� " + "\t\t" + " 4. ���Ҵ�. " + "\t\t" + " 3. �����̴�. " + "\t\t" + " 2. ���ο���. " + "\t\t" + " 1. �ſ� ���ο���. ");
			System.out.print("�� �Է�(���ڷθ� �Է����ּ���. (1~5)> ");
			rate = Business.sc.nextInt();
			rating[0] = rate;

			System.out.println("������ ������ �ǰ� �����մϴ�.");
			System.out.println("* �̿��� �ּż� �����մϴ�. *");
			
		} else if(yesOrNo.equals("N") | yesOrNo.equals("n")) {
			System.out.println("* �̿��� �ּż� �����մϴ�. *");
		} else {
			System.out.println("y �Ǵ� n�� �Է��Ͽ� �ֽñ� �ٶ��ϴ�.");
		}

		}

	public static void Search() { //�� ��ȸȭ��

		System.out.print("������ �޴�����ȣ ���ڸ� 4���� �Է��� �ּ���. >");
		customerTel = Business.sc.next();
	     if(customerTel.equals("0000")) {
			System.out.println("��ϵ� ȸ���� ��ȸ�� �� �ֽ��ϴ�.");
		}else	if(customerTel.equals(buyNo[0])) {

			System.out.println("[�� No." + buyNo[0] +"]");
			System.out.println(buyerName[0] + " ���� �ݰ����ϴ�.");
			System.out.println();

			//��ȸ �κ�
			if(totalNum == 0) {
				System.out.println(" ������ ���ų����� ����ֽ��ϴ� �����Ϸ� �������~? ");
				System.out.println();
				buyerMode(); //��ȸ �� ������ ���ƿ�
			} else {
				System.out.println(" [ �� ��ȸ ] ");
				if(soupNum == 0) { //���� ���� �������� �ʾҴٸ� 
					System.out.println("���� �������� �����̽��ϴ�.");
					System.out.println();
				} else {
					for(int i = 0; i<soupNum; i++) { //���� ���� �����ߴٸ�
						System.out.println("���� ����: " + buySoup.get(i) +"\t" + "���� ����: " + priceSp.get(i)+ "��");
					}	
					System.out.println("--------------------------------------------------------------------------");
				}
				if(sideNum == 0) { //���� ������ �������� �ʾҴٸ�
					System.out.println("������ �������� �����̽��ϴ�.");
					System.out.println();
				} else {
					for(int i = 0; i<sideNum; i++) { //���� ������ �����ߴٸ�
						System.out.println("���� ������: " + buySide.get(i) +"\t" + "���� ����: " + priceSe.get(i)+ "��");
						System.out.println();
					}
				}
				System.out.println("--------------------------------------------------------------------------");
				System.out.println("������ �� ���űݾ��� " + buyerSum + "�� �̸� �ܾ��� " + change + "�� �Դϴ�.");
				System.out.println("������ �ܿ�����Ʈ�� " + pointTotal[0] + "�� �Դϴ�.");
				System.out.println(" * �̿����ּż� �����մϴ�. * ");

				System.out.println();
				buyerMode(); //��ȸ �� ������ ���ƿ�
			}
		} 
	}
}