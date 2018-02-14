/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class ANewGame2446 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        String[] line = br.readLine().split("\\s+");
        String bianka = line[0];
        String williams = line[1];
        String handB = game(bianka, "B");
        String handW = game(williams, "W");
        boolean winG = win(handB, handW);
        if (winG) {
            bw.append("Bianka won with ");
            bw.append(handB);
            bw.newLine();
            bw.append("Williams lost with ");
            bw.append(handW);
        } else {
            bw.append("Williams won with ");
            bw.append(handW);
            bw.newLine();
            bw.append("Bianka lost with ");
            bw.append(handB);
        }
        bw.newLine();
        bw.flush();
        bw.close();
    }

    private static String game(String colors, String gamer) {
        int B = 0, W = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (colors.charAt(i) == 'B') {
                B++;
            } else {
                W++;
            }
        }
        if (W == 3) {
            return "Scissors";
        }
        if (B == 3) {
            return "Rock";
        }
        if (gamer.equals("B")) {
            if ((B == 2 && W == 1) || (B == 1 && W == 2)) {
                return "Paper";
            }
        } else {
            return (B == 2 && W == 1) ? "Rock" : "Scissors";
        }
        return null;
    }

    private static boolean win(String handB, String handW) {
        if (handB.equals("Rock") && handW.equals("Scissors")) {
            return true;
        }
        if (handB.equals("Scissors") && handW.equals("Paper")) {
            return true;
        }
        return handB.equals("Paper") && handW.equals("Rock");
    }
}
