import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BufferedReader_ex {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String a = in.readLine();
		System.out.println(a);
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int i = Integer.parseInt(st.nextToken());
		int j = Integer.parseInt(st.nextToken());
		System.out.println(i + "//" + j);
		
		StringBuilder sb = new StringBuilder();
		sb.append("Hello ");
		sb.append("SSAFY").append("!!");
		System.out.println(sb.toString());
		sb.setLength(sb.length()-2);
		System.out.println(sb.toString());
	}

}
