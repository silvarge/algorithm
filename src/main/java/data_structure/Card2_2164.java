package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Card2_2164 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Queue<Integer> queue = new LinkedList<>();

    for (int i = 1; i <= N; i++) {
      queue.offer(i);
    }

    int temp;
    while (queue.size() > 1) {
      queue.poll();
      temp = queue.poll();
      queue.offer(temp);
    }
    System.out.println(queue.poll());
  }
}
