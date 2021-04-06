package team4;

import java.util.*;

public class Buyer extends Manager{



	static List<String>list1 = new ArrayList<String>(); 
	static String [] buyNo = new String [1]; 
	static String[] buyerName = new String [1]; 
	static String buyerInput; 
	static String customerTel; 
	static int numbuyer = 0; 

	static List<String> buySoup = new ArrayList<String>(); 
	static List<String> buySide = new ArrayList<String>(); 
	static List<Integer> priceSp = new ArrayList<Integer>(); 
	static List<Integer> priceSe = new ArrayList<Integer>(); 
	static int totalNum = 0; 
	static int soupNum = 0; 
	static int sideNum = 0; 

	static String productName; 
	static int productCount; 

	static int money = 0; 
	static int change = 0; 
	static int point; 
	static int[] pointTotal = new int[1];
	static double rate; 
	static double[] rating = new double[1];

	static String yesOrNo = null; 

	static boolean run = true; 
	static boolean flag = true; 

	static int buyerSum = 0; 


	static int num = 0; 
	static boolean tt = true; 
	static int num2 = 0;

	public static void buyerMode() { 

		Manager manager = new Manager();


		System.out.println(" [ �� ���  ] ");
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
		case 4: manager.start(); break;
		default : System.out.println("�ٽ� �Է����ּ���"); buyerMode(); break;
		}
	}

	public static void buyerNumber() { 

		System.out.println("[ �ű԰� ���ȭ��  ]");
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

	public static void buyerPurchase() { 

		System.out.println("�ű� �� �� �� ����� ���Ͻø� ���� 3���� �Է����ֽð�,");
		System.out.println("����� ������ �����ôٸ� '0000'�� �Է��Ͽ� ������ �ּ���.");
		System.out.println("����ȣ�� �Է����ּ���.");
		System.out.print("�Է� >");

		try { 
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
            buyerName[0] = "�̵��";
            System.out.println();
            System.out.println(buyerName[0] +"���� ���� �������Ը� �湮���ּż� �����մϴ�!");
            System.out.println();

		} else if(customerTel.equals("3")) { 
			buyerNumber();
		} else {
			System.out.println("��ȣ�� �ٽ� �Է��� �ֽñ� �ٶ��ϴ�.");
			buyerMode();
		}

		System.out.println("                    [ ���� ���  ]                   ");
		System.out.println();
		System.out.println("--------------------------------------------------------------------");
		System.out.println("|     �޴���          |      ���� ����           |      ����           |");
		System.out.println("--------------------------------------------------------------------");

		for(int i = 0; i <  soupAmount.length; i++) {
			if(Manager.soupName.size()== 0) {
				System.out.println("��ǰ�� �غ����Դϴ�.");
				buyerMode();
			}else {
				System.out.println("\t" + Manager.soupName.get(i) + "\t\t" + Manager.rest1[i] + "��" + "\t\t" + Manager.soupPrice[i]+"��");
			}
		}

		System.out.println("--------------------------------------------------------------------");

		for(int i = 0; i < soupAmount.length; i++) {
			if(Manager.sideName.size() == 0) {
				System.out.println("��ǰ�� �غ����Դϴ�.");
				buyerMode();
			}else {
				System.out.println("\t" + Manager.sideName.get(i) + "\t\t" + Manager.rest2[i] + "��" + "\t\t" + Manager.sidePrice[i]+"��");
			}
		}


		if(flag) {
			System.out.println("���� �����ݾ��� �Է����ּ���.");
			System.out.print("�Է� >");
			change = Business.sc.nextInt();
			flag = false;
		}

		while(run) {

			
			System.out.println("[�����ϱ�]  1. ���� | 2. ����  | 3. ���ư���");
			System.out.print("���� >");
			int select = Business.sc.nextInt();
			int i;

			switch(select) {
			case  1 :
				
				System.out.println();
				System.out.println("--------------------------------------------------------------------");
				System.out.println("|     �޴���          |      ���� ����           |      ����           |");
				System.out.println("--------------------------------------------------------------------");

				for( i = 0; i < soupAmount.length; i++) {
					System.out.println("\t" + Manager.soupName.get(i) + "\t\t" + Manager.rest1[i]+ "��" + "\t\t" + Manager.soupPrice[i]+"��");
				}

				System.out.println("�����Ͻ� ��ǰ���� �Է����ּ���.");
				System.out.print("�Է� >");
				productName = Business.sc.next();

				System.out.println("�����Ͻ� ��ǰ�� ������ �Է����ּ���.");
				System.out.print("�Է� >");
				productCount = Business.sc.nextInt();



				for(int j = 0; j<soupAmount.length; j++) {



					if(productName.equals(Manager.soupName.get(j))){



						num = j;
						tt = false;
						break;

					}

				}//for ��

				if(tt) {
					System.out.println("�ش��ǰ�� ���񰡰Կ� �����ϴ�.");
					break;
				}else if(Manager.rest1[num] < productCount) {
					System.out.println("��� �����մϴ�.");
					buyerMode();
					break;

				}else if(change < (Manager.soupPrice[num]* productCount)){
					System.out.println("������ �ܾ��� �����մϴ�.");
					buyerMode();
				}else {						
					Manager.rest1[num]-=productCount;
					change -= Manager.soupPrice[num] * productCount;
					buyerSum += Manager.soupPrice[num] * productCount;
					point += Manager.soupPrice[num] * 0.03;
					pointTotal[0] = point;

					buySoup.add(productName);
					priceSp.add(productCount);
					soupNum++;
					totalNum++;
					num = 0;
					tt = true;
					System.out.println("���ſϷ� !!!");


				}

				System.out.println("��� �����Ͻðڽ��ϱ�?");
				System.out.print("�Է�(Y/N) >");
				String ys = Business.sc.next();
				if(ys.equals("n") || ys.equals("N")) {
					point();
					buyerMode();
					
				}else if(ys.equals("y") || ys.equals("Y")) {
					run = true; 
					
				}else {
					System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��� �ּ���."); break;
				}
				break;
				
			case 2 :
				
	
				System.out.println();
				System.out.println("--------------------------------------------------------------------");
				System.out.println("|     �޴���          |      ���� ����           |      ����           |");
				System.out.println("--------------------------------------------------------------------");

				for( i = 0; i < soupAmount.length; i++) {
					System.out.println("\t" + Manager.sideName.get(i) + "\t\t" + Manager.rest2[i]+ "��" + "\t\t" + Manager.sidePrice[i]+"��");
				}

				System.out.println("�����Ͻ� ��ǰ���� �Է��� �ּ���.");
				System.out.print("�Է� >");
				productName = Business.sc.next();

				System.out.println("�����Ͻ� ��ǰ�� ������ �Է��� �ּ���. ");
				System.out.print("�Է� >");
				productCount = Business.sc.nextInt();

				for(int j = 0; j<sideAmount.length; j++) {



					if(productName.equals(Manager.sideName.get(j))){

						num = j;
						tt = false;
						break;

					}

				}

				if(tt) {
					System.out.println("�ش��ǰ�� ���񰡰Կ� �����ϴ�.");
					break;
				}else if(Manager.rest2[num] < productCount) {
					System.out.println("��� �����մϴ�.");
					buyerMode();
					break;

				}else if(change < (Manager.sidePrice[num]* productCount)){
					System.out.println("������ �ܾ��� �����մϴ�.");
					buyerMode();
				}else {						
					Manager.rest2[num]-=productCount;
					change -= Manager.sidePrice[num] * productCount;
					buyerSum += Manager.sidePrice[num] * productCount;
					point += Manager.sidePrice[num] * 0.02;
					pointTotal[0] = point;

					buySide.add(productName);
					priceSe.add(productCount);
					sideNum++;
					totalNum++;
					num = 0;
					tt = true;
					System.out.println("���ſϷ� !!!");

				}

				System.out.println("��� �����Ͻðڽ��ϱ�?");
				System.out.print("�Է�(Y/N) >");
				ys = Business.sc.next();

				if(ys.equals("y") || ys.equals("Y")) {
					run = true;
					
				}else if(ys.equals("n") || ys.equals("N")) {
					point();
					buyerMode();
					
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
			} 
		} 

		
	}
	public static void point() {


		System.out.println("                  [ ��� ȭ��  ]                   ");
		System.out.println("������ �����Ͻ� �ݾ��� " + buyerSum + "�� �Դϴ�.");
		System.out.println("�ܵ� " + change  + "�� �Դϴ�.");

		if(customerTel.equals("0000")) {
			System.out.println("============================================");
		}else if(customerTel.equals(buyNo[0])) {
			System.out.println(pointTotal[0] + " ����Ʈ�� �����Ǿ����ϴ�.");
		} else {
			System.out.println();
		}

		if(buyNo[0].equals("0000")) {
			System.out.println("* �̿��� �ּż� �����մϴ�. *");
		}else {
			
			System.out.println("                [ �� ȭ�� ]                   ");
			System.out.println("�� �������Կ� ���� ������ �򰡸� �ް� �ֽ��ϴ�.");
			System.out.println("�򰡸� ����Ͻô� ��� Y�� ������� ������ N�� �����ּ���.");
			System.out.print("�Է� (Y/N) >");
			yesOrNo = Business.sc.next();

			if(yesOrNo.equals("Y") | yesOrNo.equals("y")) {

				System.out.println("�򰡿� �������ּż� �����մϴ�. �� ��Ź�帳�ϴ�.");
				System.out.println(" 5. ���� ���Ҵ� " + "\t\t" + " 4. ���Ҵ�. " + "\t\t" + " 3. �����̴�. " + "\t\t" + " 2. ���ο���. " + "\t\t" + " 1. �ſ� ���ο���. ");
				System.out.print("�� �Է� (1~5) >");
				rate = Business.sc.nextInt();
				num2++;
				rating[0] += rate;

				System.out.println("������ ������ �ǰ� �����մϴ�.");
				System.out.println("* �̿��� �ּż� �����մϴ�. *");

			} else if(yesOrNo.equals("N") | yesOrNo.equals("n")) {
				System.out.println("* �̿��� �ּż� �����մϴ�. *");
			} else {
				System.out.println("y �Ǵ� n�� �Է��Ͽ� �ֽñ� �ٶ��ϴ�.");
			}
		}

	}

	public static void Search() { 

		System.out.print("������ �޴�����ȣ ���ڸ� 4���� �Է��� �ּ���. >");
		customerTel = Business.sc.next();
		if(customerTel.equals("0000")) {
			System.out.println("��ϵ� ȸ���� ��ȸ�� �� �ֽ��ϴ�.");
		}else	if(customerTel.equals(buyNo[0])) {

			System.out.println("[�� No." + buyNo[0] +"]");
			System.out.println(buyerName[0] + " ���� �ݰ����ϴ�.");
			System.out.println();

			
			if(totalNum == 0) {
				System.out.println(" ������ ���ų����� ����ֽ��ϴ� �����Ϸ� �������~? ");
				System.out.println();
				buyerMode(); 
			} else {
				
				System.out.println(" [ �� ��ȸ  ] ");

				if(soupNum == 0) { 
					System.out.println("���� �������� �����̽��ϴ�.");
					System.out.println();
				} else {
					for(int i = 0; i<soupNum; i++) { 
						System.out.println("���� ����: " + buySoup.get(i) +"\t" + "���� ����: " + priceSp.get(i)+ "��");
					}	
					System.out.println("=========================================================================");
				}
				if(sideNum == 0) { 
					System.out.println("������ �������� �����̽��ϴ�.");
					System.out.println();
				} else {
					for(int i = 0; i<sideNum; i++) { 
						System.out.println("���� ������: " + buySide.get(i) +"\t" + "���� ����: " + priceSe.get(i)+ "��");
						System.out.println();
					}
				}
				System.out.println("=========================================================================");
				System.out.println("������ �� ���űݾ��� " + buyerSum + "�� �̸� �ܾ��� " + change + "�� �Դϴ�.");
				System.out.println("������ �ܿ�����Ʈ�� " + pointTotal[0] + "�� �Դϴ�.");
				System.out.println(" * �̿����ּż� �����մϴ�. * ");

				System.out.println();
				buyerMode(); 
			}
		} 
	}
}