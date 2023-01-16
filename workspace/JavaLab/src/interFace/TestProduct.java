package interFace;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.function.BiConsumer;

public class TestProduct {

		public static void main(String[] args) {
		// 常數常使用public static final

		Notebook nb = new Notebook("Asus", 30000, 365);

		System.out.printf("名稱:%s,價錢:%d%n", nb.getName(), nb.getPrice());
		System.out.println(nb.name);// 要跟Product在同一個package內,不然看不見
		System.out.println(nb.price);
		System.out.println(nb.desc());// 同一個package

		Product item = nb;//Notebook是Product的一種嗎?是
		System.out.println(item.desc());
		Notebook item2 = (Notebook)item;//Product是Notebook的一種嗎?不一定,不保證是
		//工程師保證可以轉成Notebook,強制轉型+(Notebook)
		if (item instanceof Food) {
			//如果item有Food型態,才做強制轉型,避免發生轉錯的問題,是一種檢查的機制
			Food item3 = (Food)item;//Product是Food的一種嗎?
		}
		//System.out.println(item.getWarranty());
		//					Product.desc
		//2022.9.5, 日曆->java.util.Date
		GregorianCalendar calendar = new GregorianCalendar(2022,Calendar.SEPTEMBER,4);
		//getTime()可以取得到Date物件,Date物件是calendar程式幫你產生在heap區
		Date expDate = calendar.getTime();
		Food f = new Food("肉圓", 50, expDate);
		System.out.println(f.desc());
		
		GregorianCalendar calendar1 = new GregorianCalendar(2022,Calendar.SEPTEMBER,30);
		Date expDate1 = calendar1.getTime();
		SimCard sCard = new SimCard("日本漫遊", 700, 7, expDate1);
		System.out.println(sCard.desc());
		
		//一籃子商品
		Product[] ps = {nb, f, sCard};
		buy(ps);
		}
		//Notebook跟Food都是Product,所以用父類別型態做就好
		public static void buy(Product[] items) {
			int sum = 0;
			for(int i = 0; i < items.length; i++) {
				Product p = items[i];
				//檢查商品是否過期,如果過期,警示,不能加到sum
				//可能是以下3種:Notebook, Food, SimCard, 只有Food, SimCard會過期
				//比較好的作法是利用Expirable型態去做判斷,因為所有的子類別只要會過期必須實作Expirable
				if ( p instanceof Expirable) {
					//此商品有過期的特性,我們才檢查是否會過期
					//取得目前時間
					Date now = new Date();
					//把p轉型成Expirable,才能呼叫最後期限()取得到期日
					Expirable exp = (Expirable) p;
					//判斷到時日是否過期
					if (exp.最後期限().before(now)) {
						System.out.println("過期了!!!");
						//不結帳,繼續處理下一個商品
						continue;
					}
				}
				System.out.println("買入:" + p.desc());
				sum += p.getPrice();
			}
			System.out.printf("總金額:%d%n", sum);
		}
	}
