package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class JosephusProblem1158 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inp = br.readLine().split(" ");
    int n = Integer.parseInt(inp[0]);
    int k = Integer.parseInt(inp[1]);

    StringBuilder sb = new StringBuilder();
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      queue.add(i);
    }

    sb.append("<");
    while (queue.size() != 1) {
      for (int i = 0; i < k - 1; i++) {
        queue.offer(queue.poll());
      }
      sb.append(queue.poll() + ", ");
    }
    sb.append(queue.poll() + ">");

    System.out.println(sb);
  }
}
