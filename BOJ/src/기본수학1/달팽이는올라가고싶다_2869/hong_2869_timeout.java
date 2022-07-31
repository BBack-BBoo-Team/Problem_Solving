package 기본수학1.달팽이는올라가고싶다_2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hong_2869_timeout {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");
        int A = Integer.parseInt(st.nextToken());  //낮 +
        int B = Integer.parseInt(st.nextToken()); //밤 -
        int V = Integer.parseInt(st.nextToken()); //높dl

        int base = 0;
        int date = 0;

        while(base < V) {
            if (base != V) {
                base += A;
                if (base != V ){
                    base -= B;
                }
            }
            date++;
        }
        System.out.println(date);
    }
}
