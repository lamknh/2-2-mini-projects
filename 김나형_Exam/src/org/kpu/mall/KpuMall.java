package org.kpu.mall;
import java.util.*;

public class KpuMall implements Mall{
	private HashMap<String, Item> shoppingCart = new HashMap<String, Item>();
	
	Scanner scan = new Scanner(System.in);
	
	public void displayItem() {
		System.out.println("---------------------");
		System.out.println("-   KPU FOOD MALL   -");
		System.out.println("---------------------");
		System.out.println(" 1. �Ұ����	2000");
		System.out.println(" 2. �ſ�Ŷ��	3000");
		System.out.println(" 3. �����ܹ���	4000");
		System.out.println(" 4. �ع�������	5000");
		System.out.println(" 5. ���簥����	6000");
		System.out.println("---------------------");
	}
	
	public void buyItem() {
		shoppingCart.put("�Ұ����", new Item("�Ұ����", 2000));
		shoppingCart.put("�ſ�Ŷ��", new Item("�ſ�Ŷ��", 3000));
		shoppingCart.put("�����ܹ���", new Item("�����ܹ���", 4000));
		shoppingCart.put("�ع�������", new Item("�ع�������", 5000));
		shoppingCart.put("���簥����", new Item("���簥����", 6000));
		
		int sel = 0;
		int num = 0;
		
		while(sel != 9) {
			System.out.print(" �ֹ��ϼ���. ����(9) >>");	
			sel = scan.nextInt();
			
			switch(sel) {
				case 1:		
					System.out.print("������ >>");
					num = scan.nextInt();
					Item item1 = shoppingCart.get("�Ұ����");
					item1.setItemQuantity(num);
					shoppingCart.put("�Ұ����", item1);
					System.out.println("�Ұ���� �ֹ� �Ϸ�. �� ���� : " + item1.getItemQuantity());
					System.out.println();
					System.out.println("---------------------");
					break;
				case 2:
					System.out.print("������ >>");
					num = scan.nextInt();
					Item item2 = shoppingCart.get("�ſ�Ŷ��");
					item2.setItemQuantity(num);
					shoppingCart.put("�ſ�Ŷ��", item2);
					System.out.println("�ſ�Ŷ�� �ֹ� �Ϸ�. �� ���� : " + item2.getItemQuantity());
					System.out.println();
					System.out.println("---------------------");
					break;
				case 3:
					System.out.print("������ >>");
					num = scan.nextInt();
					Item item3 = shoppingCart.get("�����ܹ���");
					item3.setItemQuantity(num);
					shoppingCart.put("�����ܹ���", item3);
					System.out.println("�����ܹ��� �ֹ� �Ϸ�. �� ���� : " + item3.getItemQuantity());
					System.out.println();
					System.out.println("---------------------");
					break;
				case 4:
					System.out.print("������ >>");
					num = scan.nextInt();
					Item item4 = shoppingCart.get("�ع�������");
					item4.setItemQuantity(num);
					shoppingCart.put("�ع�������", item4);
					System.out.println("�ع������� �ֹ� �Ϸ�. �� ���� : " + item4.getItemQuantity());
					System.out.println();
					System.out.println("---------------------");
					break;
				case 5:
					System.out.print("������ >>");
					num = scan.nextInt();
					Item item5 = shoppingCart.get("���簥����");
					item5.setItemQuantity(num);
					shoppingCart.put("���簥����", item5);
					System.out.println("���簥���� �ֹ� �Ϸ�. �� ���� : " + item5.getItemQuantity());
					System.out.println();
					System.out.println("---------------------");
					break;
					
			}
		}
		System.out.println("�ֹ� �����մϴ�.");
	}
	
	
	public void showReceipt() {
		System.out.println("---------------------");
		System.out.println("-      Receipt      -");
		System.out.println("---------------------");
		
		Collection v = shoppingCart.values();
		Iterator<Item> it = v.iterator();
		
		int sum = 0;
		int max = 0;
		String name = null;
		
		while(it.hasNext()) {
			Item item = it.next();
			if(item.getItemQuantity()!=0) {
				System.out.printf(" [ %s, %d��, %d�� ]\n", item.getItemName(), item.getItemPrice(), 
						item.getItemQuantity());
				sum += item.getItemPrice() * item.getItemQuantity();
				
				int sum2 = item.getItemPrice() * item.getItemQuantity();
				if(max < sum2) {
					max = sum2;
					name = item.getItemName();
				}
			}	
			
		}
		System.out.println();
		System.out.println("�� ���� �ݾ��� "+sum+"�� �Դϴ�.");
		
		System.out.println("�ְ� ���� ��ǰ�� "+ name+"("+max+"��)�Դϴ�");
	}
}
