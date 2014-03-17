/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region .

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/
import java.util.LinkedList;

public class SurroundedRegions {
	public void solve(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		assert(board != null);
		int width = board.length;
		if (width <= 2) return;
		int height = board[0].length;
		if (height <= 2) return;
		for (int i = 0; i < width; ++i) {
			if (board[i][0] == 'O') flip(board, i, 0);
			if (board[i][height-1] == 'O') flip(board, i, height-1);
		}
		for (int j = 1; j < height-1; ++j) {
			if (board[0][j] == 'O') flip(board, 0, j);
			if (board[width-1][j] == 'O') flip(board, width-1, j);
		}
		for (int i = 0; i < width; ++i) {
			for (int j = 0; j < height; ++j) {
				if (board[i][j] == 'O') board[i][j] = 'X';
				else if (board[i][j] == '-') board[i][j] = 'O';
			}
		}
	}

	private void flip(char[][] board, int x, int y) {
		LinkedList<int[]> list = new LinkedList<int[]>();
		list.add(new int[] {x, y});
		int width = board.length;
		int height = board[0].length;
		while (!list.isEmpty()) {
			int[] pos = list.pollFirst();
			x = pos[0];
			y = pos[1];
			if (board[x][y] != 'O') continue;
			board[x][y] = '-';
			if (x > 0 && board[x-1][y] == 'O') list.add(new int[] {x-1, y});
			if (x < width-1 && board[x+1][y] == 'O') list.add(new int[] {x+1, y});
			if (y > 0 && board[x][y-1] == 'O') list.add(new int[] {x, y-1});
			if (y < height-1 && board[x][y+1] == 'O') list.add(new int[] {x, y+1});
		}
	}
}
