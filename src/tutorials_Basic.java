import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner; //입력을 위한 scanner클래스 | 자바에서는 #include<>가 아닌 import를 쓰고 뒤에 ;를 붙임

//사용자 정의 예외
class Make_Exception extends Exception {
	Make_Exception() {
		super();
		System.out.println("예외 만들기");
	}
}

public class tutorials_Basic {
	
	//구분선
	public static void boundary() {
		System.out.println("------------------------------------------------");
	}
	//입출력
	public static void ex_print() {
		Scanner sc = new Scanner(System.in); //값 입력
		System.out.print("값을 입력하시오. : ");
		int num = sc.nextInt();
		
		Scanner ssc = new Scanner(System.in); //문자열 입력
		System.out.print("문자열을 입력하시오. : ");
		String str = ssc.next();
		System.out.printf("str= %s\n", str);
		
		System.out.println(1.1+2); //정수, 실수
		System.out.println('H'); //문자
		System.out.println("Hello world"); //문자열
		System.out.println("진회가 \"안녕?\"이라고 말하였다.\n진회 : 안녕?"); //print문에 따옴표("), \n 쓰기
		boundary();
	}
	//변수
	public static void ex_variable() {
		boolean fact = false; // true=1, false=0
		int a = 5; //정수 변수 | 정수형 byte(1byte), short(2), int(4)!!, long(8)
		double b = 3.2; //실수 변수 | 실수형 float(4), double(8)!!
		float bb = 4.3f; // float은 숫자 뒤에 f를 붙여야 하고 정확한 값이 안나오니(이진수로 소수를 표현) double을 사용하자
		String first = "coding "; //문자열 변수 | 문자열 char(2) String클래스(12)!!
		String second = "좋아";
		System.out.println(a+b+bb); // float값이 정확하지 않음을 알 수 있음
		System.out.println(first+second);
		System.out.println(first.equals(second)); //문자열 비교는 .equals()메소드를 사용
		boundary();
	}
	//배열
	public static void ex_arr() {
		String[] arr = { "김", "진", "회"	};
		System.out.println(arr[0] + arr[1] + arr[2]);
		System.out.println(arr.length); // c언어는 얼마나 들어가 있는지를 알려주고, java는 얼마나 수용할 수 있는지를 알려줌
		String[] brr = new String[3]; //메모리 할당(객체 생성)
		brr[0] = "김진회";
		brr[1] = "박철진";
		brr[2] = "오지용";
		System.out.println(brr[0] + brr[1] + brr[2]);
		boundary();
	}
	//기본 제어문
	public static void ex_control() {
		//if문, switch문, while문, for문, break, continue는 모두 C언어와 같음
		String[] arr = { "김", "진", "회"	};
		for(String c : arr) {
			System.out.println("내 이름은 " + c); //for-each문 (배열과 반복문)
			}
		boundary();
	}
	//파일 입력 & 랜덤함수, 정수to문자열
	//try-catch, finally | java의 파일 입출력은 꼭 try-catch문으로 예외를 잡아줘야 함. 혹은 예외 만들기를 사용할 수도 있음(본문에서는 서술하지 않음)
	public static void ex_fw() {
		Random random = new Random();
		int num = random.nextInt(10000); //랜덤 정수 생성기
		String str = String.valueOf(num); //정수의 문자열 변환
		
		System.out.println("랜덤정수 : " + num);
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("ex_file.txt"));
			out.write(str);
			out.close();
		} catch (IOException e) {
			System.out.println("파일을 쓰는 도중에 오류가 발생했습니다 : " + e.getMessage());
		} catch(Exception e) {
			System.out.println("파일을 쓰는 도중에 오류가 발생했습니다 : " + e.getStackTrace());
		} finally {
			System.out.println("try-catch에서 finally : 예외 여부와 관계없이 실행되는 로직");
		}
		boundary();
	}
	//파일 출력
	public static void ex_fr() throws FileNotFoundException { //여기서 try-catch로 잡지 않고 다음 사용자에게 'throws 예외문구'로 던질 수도 있음
		File file = new File("ex_file.txt");
		Scanner sc = new Scanner(file);
		while(sc.hasNext())
		{
			System.out.println("파일의 내용 : " + sc.next());
		}
		sc.close();
		boundary();
	}
	
	//메인 문
	public static void main(String[] args) {
		//ex_print();
		ex_variable();
		ex_arr();
		ex_control();
		ex_fw();
		try { //throws로 던져져서 다음 사용자인 main에서 처리
			ex_fr();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 쓰는 도중에 오류가 발생했습니다 : " + e.getStackTrace());
		}
	}
}