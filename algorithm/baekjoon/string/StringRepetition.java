/**문자열 반복 [2675]
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	71998	37031	32311	52.353%
문제
문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오. 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.

QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.

입력
첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다. S의 길이는 적어도 1이며, 20글자를 넘지 않는다. 

출력
각 테스트 케이스에 대해 P를 출력한다.

예제 입력 1 
2
3 ABC
5 /HTP
예제 출력 1 
AAABBBCCC
/////HHHHHTTTTTPPPPP
*/
package algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringRepetition {

	public static void main(String[] args) throws IOException {
		
		try(
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader reader = new BufferedReader(isr);
				){
			
			int cnt = Integer.valueOf(reader.readLine());
			
			while(cnt-->0) {
				
				String readLine = reader.readLine();
				StringTokenizer token = new StringTokenizer(readLine);
				StringBuilder sb = new StringBuilder();
				
				int R = Integer.valueOf(token.nextToken());
				String S = token.nextToken();
				
				for(int i=0; i<S.length(); i++) {
					for(int j=0; j<R; j++) {
						sb.append(S.charAt(i));
					}
				}
				
				System.out.println(sb.toString());
			}
		}
	}
}
