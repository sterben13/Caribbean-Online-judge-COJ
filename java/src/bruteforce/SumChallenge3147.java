/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author iromeroga
 */
public class SumChallenge3147 {
    
    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);
    
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int n, sum;
        boolean imp;
        Map<Integer, Integer> map = new HashMap<>();
        String[] line;
        while (t-- > 0) {
            line = br.readLine().split("\\s+");
            n = Integer.parseInt(line[0]);
            sum = 0;
            imp = false;
            for (int i = 1; i < line.length; i++) {
                sum += Integer.parseInt(line[i]);
                if(line[i].equals("0")||sum == 0 ||map.get(sum)!=null){
                    imp=true;
                    break;
                }
                map.put(sum, i);
            }
            bw.append(imp?"YES\n":"NO\n");
            map.clear();
        }
        bw.flush();
        bw.close();
    }
}
