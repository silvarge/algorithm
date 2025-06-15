package practice;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueuePt {

  public void practice() throws IOException {
//    Queue<Integer> priorityQueue = new PriorityQueue<>(); // 오름차순
//    Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder()); // 내림차순
    Queue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
      // 짝수 먼저 정렬, 오름차순
      boolean e1 = (o1 % 2) == 0;
      boolean e2 = (o2 % 2) == 0;

      if(e1 && !e2) return -1;  // o1이 먼저 (o1이 짝수)
      if(!e1 && e2) return 1;   // o2가 먼저 (o2가 짝수)

      return Integer.compare(o1, o2); // 둘 다 같으면 값 비교 (오름차순)
    }); // 내림차순
    StringBuilder sb = new StringBuilder();
    int[] test = new int[]{2, 5, 4, 9, 0, 28, 49, 1, 0};

    for (int i : test) {
      priorityQueue.add(i);
    }

    while (!priorityQueue.isEmpty()) {
      sb.append(priorityQueue.poll()).append("\n");
    }

    System.out.println(sb);

  }

}
