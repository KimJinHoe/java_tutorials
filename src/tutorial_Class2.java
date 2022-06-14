import javax.swing.tree.TreeCellEditor;

//자바에서의 define | enum의 배경
class ex_enum {
	public final static int SIZE = 10; //c++에서의 #define이랑 같음. #define 매크로를 사용하려면 final 매크로 형식으로 쓰면 됨
}

//enum(열거형)
enum Company {
	APPLE, SAMSUNG, LG;
}

//enum 심화
enum Fruit {
	APPLE("red"), PEACH("pink"), BANANA("yellow"); //여기서 가로는 매개변수 1개의 Fruit(String color)를 호출한다는 뜻
	public String color;
	//enum은 클래스여서 생성자를 가질 수 있음
	Fruit(String color) {
		System.out.println("생성자 호출 " + this);
		this.color = color;
	}
}

//모든 객체는 extends Object가 생략되어 있음 | toString(), equals(), clone() 등 메소드가 포함되어 있음
class Person implements Cloneable {
	String name;
	Person(String name) {
		this.name = name;
	}
	public java.lang.Object clone() throws CloneNotSupportedException { //Clone() 메소드는 오버라이딩 해야 함
		return super.clone();
	}
}

//참조와 복제
class ex_Reference {
	public int val;
	ex_Reference(int val) {
		this.val = val;
	}
}

//제네릭(Generic) | 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법.
//T, S에는 기본 데이터 타입은 올 수 없음. 기본 데이터 타입을 사용하려면 wrapper클래스(기본 데이터 타입을 객체로 만든 것)를 쓰면 됨 | Integer, Double...등등
class ex_Generic<T, S> {
	public T info;
	public S id;
	ex_Generic(T info, S id) {
		this.info = info;
		this.id = id;
	}
	public <U> void printInfo(U info) { //메소드에서도 제네릭 사용 가능
		System.out.println(info);
	}
}
//제네릭에서 제한두기 (ex_Reference 클래스 혹은 그의 하위 클래스만 들어올 수 있음. extends 인터페이스도 가능) | extends 뒤의 클래스의 메소드도 사용 가능
class People<T extends ex_Reference> {
	public T info;
	People(T info) {
		this.info = info;
	}
}
public class tutorial_Class2 {

	public static void main(String[] args) {
		Person p1 = new Person("김진회");
		try {
			Person p2 = (Person) p1.clone();
			System.out.println("p1.equals(p2) : " + p1.equals(p2)); //
			System.out.println("p1과 p2는 다르다 :" + p1 + ", " + p2);
			System.out.println("------------------------------------------------");
			
			System.out.println("p1.name.equals(p2.name) : " + p1.name.equals(p2.name));
			System.out.println("p1.name과 p2.name은 같다 : " + p1.name + ", " + p2.name);
			System.out.println("------------------------------------------------");
			
			System.out.println("p1과 p1.toString()은 같다 : " + p1 + ", " + p1.toString());
			
			
		} catch (CloneNotSupportedException e) {
			System.out.println("오류 발생 : " + e.getMessage());
		}
		System.out.println("------------------------------------------------");
		
		Fruit t1 = Fruit.APPLE;
		Company t2 = Company.APPLE;
		switch(t1) {
		case APPLE : 
			System.out.println(Fruit.APPLE + " " + Fruit.APPLE.color);
			break;
		case PEACH :
			System.out.println(Fruit.PEACH + " " + Fruit.PEACH.color);
		case BANANA :
			System.out.println(Fruit.BANANA + " " + Fruit.BANANA.color);
		}
		System.out.println(Company.APPLE);
		//if(Fruit.APPLE == Company.APPLE) >> 다름
		for(Fruit f : Fruit.values()) {
			System.out.println(f + " " + f.color);
		}
		System.out.println("------------------------------------------------");
		
		//참조와 복제
		int a = 1;
		int b = a;
		b = 2;
		System.out.println(a); //b를 바꿔도 a는 바뀌지 않음 (복제) | 기본 데이터 타입은 복제임
		ex_Reference aa = new ex_Reference(1);
		ex_Reference bb = aa;
		bb.val = 2;
		System.out.println(aa.val); //b를 바꾸면 a도 바뀐다 (참조) | 객체같은 기본 데이터 타입 외는 참조임. aa와 bb가 전부 ex_Reference(1) 인스턴스를 가르키기 때문
		System.out.println("------------------------------------------------");
		
		//제네릭(Generic)
		//ex_Reference aa = new ex_Refence(1);
		ex_Generic<ex_Reference, Integer> c = new ex_Generic(aa, 1);
		//ex_Generic<ex_Reference, Integer> c = new ex_Generic<ex_Reference, Integer>(new ex_Reference(1), 1);
		//ex_Generic c = new ex_Generic(new ex_Reference(1), 1); 로 생략할 수 있음. 매개변수로 구분 가능하기 때문 
		System.out.println(c.info.val + ", " + c.id);
		c.printInfo(aa.val);
		//c.<ex_Reference>printInfo(aa.val); 을 생략한 것
		System.out.println("------------------------------------------------");
		
	}
}
