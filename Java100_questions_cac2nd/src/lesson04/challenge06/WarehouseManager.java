/**
 * 第4章 倉庫番のお仕事
 *
 * 問題6 荷物の入れ替え
 *
 * AB興産から今度は荷物の入れ替えの依頼をいただきました。
 * 5袋ある荷物のうち、1が入っている袋と3が入っている袋を
 * 探して値を入れ替え、2が入っている袋と4が入っている袋を
 * 探して値を入れ替える必要があります。
 *
 * 袋にはそれぞれ1～5の数値が入っており、
 * どの袋にどの数値が入っているのかはランダムに決定します。
 * さらにそれぞれの袋の値が重複しないものとします。
 *
 * コメントの位置に適切なコードを記述し、
 * 実行例と同じメッセージを表示してください。
 *
 * <実行例>
 *  E主任：
 *  AB興産の荷物の入れ替えをお願いします。
 *
 *  Yさん：
 *  はい、
 *  入れ替え前の状態は、
 *  3,2,1,5,4
 *  です。
 *
 *  入れ替え後の状態は、
 *  1,4,3,5,2
 *  です。
 *
 */

package lesson04.challenge06;

public class WarehouseManager {

	public static void main(String[] args) {

		int[] ABKosanArray = new int[5];

		//ここに重複チェックおよび値の代入処理を記述する
		int num = 0;
		boolean flag = false;
		for (int i = 0; i < ABKosanArray.length; i++) {
			do {
				flag = false;
				num = (int) (Math.random() * 5) + 1;

				for (int j = 0; j < ABKosanArray.length; j++) {
					if (ABKosanArray[j] == num) {
						flag = true;
						break;
					}
				}
			} while (flag);
			ABKosanArray[i] = num;
		}

		System.out.println("E主任：");
		System.out.println("AB興産の荷物の入れ替えをお願いします。\n");

		System.out.println("Yさん：");
		System.out.println("はい、");
		System.out.println("入れ替え前の状態は、");
		for (int i = 0; i < ABKosanArray.length; i++) {
			System.out.print(ABKosanArray[i]);
			if (i != (ABKosanArray.length - 1)) {
				System.out.print(",");
			}
		}
		System.out.println("\nです。\n");

		//ここに値の入れ替え処理を記述する
		int[] temp = new int[ABKosanArray.length];

		// コピー
		for (int i = 0; i < ABKosanArray.length; i++) {
			temp[i] = ABKosanArray[i];
		}

		// 入れ替え
		for (int i = 0; i < ABKosanArray.length; i++) {
			if (temp[i] == 1) {
				ABKosanArray[i] = 3;
			} else if (temp[i] == 3) {
				ABKosanArray[i] = 1;
			} else if (temp[i] == 2) {
				ABKosanArray[i] = 4;
			} else if (temp[i] == 4) {
				ABKosanArray[i] = 2;
			} else {
				ABKosanArray[i] = temp[i]; // 5はそのまま
			}
		}
		System.out.println("入れ替え後の状態は、");
		for (int i = 0; i < ABKosanArray.length; i++) {
			System.out.print(ABKosanArray[i]);
			if (i != (ABKosanArray.length - 1)) {
				System.out.print(",");
			}
		}
		System.out.println("\nです。");

	}
}
