/**
* Judge Online: Caribbean Online Judge.
* URL: http://coj.uci.cu/24h/problem.xhtml?pid=1074
* Problem: 1074 - N-Queens Problem
* Descripcion: A problem that has motivated many studies is to find the minimum number of pieces 
* of the same type, so as to cover the entire board, or the maximum number of pieces of the same 
* type that can be placed without attacking each other, on a clasic cheesboard of 8 × 8 or of 
* another size. The great mathematician Carl F. Gauss, the greatest genius of the modern era, 
* became interested in the "eight queens problem" and found only 72 solutions. All these solutions 
* are obtained for 12 basic locations, rotations and reflections. Your goal is to find all posible 
* solutions for a board of N x N size [1 <= N <= 12].
**/

package combination;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author iromeroga
 */
public class NQueensProblem1074 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);
    private static boolean imp;
    private static int index;

    private static int[][] board;

    public static void main(String[] args) throws IOException {
        int i;
        while (br.ready()) {
            i = Integer.parseInt(br.readLine());
            createBoard(i);
            imp = true;
            index = 1;
            solveNQ(0, i);
            if (imp) {
                bw.append("No Solution.");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }

    private static void createBoard(int i) {
        board = new int[i][i];
    }

    private static void solveNQ(int col, int n) throws IOException {
        if (col == n) {
            bw.append((index++) + " : ");
            printSolution(n);
            imp = false;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(i, col, n)) {
                board[i][col] = 1;
                solveNQ(col + 1, n);
                board[i][col] = 0;
            }
        }
    }

    private static void printSolution(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[j][i] == 1) {
                    bw.append(j + 1 + " ");
                }
            }
        }
        bw.newLine();
    }

    private static boolean isSafe(int row, int col, int n) {
        int i, j;
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (i = row, j = col; j >= 0 && i < n; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
