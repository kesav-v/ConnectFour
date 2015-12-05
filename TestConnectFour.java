public class TestConnectFour {
	public static void main(String[] args) throws Throwable {
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Enter a valid position string: ");
		String position = kb.nextLine();
		char[][] board = setUp(position);

		for (char[] row : board) {
			for (char c : row)
				System.out.print(c + " ");
			System.out.println();
		}

		boolean turn = (position.length() % 2 == 0);
		long k = System.nanoTime();
// <<<<<<< HEAD
// 		String[] soln = SolveConnectFour.solve(board, turn, position.length(), lastX(position, board), lastY(position, board));
// 		System.out.println("\n" + soln[0] + "\t" + soln[1] + "\n");
// =======
		int[] result = SolveConnectFour.solve(board, turn, position.length(), lastX(position, board), lastY(position, board));
		System.out.println("\n" + result[0] + " " + result[1] + "\n");
		System.out.println((double)(System.nanoTime() - k) / 1E9 + " seconds to run");
	}

	public static char[][] setUp(String s) {
		char[][] board = new char[6][7];

		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++)
				board[i][j] = ' ';


		int[] gravRow = new int[board[0].length];

		for (int i = 0; i < gravRow.length; i++)
			gravRow[i] = 5;

		boolean turn = true;
		for (int i = 0; i < s.length(); i++) {
			int n = Integer.parseInt(s.substring(i, i + 1));
			if (turn) board[gravRow[n - 1]][n - 1] = 'R';
			else board[gravRow[n - 1]][n - 1] = 'Y';
			gravRow[n - 1]--;
			turn = !turn;
		}
		return board;
	}

	public static int lastX(String s, char[][] board) {
		int n = Integer.parseInt(s.substring(s.length() - 1, s.length())) - 1;
		for (int i = board.length - 1; i >= 0; i--)
			if (board[i][n] == ' ')
				return i + 1;
		return 0;
	}

	public static int lastY(String s, char[][] board) {
		return Integer.parseInt(s.substring(s.length() - 1, s.length())) - 1;
	}
}