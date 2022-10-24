package level1;

/** 프로그래머스 코딩테스트연습 level 1
 * 자연수 뒤집어 배열로 만들기
 * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
 */
public class hong_자연수뒤집어배열로만들기 {
        public int[] solution(long n) {
            int len = Long.toString(n).length();

            int[] answer = new int[len];

            for(int i=0; i<len; i++) {
                answer[i] = (int) (n % 10);
                n /= 10;
            }

            return answer;
        }
}
