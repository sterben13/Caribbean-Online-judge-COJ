/**
* Judge Online: Caribbean Online Judge
* URL: http://coj.uci.cu/24h/problem.xhtml?pid=2637
* Problem: 
* Descripción
* 
* Dada una lista L conteniendo n enteros, determine la suma entre un par de índices i y j 
* dados (RSQ, por las siglas en inglés), es decir RSQ(i, j) = L[i] + L[i+1] + L[i+2] 
* + ... + L[j].
* 
* Especificación de entrada
*
* La entrada comienza con un entero t en la primera línea que denota el número de casos 
* de prueba (1 <= t <= 5). Cada caso de prueba comienza con una línea en blanco, seguida 
* de una línea que contiene dos enteros: n y q (1 <= n, q <= 100000).
* A continuación, la línea siguiente contiene n enteros no negativos menores iguales que 
* 1000000000. Las q líneas siguientes cada una contiene dos enteros i y j (0 <= i, j <10000).
* 
* Especificación de salida
* 
* Para cada consulta, imprima una línea que contenga el valor de RSQ(i, j). Separe las salidas
* de cada par de casos de prueba con una línea en blanco.
* 
* Solution: Se utilizo arbol de segmentos configurado para obtener la suma de los rangos l - r;
**/
package datastructure;

/**
 *
 * @author sterben
 */
public class RangeSumQuery2637 {
    private static long[] st;

    public static void init(int[] arr) {
        int l = arr.length;
        int x = (int) (Math.ceil(Math.log(l) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new long[max_size];
        builtTree(arr, 0, l - 1, 0);
    }

    public static long builtTree(int[] arr, int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }
        int mid = getMid(ss, se);
        st[si] = builtTree(arr, ss, mid, si * 2 + 1) + builtTree(arr, mid + 1, se, si * 2 + 2);
        return st[si];
    }

    public static int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    public static long sum(int ss, int se, int qs, int qe, int si) {
        if (qs <= ss && qe >= se) {
            return st[si];
        }

        if (se < qs || ss > qe) {
            return 0;
        }

        int mid = getMid(ss, se);
        return sum(ss, mid, qs, qe, 2 * si + 1) + sum(mid + 1, se, qs, qe, 2 * si + 2);
    }

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
        int t, n, q;
        int[] arr;
        String[] line;
        try {
            t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                br.readLine();
                line = br.readLine().split(Pattern.quote(" "));
                n = Integer.parseInt(line[0]);
                q = Integer.parseInt(line[1]);
                line = br.readLine().split(Pattern.quote(" "));
                arr = new int[n];
                for (int i = 0; i < line.length; i++) {
                    arr[i] = Integer.parseInt(line[i]);
                }
                init(arr);
                while (q-- > 0) {
                    line = br.readLine().split(Pattern.quote(" "));
                    System.out.println(sum(0, n - 1, Integer.parseInt(line[0]), Integer.parseInt(line[1]), 0));
                }

                if (t > 0) {
                    System.out.println("");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(RangeSumQuery2637.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
