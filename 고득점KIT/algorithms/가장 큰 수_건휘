using System;
using System.Linq;

public class Solution {
    public string solution(int[] numbers) {

    // 두 가지 수의 합 비교
    Array.Sort(numbers, (a, b) =>
            {
                string currunt = a.ToString() + b.ToString();
                string compare = b.ToString() + a.ToString();
                return compare.CompareTo(currunt);
            });

            //linq 사용 0의 인자만 들어왔을 시 검증
            if (numbers.Where(x => x == 0).Count() == numbers.Length) return "0";
            else return string.Join("", numbers);
    }
}
