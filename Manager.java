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
	int password = 1234;
	boolean flag = true;
	
	public void password() {
			do{
				System.out.println("�н����带 �Է����ּ���");
				int pw = sc.nextInt();
				this.password = password;
				if(pw == password) {
				System.out.println("ȯ���մϴ�.");
				managerMode();
				}else {
				System.out.println("�����ڰ� �ƴմϴ�.");
				start();
			}
		}while(flag);
	}
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
			case 2: buyer.search(); break;
			case 3: System.out.println("�ý����� �����մϴ�."); break;
			default : System.out.println("�޴��� �ٽ� �����ϼ���");
			}
		}while(flag);
	}
	public void managerMode() {
			
			while(flag){
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
				System.out.println("1. ������ | 2. ������ | 3. ����� | 4. ��ġ� | 5. �δ�� ");
				System.out.println("����>");
				int selectNo = sc.nextInt();
				if(selectNo == 1) {
					System.out.println("1. ������");
					System.out.println("���� �Է�>");
					soupAmount[0] = sc.nextInt();
					System.out.println("���� �Է�>");
					soupPrice[0] = sc.nextInt();
				}else if(selectNo ==2) {
					System.out.println("2�� ������");
					System.out.println("�����Է�>");
					soupAmount[1] = sc.nextInt();
					System.out.println("�����Է�>");
					soupAmount[1] = sc.nextInt();
				}else if(selectNo ==3) {
					System.out.println("3�� �����");
					System.out.println("�����Է�>");
					soupAmount[2] = sc.nextInt();
					System.out.println("�����Է�>");
					soupAmount[2] = sc.nextInt();
				}else if(selectNo ==4) {
					System.out.println("4�� ��ġ�");
					System.out.println("�����Է�>");
					soupAmount[3] = sc.nextInt();
					System.out.println("�����Է�>");
					soupAmount[3] = sc.nextInt();
				}else if(selectNo ==5) {
					System.out.println("5�� �δ��");
					System.out.println("�����Է�>");
					soupAmount[4] = sc.nextInt();
					System.out.println("�����Է�>");
					soupAmount[4] = sc.nextInt();
				}else {
					System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");
				}
				System.out.println("��� �Ͻðڽ��ϱ�?(Y/N)");
				String ys = sc.next();
				if(ys.equals("y")) run = true;
				if(ys.equals("n")) run = false;
				break;
			case 2:
				System.out.println("1. �������� | 2. ���߸��� | 3. ���ڹ� | 4. ��ġ���� | 5.���߱�ġ");
				System.out.println("����>");
					selectNo = sc.nextInt();
				if(selectNo == 1) {
					System.out.println("1. ��������");
					System.out.println("���� �Է�>");
					sideAmount[0] = sc.nextInt();
					System.out.println("���� �Է�>");
					sidePrice[0] = sc.nextInt();
				}else if(selectNo ==2) {
					System.out.println("2�� ���߸���");
					System.out.println("�����Է�>");
					sideAmount[1] = sc.nextInt();
					System.out.println("�����Է�>");
					sideAmount[1] = sc.nextInt();
				}else if(selectNo ==3) {
					System.out.println("3�� ���ڹ�");
					System.out.println("�����Է�>");
					sideAmount[2] = sc.nextInt();
					System.out.println("�����Է�>");
					sideAmount[2] = sc.nextInt();
				}else if(selectNo ==4) {
					System.out.println("4�� ��ġ����");
					System.out.println("�����Է�>");
					sideAmount[3] = sc.nextInt();
					System.out.println("�����Է�>");
					sideAmount[3] = sc.nextInt();
				}else if(selectNo ==5) {
					System.out.println("5�� ��ġ����");
					System.out.println("�����Է�>");
					sideAmount[4] = sc.nextInt();
					System.out.println("�����Է�>");
					sideAmount[4] = sc.nextInt();
				}else {
					System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");
				}
				System.out.println("��� �Ͻðڽ��ϱ�?(Y/N)");
				ys = sc.next();
				if(ys.equals("y")) flag = true;
				break;
			default : System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ��Է��ϼ���"); break;
			}
		}
	}
	public void search() {
			System.out.println("---------------<<��ǰ ��ȸ>>--------------------");
			System.out.println("������ | ���� ���� | ��� ���� | ��������");
			System.out.println("------------------<<����>>------------------------");
			System.out.println("1. ������ |" + soupAmount[0] + " ," +"??" + "??");
			System.out.println("2. ������ |" + soupAmount[1] + " ," + "??" + "??");
			System.out.println("3. ����� |" + soupAmount[2] +  ", " +"??" + "??");
			System.out.println("4. ��ġ� |" + soupAmount[3] + " ," + "??" + "??");
			System.out.println("5. �δ�� |" + soupAmount[4] + " ," + "??" + "??");
			System.out.println("------------------<<������>>------------------------");
			System.out.println("1. �������� |" + sideAmount[0] +  ", " +"??" + "??");
			System.out.println("2. ���߸��� |" + sideAmount[1] +  " ," +"??" + "??");
			System.out.println("3. ���ڹ� |" + sideAmount[2] +  " ," +"??" + "??");
			System.out.println("4. ��ġ���� |" + sideAmount[3] +  ", " +"??" + "??");
			System.out.println("5. ���߱�ġ |" + sideAmount[4] +  ", " +"??" + "??");
	}
	public void delete() {
		System.out.println("<<����>>");
		System.out.println("1 ��  2. ����");
		System.out.println("���� > ");
		int selectNo = sc.nextInt();
		if(selectNo == 1) {
			System.out.println("1. ������ | 2. ������ | 3. ����� | 4. ��ġ� | 5.�δ��");
			System.out.println("�����Ͻ� ��ǰ�� �����ϼ���");
			System.out.println("����>");
			int select = sc.nextInt();
			
			if(select == 1 || select ==2 || select==3 || select==4 || select==5) {
				System.out.println("����Ͻ� ������ �����ּ���");
				int termin = sc.nextInt();
			}
		}
		if(selectNo == 2) {
			System.out.println("1. �������� | 2. ���߸��� | 3. ���ڹ� | 4. ��ġ���� | 5. ���߱�ġ");
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
