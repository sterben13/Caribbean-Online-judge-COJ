/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 *
 * @author iromeroga
 */
public class MultipleTimesApplyingReverse3430 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        char[] line = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < line.length; i++) {
            if (line[i] == '(') {
                stack.push(i);
            } else if (line[i] == ')') {
                int index = stack.pop();
                line = reverseString(line, index, i);
            }
        }
        for (int i = 0; i < line.length; i++) {
            if(Character.isAlphabetic(line[i])){
                bw.append(line[i]);
            }
        }
        bw.newLine();
        bw.flush();
        bw.close();
    }

    private static char[] reverseString(char[] str, int start, int end) {
        while (start < end) {
            str[start] ^= str[end];
            str[end] ^= str[start];
            str[start] ^= str[end];
            ++start;
            --end;
        }
        return str;
    }
}
