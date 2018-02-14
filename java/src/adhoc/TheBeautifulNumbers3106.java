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

/**
 *
 * @author iromeroga
 */
public class TheBeautifulNumbers3106 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        String line = br.readLine().replace(" ", "");
        bw.append(isPalimbrome(line)?"Yes\n":"No\n");
        bw.flush();
        bw.close();
    }
    
    private static boolean isPalimbrome(String line){
        for (int i = 0, j = line.length()-1; i < line.length()/2; i++, j--) {
            if(line.charAt(i)!=line.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
