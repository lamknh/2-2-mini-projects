package org.kpu.mall;
import java.util.*;

public class KpuMall implements Mall{
	private HashMap<String, Item> shoppingCart = new HashMap<String, Item>();
	
	Scanner scan = new Scanner(System.in);
	
	public void displayItem() {
		System.out.println("---------------------");
		System.out.println("-   KPU FOOD MALL   -");
		System.out.println("---------------------");
		System.out.println(" 1. 소고기김밥	2000");
		System.out.println(" 2. 매운신라면	3000");
		System.out.println(" 3. 새우햄버그	4000");
		System.out.println(" 4. 해물볶음밥	5000");
		System.out.println(" 5. 영양갈비탕	6000");
		System.out.println("---------------------");
	}
	
	public void buyItem() {
		shoppingCart.put("소고기김밥", new Item("소고기김밥", 2000));
		shoppingCart.put("매운신라면", new Item("매운신라면", 3000));
		shoppingCart.put("새우햄버그", new Item("새우햄버그", 4000));
		shoppingCart.put("해물볶음밥", new Item("해물볶음밥", 5000));
		shoppingCart.put("영양갈비탕", new Item("영양갈비탕", 6000));
		
		int sel = 0;
		int num = 0;
		
		while(sel != 9) {
			System.out.print(" 주문하세요. 종료(9) >>");	
			sel = scan.nextInt();
			
			switch(sel) {
				case 1:		
					System.out.print("개수는 >>");
					num = scan.nextInt();
					Item item1 = shoppingCart.get("소고기김밥");
					item1.setItemQuantity(num);
					shoppingCart.put("소고기김밥", item1);
					System.out.println("소고기김밥 주문 완료. 총 갯수 : " + item1.getItemQuantity());
					System.out.println();
					System.out.println("---------------------");
					break;
				case 2:
					System.out.print("개수는 >>");
					num = scan.nextInt();
					Item item2 = shoppingCart.get("매운신라면");
					item2.setItemQuantity(num);
					shoppingCart.put("매운신라면", item2);
					System.out.println("매운신라면 주문 완료. 총 갯수 : " + item2.getItemQuantity());
					System.out.println();
					System.out.println("---------------------");
					break;
				case 3:
					System.out.print("개수는 >>");
					num = scan.nextInt();
					Item item3 = shoppingCart.get("새우햄버그");
					item3.setItemQuantity(num);
					shoppingCart.put("새우햄버그", item3);
					System.out.println("새우햄버그 주문 완료. 총 갯수 : " + item3.getItemQuantity());
					System.out.println();
					System.out.println("---------------------");
					break;
				case 4:
					System.out.print("개수는 >>");
					num = scan.nextInt();
					Item item4 = shoppingCart.get("해물볶음밥");
					item4.setItemQuantity(num);
					shoppingCart.put("해물볶음밥", item4);
					System.out.println("해물볶음밥 주문 완료. 총 갯수 : " + item4.getItemQuantity());
					System.out.println();
					System.out.println("---------------------");
					break;
				case 5:
					System.out.print("개수는 >>");
					num = scan.nextInt();
					Item item5 = shoppingCart.get("영양갈비탕");
					item5.setItemQuantity(num);
					shoppingCart.put("영양갈비탕", item5);
					System.out.println("영양갈비탕 주문 완료. 총 갯수 : " + item5.getItemQuantity());
					System.out.println();
					System.out.println("---------------------");
					break;
					
			}
		}
		System.out.println("주문 종료합니다.");
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
				System.out.printf(" [ %s, %d원, %d개 ]\n", item.getItemName(), item.getItemPrice(), 
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
		System.out.println("총 구매 금액은 "+sum+"원 입니다.");
		
		System.out.println("최고 구매 상품은 "+ name+"("+max+"원)입니다");
	}
}
