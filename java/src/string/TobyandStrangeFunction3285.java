/**
* Judge Online: Caribbean Online Judge.
* URL: http://coj.uci.cu/24h/problem.xhtml?pid=2422
* Problem: 2422 - Betty and the Modular Exponentiation
* Description
*
* Betty likes integer–number mathematics, and knows that calculating something like a^b
* can produce rather large results when a and b are suﬃciently big. Furthermore, Betty is 
* only interested in knowing the last 9 digits from a^b. For this reason, she has hired you,
* a member of the Union for Tremendous Powers (UTP), to tell her the 9 least signiﬁcant digits 
* from the exponentiation.
**/
package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author iromeroga
 */
public class TobyandStrangeFunction3285 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int n, l;
        String s;
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            s = br.readLine();
            l = s.length();
            for (int i = 0; i < l; i++) {
                bw.append(s.charAt((i + l - n) % l));
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
