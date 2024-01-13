import java.io.*;
import java.lang.*;
import java.util.*;

class Islands {
	static final int ROW = 5, COL = 5;
	boolean isSafe(int M[][], int row, int col,
				boolean visited[][])
	{
		
		return (row >= 0) && (row < ROW) && (col >= 0)
			&& (col < COL)
			&& (M[row][col] == 1 && !visited[row][col]);
	}

	// parcourir en profondeur les îles adjacentes
	void DFS(int M[][], int row, int col, boolean visited[][])
	{	// définition des directions à explorer
			int[] rowNbr = {-1, -1, -1, 0, 0, 1, 1, 1};
			int[] colNbr = {-1, 0, 1, -1, 1, -1, 0, 1};

		// marquer la case courante comme visitée
			visited[row][col] = true;
		// explorer toutes les cases adjacentes
			for (int i = 0; i < 8; ++i) {
				int newrow = row + rowNbr[i];
				int newcol = col + colNbr[i];
				// si la case adjacente est sûre à explorer, continuer la recherche en profondeur
				if (isSafe(M, newrow, newcol, visited))
					DFS(M, newrow, newcol, visited);
			}
	}
	// compter le nombre d'îles
	int countIslands(int M[][])
	{// initialiser le compteur d'îles à 0 et la matrice de cases visitées à false
		int count = 0;
		boolean visited[][] = new boolean[ROW][COL];

		// explorer toutes les cases de la matrice
		for (int i = 0; i < ROW; ++i) {
			for (int j = 0; j < COL; ++j) {
				// si la case contient un "1" et n'a pas encore été visitée, commencer la recherche en profondeur
				if (M[i][j] == 1 && !visited[i][j]) {
					DFS(M, i, j, visited);// on re-appele dfs
					++count; // on add le nombre d'iles
				}
			}
		}
		// renvoyer le nombre d'îles trouvé
		return count;
	}

	public static void main(String[] args)
		throws java.lang.Exception
	{
		int M[][] = new int[][] {{ 1, 1, 0, 0, 0 },
								{ 0, 1, 0, 0, 1 },
								{ 1, 0, 0, 1, 1 },
								{ 0, 0, 0, 0, 0 },
								{ 1, 0, 1, 0, 1 } };
		Islands I = new Islands();
		System.out.println("Number of islands is: "
						+ I.countIslands(M));

		// OUTPUT: Number of islands is: 5
	}
} 
