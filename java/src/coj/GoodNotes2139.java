
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
public class GoodNotes2139 {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
        try {
            while (br.ready()) {                
                String[] line = br.readLine().split("\\s+");
                bw.append(isSubsequence(line[0], line[1], line[0].length(), line[1].length())?"Yes":"No");
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static boolean isSubsequence(String a, String b, int m, int n) {
        int j = 0;
        for (int i = 0; i < n && j < m; i++) {
            if(a.charAt(j)==b.charAt(i)){
                j++;
            }
        }
        return j == m;
    }

}
