package lesson07.challenge15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yamanotesen {

	public static void main(String[] args) throws IOException {
		String[] stations = { "東京", "新宿", "新橋", "御徒町", "五反田",
				"秋葉原", "浜松町", "渋谷", "田町", "恵比寿", "有楽町",
				"目黒", "大崎", "原宿", "品川", "目白", "大塚", "上野",
				"池袋", "日暮里", "西日暮里", "駒込", "田端", "高田馬場",
				"神田", "鴬谷", "代々木", "新大久保", "巣鴨",
				"高輪ゲートウェイ" };

		boolean[] used = new boolean[stations.length];

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int gameCount = 0;
		boolean loseFlag = false;

		System.out.println("※※※ 山手線ゲーム ※※※");
		System.out.println();
		System.out.println("      ゲームスタート！    ");
		System.out.println();

		while (gameCount < stations.length) {

			// プレイヤーの入力
			String inputStation = reader.readLine();

			boolean hitFlag = false;
			//入力された駅名が、配列の何番目にあるかを記録するための変数
			//最初はまだ見つかっていないので -1 
			//配列の番号は 0 から始まるので、-1 は「まだ見つかっていない」
			int stationIndex = -1;

			// 入力された駅名が山手線の駅名かどうか探す
			for (int i = 0; i < stations.length; i++) {
				//文字列は == ではなく equals() で比較する
				//== は同じものかどうかを判定し、
				//equals() は文字列の中身が同じかを判定する(java限定)
				if (stations[i].equals(inputStation)) {
					//入力された駅名が、山手線の駅名配列の中に見つかった場合
					//hitFlag を true
					hitFlag = true;
					//見つかった駅名が配列の何番目だったかを保存
					stationIndex = i;
					break;
				}
			}

			// 山手線の駅名ではない場合
			if (!hitFlag) {
				loseFlag = true;
				break;
			}

			// すでに出た駅名だった場合
			if (used[stationIndex]) {
				loseFlag = true;
				break;
			}

			// プレイヤーの回答を使用済みにする
			used[stationIndex] = true;
			gameCount++;

			// 全駅出尽くした場合
			if (gameCount == stations.length) {
				break;
			}

			// コンピュータの回答
			for (int i = 0; i < stations.length; i++) {
				if (!used[i]) {
					System.out.println(stations[i]);
					used[i] = true;
					gameCount++;
					break;
				}
			}
		}

		if (loseFlag) {
			System.out.println("あなたの負けです！");
		} else {
			System.out.println("あなたの勝ちです！");
		}
	}
}