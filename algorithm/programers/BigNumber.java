/* 가장 큰 수*/
/*0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
*/

package algorithm.programers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class BigNumber {

  /* Stream 활용 - 느림 */
  public String solution4(int[] numbers) {
    
    return new BigDecimal(
            Arrays.stream(numbers)
                  .mapToObj(i->String.valueOf(i))
                  .sorted((s1,s2)->(s2+s1).compareTo(s1+s2))
                  .reduce("",(s1,s2)->s1+s2)
          ).toString();
    
  }

  /* Stream 활용 */
  public String solution3(int[] numbers) {
    
    StringBuilder sb = new StringBuilder();
    
    Arrays.stream(numbers)
          .mapToObj(i->String.valueOf(i))
          .sorted((s1,s2)->(s2+s1).compareTo(s1+s2))
          .forEach(s->sb.append(s));
    
    return new BigDecimal(sb.toString()).toString();
  }
  

  public String solution2(int[] numbers) {

    String[] arrS = new String[numbers.length];
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < numbers.length; i++) {
      arrS[i] = String.valueOf(numbers[i]);
    }
    
    //두 문자열을 각각 반대로 붙인 순서 비교로 정렬 
    Arrays.sort(arrS, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

    for (String s : arrS) {
      sb.append(s);
    }
    
    // 맨 앞자리가 0 인 경우를 대비해 숫자타입 변환 후 문자타입 변환
    return String.valueOf(new BigDecimal(sb.toString()));
  }

  /* 최초 */
  public String solution1(int[] numbers) {
    StringBuffer result = new StringBuffer();
    String[] arrS = Arrays.stream(numbers).mapToObj(i -> String.valueOf(i)).toArray(String[]::new);

    Arrays.sort(arrS, new Comparator<String>() {
      public int compare(String s1, String s2) {
        return (s2 + s1).compareTo(s1 + s2);
      }
    });

    for (String s : arrS)
      result.append(s);

    return String.valueOf(new BigDecimal(result.toString()));
  }

  public static void main(String[] args) {

    // int[] numbers = {6, 10, 2}; /* 6210 */
    // int[] numbers = {3, 30, 34, 5, 9}; /* 9534330 */
    int[] numbers = {3, 30, 34, 5, 9, 300}; /* 9534330300 */
    // int[] numbers = {3, 30, 34, 5, 9,340}; /* 9534330300 */

    BigNumber bigNumber = new BigNumber();
    String rtn = bigNumber.solution4(numbers);

    System.out.println(rtn);
  }

}
