import java.util.Random;

class Job{
	static int exp = 0;
	static int level = 1;
	static String jobname;
	String[] Job_list = { "전사", "마법사", "궁수", "도적" };
	public Job() { }
	public Job(int num) {
		jobname = Job_list[num];
		System.out.println("용사님이 직업으로 [" + jobname + "]을(를) 선택하셨습니다.");
	}
	public void hunt() {
		Random random = new Random();
		int num = random.nextInt((int)(10 * Math.pow(1.2, level)));
		System.out.println("경험치 +" + num);
		exp += num;
		int max_exp = 10 * (int)Math.pow(1.5 , level - 1);
		if(exp >= max_exp) {
			level++;
			exp = exp - max_exp;
			System.out.println("레벨 업!!!! Lv." + level);
			}
		}
	}