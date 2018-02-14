
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
public class Eazzzzzy1688 {

    public static InputStreamReader isr = new InputStreamReader(System.in);
    public static BufferedReader br = new BufferedReader(isr);
    public static OutputStreamWriter osw = new OutputStreamWriter(System.out);
    public static BufferedWriter bw = new BufferedWriter(osw);

    public static StringBuilder createLine(int ast, int esp) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < esp; i++) {
            s.append(" ");
        }
        for (int i = 0; i < ast; i++) {
            s.append("*");
        }
        return s;
    }

    public static String createTriangle(int h) {
        StringBuilder sb = new StringBuilder();
        int esp = h - 1;
        int w = 1;
        for (int i = 0; i < h; i++) {
            sb.append(createLine(w, esp--));
            sb.append("\n");
            w += 2;
        }
        return sb.toString();
    }

    public static String createParallelogram(int w, int h) {
        StringBuilder sb = new StringBuilder();
        int spa = h - 1;
        for (int i = 0; i < h; i++) {
            sb.append(createLine(w, spa--));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String createRectangle(int w, int h) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            sb.append(createLine(w, 0));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void createFigure(String c) throws IOException {
        String[] line = br.readLine().split("\\s+");
        switch (c) {
            case "1":
                bw.append(createTriangle(Integer.parseInt(line[0])));
                break;
            case "2":
                bw.append(createParallelogram(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
                break;
            case "3":
                bw.append(createRectangle(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        String c;
        int i = 0;
        while (true) {
            c = br.readLine();
            if (c.equals("-1")) {
                break;
            } else {
                if (i != 0) {
                    bw.newLine();
                }
            }
            createFigure(c);
            i++;
        }
        bw.flush();
        bw.close();
    }
}
