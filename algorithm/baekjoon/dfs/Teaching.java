/*
가르침 [1062]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB (하단 참고)	33435	9056	5362	25.128%
문제
남극에 사는 김지민 선생님은 학생들이 되도록이면 많은 단어를 읽을 수 있도록 하려고 한다.
그러나 지구온난화로 인해 얼음이 녹아서 곧 학교가 무너지기 때문에, 김지민은 K개의 글자를 가르칠 시간 밖에 없다.
김지민이 가르치고 난 후에는, 학생들은 그 K개의 글자로만 이루어진 단어만을 읽을 수 있다.
김지민은 어떤 K개의 글자를 가르쳐야 학생들이 읽을 수 있는 단어의 개수가 최대가 되는지 고민에 빠졌다.

남극언어의 모든 단어는 "anta"로 시작되고, "tica"로 끝난다. 남극언어에 단어는 N개 밖에 없다고 가정한다.
학생들이 읽을 수 있는 단어의 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 단어의 개수 N과 K가 주어진다. N은 50보다 작거나 같은 자연수이고, K는 26보다 작거나 같은 자연수 또는 0이다.
둘째 줄부터 N개의 줄에 남극 언어의 단어가 주어진다. 단어는 영어 소문자로만 이루어져 있고, 길이가 8보다 크거나 같고, 15보다 작거나 같다.
모든 단어는 중복되지 않는다.

출력
첫째 줄에 김지민이 K개의 글자를 가르칠 때, 학생들이 읽을 수 있는 단어 개수의 최댓값을 출력한다.

예제 입력 1
3 6
antarctica
antahellotica
antacartica
예제 출력 1
2
예제 입력 2
2 3
antaxxxxxxxtica
antarctica
예제 출력 2
0
예제 입력 3
9 8
antabtica
antaxtica
antadtica
antaetica
antaftica
antagtica
antahtica
antajtica
antaktica
예제 출력 3
3
 */
package algorithm.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Teaching {

    static String[] words;
    static int K;
    static int result = 0;
    static boolean[] teach = new boolean[26];
    
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        for (int i = 0; i < N; i++) {
            String s = reader.readLine();
            words[i] = s.substring(4, s.length() - 4);
        }

        if(K < 5) {
            System.out.println(0);
            return;
        } else if(K >= 26) {
            System.out.println(N);
            return;
        }

        teach['a' - 'a'] = true;
        teach['n' - 'a'] = true;
        teach['t' - 'a'] = true;
        teach['i' - 'a'] = true;
        teach['c' - 'a'] = true;

        backTracking(5, 0);

        System.out.println(result);
    }

    public static void backTracking(int teachCount, int start) {

        if(teachCount >= K) {
            int count = check();
            result = Math.max(result, count);
            return;
        }

        for (int i = start; i < 26; i++) {
            if(!teach[i]) {
                teach[i] = true;
                backTracking(teachCount + 1, i);
                teach[i] = false;
            }
        }
    }

    public static int check() {
        int count = 0;
        for (String word : words) {
            boolean read = true;
            for (int j = 0; j < word.length(); j++) {
                if (!teach[word.charAt(j) - 'a']) {
                    read = false;
                    break;
                }
            }
            if (read) {
                count++;
            }
        }
        return count;
    }
}
