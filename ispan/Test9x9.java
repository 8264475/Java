
public class Test9x9 {

	public static void main(String[] args) {
		//ixj
		//1x1=1 1x2=2 ... 1x9=9
		//2x1=2 2x2=4 ... 2x9=18
		
		for ( int i = 1; i <= 9 ; i++ ) {

			for ( int j=1 ; j <= 9 ; j++ ) {
			// ln:line 、 \t: tab鍵
			System.out.print(i + "x" + j + "=" + i*j +"\t");
		}
		System.out.println();//換行
		
		
		}
	}
}		


