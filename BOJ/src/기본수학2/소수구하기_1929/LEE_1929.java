package 기본수학2.소수구하기_1929;

import java.util.Scanner;

public class LEE_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m=sc.nextInt();
        int n=sc.nextInt();

        boolean arr[] = new boolean[n+1]; //최대치 만큼의 배열 할당

        arr[0] = true;
        arr[1] = true;

        // 에라토스테네스의 체를 이용하여 소수인 인덱스를 true로 변경
        for(int i =2; i<=Math.sqrt(n+1); i++){
            for(int j=i*i; j<n+1; j+=i){
                arr[j] = true;                //소수가 아닌 수는 true
            }
        }

        for(int i=m; i<n+1; i++){
            if(arr[i] == false)
                System.out.println(i);
        }
    }
}
/*
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 0, 1 번째 인덱스를 제외한 나머지를 true로 세팅
		boolean[] sosu = new boolean[1000000];
		sosu[0] = false;
		sosu[1] = false;
		for(int i = 2; i < sosu.length; i++) {
			sosu[i] = true;
		}
		// 에라토스테네스의 체를 이용하여 소수가 아닌 인덱스를 false로 변경
		for(int i = 2; i < sosu.length; i++) {
			if(sosu[i]) {
				for(int j = 2*i; j < sosu.length; j += i) {
					sosu[j] = false;
				}
			}
		}

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		// a에서 b 사이의 true(소수)인 인덱스 값을 출력
		for(int i = a; i <= b; i++) {
			if(sosu[i]) {
				System.out.println(i);
			}
		}
		sc.close();
	}
}
 */




/*
new boolean[n+1] 최대치만큼 배열에 할당?
 */
/*
Math.sqrt()
double형태로 인수를 넣으면 인수의 제곱근을 출력합니다
ex) 9 = 3
ex) 100 = 10
ex) 20 = 4.4721
음수는 NaN
 */
/*
constexpr int MAX=1000001;
bool prime[MAX];
void eratosthenes(){
    memset(prime, false, MAX);//배열을 초기화한다.
    prime[2]=true;//2는 소수다. 이러면 3 이상의 홀수만 판별하면 된다.
    for(int i=3;i<MAX;i+=2)
        prime[i]=true;
    for(int i=3;;i+=2)//2씩 더해 굳이 짝수를 검색하지 않아도 된다.
        if(prime[i]==true){
            int j=i*i;
            if(j>=MAX) break;
            for(i*=2;j<MAX;j+=i){//i를 2배로 하여 i의 짝수곱을 굳이 검색하지 않게 한다.
                prime[j]=false;
            }
            i/=2;//i 원상복구
        }
}
 */

