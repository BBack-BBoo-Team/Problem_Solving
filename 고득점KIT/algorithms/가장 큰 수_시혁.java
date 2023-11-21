// 1<= numbers.length <= 100,000 -> O(N) 이하
// 0<= numbers <= 1,000 -> 수는 4자리, int
// 정답은 String -> StringBuilder로 append 후 String 변환
// 앞자리 기준으로 내림차순 정렬, 같을경우 뒷자리로 정렬
// 3, 30 -> 이게 약간 문제네.. 303 보단 330이 큼
import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
 
        // 1. 정수 타입의 numbers를 문자열 배열에 저장 (Stream 활용)
        String[] numsToString = Arrays.stream(numbers)
                                        .mapToObj(String::valueOf)
                                        .toArray(String[]::new);
        
        // 2. 직접 Custom 정렬 방식으로 정렬
        Arrays.sort(numsToString, (s1, s2) -> (s2+s1).compareTo(s1+s2));
        
        // 3. String은 더 할때마다 메모리 소비가 있기 때문에
        //    가변성을 가진 StringBuilder 활용
        StringBuilder sb = Arrays.stream(numsToString)
            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
