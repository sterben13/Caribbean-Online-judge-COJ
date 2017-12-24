/**
* Judge Online: Caribbean Online Judge.
* URL: http://coj.uci.cu/24h/problem.xhtml?pid=1216
* Problem: 1216 - Counting Subsequences I
* Descripcion:
* "47 is the quintessential random number," states the 47 society. And there might be a grain of truth in that. For example, 
* the first ten digits of the Euler's constant are: 2 7 1 8 2 8 1 8 2 8 And what's their sum? Of course, it is 47. Try walking 
* around with your eyes open. You may be sure that soon you will start discovering occurences of the number 47 everywhere. You 
* are given a sequence S of integers we saw somewhere in the nature. Your task will be to compute how strongly does this sequence 
* support the above claims. We will call a continuous subsequence of S interesting if the sum of its terms is equal to 47. E.g., 
* consider the sequence S = (24, 17, 23, 24, 5, 47). Here we have two interesting continuous subsequences: the sequence (23, 24) 
* and the sequence (47). Given a sequence S, find the count of its interesting subsequences.
**/
package datastructure;

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
public class CountingSubsequencesI1216 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int n;
        String[] line;
        while (t-- > 0) {
            br.readLine();
            n = Integer.parseInt(br.readLine());
            line = br.readLine().split("\\s+");
            System.out.println(sumCount(line, n, 47));
        }
        bw.flush();
        bw.close();
    }

    private static int sumCount(String arr[], int n, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(arr[i]);
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            if(map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
            }else{
                map.put(sum, 1);
            }
        }
        return count;
    }
}
