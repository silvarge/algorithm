package set_and_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PocketMaster1620 {
  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] number = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    Map<String, Integer> pokemonDict = new HashMap<>();
    Map<Integer, String> reverseDict = new HashMap<>();
    // 도감
    for (int i = 1; i <= number[0]; i++) {
      String name = br.readLine();
      pokemonDict.put(name, i);
      reverseDict.put(i, name);
    }
    StringBuilder sb = new StringBuilder();
    // 문제
    for (int i = 0; i < number[1]; i++) {
      String readLine = br.readLine();
      if(pokemonDict.containsKey(readLine)) {
        sb.append(pokemonDict.get(readLine) + "\n");
      }else{
        sb.append(reverseDict.get(Integer.parseInt(readLine)) + "\n");
      }
    }
    System.out.println(sb);
  }
}
