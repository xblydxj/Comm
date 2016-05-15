package Comm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			int st = r.nextInt(30);
			int sh = r.nextInt(101);
			int at = r.nextInt(30);
			int ah = r.nextInt(50);
			String t = new SimpleDateFormat("HH:mm:ss").format(new Date());
			Data data = new Data(st, sh, at, ah, t);
			try {
				Thread.sleep(3000);
				new JDBCUtils().addData(data);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
