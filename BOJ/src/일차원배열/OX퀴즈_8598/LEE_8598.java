package 일차원배열.OX퀴즈_8598;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/*
1. 배열 카운트 해주기
2. for문 사용해서 카운트한 배열에 O,X넣어주기
3. 완성된 배열의 O의 연속됨을 확인하고 +1씩 해주기
3-1. 연속이 아니거나 X라면 0으로 설정
3-2. O이 연속적으로 더해지지 않게 작성하는 것이 매우 중요!!(ex OOXOO = 12034가되는걸 막아야한다)
4. 배열 속 숫자 모두 더하기

메모리 17852KB
시간   244ms
*/
public class LEE_8598 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arrayCount = sc.nextInt();    //배열 크기 입력하기
        String[] arr = new String[arrayCount]; //입력한 숫자만큼 배열 만들기
        //일단 배열 완성시키기
        for(int i=0; i<arr.length; i++){  //범위는 입력한 배열크기보다 크지 않게
            arr[i] = sc.next();  //입력할 내용이 String이라서 그냥 next만 사용하기
        }

        sc.close(); // 명시적으로 Scanner를 닫아주는게 좋다.

        for(int i=0; i<arr.length; i++){          // 배열의 크기만큼 반복

            int stack = 0;                        // 쌓이는 값을 넣어줄 그릇
            int sum = 0;                          // 쌓는게 끝나면 합할 그릇

            // for(int i=0; i<arr.length; i++) 라고 썼다가 배열의 길이 만큼만 저장했다.
            for(int j=0; j<arr[i].length(); j++){ // 여기서 고생 OXOOX 라면 이 배열의 길이만큼 반복해야한다.
                if(arr[i].charAt(j) == 'O'){      // i번째 배열의 j번째 값이 'O'이라면 stack를 1씩 증가시켜라
                    // 만약 j가 'O'이 아니라면 stack은 0이된다.

                    stack++;

                }else stack = 0;
                sum += stack;                     //for문이 한번 끝날때 마다 stack의 값을 sum에 더해줘라
            }
            System.out.println(sum);              // 더한 값을 출력하면 완성!!
        }
    }
}
