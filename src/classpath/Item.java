package classpath;

import java.util.Random;

public class Item{
	static int weapon_level = 0;
	static String weapon;
	public String[] Item_list = { "��", "������", "Ȱ", "�ܰ�" };
	public Item() { }
	public Item(int num) {
		weapon = Item_list[num];
		System.out.println("������ ����� [" + weapon + "]��(��) �����ϼ̽��ϴ�.");
	}
	public void enforce() {
		Random random = new Random();
		int num = random.nextInt(100);
		if(num>=50) {
			weapon_level++;
			System.out.println("��ȭ ����!! ["+ weapon + "+" + weapon_level + "]");
		}
		else System.out.println("��ȭ ����.. ["+ weapon + "+" + weapon_level + "]");
	}
}