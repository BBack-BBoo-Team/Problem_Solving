import java.util.*;

public class 회장선거 {

    public String solution(String[] votes, int k){
        String answer = "";

        // 1) 후보자별로 추천한 학생의 목록을 저장
        HashMap<String, ArrayList<String>> candidate = new HashMap<>();
        for (int i = 0; i < votes.length; i++) {
            String[] split = votes[i].split(" ");
            String from = split[0];
            String to = split[1];
            if(!candidate.containsKey(to)) candidate.put(to, new ArrayList<>());
            candidate.get(to).add(from);
        }

        // k 를 넘는 후보자를 추천한 학생별로 선물 받을 수량 저장
        HashMap<String, Integer> presentCnt = new HashMap<>();
        for (String student : candidate.keySet()) {
            ArrayList<String> fromList = candidate.get(student);
            if(fromList.size() >= k) {
                for (String from : fromList) {
                    presentCnt.put(from, presentCnt.getOrDefault(from, 0)+1);
                }
            }
        }

        // 선물을 받을 학생 중 가장 많이 받으면서, 이름이 제일 사전순인 학생 출력
        int max = 0;
        for(String student : presentCnt.keySet()) {
            int cnt = presentCnt.get(student);
            if (max < cnt) {
                max = cnt;
                answer = student;
            } else if (max == cnt && answer.compareTo(student) > 0) {
                answer = student;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        회장선거 T = new 회장선거();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
