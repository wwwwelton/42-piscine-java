import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
  static String formatNote(String str) {
    StringBuilder sb = new StringBuilder();
    String arr[] = str.split(" ");
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += Integer.parseInt(arr[i]);
    }
    sum = sum / arr.length;
    for (int i = 0; i < sum; i++) {
      sb.append("=");
    }
    sb.append(">");
    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Map<Integer, String> weeks = new HashMap<>();
    int index = 0;
    while (true) {
      String week = scanner.nextLine();
      if (week.equals("42"))
        break;
      String tmp[] = week.split(" ");
      if (Integer.parseInt(tmp[1]) - 1 > index) {
        System.err.println("IllegalArgument");
        System.exit(-1);
      }
      index = Integer.parseInt(tmp[1]);
      if (index == 18) {
        System.err.println("Maximum number of weeks for the analysis is 18");
        break;
      }
      String notes = formatNote(scanner.nextLine());
      weeks.put(index, notes);
    }
    for (Map.Entry<Integer, String> entry : weeks.entrySet()) {
      System.out.println("Week " + entry.getKey() + " " + entry.getValue());
    }
    System.exit(0);
  }
}


