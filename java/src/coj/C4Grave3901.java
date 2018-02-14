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

/**
 *
 * @author iromeroga
 */
public class C4Grave3901 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);
    private static Rectangle[] r;
    private static int x1, y1, x2, y2, x3, y3, x4, y4;

    public static void main(String[] args) throws IOException {
        read();
    }

    private static void read() throws IOException {
        String[] line = br.readLine().split("\\s+");
        x1 = Integer.parseInt(line[0]);
        y1 = Integer.parseInt(line[1]);
        x2 = Integer.parseInt(line[2]);
        y2 = Integer.parseInt(line[3]);
        line = br.readLine().split("\\s+");
        x3 = Integer.parseInt(line[0]);
        y3 = Integer.parseInt(line[1]);
        x4 = Integer.parseInt(line[2]);
        y4 = Integer.parseInt(line[3]);
        r = new Rectangle[4];
        r[0] = new Rectangle(x1, y1, x3, y2);//L
        r[1] = new Rectangle(x1, y4, x2, y2);//T
        r[2] = new Rectangle(x4, y1, x2, y2);//R
        r[3] = new Rectangle(x1, y1, x2, y3);//B
        line = br.readLine().split("\\s+");
        int w = Integer.parseInt(line[0]);
        int h = Integer.parseInt(line[1]);
        boolean p = false;
        for (Rectangle r1 : r) {
            if (r1.space(w, h)) {
                p = true;
                break;
            }
        }
        bw.append(p ? "Yes" : "No");
        bw.newLine();
        bw.flush();
        bw.close();
    }

    private static class Rectangle {

        int x1;
        int y1;
        int x2;
        int y2;
        int w;
        int h;

        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            lades();
        }

        private void lades() {
            w = x2 - x1;
            h = y2 - y1;
        }

        public boolean space(int w, int h) {
            return w <= this.w && h <= this.h;
        }
    }
}
