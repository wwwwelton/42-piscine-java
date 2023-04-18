import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Map<Character, Integer> map = new HashMap<>();
    String str = scanner.nextLine();
    char[] charArray = str.toCharArray();
    for (char c : charArray) {
      if (!Character.isLetter(c))
        continue;
      if (map.containsKey(c))
        map.put(c, map.getOrDefault(c, 0) + 1);
      else
        map.put(c, 1);
    }
    char[] charArr = new char[map.size()];
    int[] freqArr = new int[map.size()];
    int count = 0;
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      charArr[count] = entry.getKey();
      freqArr[count] = entry.getValue();
      count++;
    }
    boolean isNotSorted = true;
    while (isNotSorted) {
      isNotSorted = false;
      for (int i = 0; i < (count - 1); i++) {
        int fTmp = freqArr[i];
        char cTmp = charArr[i];
        if (freqArr[i] == freqArr[i + 1] && Character.compare(charArr[i], charArr[i + 1]) < 0) {
          continue;
        }
        if (freqArr[i] <= freqArr[i + 1]) {
          freqArr[i] = freqArr[i + 1];
          charArr[i] = charArr[i + 1];
          freqArr[i + 1] = fTmp;
          charArr[i + 1] = cTmp;
          isNotSorted = true;
        }
      }
    }

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < i; j++) {
        System.out.print("# ");
      }
      System.out.println(freqArr[i] + " ");
    }
    for (int i = 0; i < 10; i++) {
      System.out.print(charArr[i] + " ");
    }
    System.exit(0);
  }
}
