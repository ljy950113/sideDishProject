package team4;

import java.util.*;

public class Manager implements Food{
	static List<String>soupName = new ArrayList<String>();
	static List<String>sideName = new ArrayList<String>();
	static int[] soupPrice = new int[5];
	static int[] soupAmount = new int[5];
	static int[] sidePrice  = new int[5];
	static int[] sideAmount = new int[5];
	static int[] remove = new int[5];
	static int[] rest1 = new int[5]; // �� �ܿ���
	static int[] rest2 = new int[5]; // ���� �ܿ���
	
	boolean flag = true;
	
	void add() { 
		
	}
	
	public void start() { //ù ����ȭ��


		do {
			System.out.println("[ �������� ���� �ý���  ]");
			System.out.println();
			System.out.println("1. ������ ���");
			System.out.println();
			System.out.println("2. �� ���");
			System.out.println();
			System.out.println("3. ���α׷� ����");
			System.out.print("���� >");
			int select = Business.sc.nextInt();

			switch(select) {
			case 1: password();  break;
			case 2: Buyer.buyerMode();break;  
			case 3: System.out.println("�ý����� �����մϴ�."); flag = false; break;
			default : System.out.println("�޴��� �ٽ� �����ϼ���");
			}
		}while(flag);
	}
	
	public void password() { //������ ��й�ȣ �Է�ȭ��
		int comparition = 1;
		for(int i=0; i < comparition; i++) {
			System.out.println("�н����带 �Է����ּ���.");
			System.out.print("�Է� > ");
			int pw = Business.sc.nextInt();
			if(password == pw) {
				System.out.println("�����ڰ� �½��ϴ�.");
				managerMode();
			}else {
				System.out.println("�н����尡 �ùٸ��� �ʽ��ϴ�. �ٽ� �Է��ϼ���");
				comparition++;
				if(comparition ==4) {
					System.out.println("3ȸ �̻� Ʋ�Ƚ��ϴ�. ����ȭ������ ���ư��ϴ�.");
					start();
					break;
				}
			}
		}
	}
	public void managerMode() { //�Ŵ��� �޴�

		System.out.println(" [ ������ ��� ] ");
		System.out.println("1. �԰�");
		System.out.println("2. ����");
		System.out.println("3. ��ǰ��ȸ");
		System.out.println("4. ������");
		System.out.println("5. ���ư���");
		System.out.print("���� > ");
		int select = Business.sc.nextInt();
		switch(select) {
		case 1: entering();  break;
		case 2: delete();	break;
		case 3: search();	break;
		case 4: customer();	break;
		case 5: start(); break;

		default : System.out.println("�ٽ� �Է����ּ���"); break;
		}
	}
	public void entering() { //�޴� �԰�ȭ��
		boolean run = true;
		int select = 0;
		soupName.add("������"); 
		soupName.add("������");
		soupName.add("�����");
		soupName.add("��ġ�");
		soupName.add("�δ��");

		sideName.add("��������");
		sideName.add("���߸���");
		sideName.add("���ڹ�");
		sideName.add("��ġ����");
		sideName.add("���߱�ġ");
	

		while(run) {
			
			
				System.out.println("[ �԰� ]");
				System.out.println("1. ��  2. ����");
				System.out.print("����> ");
				select = Business.sc.nextInt();

			switch(select) {

			case 1: //�� �԰�
				System.out.println("                  [ �԰� ���� ��� ]                  ");
				System.out.println("1." + soupName.get(0) + " | " +  "2." + soupName.get(1) + " | " + 
											"3."  +soupName.get(2) + " | " + "4." +soupName.get(3) +" | " + 
											"5." + soupName.get(4));
				
				System.out.print("���� > ");
				int selectNo = Business.sc.nextInt();
				for(int i=0; i < soupAmount.length; i++) {
					if(selectNo == i+1) {
						System.out.println();
						System.out.println((i+1)+ "." +soupName.get(i));
						System.out.print("���� �Է� > ");
						soupAmount[i] += Business.sc.nextInt();
						rest1[i] = soupAmount[i];
						System.out.print("���� �Է� > ");
						soupPrice[i] = Business.sc.nextInt();
					}//selectNo if�� ��
					if(selectNo > soupName.size()) {
						System.out.println("1������ 5�� �߿� ������ �ּ���");
						entering();
					}//6��������� ���ư���
				}//for����
				System.out.println("��� �Ͻðڽ��ϱ�?");
				System.out.print("�Է�(Y/N) > ");
				String ys = Business.sc.next();
				if(ys.equals("n") || ys.equals("N")) {
					run = false;
					managerMode();
					break;
				}else if(ys.equals("y") || ys.equals("Y")) {
					break;
				}else {
					System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���."); break;
				}


			case 2: //���� �԰�
				System.out.println("                  [ �԰� ���� ���  ]                  ");
				System.out.println("1." + sideName.get(0) + " | " +  "2." + sideName.get(1) + " | " + 
											"3."  +sideName.get(2) + " | " + "4." +sideName.get(3) +" | " + 
											"5." + sideName.get(4));
				System.out.print("���� > ");
				selectNo = Business.sc.nextInt();
				for(int i=0; i < soupAmount.length; i++) {
					if(selectNo == i+1) {
						System.out.println();
						System.out.println((i+1)+ "." +sideName.get(i));
						System.out.print("���� �Է� > ");
						sideAmount[i] += Business.sc.nextInt();
						rest2[i] = sideAmount[i];
						System.out.print("���� �Է� > ");
						sidePrice[i] = Business.sc.nextInt();
					}//selectNo if�� ��
					if(selectNo > sideName.size()) {
						System.out.println("1������ 5�� �߿� ������ �ּ���");
						entering();
					}//6��������� ���ư���
				}//for����
				System.out.println("��� �Ͻðڽ��ϱ�?");
				System.out.print("�Է�(Y/N) > ");
				ys = Business.sc.next();
				if(ys.equals("n") || ys.equals("N")) {
					run = false;
					managerMode();
					break;
				}else if(ys.equals("y") || ys.equals("Y")) {
					break;
				}else {
					System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���."); break;
				}
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���"); break;
			}
		}//while�� ��
	}
	
	public void delete() { //�޴� ���� ȭ��
		boolean run = true;

		while(run) {
			System.out.println("[ ���� ]");
			System.out.println("1. ��  2. ����");
			System.out.print("���� > ");
			int select = Business.sc.nextInt();

			switch(select) {


			case 1: //�� ����
				System.out.println("1." + soupName.get(0) + " | " +  "2." + soupName.get(1) + " | " + 
						"3."  +soupName.get(2) + " | " + "4." +soupName.get(3) +" | " + 
						"5." + soupName.get(4));
				System.out.print("���� > ");
				int selectNo = Business.sc.nextInt();
				for( int i=0; i < soupAmount.length; i++) {
					if(selectNo == i+1) {
						System.out.println((i+1)+ ". " +soupName.get(i));
						System.out.println("��� ������ �Է����ּ���.");
						System.out.print("�Է� > ");
						remove[i] += Business.sc.nextInt();
						rest1[i] = soupAmount[i]-remove[i];
						if(rest1[i] <=0) {
							System.out.println("��� ��� ������ �ܿ� �������� �����ϴ�.");
							rest1[i] = 0;
						}
					}//if select ��
					if(selectNo > soupName.size()) {
						System.out.println("1������ 5�� �߿� ������ �ּ���");
						delete();
					}//6���������
				}//for�� ��
				System.out.print("���ư���(Y or N) >");
				String yn = Business.sc.next();
				if(yn.equals("y") || yn.equals("Y")) managerMode();
				if(yn.equals("n") || yn.equals("N")) delete();
				else System.out.println("�߸� �Է��ϼ̽��ϴ�."); 	
				break;


			case 2: //���� ����
				System.out.println("1." + sideName.get(0) + " | " +  "2." + sideName.get(1) + " | " + 
						"3."  +sideName.get(2) + " | " + "4." +sideName.get(3) +" | " + 
						"5." + sideName.get(4));
				System.out.print("���� >");
				selectNo = Business.sc.nextInt();
				for( int i=0; i < sideAmount.length; i++) {
					if(selectNo == i+1) {
						System.out.println((i+1)+ ". " + sideName.get(i));
						System.out.println("��� ������ �Է����ּ���.");
						System.out.print("�Է� > ");
						remove[i] += Business.sc.nextInt();
						rest2[i] = sideAmount[i]-remove[i];
						if(rest2[i] <=0) {
							System.out.println("��� ��� ������ �ܿ� �������� �����ϴ�.");
							rest2[i] = 0;	}
					}
					if(selectNo > sideName.size()) {
						System.out.println("1������ 5�� �߿� ������ �ּ���");
						delete();
					}//6���������
				}//for�� ��
				System.out.print("���ư���(Y or N) >");
				yn = Business.sc.next();
				if(yn.equals("y") || yn.equals("Y")) managerMode();
				if(yn.equals("n") || yn.equals("N")) delete();
				else System.out.println("�߸� �Է��ϼ̽��ϴ�."); 
				break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�."); delete(); break;
			}//end switch
		}//end while
	}//end delete
	

	public void customer() { //�� ���� ȭ��
		System.out.println("[ ������ ]");
		System.out.println("��No. | �� ����Ʈ");
		System.out.println(Buyer.buyNo[0]);

	}



	public void search() { //�԰�� �޴� ��ȸ ȭ��    ��ǻ� ���ư��ڽ��ϱ�? ��� �ʿ䰡���� ���ư����ҰŰ����ϴ�.
		int i;
		soupName.add("������"); 
		soupName.add("������");
		soupName.add("�����");
		soupName.add("��ġ�");
		soupName.add("�δ��");
		
		sideName.add("��������");
		sideName.add("���߸���");
		sideName.add("���ڹ�");
		sideName.add("��ġ����");
		sideName.add("���߱�ġ");
		
		System.out.println("                       [ ��ǰ ��ȸ ]                       ");
		System.out.println();
		System.out.println("                         [ ���� ]                         ");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("|     �޴���          |     �԰� ����          |     �ܿ� ����          |     �޴�����          |");
		System.out.println("--------------------------------------------------------------------------------");
		for (  i = 0; i < 5; i++) {
			System.out.println("\t" + soupName.get(i) + "\t\t" + soupAmount[i]+ "��" + "\t\t" + rest1[i]+ "��" + "\t\t" + "�޴�����");
			
		}
		
		
		System.out.println();
		System.out.println("                        [ ������ ]                        ");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("|     �޴���          |     �԰� ����          |     �ܿ� ����          |     �޴�����          |");
		System.out.println("---------------------------------------------------------------------------------");
		for (  i = 0; i < 5; i++) {
			System.out.println("\t" + sideName.get(i) + "\t\t" + sideAmount[i]+ "��" + "\t\t" + rest2[i]+ "��" + "\t\t" + "�޴�����");
		}
		System.out.println();
		managerMode();
	}


	public void customerSearch() { //������ ���� �޴���
		
		System.out.println("                   [ �� ��� ]                   ");
		System.out.println();
		System.out.println("---------------------------------------------------------");
		System.out.println("|     �޴���          |      ���� ����           |      ����           |");
		System.out.println("---------------------------------------------------------");
		for(int i = 0; i < soupName.size(); i++) {
			System.out.println("\t" + soupName.get(i) + "\t\t" + rest1[i]+ "��" + "\t\t" + soupPrice[i]+"��");
		}
		System.out.println("---------------------------------------------------------");
		for(int i = 0; i < sideName.size(); i++) {
			System.out.println("\t" + sideName.get(i) + "\t\t" + rest2[i]+ "��" + "\t\t" + sidePrice[i]+"��");
		}
		System.out.println("---------------------------------------------------------");

	}

	
}