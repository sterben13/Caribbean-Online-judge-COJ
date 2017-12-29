/**
* Judge Online: Caribbean Online Judge.
* URL: http://coj.uci.cu/24h/problem.xhtml?pid=1016
* Problem: 1016 - Freckles
* Description
*
* In an episode of the Dick Van Dyke show, little Richie connects the freckles on his Dad's back
* to form a picture of the Liberty Bell. Alas, one of the freckles turns out to be a scar, so his
* Ripley's engagement falls through. Consider Dick's back to be a plane with freckles at various 
* (x,y) locations. Your job is to tell Richie how to connect the dots so as to minimise the amount 
* of ink used. Richie connects the dots by drawing straight lines between pairs, possibly lifting 
* the pen between lines. When Richie is done there must be a sequence of connected lines from any 
* freckle to any other freckle.
**/
package graphtheory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author iromeroga
 */
public class Freckles1016 {

    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);
    private static OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static BufferedWriter bw = new BufferedWriter(osw);
    private static Point[] points;
    private static float[][] graph;
    private static int V;

    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        String[] line;
        points = new Point[V];
        for (int i = 0; i < V; i++) {
            line = br.readLine().split("\\s+");
            points[i] = new Point(Float.parseFloat(line[0]), Float.parseFloat(line[1]));
        }
        graph = new float[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = distance(points[i], points[j]);
            }
        }
        primMST();
    }

    private static void primMST() {
        int parent[] = new int[V];
        float key[] = new float[V];
        boolean[] mstSet = new boolean[V];
        for (int i = 0; i < V; i++) {
            key[i] = Float.MAX_VALUE;
            mstSet[i] = false;
        }
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent, V, graph);
    }

    private static int minKey(float key[], boolean mstSet[]) {
        float min = Float.MAX_VALUE;
        int min_index = -1;
        for (int i = 0; i < V; i++) {
            if (mstSet[i] == false && key[i] < min) {
                min = key[i];
                min_index = i;
            }
        }
        return min_index;
    }

    private static void printMST(int parent[], int n, float graph[][]) {
        float sum = 0.0f;
        for (int i = 1; i < V; i++) {
            sum += graph[i][parent[i]];
        }
        System.out.printf("%.2f\n", sum);
    }

    private static float distance(Point point1, Point point2) {
        return (float) Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2)
                + Math.pow(point2.getY() - point1.getY(), 2));
    }

    private static class Point {

        private double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;

        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }
}
