
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author iromeroga
 */
public class MonkeyBananaProblem1861 {

    static int[][] matrix;

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
        String[] line;
        int t, n, maxI, caseI=1;
        try {
            t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                n = Integer.parseInt(br.readLine());
                matrix = new int[(n * 2) - 1][n];
                for (int i = 0; i < (n * 2) - 1; i++) {
                    line = br.readLine().split("\\s+");
                    for (int j = 0; j < line.length; j++) {
                        matrix[i][j] = Integer.parseInt(line[j]);
                    }
                }
                maxI = 0;
                for (int i = 1; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] += maximo(i - 1, j - 1, j);
                    }
                }
                for (int i = n; i < (n * 2) - 1; i++) {
                    for (int j = 0; j < n-1; j++) {
                        matrix[i][j] += maximo(i - 1, j, j + 1);
                    }
                }
                bw.append("Case "+(caseI++)+": "+matrix[(n * 2) - 2][0]);
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static int maximo(int i, int j1, int j2) {
        if (j1 < 0) {
            return matrix[i][j2];
        } else {
            return matrix[i][j1] > matrix[i][j2] ? matrix[i][j1] : matrix[i][j2];
        }
    }
}
