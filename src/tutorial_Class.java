import classpath.Item;
//import classpath.*;

// 객체클래스
class Object{
	static int base = 0;
	static int cnt = 0;
	int a,b,c;
	int d;
	
	//생성자 | 소멸자는 finalize지만 자바에서는 소멸자 자체를 쓰지 않음. 컴퓨터가 알아서 가비지 컬렉션으로 메모리 누수를 관리하기 때문
	public Object() {}
	public Object(int a, int b){ //메개변수와 전역변수 이름을 달리하면 this를 안붙여도 됨
		this.a = a;
		this.b = b;
		this.c = a + b + base;
		cnt++;
		System.out.println("Calculator 객체수: " + cnt);
	}
	
	//오버로딩 | 메소드의 리턴값(void, int) 같아야 함
	public Object(int a, int b, int d) {
		this.a = a;
		this.b = b;
		this.d = d;
		this.c = a + b + d + base;
		cnt++;
		System.out.println("Calculator 객체수: " + cnt);
	}
	public void sum() {
		System.out.println(this.cnt + "번 째 객체의 합: " + this.c);
	}
	public void avg() {
		System.out.println(this.cnt + "번 째 객체의 평균: " + this.c/2);
	}
	void Scope() { //전역변수는 this.a
		int a = 0;
		System.out.println("a값은 " + a);
		System.out.println("this.a값은 " + this.a);
	}
}

//상속, 하위클래스
class Object2 extends Object {
	static int cnt2 = 0;
	
	public Object2(int a, int b) {
		super(a, b);
		cnt2++;
		System.out.println("하위클래스 수 : " + cnt2);
	}
	public Object2(int a, int b, int d) {
		super(a, b, d);
		cnt2++;
		System.out.println("하위클래스 수 : " + cnt2);
	}
	//오버라이딩 | 제약사항 : 메소드의 리턴타입(void, int)이 부모와 같아야 함
	public void sum() {
		System.out.print("[overriding] ");
		super.sum();
	}
	//상속 외 추가 메소드
	public void minus() {
		System.out.println(this.a - this.b);
	}
}

//클래스 메소드
class Cal{
	public static void sum(int a, int b) { //함수에 static을 붙여야 직접 사용가능| 클래스 메소드는 인스턴스 변수(static없는 변수)를 쓸 수 없음
		System.out.println("합: "+ (a+b));
	}
	public static void avg(int a, int b) {
		System.out.println("평균: " + (a+b)/2);
	}
}

//접근제어자 | public, protected, default, private | 클래스 접근제어자는 public, default 2가지
class Range {
	public int q;
	private int w;
	protected int e;
	int r; //아무것도 없으면 default
	public String x() {
		return "public void x()";
	}
	private String y() {
		return "private void y()";
	}
	protected String v() {
		return "protected void v()";
	}
	String w() {
		return "default String w()";
	}
	public String z() {
		System.out.print("public void z()를 이용한 호출 ");
		return y();
	}
}

//추상클래스 | 상속을 강제하기 위한 규제
//final | 추상과 반대로 상속/변경을 금지하기 위한 규제
abstract class Abstract_Parent {
	int value = 0;
	static final double PI = 3.14; // PI값은 바꿀 수 없음, 메소드가 final이면 하위클래스에서 해당 메소드를 오버라이딩을 못 함. 클래스가 final이면 다른 클래스가 상속 못 함.
	
	public abstract void a();
	//본체가 있는 메소드는 abstract 키워드를 가질 수 없음. 즉, public abstract void a() { ~~ }는 불가능
	//추상 클래스 내에는 추상 메소드가 아닌 메소드는 존재 가능함. ↓↓↓
	public void run() {
		a();
		System.out.println("value값은 " + value);
	}
}
class Abstract_A extends Abstract_Parent {
	public Abstract_A () {
		System.out.println("Abstract_A 생성자");
	}
	public void a() {
		value ++;
	}
}
class Abstract_B extends Abstract_Parent {
	public Abstract_B () {
		System.out.println("Abstract_B 생성자");
	}
	public void a() {
		value --;
	}
}

//인터페이스 | 어떤 객체가 인터페이스를 사용한다면 그 객체는 반드시 해당 인터페이스의 메소드들을 구현해야만 함
interface I {
	public void method1();
	public void method2();
}
interface II extends I{ //인터페이스도 상속 가능. 인터페이스 멤버는 반드시 public
	public void method3();
}
class III implements I, II { //인터페이스 I의 내용을 구현. 해당 인터페이스의 메소드를 모두 구현해야만 함. 여러개의 인터페이스를 구현 가능. 
	public void method1() {
		System.out.println("메소드1");
	}
	public void method2() {
		System.out.println("메소드2");
	}
	public void method3() {
		System.out.println("메소드3");
	}
}

//메인문
public class tutorial_Class {
	public static void main(String[] args) {
		//객체생성
		Object x = new Object(10,20);
		x.sum();
		x.avg();
		System.out.println("------------------------------------------------");
		
		Object.base = 10;
		Object y = new Object(20,40);
		y.sum();
		y.avg();
		Object.base = 0;
		System.out.println("------------------------------------------------");
		
		//클레스 메소드
		Cal.sum(10,20);
		Cal.avg(10, 20);
		Cal.sum(100,200);
		Cal.avg(100, 200);
		System.out.println("------------------------------------------------");
		
		//this를 이용한 전역,지역변수 활용
		x.Scope();
		System.out.println("------------------------------------------------");
		
		//상속, 오버라이딩
		Object2 xx = new Object2(30,50);
		xx.sum();
		xx.minus();
		System.out.println("------------------------------------------------");
		
		//오버로딩
		Object2 yy = new Object2(30,50,70);
		yy.sum();
		System.out.println("------------------------------------------------");
		
		//업캐스팅, 클래스와 다형성 | 인터페이스도 비슷함
		Object xxx = new Object2(40,60);
		xxx.sum(); // Object가 아닌 Object2의 sum을 실행
		//xxx.minus(); // xxx의 데이터타입은 Object이기 때문에 Ojbect2만의 메소드는 못 씀
		System.out.println("------------------------------------------------");
		
		//클래스패스 | 다른 클래스 혹은 패키지에서 클래스 가져다쓰기
		//같은 패키지면 따로 import안해도 되고 다른 패키지면 import 따로 해줘야 함. 그리고 import할 클래스는 파일명과 동일해야 함. Item.java, Job.java 참고
		Job user = new Job(2);
		for(int i = 0; i<5; i++) { //같은 패키지 Job.java
			user.hunt();
		}
		Item a = new Item(2);
		for(int i = 0; i<5; i++) { //다른 패키지 Item.java
			a.enforce();
		}
		System.out.println("------------------------------------------------");
		
		//접근제어자
		Range r = new Range();
		System.out.println(r.x());
		//System.out.println(r.y)); | 오류
		System.out.println(r.z());
		System.out.println("------------------------------------------------");
		
		//추상클래스
		Abstract_A abstract_a = new Abstract_A();
		abstract_a.run();
		Abstract_B abstract_b = new Abstract_B();
		abstract_b.run();
		System.out.println("------------------------------------------------");
		
		
	}
}
