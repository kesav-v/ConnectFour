public class CheckWin {

	public static void main(String[] args) {
		char[][] board = {{'R', 'R', 'R', 'R'}, {'Y', 'R', 'R', 'Y'}, {'R', 'Y', 'Y', 'R'}, {'Y', 'R', 'R', 'Y'}};
		System.out.println(game_over(board, 0, 2));
	}

	public static char game_over(char[][] tboard, int x, int y) { 
		int countConsecutive = 0;
		char color = ' ';
		int i, a;
		for (i = x - 3; i <= x + 3; i++) { // Horizontal 
			if (i >= 0 && i < tboard.length && countConsecutive < 4)
				if (tboard[i][y] == color) countConsecutive++;
				else if (tboard[i][y] == 'R' || tboard[i][y] == 'Y') {
					color = tboard[i][y];
					countConsecutive = 1; 
				}
				else color = ' ';
			else if (countConsecutive == 4)
				return color;
			if (countConsecutive == 4)
				return color;
			countConsecutive = 0;
			color = ' ';
		}
		for (a = y - 3; a <= y + 3; a++) { // Vertical
			if (a >= 0 && a < tboard.length && countConsecutive < 4)
				if (tboard[x][a] == color) countConsecutive++;
				else if (tboard[x][a] == 'R' || tboard[x][a] == 'Y') {
					color = tboard[x][a];
					countConsecutive = 1;
				}
				else color = ' ';
			else if (countConsecutive == 4)
				return color; if (countConsecutive == 4) return color;
			countConsecutive = 0;
			color = ' ';
		}
		for (i = x - 3, a = y - 3; i <= x + 3; i++, a++) { // diagonal 1 topleft - bottomright
			if (a >= 0 && a < tboard.length && i >= 0 && i < tboard.length && countConsecutive < 4) {
				if (tboard[i][a] == color)
					countConsecutive++;
				else if (tboard[i][a] == 'R' || tboard[i][a] == 'Y') {
					color = tboard[i][a];
					countConsecutive = 1;
				}
				else color = ' ';
			}
			else if (countConsecutive == 4)
					return color;
			if (countConsecutive == 4)
				return color;
			countConsecutive = 0;
			color = ' ';
		}
		for (i = x - 3, a = y + 3; i <= x + 3; i++, a--) { // diagonal 1 topright - bottomleft
			if (a >= 0 && a < tboard.length && i >= 0 && i < tboard.length && countConsecutive < 4)
				if (tboard[i][a] == color) countConsecutive++; else if (tboard[i][a] == 'R' || tboard[i][a] == 'Y') {
					color = tboard[i][a];
					countConsecutive = 1;
				}
				else color = ' ';
			else if (countConsecutive == 4)
				return color;
			if (countConsecutive == 4)
				return color;
			for (i = 0; i < tboard.length; i++)
				if (tboard[i][0] == ' ')
					return 'f';
		}
		return 't';
	}
}