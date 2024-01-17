import java.util.Arrays;
import java.util.HashMap;

// 1. 같은 팀 공격 x, 상대 공격력이 이상이면 공격 x
// O(nlogn), O(n)
// 정렬했기 때문에 O(nlogn)
public class 전투게임2 {

    // 인덱스와 인덱스별 팀과 공격력을 같이 저장할 자료구조 생성
    // 공격력으로 오름차순 정렬
    // 0번은 어차피 제일 작기 때문에, 1번부터 탐색 시작
    // i == 1, j == 0
    // 공격력이 같으면 i는 패스
    // 그렇지 않으면 total에 더하고 hashmap에 j의 팀과 공격력 누적, j++
    // 현재 i 팀과 같은 팀이 hashmap 있다면 total에서 빼고
    // 아니면 그냥 total 값을 answer[i]에 저장
    // total은 누적
    int[][] arr;
    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];

        arr = new int[n][3];
        for(int i = 0; i < n; i++) { // O(N)
            arr[i][0] = i;
            arr[i][1] = students[i].split(" ")[0].charAt(0);
            arr[i][2] = Integer.parseInt(students[i].split(" ")[1]);
        }

        Arrays.sort(arr, (o1,o2) -> o1[2]-o2[2]); // O(NlogN)

        int j = 0, total = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 1; i < n; i++) { // O(N)

            while(getPower(i)!=getPower(j) && j < i) {
                total += getPower(j);
                map.put(getTeam(j), map.getOrDefault(getTeam(j), 0) + getPower(j));
                j++;
            }

            if(map.containsKey(getTeam(i))) answer[getIdx(i)] = total - map.get(getTeam(i));
            else answer[getIdx(i)] = total;
        }

        return answer;
    }

    private String getTeam(int idx) {
        return String.valueOf(arr[idx][1]);
    }

    private int getIdx(int idx) {
        return arr[idx][0];
    }

    private int getPower(int idx) {
        return arr[idx][2];
    }

    public static void main(String[] args){
        전투게임2 T = new 전투게임2();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}
