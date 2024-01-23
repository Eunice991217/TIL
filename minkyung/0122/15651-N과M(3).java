import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        static int n, m;
        static StringBuilder sb = new StringBuilder();

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            ArrayList<Integer> a = new ArrayList<>();
            for(int i=0;i<n;i++) {
                a.add(i+1);
            }
            int output[] = new int[a.size()];
            permutation(a, output, 0, m);
            System.out.println(sb);

        }
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++) {
            a.add(i+1);
        }
        int output[] = new int[a.size()];
        permutation(a, output, 0, m);
        System.out.println(sb);

    }


    public static void permutation(ArrayList<Integer> a, int output[], int depth, int r) {

        if(depth==r) {
            for(int i=0;i<r;i++) {
                sb.append(output[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i< a.size();i++) {
            output[depth] = a.get(i);
            permutation(a, output, depth + 1, r);
        }

    }

}