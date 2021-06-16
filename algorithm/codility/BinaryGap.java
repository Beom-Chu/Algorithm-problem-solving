/*
이진 갭 N 양의 정수 내에는 N.의 이진 표현의 양단들에 의해 둘러싸인 연속 된 제로 중 최대 시퀀스 인

예를 들어, 숫자 9는 이진 표현 1001 이고 길이 2의 이진 갭을 포함합니다. 
숫자 529는 이진 표현 1000010001을 가지며 두 개의 이진 갭을 포함합니다. 
하나는 길이 4이고 하나는 길이 3입니다. 
숫자 20은 이진 표현 10100을 가지며 길이 1의 이진 갭 1 개 숫자 15는 이진 표현 1111 을 가지며 이진 갭이 없습니다. 
숫자 32는 이진 표현 100000 이며 이진 간격이 없습니다.

함수 작성 :

class Solution {public int solution (int N); }

양의 정수 N이 주어지면 가장 긴 이진 간격의 길이를 반환합니다. N에 이진 갭이 없으면 함수는 0을 반환해야합니다.

예를 들어 N = 1041이면 함수는 5를 반환해야합니다. 
N은 이진 표현 10000010001 이고 따라서 가장 긴 이진 간격은 길이 5이기 때문입니다.
 N = 32이면 함수는 0을 반환해야합니다. N은 이진 표현 '100000'이므로 바이너리 갭이 없습니다.

다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

N은 [ 1 .. 2,147,483,647 ] 범위 내의 정수 입니다. 
 */
package algorithm.codility;

public class BinaryGap {
	
    public int solution(int N) {
        
        int rtn = 0, cnt = 0;
        
        String binary = Integer.toBinaryString(N);

        if(getOneCount(binary) == 1) return 0;

        for(char chr : binary.toCharArray()){
            if(chr == '1') {
                rtn = Math.max(rtn, cnt);
                cnt=0;
            } else {
                cnt++;
            }
        }

        return rtn;
    }

    public int getOneCount(String binary){
        return binary.replaceAll("0","").length();
    }
}
