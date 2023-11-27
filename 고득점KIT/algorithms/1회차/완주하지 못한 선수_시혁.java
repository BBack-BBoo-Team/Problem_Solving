// 1 <= 선수 <= 100,000
// 무조건 한명은 미완주
// 1 <= 참가자 이름 길이 <= 20
// 참가자 동명이인 있을 수 있음

// 참여자 목록을 HashMap에 저장
// Key: 참여자이름, Value : 인원수 (동명이인 체크)
// 완주자 목록을 순회하면서 HashMap 비교
// 만약 Map에 존재한다면 value-1
// 모든 순회가 마무리되고, HashMap에서 value가 1인 키를 찾아서 반환
// O(N) 예상

// 풀이 20분 소요
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String,Integer> map = new HashMap<>();

        // 동명이인 체크를 위해 getOrDefault() 사용
        // 등록된 키가 없으면 default 0 적용, 등록된 키가 있다면 해당 키의 값 가지고 옴
        // 그리고 값에서 +1 적용
        for(String player : participant) map.put(player, map.getOrDefault(player,0)+1);
        
        // 완주자 중에 동명이인이 있을 수 있음
        // 완주자 이름에 맞는 map의 인원수를 -1
        for(String player : completion) map.put(player, map.get(player)-1);
        
        for(String key: map.keySet()) {
            if (map.get(key)==1) return key;
        }
        
        return "";
    }
}
