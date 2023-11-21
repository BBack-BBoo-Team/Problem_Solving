// 1<= numbers.length <= 100,000 ->> O(N) 이하
// 0<= numbers <= 1,000 ->> 수는 4자리, int
// 정답은 String ->> StringBuilder로 append 후 String 변환
import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
 
        String[] numsToString = Arrays.stream(numbers)
                                        .mapToObj(String::valueOf)
                                        .toArray(String[]::new); // #1
        
        Arrays.sort(numsToString, (s1, s2) -> (s2+s1).compareTo(s1+s2)); // #2
        
        StringBuilder sb = Arrays.stream(numsToString)
            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append); // #3
        
        return sb.charAt(0) == '0' ? "0" : sb.toString(); // #4
    }
}
/**
* Description
* #Idea
* 1) 정수를 문자열로 변환
* 2) 문자열 자체로 수 결합 -> ex) 3, 30일경우 3+30은 330
* 3) 결합한 수의 내림차순으로 정렬
* >>> 해당 문제는 정렬 인터페이스를 얼마나 이해하고 다룰 수 있냐 체크하는 문제
* >>> Comparator의 compare 커스텀해야함
* >>> 직접 구현해도 되지만 숫자의 길이가 최대 4자리이므로, 코드가 굉장히 더러워지고 시간복잡도가 쓸데없이 높아질 수 있음
*
* #1. 정수 타입의 numbers를 문자열 배열에 저장 (Stream 활용)
* 
* #2. Comparator 인터페이스의 compare 메서드를 통해 두 개의 객체를 비교
* >>> 따라서 두 개의 수를 연결했을 때의 결과를 내림차순 정렬 방식을 적용
*
* #3. 불변성인 String은 더 할때마다 메모리 비용 발생 따라서 가변성을 가진 StringBuilder 활용
* #4. 결과가 첫번째 자리가 0이라는 뜻은 주어진 숫자 배열이 [0, 0, 0, 0,,,0] 일 수 있음
* >>> 이 경우엔 "00000,,,0"으로 출력되기 때문에 "0"으로 변환
*/

/**
* 관련된 공부 주제
* >> JAVA
* 1) Comparable, Comparator 인터페이스 비교
* 2) Comparable과 Comparator 구현 및 사용 방법
* 3) 문자열 정렬 원리
* 4) 정렬 알고리즘별 시간복잡도 계산
*
* >> C#
*/
