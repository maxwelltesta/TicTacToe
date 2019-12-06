//Maxwell Testa 111713073
import java.util.Scanner;
import java.lang.IndexOutOfBoundsException;
import java.util.InputMismatchException;
public class ConnectFour {
	public static void main(String[] args) {
		// 0 is empty, 1 is red, 2 is yellow
		char[][] board = new char[6][7];
		boolean redWin = false;
		boolean yellowWin = false;
		int turn = 0; // 0 = red, 1 = yellow, red starts
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = ' ';
			}
		}
		Scanner sc = new Scanner(System.in);
		while (redWin == false & yellowWin == false) {
			if (turn == 0) {
				try {
					System.out.println("Drop a red disk at column (0-6): ");
					int place = sc.nextInt();
					placer(board, place, 'R');
					turn = 1;
				}
				catch(InputMismatchException ime) {
					System.out.println("Incorrect input, enter again: ");
					sc.next();
				}
				catch(IndexOutOfBoundsException ioob) {
					System.out.println("Your index is out of bounds, enter again: ");
					sc.next();
				}
				for (int i = 0; i < board.length; i++) {
					for (int j = 0; j < board[i].length; j++) {
						System.out.print("|" + board[i][j]);
					}
					System.out.println("|");
				}
				if (winCheck('R', board) == true) {
					System.out.println("Red wins!");
					redWin = true;
				}
				if (catsGame(board) == true) {
					System.out.println("CATS GAME!!!");
					break;
				}
			}
			else if (turn == 1) {
				try {
					System.out.println("Drop a yellow disk at column (0-6): ");
					int place = sc.nextInt();
					placer(board, place, 'Y');
					turn = 0;
				}
				catch(InputMismatchException ime1) {
					System.out.println("Incorrect input, enter again: ");
					sc.next();
				}
				catch(IndexOutOfBoundsException ioob1) {
					System.out.println("Your index is out of bounds, enter again: ");
					sc.next();
				}
				for (int i = 0; i < board.length; i++) {
					for (int j = 0; j < board[i].length; j++) {
						System.out.print("|" + board[i][j]);
					}
					System.out.println("|");
				}
				if (winCheck('Y', board) == true) {
					System.out.println("Yellow wins!");
					yellowWin = true;
				}
				if (catsGame(board) == true) {
					System.out.println("CATS GAME!!!");
					break;
				}
			}
			
		}
		sc.close();
	}
	public static void placer(char[][] board, int column, char color) {
		boolean placed = false;
		int i = 5;
		while (placed == false) {
			if (board[i][column] == ' ') {
				board[i][column] = color;
				placed = true;
			}
			else {
				i--;
			}
		}
	}
	public static boolean winCheck(char player, char[][] board){
	    //horizontalCheck 
	    for (int i = 0; i < 6; i++) {
	    		for(int j = 0; j < 4; j++) {
	    			if ((board[i][j] == player && board[i][j+1] == player && board[i][j+2] == player && board[i][j+3] == player)) {
	    				return true;
	    			}
	    		}
	    }
	    //verticalCheck
	    for (int i = 0; i < 3 ; i++ ){
	        for (int j = 0; j < 7; j++){
	            if (board[i][j] == player && board[i+1][j] == player && board[i+2][j] == player && board[i+3][j] == player){
	                return true;
	            }           
	        }
	    }
	    //ascendingDiagonalCheck 
	    for (int i = 3; i < 6; i++){
	        for (int j = 0; j < 4; j++){
	            if (board[i][j] == player && board[i-1][j+1] == player && board[i-2][j+2] == player && board[i-3][j+3] == player)
	                return true;
	        }
	    }
	    //descendingDiagonalCheck
	    for (int i = 3; i < 6; i++){
	        for (int j = 3; j < 7; j++){
	            if (board[i][j] == player && board[i-1][j-1] == player && board[i-2][j-2] == player && board[i-3][j-3] == player)
	                return true;
	        }
	    }
	    return false;
	}
	public static boolean catsGame(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
}
