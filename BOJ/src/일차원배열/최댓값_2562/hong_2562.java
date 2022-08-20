package 일차원배열.최댓값_2562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 일차원 배열 - 값댓값
time : 124 ms
memory : 14052 KB
 */

public class hong_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        int max = arr[0];
        int index = 0;
        for(int i=1; i<9; i++){
            if(max < arr[i]){
                max = arr[i];
                index = i;
            }
        }
        System.out.println(max);
        System.out.println(index+1);
    }
}

