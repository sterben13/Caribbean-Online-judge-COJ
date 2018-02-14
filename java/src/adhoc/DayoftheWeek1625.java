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
import java.util.Date;

/**
 *
 * @author iromeroga
 */
public class DayoftheWeek1625 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        String line;
        while (t-- > 0) {
            line = br.readLine();
            Date date = new Date(line);
            switch (date.getDay()) {
                case 0:
                    bw.append("SUNDAY\n");
                    break;
                case 1:
                    bw.append("MONDAY\n");
                    break;
                case 2:
                    bw.append("TUESDAY\n");
                    break;
                case 3:
                    bw.append("WEDNESDAY\n");
                    break;
                case 4:
                    bw.append("THURSDAY\n");
                    break;
                case 5:
                    bw.append("FRIDAY\n");
                    break;
                case 6:
                    bw.append("SATURDAY\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
