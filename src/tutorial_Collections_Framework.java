import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//API 참고 : https://prashantgaurav1.files.wordpress.com/2013/12/java-util-collection.gif

//Collections 예문을 위한 클래스 | implements Comparable을 꼭 해야 함
class Computer implements Comparable{
    int serial;
    String owner;
    Computer(int serial, String owner){
        this.serial = serial;
        this.owner = owner;
    }
    public int compareTo(java.lang.Object o) {
        return this.serial - ((Computer)o).serial;
    }
    public String toString(){
        return serial+" "+owner;
    }
}

public class tutorial_Collections_Framework {
	
	//Arraylist 자동할당 배열클래스 (순차적 수정은 Array가 빠름, 비순차적은 Linked가 훨씬 빠름, 조회는 Array가 훨씬 빠름)
	public static void ex_arraylist() {
		ArrayList arr = new ArrayList();
		arr.add("one");
		arr.add("two");
		arr.add("three");
		System.out.println(arr.toString());
		for(int i = 0; i< arr.size(); i++) {
			System.out.println(arr.get(i)); // → arr.get(i)는 Object타입이
			//String value = (String)arr.get(i); → String 형변환
			//System.out.println(value);
			}
		System.out.println("------------------------------------------------");
	}
	//혹은 제네릭을 이용하여데이터 타입을 명시함
	public static void ex_arraylist2() {
		ArrayList<String> brr = new ArrayList<String>();
		brr.add("일");
		brr.add("일");
		brr.add("이");
		brr.add("삼");
		System.out.println(brr.toString());
		for(int i = 0; i< brr.size(); i++) {
			String value = brr.get(i);
			System.out.println(value);
			}
		System.out.println("------------------------------------------------");
	}
	
	//HashSet | 순서가 없음 또한, 중복된 값은 배열 추가 안됨 (컬렉션프레임워크의 Set과 list의 차이점)
	public static void ex_hashset() {
		HashSet<Integer> A = new HashSet();
		A.add(1);
		A.add(1);
		A.add(2);
		A.add(2);
		A.add(2);
		A.add(3);
		
		System.out.println("집합 A : " + A.toString());
		Iterator hi = (Iterator) A.iterator();
		while(hi.hasNext()) {
			System.out.println(hi.next());
		}
		
		HashSet<Integer> B = new HashSet();
		B.add(1);
		B.add(2);
		System.out.println("집합 B : " + B.toString());
		
		HashSet<Integer> C = new HashSet();
		C.add(1);
		C.add(4);
		System.out.println("집합 C : " + C.toString());
		System.out.println("------------------------------------------------");
		
		System.out.println("B는 A의 부분집합인가? : " + A.containsAll(B));
		System.out.println("C는 A의 부분집합인가? : " + A.containsAll(C));
		A.addAll(C); //합집합
		System.out.println("A와 C의 합집합 : " +A.toString());
		A.retainAll(C); //교집합
		System.out.println("그 후, A와 C의 교집합 : " + A.toString());
		A.removeAll(B); //차집합
		System.out.println("그 후, A와 B의 차집합 : " + A.toString());
		System.out.println("------------------------------------------------");
	}
	
	//Map맵 | key와 value의 매칭. key는 중복이 안되지만 value는 중복 가능
	public static void ex_map() {
		HashMap<String, Integer> a = new HashMap();
		a.put("one", 1);
		a.put("two", 2);
		a.put("three", 3);
		a.put("이", 2);
		System.out.println("HashMap a : " + a.toString());
		System.out.println("HashMa a의 key \"one\" 출력 : " + a.get("one"));
		System.out.println("------------------------------------------------");
		
		//Map을 하나하나 열거하는 방법 1
		iteratorUsingForEach(a);
		System.out.println("------------------------------------------------");
		
		//Map을 하나하나 열거하는 방법 2
		iteratorUsingIterator(a);
		System.out.println("------------------------------------------------");
	}
	public static void iteratorUsingForEach(HashMap map) {
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		for(Map.Entry<String, Integer> entry : entries) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	public static void iteratorUsingIterator(HashMap map) {
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		Iterator<Map.Entry<String, Integer>> i = entries.iterator();
		while(i.hasNext()) {
			Map.Entry<String, Integer> entry = i.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	//Collections | 리스트의 정렬
	public static void ex_collections() {
		List<Computer> computers = new ArrayList<Computer>();
	    computers.add(new Computer(500, "egoing"));
	    computers.add(new Computer(200, "leezche"));
	    computers.add(new Computer(3233, "graphittie"));
	    Iterator i = computers.iterator();
	    System.out.println("before");
	    while(i.hasNext()){
	        System.out.println(i.next());
	    }
	    Collections.sort(computers);
	    System.out.println("\nafter");
	    i = computers.iterator();
	    while(i.hasNext()){
	        System.out.println(i.next());
	    }
	    System.out.println("------------------------------------------------");
	}
	
	//메인문
	public static void main(String[] args) {
		ex_arraylist();
		ex_arraylist2();
		ex_hashset();
		ex_map();
		ex_collections();
	}
}
