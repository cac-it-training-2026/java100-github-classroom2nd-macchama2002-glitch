package lesson04.challenge06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Advertisement {

	public static void main(String[] args) throws IOException {
		System.out.println("店長から");
		System.out.println("新たな仲間を歓迎しています。");
		System.out.println("勤務可能時間を教えてください!\n1:9:00～13:00 2:13:00～17:00 3:17:00～21:00 4:要相談");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		int num = Integer.parseInt(str);

		switch (num) {
		case 1:
			System.out.println("時給は\\1500です。\n制服の貸し出しあり");
			break;
		case 2:
			System.out.println("時給は\\1400です。\n制服の貸し出しあり");
			break;
		case 3:
			System.out.println("時給は\\1600です。\n制服の貸し出しなし(エプロンをお持ちください)");
			break;
		case 4:
			System.out.println("こちらにご連絡ください\n 080-0000-0000");
			break;
		}
		System.out.println("皆様のご応募、心からお待ちしております。");
	}

}
