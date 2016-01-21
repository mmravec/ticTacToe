package ticTacToe.consoleui;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ticTacToe.core.TicTacToe;

public class ConsoleUi {
	TicTacToe t = new TicTacToe();
	private static final Pattern INPUT_PATTERN = Pattern.compile("([O|M])([A-I])([0-8])");

	public void play() {
		t.printBoard();
		while (!t.isBoardFull() && !t.checkForWin()) {
			pocess();
			t.printBoard();
			t.playerComputer();
			t.printBoard();

			// System.out.println(t.checkForWin());
			if (t.checkForWin()) {
				System.out.println("Vyhral si!");
				String name = System.getProperty("user.name");
				System.out.println(name + " tvoj cas je : " + t.getPlayingSeconds() + " s");
			}
			if (t.isBoardFull() && !t.checkForWin()){
				System.out.println("Remiza");
				
			}
		}
	}

	public void pocess() {
		System.out.println("Zrob daco");
		String line = new Scanner(System.in).nextLine().toUpperCase();
		if ("X".equals(line)) {
			System.exit(0);
		}
		Matcher matcher = INPUT_PATTERN.matcher(line);
		if (matcher.matches()) {
			int row = matcher.group(2).charAt(0) - 'A';
			int column = Integer.parseInt(matcher.group(3));
			if ("O".equals(matcher.group(1))) {
				t.placeMark(row, column);
				t.changePlayer();
			}
		} else {
			System.out.println("Zrob ine, ne toto");
		}

		System.out.println("Game Draw");
	}

}