import java.util.*;

// hint 기차를 한 줄로 생각할 것
public class 최대인원수 {

    public int solution(int n, int[][] trans, int[][] bookings){
        int answer=0;

        // 누적합으로 역별 탑승 인원수 구하기
        int[] station = new int[n+1]; // 0 = dummy
        for(int i = 0; i < trans.length; i++) {
            station[trans[i][0]]+=trans[i][2];
            station[trans[i][1]]-=trans[i][2];
        }
        for(int i = 1; i <= n; i++) {
            station[i] += station[i-1];
        }

        Arrays.sort(bookings, (o1,o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int num = 0; // 어린이 번호
        LinkedList<Integer> train = new LinkedList<>();
        for(int i = 1; i <= n; i++) {

            // 도착역에서 내림
            // 정상적으로 내렸기 때문에 answer+1
            while(!train.isEmpty() && train.get(0) == i) {
                train.pollFirst();
                answer++;
            }

            // 현재 시간에 탑승하는 사람들 모두 체크
            while(num < bookings.length && bookings[num][0]<=i) {
                if(bookings[num][0]==i) train.add(bookings[num][1]);
                num++;
            }
            Collections.sort(train);

            // 탑승 가능 수가 넘었다면 가장 멀리서 내리는 사람을 내리게 함
            while(train.size() > station[i]) {
                train.pollLast();
            }
        }
        return answer;
    }

    public static void main(String[] args){
        최대인원수 T = new 최대인원수();
        System.out.println(T.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
        System.out.println(T.solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
        System.out.println(T.solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
        System.out.println(T.solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
        System.out.println(T.solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
    }
}
