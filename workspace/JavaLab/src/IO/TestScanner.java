package IO;

import java.util.Scanner;

public class TestScanner {

	public static void main(String[] args) {

		System.out.println("請輸入選項:");
		System.out.println("1.aaaa");
		System.out.println("2.bbbb");
		
		Scanner s = new Scanner(System.in);
		//透過nextLine()讀取使用者輸入的文字
		String answer = s.nextLine();
		System.out.println("您輸入的為"+answer);

	}

}
