package lesson08.lesson10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//低確率で不思議な飴を生成するというとんでもない機能を追加
class NeoRobot {
	boolean mysteryCandy() {
		if (Math.random() < 0.1) {
			System.out.println("\n博士\nなんじゃこの飴は!?!?!?!?");
			return true;
		} else {
			System.out.println("\nなにもできんあかったなぁ...");
			return false;
		}
	}
}

class ClearRobot {
	void clearTable(int[] ingredients) {
		Arrays.fill(ingredients, 0);
	}
}

class Robot {
	int energy = 10;
	String name;
	int water;

	void pumpWater() {
		//randomWater();
		System.out.println("「水を" + water + "リットルだします」");
	}

	void randomWater() {
		water = (int) (Math.random() * 10) + 1;
	}

	void setwater(int water) {
		this.water = water;
	}

	void makeOmelet(int eggNum, int butterNum) {
		int omelet1 = eggNum / 2;
		int omelet2 = butterNum / 5;
		int omeletNum = Math.min(omelet1, omelet2);
		System.out.println(omeletNum + "人分のオムレツを作成しました。");
	}

	int getWater() {
		return water;
	}

	String makeEggDishes(int flourNum, int sugarNum, int eggNum, int butterNum) {
		int flour = flourNum - 170;
		int sugar = sugarNum - 50;
		int egg = eggNum - 1;
		int butter = butterNum - 80;

		String menu = null;
		if ((flour >= 0) && (sugar >= 0) && (egg >= 0) && (butter >= 80)) {
			menu = "クッキー";
		} else if ((egg >= 1) && (butter >= -75)) {
			menu = "オムレツ";
		} else if ((egg >= 0)) {
			menu = "ゆで卵";
		} else {
			menu = null;
		}
		return menu;

	}
}

public class SuperRobot {

	public static void main(String[] args) throws IOException {

		System.out.println("Rさん：");
		System.out.println("あとかたづけをしてくれるロボットも欲しいところですね。\n");
		System.out.println("G博士：");
		System.out.println("そうれはもう作ってあるぞ。\n");
		System.out.println("Rさん：");
		System.out.println("えっ！どうやって使うんですか？\n");
		System.out.println("G博士：");
		System.out.println("今まで使ってきた材料をまとめて、料理と一緒に渡すときれいにしてくれるんじゃ。\n");
		System.out.println("Rさん：");
		System.out.println("早速やってみます。\n");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("小麦粉の量を入力してください（グラム）＞");
		String flourNumStr = br.readLine();
		int flourNum = Integer.parseInt(flourNumStr);

		System.out.print("\n砂糖の量を入力してください（グラム）＞");
		String sugarNumStr = br.readLine();
		int sugarNum = Integer.parseInt(sugarNumStr);

		System.out.print("\n卵の個数を入力してください＞");
		String eggNumStr = br.readLine();
		int eggNum = Integer.parseInt(eggNumStr);

		System.out.print("\nバターの量を入力してください（グラム）＞");
		String butterNumStr = br.readLine();
		int butterNum = Integer.parseInt(butterNumStr);

		//ここでRobotクラスのインスタンスを作り、
		//（インスタンス名はrobot）
		//makeEggDishesを実行する。
		//標準出力でメニューを表示する。

		Robot robot = new Robot();
		String menu = robot.makeEggDishes(flourNum, sugarNum, eggNum, butterNum);
		if (menu != null) {
			System.out.println(menu + "ができました。");
		} else {
			System.out.println("何も作れません");
		}

		System.out.println("\nあとかたづけをします。\n");
		int[] ingredients = new int[4];
		ingredients[0] = flourNum;
		ingredients[1] = sugarNum;
		ingredients[2] = eggNum;
		ingredients[3] = butterNum;

		//ここでClearRobotクラスのインスタンスを作り、
		//（インスタンス名はclearRobot）
		//clearTableを実行する。

		ClearRobot clearRobot = new ClearRobot();
		clearRobot.clearTable(ingredients);

		System.out.println("小麦粉  ：" + ingredients[0] + "g");
		System.out.println("砂糖    ：" + ingredients[1] + "g");
		System.out.println("卵      ：" + ingredients[2] + "個");
		System.out.println("バター  ：" + ingredients[3] + "g");

		System.out.println("\nきれいになりました。");

		NeoRobot neoRobot = new NeoRobot();
		boolean hasCandy = neoRobot.mysteryCandy();

		if (hasCandy) {
			System.out.print("\n飴で作る料理を選んでください（クッキー / オムレツ / ゆで卵）＞");
			String candyMenu = br.readLine();

			if (candyMenu.equals("クッキー") || candyMenu.equals("オムレツ") || candyMenu.equals("ゆで卵")) {
				System.out.println("不思議な飴を使って" + candyMenu + "を1つ作成しました。");
			} else {
				System.out.println("その料理は作れません。");
			}
		}
	}

}