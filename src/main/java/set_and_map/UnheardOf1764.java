package set_and_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class UnheardOf1764 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    Set<String> notListen = new HashSet<>();
    Set<String> notSee = new HashSet<>();

    for (int i = 0; i < N; i++) {
      notListen.add(br.readLine());
    }

    for (int i = 0; i < M; i++) {
      notSee.add(br.readLine());
    }

    List<String> result = notListen.stream().filter(notSee::contains).sorted()
        .collect(Collectors.toList());

    sb.append(result.size()).append("\n");
    for (String s : result) {
      sb.append(s).append("\n");
    }
    System.out.println(sb);
  }
}
