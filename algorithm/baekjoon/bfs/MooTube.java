/*
MooTube (Silver) [15591]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	512 MB	4363	1670	1265	38.887%
문제
농부 존은 남는 시간에 MooTube라 불리는 동영상 공유 서비스를 만들었다.
MooTube에서 농부 존의 소들은 재밌는 동영상들을 서로 공유할 수 있다.
소들은 MooTube에 1부터 N까지 번호가 붙여진 N (1 ≤ N ≤ 5,000)개의 동영상을 이미 올려 놓았다.
하지만, 존은 아직 어떻게 하면 소들이 그들이 좋아할 만한 새 동영상을 찾을 수 있을지 괜찮은 방법을 떠올리지 못했다.

농부 존은 모든 MooTube 동영상에 대해 “연관 동영상” 리스트를 만들기로 했다.
이렇게 하면 소들은 지금 보고 있는 동영상과 연관성이 높은 동영상을 추천 받을 수 있을 것이다.

존은 두 동영상이 서로 얼마나 가까운 지를 측정하는 단위인 “USADO”를 만들었다.
존은 N-1개의 동영상 쌍을 골라서 직접 두 쌍의 USADO를 계산했다.
그 다음에 존은 이 동영상들을 네트워크 구조로 바꿔서, 각 동영상을 정점으로 나타내기로 했다.
또 존은 동영상들의 연결 구조를 서로 연결되어 있는 N-1개의 동영상 쌍으로 나타내었다.
좀 더 쉽게 말해서, 존은 N-1개의 동영상 쌍을 골라서 어떤 동영상에서 다른 동영상으로 가는 경로가 반드시 하나 존재하도록 했다.
존은 임의의 두 쌍 사이의 동영상의 USADO를 그 경로의 모든 연결들의 USADO 중 최솟값으로 하기로 했다.

존은 어떤 주어진 MooTube 동영상에 대해, 값 K를 정해서 그 동영상과 USADO가 K 이상인 모든 동영상이 추천되도록 할 것이다.
하지만 존은 너무 많은 동영상이 추천되면 소들이 일하는 것이 방해될까 봐 걱정하고 있다! 그래서 그는 K를 적절한 값으로 결정하려고 한다.
농부 존은 어떤 K 값에 대한 추천 동영상의 개수를 묻는 질문 여러 개에 당신이 대답해주기를 바란다.

입력
입력의 첫 번째 줄에는 N과 Q가 주어진다. (1 ≤ Q ≤ 5,000)

다음 N-1개의 줄에는 농부 존이 직접 잰 두 동영상 쌍의 USADO가 한 줄에 하나씩 주어진다.
각 줄은 세 정수 pi, qi, ri (1 ≤ pi, qi ≤ N, 1 ≤ ri ≤ 1,000,000,000)를 포함하는데,
이는 동영상 pi와 qi가 USADO ri로 서로 연결되어 있음을 뜻한다.

다음 Q개의 줄에는 농부 존의 Q개의 질문이 주어진다.
각 줄은 두 정수 ki와 vi(1 ≤ ki ≤ 1,000,000,000, 1 ≤ vi ≤ N)을 포함하는데,
이는 존의 i번째 질문이 만약 K = ki라면 동영상 vi를 보고 있는 소들에게 몇 개의 동영상이 추천될 지 묻는 것이라는 것을 뜻한다.

출력
Q개의 줄을 출력한다. i번째 줄에는 농부 존의 i번째 질문에 대한 답변이 출력되어야 한다.

예제 입력 1
4 3
1 2 3
2 3 2
2 4 4
1 2
4 1
3 1
예제 출력 1
3
0
2
힌트
농부 존은 1번 동영상과 2번 동영상이 USADO 3을 가지고, 2번 동영상과 3번 동영상이 USADO 2를 가지고,
2번 동영상과 4번 동영상이 USADO 4를 가진다고 했다.
이것에 기반해서 1번 동영상과 3번 동영상의 USADO는 min(3,2)=2가 되고, 1번 동영상과 4번 동영상의 USADO는 min(3,4)=3이 되고,
3번 동영상과 4번 동영상의 USADO는 min(2,4)=2가 된다.

농부 존은 K=1일 때 2번 동영상, K=3일 때 1번 동영상, K=4일 때 1번 동영상을 보면 각각 몇 개의 동영상이 추천될까 궁금해하고 있다.
 K=1일 때 2번 동영상에서 추천되는 동영상은 1, 3, 4번 동영상이다. K=4일 때 1번 동영상으로부터 추천되는 동영상은 없다.
 그러나 K=3일때는 1번 동영상에서 2번 동영상과 4번 동영상이 추천된다.
 */
package algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MooTube {

    static Map<Integer, List<int[]>> usado = new HashMap<>();
    static int N, Q;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st1.nextToken());
        Q = Integer.parseInt(st1.nextToken());


        int[][] kvs = new int[Q][2];

        for (int i = 1; i <= N; i++) {
            usado.put(i, new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int[] u = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            usado.get(u[0]).add(new int[]{u[1],u[2]});
            usado.get(u[1]).add(new int[]{u[0],u[2]});
        }

        for(int i = 0; i < Q; i++) {
            kvs[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        StringBuilder sb = new StringBuilder();

        for(int[] kv : kvs) {
            sb.append(bfs(kv[0], kv[1])).append("\n");
        }
        System.out.println(sb);
    }

    public static int bfs(int k, int v) {
        int result = 0;
        Queue<Integer> que = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        que.add(v);

        while(!que.isEmpty()) {
            Integer current = que.poll();
            visit[current] = true;

            for(int[] u : usado.get(current)) {
                if (!visit[u[0]] && u[1] >= k) {
                    que.add(u[0]);
                    result++;
                }
            }
        }
        return result;
    }
}
