/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author iromeroga
 */
public class RevisedRussianRoulette {

    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);
    private static OutputStreamWriter osw = new OutputStreamWriter(System.out);
    private static BufferedWriter bw = new BufferedWriter(osw);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split("\\s+");
        CircularLinkedList cl = new CircularLinkedList();
        for (int i = 0; i < line.length; i++) {
            cl.add(line[i]);
        }
        cl.printList();
    }

    public static class Node {

        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class CircularLinkedList {

        Node head;
        Node tail;

        public void add(String data) {
            Node n = new Node(data);
            if (head == null) {
                addEmty(n);
            } else {
                Node aux = tail.next;
                aux.next = n;
                tail = n;
                tail.next = head;
            }
        }

        private void addEmty(Node n) {
            head = n;
            head.next = head;
            tail = head;
        }

        public void printList() {
            Node aux = head;
            System.out.println(head.next.data);
            do {
                System.out.println(aux.data);
                aux = aux.next;
            } while (aux != head);
        }
    }

}
