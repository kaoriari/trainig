package application;

import java.util.Random;
import java.util.Scanner;

public class Numero {
	public static void main(String[] args) {
		int answer = new Random().nextInt(100)+1;
		int guess,count = 0;
		System.out.println("数字当てゲーム開始");	
		System.out.println("1～100の範囲で数字を入力し最後にEnterを押してください");
		while (true){
			try {
				guess = new Scanner(System.in).nextInt();
				if(1 > guess || guess > 100) {
					System.out.println("範囲外の数字が入力されました");
					continue;
				}
				count++;
				if(answer == guess){
					System.out.println("正解!");
					System.out.println(count +"回目で正解");
					if(count == 1){
						System.out.println("奇跡的！正解です");
					}
					break;
				}else if(answer > guess){
					System.out.println("もっと大きい数字です");
				}else{
					System.out.println("もっと小さい数字です");
				}
				if(count == 8) {
					System.out.println();
					System.out.println("！！GAME OVER！！");
					System.out.println("７手以内で答えられるように頑張って！");
					break;
				}
			}catch(Exception e) {
				System.out.println("整数を入力してください");
			}
		}
		System.out.println("答えは『" + answer + "』でした");
	}
}


