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
public class SegmentTree {

    int st[]; // La matriz que almacena nodos de árbol de segmento

    /**
     * Constructor para construir un árbol de segmentos a partir de un conjunto
     * determinado. Este constructor asigna memoria para el árbol de segmento y
     * llama a constructSTUtil () para llenar la memoria asignada.
     *
     * @param arr
     * @param n
     */
    SegmentTree(int arr[], int n) {
        // Asignar memoria para árbol de segmento
        // Altura del árbol de segmento
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

        // Maximo tamaño del arbol de segmanto
        int max_size = 2 * (int) Math.pow(2, x) - 1;

        st = new int[max_size];

        constructSTUtil(arr, 0, n - 1, 0);
        for (int i = 0; i < st.length; i++) {
            System.out.println(st[i]);
        }
    }

    /**
     * Una función de utilidad para obtener el índice medio de los índices de
     * esquina.
     *
     * @param s
     * @param e
     * @return
     */
    int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    /**
     * Una función recursiva para obtener la suma de valores en un rango dado de
     * la matriz. Los siguientes son parámetros para esta función.         
     *        ss & se ->        qs y qe -> índices inicial y final del rango de
     * consulta
     *
     * @param ss Puntero al árbol de segmentos. Indices iniciales del segmento
     * representado por nodo actual, es decir, st [si]
     * @param se Indices final del segmento representado por nodo actual, es
     * decir, st [si]
     * @param qs indice inicial del rango de query
     * @param qe indice final del rango del query
     * @param si Índice del nodo actual en el árbol del segmento. Inicialmente 0
     * se pasa como raíz está siempre en el índice 0
     * @return
     */
    int getSumUtil(int ss, int se, int qs, int qe, int si) {
        // Si el segmento de este nodo es parte del rango dado, entonces regrese
        // la suma del segmento
        if (qs <= ss && qe >= se) {
            return st[si];
        }

        // Si el segmento de este nodo está fuera del rango dado retornar 0
        if (se < qs || ss > qe) {
            return 0;
        }

        // Si una parte de este segmento se solapa con el intervalo dado
        int mid = getMid(ss, se);
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1)
                + getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }

    /**
     * Devuelve la suma de los elementos en el rango desde el índice qs (quey
     * start) hasta qe (final de la consulta). Utiliza principalmente
     * getSumUtil()
     *
     * @param tamaño del arreglo
     * @param qs indice de inicio de la query
     * @param qe indice final de la query
     * @return
     */
    int getSum(int n, int qs, int qe) {
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }
        System.out.println("getSum:: "+n+" "+qs+" "+qe);
        return getSumUtil(0, n - 1, qs, qe, 0);
    }

    /**
     * Una función recursiva que construye el árbol de segmentos para la matriz
     * [ss..se]. Si es el índice del nodo actual en el árbol de segmento st
     *
     * @param arr arreglo con valores para el segmento
     * @param ss indice de inicio del segmento
     * @param se indice final del segmento
     * @param si indice del nodo actual
     * @return
     */
    int constructSTUtil(int arr[], int ss, int se, int si) {
        System.out.println("Entro a la recurcion: " + ss + " " + se + " " + si);
        // If there is one element in array, store it in current node of
        // segment tree and return
        if (ss == se) {
            st[si] = arr[ss];
            System.out.println("Return: "+si+" - "+st[si]);
            return arr[ss];
        }

        // If there are more than one elements, then recur for left and
        // right subtrees and store the sum of values in this node
        int mid = getMid(ss, se);
        System.out.println(ss + " " + mid + " " + (si * 2 + 1) + "------"
                + (mid + 1) + " " + se + " " + (si * 2 + 2));
        st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1)
                + constructSTUtil(arr, mid + 1, se, si * 2 + 2);
        System.out.println("Return::: "+si+" - "+st[si]);
        return st[si];
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        int arr[] = {10, 9, 7, 20, 14, 23, 14, 27, 38, 77};
        int n = arr.length;
        SegmentTree tree = new SegmentTree(arr, n);

        // Build segment tree from given array
        // Print sum of values in array from index 1 to 3
        System.out.println("Sum of values in given range = "
                + tree.getSum(n, 4, 9));
    }
}
