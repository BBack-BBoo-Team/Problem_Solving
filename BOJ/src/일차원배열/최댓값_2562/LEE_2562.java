package 일차원배열.최댓값_2562;

import java.util.Scanner;

public class LEE_2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[9];    // 9개의 인자를 갖는 배열 선언
        int num = 0;
        int max = 0;

        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();   // 입력한 값들을 차례대로 배열에 넣어준다.
            if (arr[i] > max){         // 배열을 순서대로 돌면서 가장 큰 값이 나오면 max에 넣어주고 num을 하나씩 올려준다.
                max = arr[i];
                num = i+1;    // num++을 해도 같은 값이 나왔는데 아니라고 한다...
            }
        }
        System.out.println(max);
        System.out.println(num);
    }
}
