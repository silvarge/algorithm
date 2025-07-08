package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Truck13335 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int W = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());

    Queue<Integer> trucks = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      trucks.offer(Integer.parseInt(st.nextToken()));
    }

    Queue<Integer> bridge = new LinkedList<>();
    for (int i = 0; i < W; i++) {
      bridge.add(0);
    }

    int bridgeWeight = 0;
    int time = 0;

    // 마지막 트럭이 다리에 올라갈 때까지 반복
    while (!trucks.isEmpty()) {
      time++;
      bridgeWeight -= bridge.poll();

      if (bridgeWeight + trucks.peek() <= L) {
        int nextTruck = trucks.poll();
        bridge.offer(nextTruck);  // 다리 진입
        bridgeWeight += nextTruck;
      } else {
        bridge.offer(0);
      }
    }
    // 마지막 트럭이 다리를 빠져나갈때까지 걸리는 시간 W 추가
    time += W;

    System.out.println(time);
  }
}
