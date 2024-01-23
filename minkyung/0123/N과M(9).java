import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int cnt=0;
    static StringBuilder sb = new StringBuilder();
    static Object[] str = new String[100000004];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> a = new ArrayList<>();
        int x;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            x = Integer.parseInt(st.nextToken());
            a.add(x);
        }
        int output[] = new int[a.size()];
        boolean visited[] = new boolean[a.size()];
        Collections.sort(a);
        Arrays.fill(str,"");
        permutation(a, visited, output, 0, m);
        str = Arrays.stream(str).distinct().toArray();
        for(int i=0;i<str.length;i++) {
        	sb.append(str[i]).append("\n");
        }
        System.out.print(sb);
    }


    public static void permutation(List<Integer> a, boolean visited[], int output[], int depth, int r) {

        if(depth==r) {
            for(int i=0;i<r;i++) {
                str[cnt] += (output[i]+" ");
            }
            cnt++;
            return;
        }

        for(int i=0;i< a.size();i++) {
            if(!visited[i]) {
                visited[i]=true;
                output[depth] = a.get(i);
                permutation(a, visited, output, depth + 1, r);
                visited[i]=false;
            }
        }

    }

}