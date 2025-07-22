package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SerialNumber1431 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    List<String> list = new ArrayList<>();

    // 입력
    for (int i = 0; i < N; i++) {
      list.add(br.readLine());
    }

    list = list.stream().sorted((o1, o2) -> {
      if (o1.length() > o2.length()) {
        return 1;
      } else if (o1.length() < o2.length()) {
        return -1;
      } else {
        int o1Sum = 0, o2Sum = 0;
        for (char c : o1.toCharArray()) {
          if (Character.isDigit(c)) {
            o1Sum += Integer.parseInt(String.valueOf(c));
          }
        }
        for (char c : o2.toCharArray()) {
          if (Character.isDigit(c)) {
            o2Sum += Integer.parseInt(String.valueOf(c));
          }
        }
        if (o1Sum < o2Sum) {
          return -1;
        } else if (o1Sum > o2Sum) {
          return 1;
        } else {
          return o1.compareTo(o2);
        }
      }
    }).collect(Collectors.toList());

    for (String str : list) {
      sb.append(str).append("\n");
    }

    System.out.println(sb);
  }

}
