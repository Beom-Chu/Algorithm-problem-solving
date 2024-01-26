/*
쿠키의 신체 측정
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	1024 MB	1984	1292	1173	67.921%
문제
쿠키런은 데브시스터즈에서 제작한 모바일 러닝 액션 게임이다.
마녀의 오븐에서 탈출한 쿠키들과 함께 모험을 떠나는 게임으로, 점프와 슬라이드 2가지 버튼만으로 손쉽게 플레이할 수 있는 것이 특징이다.

연세대학교를 졸업한 김강산 선배님이 데브시스터즈에 취직하면서 주변 사람들에게 쿠키런을 전파시켰다.
하지만 게임을 전파하던 중에 쿠키들에게 신체적으로 이상이 생기는 것을 발견하였다.
팔, 다리 길이가 임의적으로 변한 것이다. 때문에 긴급하게 각 쿠키들의 신체들을 측정하려고 한다.

쿠키들은 신체를 측정하기 위해서 한 변의 길이가 N인 정사각형 판 위에 누워있으며, 어느 신체 부위도 판 밖으로 벗어나지 않는다.
판의 x번째 행, y번째 열에 위치한 곳을 (x, y)로 지칭한다. 판의 맨 왼쪽 위 칸을 (1, 1), 오른쪽 아래 칸을 (N, N)으로 나타낼 수 있다.



그림과 같이 쿠키의 신체는 머리, 심장, 허리, 그리고 좌우 팔, 다리로 구성되어 있다. 그림에서 빨간 곳으로 칠해진 부분이 심장이다.
머리는 심장 바로 윗 칸에 1칸 크기로 있다.
왼쪽 팔은 심장 바로 왼쪽에 붙어있고 왼쪽으로 뻗어 있으며, 오른쪽 팔은 심장 바로 오른쪽에 붙어있고 오른쪽으로 뻗어있다.
허리는 심장의 바로 아래 쪽에 붙어있고 아래 쪽으로 뻗어 있다.
왼쪽 다리는 허리의 왼쪽 아래에, 오른쪽 다리는 허리의 오른쪽 아래에 바로 붙어있고, 각 다리들은 전부 아래쪽으로 뻗어 있다.
각 신체 부위들은 절대로 끊겨있지 않으며 굽혀진 곳도 없다. 또한, 허리, 팔, 다리의 길이는 1 이상이며, 너비는 무조건 1이다.

쿠키의 신체가 주어졌을 때 심장의 위치와 팔, 다리, 허리의 길이를 구하여라.

입력
다음과 같이 입력이 주어진다.

N
a1,1 . . . a1,N
. . . . . .
aN,1 . . . aN,N
출력
첫 번째 줄에는 심장이 위치한 행의 번호 x와 열의 번호 y를 공백으로 구분해서 출력한다.

두 번째 줄에는 각각 왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리의 길이를 공백으로 구분해서 출력하여라.

제한
5 ≤ N ≤ 1,000. N은 판의 한 변의 길이를 의미하는 양의 정수다.
ai,j는 * 또는 _이다. *는 쿠키의 신체 부분이고, _는 쿠키의 신체가 올라가 있지 않은 칸을 의미한다. (1 ≤ i, j ≤ N)
쿠키의 신체 조건에 위배되는 입력은 주어지지 않는다.

예제 입력 1
5
_____
__*__
_***_
__*__
_*_*_
예제 출력 1
3 3
1 1 1 1 1

예제 입력 2
10
__________
_____*____
__******__
_____*____
_____*____
_____*____
____*_*___
____*_____
____*_____
____*_____
예제 출력 2
3 6
3 2 3 4 1

예제 입력 3
9
____*____
*********
____*____
____*____
____*____
___*_*___
___*_*___
___*_*___
___*_*___
예제 출력 3
2 5
4 4 3 4 4
 */
package algorithm.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CookiesBodyMeasurements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        Cookie cookie = new Cookie();
        String[] input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = reader.readLine();
        }

        for (int i = 0; i < N; i++) {
            if (cookie.heart == null) {
                cookie.heart = setHeart(input[i], i);
            } else if(cookie.leftHand == 0 || cookie.rightHand == 0) {
                cookie.leftHand = setLeftHand(cookie.heart, input[i]);
                cookie.rightHand = setRightHand(cookie.heart, input[i]);
            } else if(cookie.waist == 0) {
                cookie.waist = setWaist(cookie.heart, input, i);
            } else {
                if(cookie.leftFoot == 0) {
                    cookie.leftFoot = setLeftFoot(cookie, input[i], i, N);
                }
                if(cookie.rightFoot == 0) {
                    cookie.rightFoot = setRightFoot(cookie, input[i], i, N);
                }
            }
        }

        cookie.print();
    }

    private static int setRightFoot(Cookie cookie, String input, int i, int N) {
        return setFoot(cookie, input, i, N, "R");
    }

    private static int setLeftFoot(Cookie cookie, String input, int i, int N) {
        return setFoot(cookie, input, i, N, "L");
    }

    private static int setFoot(Cookie cookie, String input, int i, int N, String lr) {
        if(input.charAt(cookie.heart.y + (lr.equals("L") ? -1 : 1)) != '*') {
            return i - cookie.heart.x - cookie.waist - 1;
        } else if(i == N - 1) {
            return i - cookie.heart.x - cookie.waist;
        }
        return 0;
    }

    private static int setWaist(Heart heart, String[] input, int i) {
        if(input[i].charAt(heart.y) == '*' && input[i+1].charAt(heart.y) == '_'){
            return i - heart.x;
        }
        return 0;
    }

    private static int setRightHand(Heart heart, String input) {
        return input.lastIndexOf("*") - heart.y;
    }

    private static int setLeftHand(Heart heart, String input) {
        return heart.y - input.indexOf("*");
    }

    private static Heart setHeart(String input, int i) {
        if (input.contains("*")) {
            return new Heart(i + 1 , input.indexOf("*"));
        }
        return null;
    }

    static class Cookie {
        Heart heart;
        int leftHand = 0;
        int rightHand = 0;
        int waist = 0;
        int leftFoot = 0;
        int rightFoot = 0;

        void print() {
            System.out.printf("%s %s\n", this.heart.x + 1, this.heart.y + 1);
            System.out.printf("%s %s %s %s %s", this.leftHand, this.rightHand, this.waist, this.leftFoot, this.rightFoot);
        }
    }
    static class Heart {
        int x;
        int y;
        public Heart(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
