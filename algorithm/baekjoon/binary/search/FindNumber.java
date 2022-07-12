/*
수 찾기 [1920]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	147346	43317	28752	29.871%
문제
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다.
다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데,
 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

출력
M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.

예제 입력 1
5
4 1 5 2 3
5
1 3 7 9 5
예제 출력 1
1
1
0
0
1
 */
package algorithm.baekjoon.binary.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNumber {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nNums = new int[n];
        StringTokenizer stN = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            nNums[i] = Integer.parseInt(stN.nextToken());
        }
        int m = Integer.parseInt(reader.readLine());
        int[] mNums = new int[m];
        StringTokenizer stM = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            mNums[i] = Integer.parseInt(stM.nextToken());
        }

        Arrays.sort(nNums);
        
        for(int mNum : mNums) {
//            System.out.println(Arrays.binarySearch(nNums, mNum) >= 0 ? 1 : 0);
            System.out.println(binarySearch(nNums, mNum));
        }
    }

    public static int binarySearch(int[] nNums, int mNum){
        int low = 0;
        int high = nNums.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nNums[mid];

            if (midVal < mNum)
                low = mid + 1;
            else if (midVal > mNum)
                high = mid - 1;
            else
                return 1;
        }
        return 0;
    }
}
