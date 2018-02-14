//HeptadecimalNumbers1164.java
package arithmeticalgebra;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigInteger;

/**
 * HeptadecimalNumbers1164
 */
public class HeptadecimalNumbers1164 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        
        String[] line;
        while (true) {
            line = br.readLine().split("\\s+");
            if (line[0].equals("*")) {
                break;
            }
            BigInteger a = new BigInteger(line[0],17);
            BigInteger b = new BigInteger(line[1],17);
            System.out.println((a.compareTo(b)==0) ? "=" : (a.compareTo(b)==1)?">":"<");
        }
    }
}
