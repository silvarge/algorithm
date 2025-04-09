package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SortNumber2750 {
  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> arr = new ArrayList<>();
    int count = Integer.parseInt(br.readLine());
    for (int i = 0; i < count; i++) {
      arr.add(Integer.parseInt(br.readLine()));
    }

    arr.stream()
        .sorted()
        .forEach(System.out::println);
  }
}
