package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class StringSet14425 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int result = 0;

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    HashSet<String> hashSet = new HashSet<>();
    for (int i = 0; i < N; i++) {
      hashSet.add(br.readLine());
    }

    for (int i = 0; i < M; i++) {
      if (hashSet.contains(br.readLine())) {
        result++;
      }
    }

    System.out.println(result);
  }

}
