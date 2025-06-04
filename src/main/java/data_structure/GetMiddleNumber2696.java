package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class GetMiddleNumber2696 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = null;

    int T = Integer.parseInt(br.readLine());  // 테스트 케이스의 개수
    while (T-- > 0) {

      Queue<Integer> maxHeap = new PriorityQueue<>(
          Comparator.reverseOrder());  // 높은 숫자가 우선순위 (내림차순)
      Queue<Integer> minHeap = new PriorityQueue<>(); // 낮은 숫자가 우선순위 (오름차순)

      int M = Integer.parseInt(br.readLine());
      int cnt = 0;

      sb.append(M / 2 + 1).append("\n");

      for (int i = 0; i < M; i++) {
        if (i % 10 == 0) {
          st = new StringTokenizer(br.readLine());
        }
        int n = Integer.parseInt(st.nextToken());

        // 들어온 값을 일단 넣어줌
        if (maxHeap.size() == minHeap.size()) {
          maxHeap.offer(n);
        } else {
          minHeap.offer(n);
        }

        // 비교해서 위치 정하기
        if (!minHeap.isEmpty()) {
          if (maxHeap.peek() > minHeap.peek()) {
            int t1 = maxHeap.poll();
            int t2 = minHeap.poll();

            maxHeap.offer(t2);
            minHeap.offer(t1);
          }
        }

        // 0부터 시작 -> 짝수일 때 홀수 번째 수임
        if (i % 2 == 0) {
          if (cnt == 9 || i == M - 1) {
            sb.append(maxHeap.peek()).append("\n");
            cnt = 0;
          } else {
            sb.append(maxHeap.peek()).append(" ");
          }
          cnt++;
        }
      }
    }
    System.out.println(sb);
  }
}