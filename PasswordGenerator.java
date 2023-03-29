package application;

import java.util.ArrayList;
import java.util.Scanner;

public class PasswordGenerator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("パスワードに使用する文字列を入力してください（16文字まで）：");
		String input = scanner.nextLine();

        while (input.matches("[\\p{InHiragana}\\p{InKatakana}]+") || input.matches("[０-９Ａ-Ｚａ-ｚ]+")) {
            System.out.println("パスワードに使用可能な英数字・記号で入力してください。");
            System.out.println("（例：orange / orange_1234）");
            input = scanner.nextLine();
        }
        
        if (input.length() > 16) {
			input = input.substring(0, 16);
			System.out.println("16文字を超えたため、先頭16文字を使用します。");
		}

		char[] chars = input.toCharArray();

		ArrayList<Character> passwordChars = new ArrayList<>();
		for (char c = '0'; c <= '9'; c++) {
			passwordChars.add(c);
		}
		for (char c = 'A'; c <= 'Z'; c++) {
			passwordChars.add(c);
		}
		for (char c = 'a'; c <= 'z'; c++) {
			passwordChars.add(c);
		}
		passwordChars.add('_');
		passwordChars.add('-');
		passwordChars.add('!');
		passwordChars.add('#');
		passwordChars.add('$');
		passwordChars.add('%');
		passwordChars.add('&');
		passwordChars.add('?');

		System.out.println("生成されたパスワード：");
		for (int i = 0; i < chars.length; i++) {
			System.out.print(chars[i]);
		}
		if (chars.length < 16) {
			for (int i = 0; i < 8 + (int) (Math.random() * 9); i++) {
				System.out.print(passwordChars.get((int) (Math.random() * passwordChars.size())));
			}
		}
		System.out.println();

		while (true) {
			System.out.println("Enterキーを押すと新しいパスワードを生成します。終了する場合は「x」を入力してください。");
			String inputStr = scanner.nextLine();
			if (inputStr.equalsIgnoreCase("x") || inputStr.equalsIgnoreCase("ｘ")) {
				break;
			}
			if (inputStr.length() > 0 && !inputStr.equalsIgnoreCase("x")) {
				System.out.println("不正な入力です。");
				continue;
			}
			System.out.println("生成されたパスワード：");
			for (int i = 0; i < chars.length; i++) {
				System.out.print(chars[i]);
			}
			for (int i = 0; i < 8 + (int) (Math.random() * 9); i++) {
				System.out.print(passwordChars.get((int) (Math.random() * passwordChars.size())));
			}
			System.out.println();
		}

		scanner.close();
	}
}