/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adhoc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author iromeroga
 */
public class DifferentDigits2120 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);
    private static final Set<Character> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        String[] line;
        int n, m, sum;
        while (br.ready()) {
            line = br.readLine().split("\\s+");
            n = Integer.parseInt(line[0]);
            m = Integer.parseInt(line[1]);
            sum = 0;
            for (int i = n; i <= m; i++) {
                sum += repite(String.valueOf(i));
            }
            bw.append(sum+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static int repite(String n) {
        set.clear();
        boolean repeat = false;
        for (int i = 0; i < n.length(); i++) {
            if (set.contains(n.charAt(i))) {
                return 0;
            } else {
                set.add(n.charAt(i));
            }
        }
        return 1;
    }
}
