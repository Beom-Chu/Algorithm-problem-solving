package algorithm.baekjoon.sorting;

/*
올림픽[8979]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	23988	9063	7411	38.921%
문제
올림픽은 참가에 의의가 있기에 공식적으로는 국가간 순위를 정하지 않는다.
그러나, 많은 사람들이 자신의 국가가 얼마나 잘 하는지에 관심이 많기 때문에 비공식적으로는 국가간 순위를 정하고 있다.
두 나라가 각각 얻은 금, 은, 동메달 수가 주어지면, 보통 다음 규칙을 따라 어느 나라가 더 잘했는지 결정한다.

1.금메달 수가 더 많은 나라
2.금메달 수가 같으면, 은메달 수가 더 많은 나라
3.금, 은메달 수가 모두 같으면, 동메달 수가 더 많은 나라
각 국가는 1부터 N 사이의 정수로 표현된다. 한 국가의 등수는 (자신보다 더 잘한 나라 수) + 1로 정의된다.
만약 두 나라가 금, 은, 동메달 수가 모두 같다면 두 나라의 등수는 같다.
예를 들어, 1번 국가가 금메달 1개, 은메달 1개를 얻었고, 2번 국가와 3번 국가가 모두 은메달 1개를 얻었으며,
4번 국가는 메달을 얻지 못하였다면, 1번 국가가 1등, 2번 국가와 3번 국가가 공동 2등, 4번 국가가 4등이 된다. 이 경우 3등은 없다.

각 국가의 금, 은, 동메달 정보를 입력받아서, 어느 국가가 몇 등을 했는지 알려주는 프로그램을 작성하시오.

입력
입력의 첫 줄은 국가의 수 N(1 ≤ N ≤ 1,000)과 등수를 알고 싶은 국가 K(1 ≤ K ≤ N)가 빈칸을 사이에 두고 주어진다.
각 국가는 1부터 N 사이의 정수로 표현된다.
이후 N개의 각 줄에는 차례대로 각 국가를 나타내는 정수와 이 국가가 얻은 금, 은, 동메달의 수가 빈칸을 사이에 두고 주어진다.
전체 메달 수의 총합은 1,000,000 이하이다.

출력
출력은 단 한 줄이며, 입력받은 국가 K의 등수를 하나의 정수로 출력한다. 등수는 반드시 문제에서 정의된 방식을 따라야 한다.

서브태스크
번호	배점	제한
1	8
예제 입력, 출력

2	12
N = 2

3	20
모든 국가의 은메달 및 동메달 획득 수는 0

4	25
N ≤ 500

5	35
추가적인 제약 조건은 없다.

예제 입력 1
4 3
1 1 2 0
2 0 1 0
3 0 1 0
4 0 0 1
예제 출력 1
2
예제 입력 2
4 2
1 3 0 0
3 0 0 2
4 0 2 0
2 0 2 0
예제 출력 2
2
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Olympic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer firstLineToken = new StringTokenizer(reader.readLine());

        int count = Integer.parseInt(firstLineToken.nextToken());
        int target = Integer.parseInt(firstLineToken.nextToken());
        List<Medal> medals = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            medals.add(new Medal(reader.readLine()));
        }
        medals.sort(new MedalComparator(target));

        int result = 1;
        for(Medal medal : medals) {
            if(medal.no.equals(target)) {
                System.out.println(result);
                break;
            } else {
                result++;
            }
        }
    }

    static class Medal {
        Integer no;
        Integer gold;
        Integer silver;
        Integer bronze;

        public Medal(String s) {
            StringTokenizer st = new StringTokenizer(s);
            this.no = Integer.parseInt(st.nextToken());
            this.gold = Integer.parseInt(st.nextToken());
            this.silver = Integer.parseInt(st.nextToken());
            this.bronze = Integer.parseInt(st.nextToken());
        }
    }

    private static class MedalComparator implements java.util.Comparator<Medal> {
        Integer target;
        public MedalComparator(int target) {
            this.target = target;
        }

        /* 금,은,동 메달수 순으로 정렬하고 모두 같으면 알고 싶은 나라를 우선으로 정렬 */
        @Override
        public int compare(Medal o1, Medal o2) {
            if(o2.gold.compareTo(o1.gold) != 0) {
                return o2.gold.compareTo(o1.gold);
            } else if(o2.silver.compareTo(o1.silver) != 0) {
                return o2.silver.compareTo(o1.silver);
            } else if(o2.bronze.compareTo(o1.bronze) != 0) {
                return o2.bronze.compareTo(o1.bronze);
            } else {
                return o1.no.equals(target) ? -1 : 1;
            }
        }
    }
}
