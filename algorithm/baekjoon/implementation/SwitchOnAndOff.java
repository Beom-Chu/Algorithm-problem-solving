/*
스위치 켜고 끄기[1244]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	67547	14894	11063	20.165%
문제
1부터 연속적으로 번호가 붙어있는 스위치들이 있다. 스위치는 켜져 있거나 꺼져있는 상태이다.
<그림 1>에 스위치 8개의 상태가 표시되어 있다. ‘1’은 스위치가 켜져 있음을, ‘0’은 꺼져 있음을 나타낸다.
그리고 학생 몇 명을 뽑아서, 학생들에게 1 이상이고 스위치 개수 이하인 자연수를 하나씩 나누어주었다.
학생들은 자신의 성별과 받은 수에 따라 아래와 같은 방식으로 스위치를 조작하게 된다.

남학생은 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다.
즉, 스위치가 켜져 있으면 끄고, 꺼져 있으면 켠다.
<그림 1>과 같은 상태에서 남학생이 3을 받았다면, 이 학생은 <그림 2>와 같이 3번, 6번 스위치의 상태를 바꾼다.

여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서,
그 구간에 속한 스위치의 상태를 모두 바꾼다. 이때 구간에 속한 스위치 개수는 항상 홀수가 된다.

스위치 번호	①	②	③	④	⑤	⑥	⑦	⑧
스위치 상태	0	1	0	1	0	0	0	1
<그림 1>

예를 들어 <그림 2>에서 여학생이 3을 받았다면, 3번 스위치를 중심으로 2번, 4번 스위치의 상태가 같고 1번, 5번 스위치의 상태가 같으므로,
 <그림 3>과 같이 1번부터 5번까지 스위치의 상태를 모두 바꾼다.
 만약 <그림 2>에서 여학생이 4를 받았다면, 3번, 5번 스위치의 상태가 서로 다르므로 4번 스위치의 상태만 바꾼다.

스위치 번호	①	②	③	④	⑤	⑥	⑦	⑧
스위치 상태	0	1	1	1	0	1	0	1
<그림 2>

스위치 번호	①	②	③	④	⑤	⑥	⑦	⑧
스위치 상태	1	0	0	0	1	1	0	1
<그림 3>

입력으로 스위치들의 처음 상태가 주어지고, 각 학생의 성별과 받은 수가 주어진다.
학생들은 입력되는 순서대로 자기의 성별과 받은 수에 따라 스위치의 상태를 바꾸었을 때, 스위치들의 마지막 상태를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 스위치 개수가 주어진다. 스위치 개수는 100 이하인 양의 정수이다.
둘째 줄에는 각 스위치의 상태가 주어진다. 켜져 있으면 1, 꺼져있으면 0이라고 표시하고 사이에 빈칸이 하나씩 있다.
셋째 줄에는 학생수가 주어진다. 학생수는 100 이하인 양의 정수이다.
넷째 줄부터 마지막 줄까지 한 줄에 한 학생의 성별, 학생이 받은 수가 주어진다.
남학생은 1로, 여학생은 2로 표시하고, 학생이 받은 수는 스위치 개수 이하인 양의 정수이다. 학생의 성별과 받은 수 사이에 빈칸이 하나씩 있다.

출력
스위치의 상태를 1번 스위치에서 시작하여 마지막 스위치까지 한 줄에 20개씩 출력한다.
예를 들어 21번 스위치가 있다면 이 스위치의 상태는 둘째 줄 맨 앞에 출력한다.
켜진 스위치는 1, 꺼진 스위치는 0으로 표시하고, 스위치 상태 사이에 빈칸을 하나씩 둔다.

예제 입력 1
8
0 1 0 1 0 0 0 1
2
1 3
2 3
예제 출력 1
1 0 0 0 1 1 0 1
 */
package algorithm.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SwitchOnAndOff {
    /*
    남학생 : 받은 번호의 배수 스위치 변경
    여학생 : 받은 번호 포함, 그 번호 중심으로 대칭인 스위치 모두 변경
     */
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int switchCount = Integer.parseInt(reader.readLine());
        int[] switches = new int[switchCount];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < switchCount; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }
        int studentCount = Integer.parseInt(reader.readLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student(reader.readLine()));
        }

        for (Student student : students) {
            switches = on(switches, student);
        }

        StringJoiner joiner = new StringJoiner(" ");
        for (int s : switches) {
            joiner.add(String.valueOf(s));
        }

        System.out.println(joiner);
    }

    // 학생 처리
    private static int[] on(int[] switches, Student student) {
        if (student.gender == 1) {
            return onMale(switches, student.number);
        } else {
            return onFemale(switches, student.number - 1);
        }
    }

    // 남학생 처리
    private static int[] onMale(int[] switches, int number) {
        for (int i = 0; i < switches.length; i++) {
            if((i + 1) % number == 0) {
                switches[i] = change(switches[i]);
            }
        }
        return switches;
    }

    // 여학생 처리
    private static int[] onFemale(int[] switches, int number) {
        switches[number] = change(switches[number]);
        int left = number;
        int right = number;
        while(left > 0 && right < switches.length - 1) {
            left--;
            right++;
            if(switches[left] == switches[right]) {
               switches[left] = change(switches[left]);
               switches[right] = change(switches[right]);
            } else {
                break;
            }
        }

        return switches;
    }

    // 스위치 변경
    private static int change(int i) {
        return Math.abs(i - 1);
    }

    public static class Student {
        int gender;
        int number;

        public Student(String s) {
            StringTokenizer st = new StringTokenizer(s);
            this.gender = Integer.parseInt(st.nextToken());
            this.number = Integer.parseInt(st.nextToken());
        }

        @Override
        public String toString() {
            return "Student{" +
                    "gender=" + gender +
                    ", number=" + number +
                    '}';
        }
    }
}