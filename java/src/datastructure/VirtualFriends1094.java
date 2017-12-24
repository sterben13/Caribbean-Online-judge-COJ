/**
* Judge Online: Caribbean Online Judge.
* URL: http://coj.uci.cu/24h/problem.xhtml?pid=1394
* Problem: 1094 - Virtual Friends
* Descripcion:
* These days, you can do all sorts of things online. For example, you can use various websites to make virtual
* friends. For some people, growing their social network (their friends, their friends' friends, their friends' 
* friends' friends, and so on), has become an addictive hobby. Just as some people collect stamps, other people 
* collect virtual friends. Your task is to observe the interactions on such a website and keep track of the size 
* of each person's network. Assume that every friendship is mutual. If Fred is Barney's friend, then Barney is also 
* Fred's friend.
**/
package datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author iromeroga
 */
public class VirtualFriends1094 {

    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);
    private static OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static BufferedWriter bw = new BufferedWriter(osw);
    private static Map<String, Integer> index;
    private static int[] parent;
    private static int[] count;
    private static int[] rank;
    private static int c;

    public static void main(String[] args) throws IOException {
        index = new HashMap<>();
        read(Integer.parseInt(br.readLine()));

    }

    private static void read(int t) throws IOException {
        int f;
        String[] line;
        while (t-- > 0) {
            f = Integer.parseInt(br.readLine());
            parent = new int[f * 2];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            count = new int[f * 2];
            Arrays.fill(count, 1);
            rank = new int[f * 2];
            c = 0;
            index.clear();
            while (f-- > 0) {
                line = br.readLine().split("\\s+");
                addPerson(line[0]);
                addPerson(line[1]);
                int i = union(index.get(line[0]), index.get(line[1]));
                System.out.println(i);
                print();
            }
        }
    }

    private static void addPerson(String person) {
        if (!index.containsKey(person)) {
            index.put(person, c++);
        }
    }

    private static int union(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        if (xRoot == yRoot) {
            return count[xRoot];
        }
        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
            count[yRoot] += count[xRoot];
            return count[yRoot];
        } else if (rank[yRoot] < rank[xRoot]) {
            parent[yRoot] = xRoot;
            count[xRoot] += count[yRoot];
            return count[xRoot];
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
            count[xRoot] += count[yRoot];
            return count[xRoot];
        }
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void print() {
        for (int i = 0; i < parent.length; i++) {
            System.out.println(i + " " + parent[i]);
        }
    }
}
