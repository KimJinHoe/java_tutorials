package classpath;

import java.util.Random;

public class Item{
	static int weapon_level = 0;
	static String weapon;
	public String[] Item_list = { "검", "지팡이", "활", "단검" };
	public Item() { }
	public Item(int num) {
		weapon = Item_list[num];
		System.out.println("용사님이 무기로 [" + weapon + "]을(를) 선택하셨습니다.");
	}
	public void enforce() {
		Random random = new Random();
		int num = random.nextInt(100);
		if(num>=50) {
			weapon_level++;
			System.out.println("강화 성공!! ["+ weapon + "+" + weapon_level + "]");
		}
		else System.out.println("강화 실패.. ["+ weapon + "+" + weapon_level + "]");
	}
}