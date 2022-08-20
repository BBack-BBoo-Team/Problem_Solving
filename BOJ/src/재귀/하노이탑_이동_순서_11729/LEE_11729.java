package 재귀.하노이탑_이동_순서_11729;

import java.util.Scanner;


/*
n-1개의 원판을 1->3->2 순으로 타워 롤 옮기고, 2->1->3 순으로 3번에 다시 쌓으면 된다고 한다.
그렇기 때문에 재귀 호출을 통해 인자만 변경하면서 전달해주면 된다.

n-1을 하는 이유는 가장 큰 원판은 항상 가장 아래에 있어야됨 굳이 움직일 필요가 없고 마지막에 한번만 움겨줘야 가장 최소의 움직임
by를 어떻게 들려야하는지 모르겠음...

StringBuffer 클래스의 인자는 변할 수 있다는 특징이 있습니다
 */
public class LEE_11729 {
        static int n,cnt=0;
        static StringBuilder sb = new StringBuilder();
        static void hanoi(int n,int from,int by,int to) {
            cnt++;
            if(n==1) { // 원판이 1개일 때  , 종료되는 곳
                sb.append(from+" "+to+"\n");
                return;
            }else { // 원판이 1개가 아닐 때
                hanoi(n-1,from,to,by); // n-1을 한 후, 1->3->2로 원판을 전달
                sb.append(from+" "+to+"\n");
                hanoi(n-1,by,from,to); // n-1을 한 후, 2->1->3으로 원판을 전달
            }
        }

        public static void main(String[] args)   {
            Scanner sc = new Scanner(System.in);

            n = sc.nextInt();
            hanoi(n,1,2,3);
            System.out.println(cnt);
            System.out.println(sb);

        }

    }
