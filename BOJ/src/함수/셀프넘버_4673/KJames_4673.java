package 함수.셀프넘버_4673;

/**
 * 수행시간 132ms
 */
public class KJames_4673 {

    // boolean 타입으로 배열 선언(해당 인덱스를 정수로 생각함
    // 만약 해당 인덱스의 수가 셀프 넘버라면 false!, 셀프 넘버가 아니면 true!
    // 문제에서 1~10,000 이하 범위로 제시되었기 때문에, 10001 크기에 배열 생성
    static boolean[] integerArr = new boolean[10001];

    // 셀프넘버가 아닌 수들을 찾는 함수(메서드)
    public static void searchSelfNum(int i) {

        int sumOfUnits = i; // 입력받은 수와 각 자리 수를 더한 값을 할당받을 변수
        int currentNum = i; // 현재 정수, 입력받은 수로부터 시작

        // 입력받은 값으로부터 만들어질 수열을 찾기 위해 사용된 while 문
        while (currentNum < 10001) {

            // 입려받은 수와 각 자리 수를 더하기 위해 사용된 while 문
            while (currentNum > 0) {
                sumOfUnits += currentNum % 10; // 초기값 + 각 자리 수
                currentNum /= 10;
            }

            // 점화식을 통해 나온 결과가 곧 인덱스이기 때문에 배열의 인덱스를 벗어난다면, break;
            if (sumOfUnits > 10000) {
                break;
            }

            // 점화식을 통해 나온 결과는 셀프 넘버가 아님.
            // 해당 값을 인덱스로 하고, true 로 변환
            integerArr[sumOfUnits] = true;

            // 수열을 계속 찾기 위해, 결과를 현재 정수인 변수에 할당하고 계속 진행
            currentNum = sumOfUnits;
        }

    }

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        // 배열의 인덱스를 정수로 생각하고, 메서드에 인덱스를 넣으며 셀프넘버와 아닌 수를 찾음
        for (int i = 1; i < integerArr.length; i++) {

            // 해당 인덱스의 값이 true 이면, 이미 셀프넘버가 아니란 것을 확인했기 때문에
            // false 인 경우에만 함수(메서드) 진행
            if (!integerArr[i]) {
                searchSelfNum(i);
            }
        }

        // 배열 전체를 순회하며, 셀프넘버 출력
        for (int i = 1; i < integerArr.length; i++) {

            // 배열에서 false 에 해당하는 인덱스가 셀프넘버
            if (!integerArr[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
