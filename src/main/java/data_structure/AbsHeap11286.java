package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class AbsHeap11286 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());

    // 절댓값이 가장 작은 값 -> 만약 값이 같다면 가장 작은 수
    Queue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
      if (Math.abs(o1) < Math.abs(o2)) {
        return -1;
      } else if (Math.abs(o1) == Math.abs(o2)) {
        return Integer.compare(o1, o2);
      } else {
        return 1;
      }
    });

    int input;
    for (int i = 0; i < N; i++) {
      input = Integer.parseInt(br.readLine());
      if (input == 0) {
        if (priorityQueue.isEmpty()) {
          sb.append(0).append("\n");
        } else {
          sb.append(priorityQueue.poll()).append("\n");
        }
      } else {
        priorityQueue.add(input);
      }
    }
    System.out.println(sb);

  }

}
