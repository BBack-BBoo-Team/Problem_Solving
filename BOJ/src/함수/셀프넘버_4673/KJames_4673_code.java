package 함수.셀프넘버_4673;

/**
 * 주석제거
 */
public class KJames_4673_code {
    static boolean[] integerArr = new boolean[10001];

    public static void searchSelfNum(int i) {
        int sumOfUnits = i;
        int currentNum = i;

        while (currentNum < 10001) {

            while (currentNum > 0) {
                sumOfUnits += currentNum % 10;
                currentNum /= 10;
            }
            if (sumOfUnits > 10000) {
                break;
            }
            integerArr[sumOfUnits] = true;
            currentNum = sumOfUnits;

        }

    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < integerArr.length; i++) {
            if (!integerArr[i]) {
                searchSelfNum(i);
            }
        }

        for (int i = 1; i < integerArr.length; i++) {
            if (!integerArr[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
