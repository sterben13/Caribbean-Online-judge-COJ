/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author iromeroga
 */
public class Apples1622 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        String[] line;
        int n, odd, even, num, sum;
        while (br.ready()) {
            n = Integer.parseInt(br.readLine());
            line = br.readLine().split("\\s+");
            odd = even = sum = 0;

            for (int i = 0; i < line.length; i++) {
                num = Integer.parseInt(line[i]);
                sum += num;
                if ((num & 1) == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            bw.append((((sum & 1) == 0) ? even : odd) + "\n");

        }
        bw.flush();
        bw.close();
    }
}
