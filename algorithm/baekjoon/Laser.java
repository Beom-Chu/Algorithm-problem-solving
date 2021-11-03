/**
 * 레이저 [1732]
시간 제한 메모리 제한  제출  정답  맞은 사람 정답 비율
2 초 128 MB  78  14  11  21.154%
문제
2차원 평면상에 N(1≤N≤100,000)개의 기둥이 설치되어 있다. 각각의 기둥의 꼭대기에는 레이저가 설치되어 있는데, 
레이저는 (0, 0)의 위치에 있는 조각상을 비추고 있다. 각각의 건물의 높이는 다를 수 있는데, 이때문에 몇몇 레이저들은 다른 건물에 가려질 수도 있다. 
두 개의 건물 A, B와 조각상이 일직선상에 순서대로 있을 때, 만약 A의 높이가 B의 높이 이하이면 A의 꼭대기에 설치되어 있는 레이저는 건물 B에 가려지게 된다.

각 건물들의 좌표가 주어졌을 때, 레이저가 가려지게 되는 건물들을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. 다음 N개의 줄에는 세 정수 x, y, z가 주어진다. 이는 (x, y)의 위치에 높이 z인 건물이 존재한다는 의미이다. 
단 -100,000≤x≤100,000, 0≤y≤10,000, 0≤z≤10,000이 만족된다. 같은 위치에는 최대 한 개의 건물만 있을 수 있다.

출력
첫째 줄부터 가려지는 건물들의 좌표를 출력한다. 
좌표를 출력할 때에는 x좌표가 증가하는 순서대로, x좌표가 같다면 y좌표가 증가하는 순서대로 출력한다.

예제 입력 1 
5
-1 0 1
-1 1 2
-2 2 2
-3 3 3
-4 4 2
예제 출력 1 
-4 4
-2 2

두수의 최대 공약수를 구함
각 수에서 최대공약수로 나눈 수만큼 증가,감소 시키면서 겹치는 위치가 있는지 체크
겹치는 위치가 나왔을때 그 건물이 비교 대상 건물의 높이보다 같거나 높으면 출력

 */
package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Laser {

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.valueOf(reader.readLine());

    ArrayList<Building> buildings = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer token = new StringTokenizer(reader.readLine(), " ");
      int x = Integer.valueOf(token.nextToken());
      int y = Integer.valueOf(token.nextToken());
      int h = Integer.valueOf(token.nextToken());
      buildings.add(new Building(x, y, h));
    }
    
    //정렬
    Collections.sort(buildings, (o1, o2) -> o1.x == o2.x ? o1.y - o2.y : o1.x - o2.x);
    
    for(int i = 0; i < buildings.size(); i++) {
      
      Building tempBuilding = new Building(buildings.get(i));
      long gcd = Math.abs(GcdRecursion(tempBuilding.x,tempBuilding.y));
      long increX = tempBuilding.x / gcd;
      long increY = tempBuilding.y / gcd;
      
      boolean isBreak = false;
      
      while(!(tempBuilding.x == 0 && tempBuilding.y == 0)) {
        
        tempBuilding.x -= increX;
        tempBuilding.y -= increY;
        
        //가려지는 건물 확인
        for (Building building : buildings) {
          if(building.x == tempBuilding.x && building.y == tempBuilding.y
              && building.height >= tempBuilding.height) {
            
            System.out.println(buildings.get(i).x +","+buildings.get(i).y);
            isBreak = true;
            break;
          }
        }
        
        if(isBreak) {
          break;
        }
      }
    }
  }

  /* 최대공약수 - 재귀 */
  public static long GcdRecursion(int a, int b) {
    return b > 0 ? GcdRecursion(b, a % b) : a;
  }
  
  public static class Building {
    int x;
    int y;
    int height;
    
    public Building(int x, int y, int height) {
      this.x = x;
      this.y = y;
      this.height = height;
    }
    
    public Building(Building building) {
      this.x = building.x;
      this.y = building.y;
      this.height = building.height;
    }
  }
}
