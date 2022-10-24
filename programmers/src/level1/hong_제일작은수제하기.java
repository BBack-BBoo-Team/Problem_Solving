package level1;

/** 프로그래머스 코딩테스트연습 level 1
 * 제일 작은 수 제거하기
 * 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
 * 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
 */
public class hong_제일작은수제하기 {
        public int[] solution(int[] arr) {
            int[] result = new int[arr.length -1];

            if(arr.length <= 1){
                int[] answer = {-1};
                return answer;
            }

            int min = arr[0];

            for(int i=0; i<arr.length; i++){
                if(min > arr[i]) {
                    min = arr[i];
                }
            }

            int index = 0;
            for(int x=0; x<arr.length; x++) {
                if(min == arr[x]) {
                    continue;
                } else {
                    result[index++] = arr[x];
                }
            }
            return result;
        }
}
