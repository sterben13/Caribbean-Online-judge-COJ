/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

/**
 *
 * @author iromeroga
 */
public class RotateArray {

    /**
     *
     * @param arr
     * @param d
     * @param n
     */
    public static void rotateMethodo1(int[] arr, int d, int n) {
        int[] aux = new int[d];
        for (int i = 0; i < d; i++) {
            aux[i] = arr[i];
        }
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                arr[j] = arr[j + 1];
            }
        }
        for (int i = n - d, j = 0; j < d; i++, j++) {
            arr[i] = aux[j];
        }
        print(arr);
    }

    public static void rotateMethodo2(int[] arr, int d, int n) {
        for (int i = 0; i < d; i++) {
            rotateOne(arr, d, n);
        }
        print(arr);
    }

    private static void rotateOne(int[] arr, int d, int n) {
        int temp = arr[0];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = temp;
    }

    private static void rotateMethodo3(int[] arr, int d, int n) {
        int j, k, temp;
        for (int i = 0; i < gcd(d, n); i++) {
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n) {
                    k = k - n;
                }
                if (k == i) {
                    break;
                }
                arr[j] = arr[k];
                j = k;
            }
            arr[j]=temp;
        }
    }

    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 2, n = 7;
        //rotateMethodo1(arr, d, n);
        rotateMethodo2(arr, d, n);
    }

}
