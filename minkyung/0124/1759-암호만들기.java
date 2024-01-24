import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static String[] cArr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cArr = new String[m];
        visited = new boolean[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
            cArr[i] = st.nextToken();
        }
        Arrays.sort(cArr); // 사전 순으로 정렬
        combination(cArr, visited, 0, 0);
        System.out.print(sb);
    }

    public static void combination(String arr[], boolean visited[], int start, int depth) {

        if(depth==n) {
            String str="";
            for(int i=0;i<arr.length;i++) {
                if(visited[i]) {
                    str+=arr[i];
                }
            }
            boolean flag=false; // 순서 판단
            int cnt1=0, cnt2=0; // cnt1 : 모음, cnt2 : 자음
            for(int i=0;i<str.length()-1;i++) {
                if (str.charAt(i) > str.charAt(i + 1)) {
                    flag=true;
                    break;
                }
            }
            for(int i=0;i<str.length();i++) {
                if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u') {
                    cnt1++;
                }else {
                    cnt2++;
                }
            }
            if(!flag) {
                if(cnt1>=1 && cnt2>=2) {
                    sb.append(str).append("\n");
                }
            }
            return;
        }

        for(int i=start;i<arr.length;i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(arr, visited, i+1, depth+1);
                visited[i] = false;
            }
        }

    }

}