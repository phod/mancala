package gameLogic;

import java.util.Scanner;

/**
 * Used for testing boardDate
 */

public class LogicTestApp {

	static Scanner scan = new Scanner(System.in);
	static int player = 0;

	public static void makeMove(BoardController actions) {
		if (actions.pickHole(scan.nextInt())) {
			actions.printBoard();
			System.out.println("please choose another hole (from 0 -5)");
			makeMove(actions);
		} else {
			player = Math.abs(player - 1);
			actions.setPlayer(player);
		}
	}

	public static void main (String args){
		boolean gameFinished = false;
		BoardController actions = new BoardController();
		System.out.println("Player one, please choose a hole (from 0 - 5)");
		while(!gameFinished){
			makeMove(actions);
			gameFinished = actions.gameOver();
			if(!gameFinished){
				actions.printBoard();
				System.out.println("next player choose a hole (form 0 - 5)");
				makeMove(actions);
			}
		}
		actions.endGameCapture(player);
		actions.printBoard();
		}
}