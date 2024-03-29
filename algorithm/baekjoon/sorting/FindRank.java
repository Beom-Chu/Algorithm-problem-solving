/*
등수 구하기 [1205]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	20957	5284	4384	25.982%
문제
태수가 즐겨하는 디제이맥스 게임은 각각의 노래마다 랭킹 리스트가 있다.
이것은 매번 게임할 때 마다 얻는 점수가 비오름차순으로 저장되어 있는 것이다.

이 랭킹 리스트의 등수는 보통 위에서부터 몇 번째 있는 점수인지로 결정한다.
하지만, 같은 점수가 있을 때는 그러한 점수의 등수 중에 가장 작은 등수가 된다.

예를 들어 랭킹 리스트가 100, 90, 90, 80일 때 각각의 등수는 1, 2, 2, 4등이 된다

랭킹 리스트에 올라 갈 수 있는 점수의 개수 P가 주어진다. 그리고 리스트에 있는 점수 N개가 비오름차순으로 주어지고, 태수의 새로운 점수가 주어진다.
이때, 태수의 새로운 점수가 랭킹 리스트에서 몇 등 하는지 구하는 프로그램을 작성하시오.
만약 점수가 랭킹 리스트에 올라갈 수 없을 정도로 낮다면 -1을 출력한다.

만약, 랭킹 리스트가 꽉 차있을 때, 새 점수가 이전 점수보다 더 좋을 때만 점수가 바뀐다.

입력
첫째 줄에 N, 태수의 새로운 점수, 그리고 P가 주어진다.
P는 10보다 크거나 같고, 50보다 작거나 같은 정수, N은 0보다 크거나 같고, P보다 작거나 같은 정수이다.
그리고 모든 점수는 2,000,000,000보다 작거나 같은 자연수 또는 0이다.
둘째 줄에는 현재 랭킹 리스트에 있는 점수가 비오름차순으로 주어진다.
둘째 줄은 N이 0보다 큰 경우에만 주어진다.

출력
첫째 줄에 문제의 정답을 출력한다.

예제 입력 1
3 90 10
100 90 80
예제 출력 1
2
예제 입력 2
10 1 10
10 9 8 7 6 5 4 3 2 1
예제 출력 2
-1
예제 입력 3
10 1 10
10 9 8 7 6 5 4 3 3 0
예제 출력 3
10
예제 입력 4
0 0 50
예제 출력 4
1
 */
package algorithm.baekjoon.sorting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class FindRank {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int newScore = scanner.nextInt();
        int P = scanner.nextInt();
        ArrayList<Integer> scores = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            scores.add(scanner.nextInt());
        }

        scores.sort(Comparator.reverseOrder());

        int rank = -1;

        if(N == 0) { // 등록 점수 없으면 1
            System.out.println(1);
            return;
        } else if(scores.size() >= P) { // 랭킹리스트 마지막보다 신규 점수가 작거나 같으면 -1
            if(scores.get(P - 1) >= newScore) {
                System.out.println(rank);
                return;
            }
        }

        for (int i = 0; i < scores.size() && i < P; i++) {
            if(scores.get(i) <= newScore) {
                rank = i + 1;
                break;
            }
        }

        if(rank == -1 && scores.size() < P) {
            System.out.println(scores.size() + 1);
            return;
        }

        System.out.println(rank);
    }
}
/*
10 1 11
10 9 8 7 6 5 4 3 1 1

9 5 10
10 10 10 9 9 8 7 6 6
 */