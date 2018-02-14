/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphtheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author iromeroga
 */
public class ComeandGo1220 {

    private static final InputStreamReader isr = new InputStreamReader(System.in);
    private static final BufferedReader br = new BufferedReader(isr);
    private static final OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static final BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        String line;
        String[] data;
        int n, m;
        while (true) {
            line = br.readLine();
            if (line.equals("0 0")) {
                break;
            }
            data = line.split("\\s+");
            n = Integer.parseInt(data[0]);
            m = Integer.parseInt(data[1]);
            Graph graph = new Graph(n);
            for (int i = 0; i < m; i++) {
                data = br.readLine().split("\\s+");
                graph.addEdge(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            }
            bw.append(graph.valid()?'1':'0');
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static class Graph {

        private int v;
        private LinkedList<Integer>[] adjListArr;

        public Graph(int v) {
            this.v = v;
            adjListArr = new LinkedList[v + 1];
            for (int i = 1; i <= v; i++) {
                adjListArr[i] = new LinkedList<>();
            }
        }

        public void addEdge(int v, int w, int m) {
            adjListArr[v].add(w);
            if (m == 2) {
                adjListArr[w].add(v);
            }
        }

        public int BFS(int s) {
            int size = 0;
            boolean[] visited = new boolean[v + 1];
            visited[s] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);
            while (!queue.isEmpty()) {
                s = queue.poll();
                size++;
                Iterator<Integer> it = adjListArr[s].listIterator();
                while (it.hasNext()) {
                    Integer n = it.next();
                    if (!visited[n]) {
                        queue.add(n);
                        visited[n] = true;
                    }
                }
            }
            return size;
        }

        public boolean valid() {
            for (int i = 1; i <= v; i++) {
                if (v != BFS(i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
