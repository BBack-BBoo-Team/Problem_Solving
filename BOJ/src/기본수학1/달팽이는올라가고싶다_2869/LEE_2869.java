package 기본수학1.달팽이는올라가고싶다_2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LEE_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());  // 올라간
        int B = Integer.parseInt(st.nextToken());  // 미끄러진
        int V = Integer.parseInt(st.nextToken());  // 도착 높이

        int day = (V-B)/(A-B);        // 걸린날
        int snail = 0;         // 달팽이 위치

        if((V-B)%(A-B) !=0){  // 위의 식이 나머지가 없으면 day를 1더해라
            day++;
        }
        System.out.println(day);
    }
}


        /*
        while(snail <= V) { //여기만 무조건 통과한다면 가능
            snail += A;
            day++;
        }if (snail < V) {
                snail -= B;
        } else if (snail >= V) {
        }
        System.out.println(day);

    }
}
*/
        /*while (snail < V) {  //달팽이가 도착높이보다 낮으면 계속 돌아라
            snail += A;
            if (snail <= V) {
                snail -= B;
            } else {
                snail += 0;
            }
            day++;
        }

        System.out.println(day);
    }

}
*/