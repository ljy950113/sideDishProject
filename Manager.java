package team4;

import java.util.Scanner;

public class Manager implements Food{
	Scanner sc = new Scanner(System.in);
	
	String[] soupName = {"������", "������", "�����", "��ġ�","�δ��"}; // ������ �迭 0���� ������ 1���� ��ġ� �̷���
	int[] soupPrice = new int[5];
	int[] soupAmount = new int[5]; // 0������ 1������ 2����� 3��ġ� 4�δ��
	String[] sideName = {"��������", "���߸���", "���ڹ�", "��ġ����","���߱�ġ"};// ������ �迭 0���� ���߱�ġ, 1���� ����ġ
	int[] sidePrice  = new int[5];
	int[] sideAmount = new int[5];
	boolean flag = true;
	
	public void start() {

		Buyer buyer = new Buyer();
		
		do {
			System.out.println("<<�������� ���� �ý���>>");
			System.out.println("1. ������ ���");
			System.out.println();
			System.out.println("2. �� ���");
			System.out.println();
			System.out.println("3. ���α׷� ����");
			System.out.println("���� > ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1: password();  break;
			case 2: Buyer.buyerPrint();; break;
			case 3: System.out.println("�ý����� �����մϴ�."); flag = false; break;
			default : System.out.println("�޴��� �ٽ� �����ϼ���");
			}
		}while(flag);
	}
	
	public void password() {
			int comparition = 1;
			for(int i=0; i < comparition; i++) {
				System.out.println("�н����带 �Է����ּ���");
				int pw = sc.nextInt();
				if(password == pw) {
					System.out.println("�����ڰ� �½��ϴ�.");
					managerMode();
				}else {
					System.out.println("�н����尡 �ǹٸ��� �ʽ��ϴ�. �ٽ� �Է��ϼ���");
					comparition++;
					if(comparition ==4) {
						System.out.println("3ȸ �̻� Ʋ�Ƚ��ϴ�. �������� ���ư��ϴ�.");
						start();
						break;
					}
				}
			}
	}
	public void managerMode() {
			
				System.out.println("<<������ ���>>");
				System.out.println("1. �԰�");
				System.out.println("2. ����");
				System.out.println("3. ��ǰ��ȸ");
				System.out.println("4. ������");
				System.out.println("5. ���ư���");
				int select = sc.nextInt();
				switch(select) {
				case 1: entering();  break;
				case 2: delete();	break;
				case 3: search();	break;
				case 4: customer();	break;
				case 5: start();
							break;
				default : System.out.println("�ٽ� �Է����ּ���"); break;
				}
			}
	public void entering() {
		boolean run = true;
			while(run) {
			System.out.println("<<�԰�>>");
			System.out.println("1. ��  2. ����");
			System.out.println("����>");
			int select = sc.nextInt();
			
			switch(select) {
			case 1: 
				System.out.println("1. " + soupName[0] +" | " +  " 2. " + soupName[1] + " | " +
											" 3. "  +soupName[2] + " | " + " 4. " +soupName[3] +" | " + 
											" 5. " + soupName[4]);
				System.out.println("����>");
				int selectNo = sc.nextInt();
				for(int i=0; i < soupName.length; i++) {
					if(selectNo == i+1) {
						System.out.println((i+1)+ ". " +soupName[i]);
						System.out.println("���� �Է�>");
						soupAmount[i] = sc.nextInt();
						System.out.println("���� �Է�>");
						soupPrice[i] = sc.nextInt();
					}
				}
				System.out.println("��� �Ͻðڽ��ϱ�?(Y/N)");
				String ys = sc.next();
				if(ys.equals("n") || ys.equals("N")) managerMode();
				break;
			case 2:
				System.out.println("1. " + sideName[0] +" | " +  " 2. " + sideName[1] + " | " +
						" 3. "  +sideName[2] + " | " + " 4. " +sideName[3] +" | " + 
						" 5. " + sideName[4]);
				System.out.println("����>");
				selectNo = sc.nextInt();
				for(int i=0; i < sideName.length; i++) {
					if(selectNo == i+1) {
						System.out.println((i+1)+ ". " +sideName[i]);
						System.out.println("�����Է�>");
						sideAmount[i] = sc.nextInt();
						System.out.println("�����Է�>");
						sidePrice[i] = sc.nextInt();
					}
			
				}
				System.out.println("��� �Ͻðڽ��ϱ�?(Y/N)");
				ys = sc.next();
				if(ys.equals("n") || ys.equals("N")) managerMode();
				break;
			default : System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���"); break;
			}
			run = false;
		}
	}

	public void search() {
			int i;
			System.out.println("---------------<<��ǰ ��ȸ>>--------------------");
			System.out.println("------------------<<����>>------------------------");
			System.out.println("������ | ���� ���� | ��� ���� | ��������");
			for (  i = 0; i < soupName.length; i++) {
				System.out.println(sideName[i] + " | " + sideAmount[i] + " | " + "��ⰳ��" + " | " + "��������");
			}
			System.out.println();
			System.out.println("------------------<<������>>------------------------");
			System.out.println("������ | ���� ���� | ��� ���� | ��������");
			for (  i = 0; i < soupName.length; i++) {
				System.out.println(soupName[i] + " | " + soupAmount[i] + " | " + "��ⰳ��" + " | " + "��������");
			}
			System.out.println();
			System.out.println("���ư���-->");
			String yn = sc.next();
			if(yn.equals("y") || yn.equals("Y")) {managerMode();}
	}
	public void delete() {
		System.out.println("<<����>>");
		System.out.println("1 ��  2. ����");
		System.out.println("���� > ");
		int selectNo = sc.nextInt();
		if(selectNo == 1) {
			System.out.println("1. " + soupName[0] +" | " +  " 2. " + soupName[1] + " | " +
					" 3. "  +soupName[2] + " | " + " 4. " +soupName[3] +" | " + 
					" 5. " + soupName[4]);
			System.out.println("�����Ͻ� ��ǰ�� �����ϼ���");
			System.out.println("����>");
			int select = sc.nextInt();
			
			if(select == 1 || select ==2 || select==3 || select==4 || select==5) {
				System.out.println("����Ͻ� ������ �����ּ���");
				int termin = sc.nextInt();
			}
		}
		if(selectNo == 2) {
			System.out.println("1. " + sideName[0] +" | " +  " 2. " + sideName[1] + " | " +
					" 3. "  +sideName[2] + " | " + " 4. " +sideName[3] +" | " + 
					" 5. " + sideName[4]);
			System.out.println("�����Ͻ� ��ǰ�� �����ϼ���");
			System.out.println("����>");
			int select = sc.nextInt();
			
			if(select == 1 || select ==2 || select==3 || select==4 || select==5) {
				System.out.println("����Ͻ� ������ �����ּ���");
				int termin = sc.nextInt();
			}
		}
	}
	public void customer() {
		System.out.println("<<������>>");
		System.out.println("��No. | �� ����Ʈ");
		
	}
	
}
