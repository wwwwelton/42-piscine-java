import java.util.Scanner;

public class Program {
  static String convertStrToNote(String str) {
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
    String[] weeks = new String[18];
    int index = 0;
    int size = 0;
    while (true) {
      String week = scanner.nextLine();
      if (week.equals("42"))
        break;
      String tmp[] = week.split(" ");
      if (Integer.parseInt(tmp[1]) - 1 > index) {
        System.err.println("IllegalArgument");
        System.exit(-1);
      }
      index = Integer.parseInt(tmp[1]) - 1;
      if (index + 1 == 18) {
        System.err.println("Maximum number of weeks for the analysis is 18");
        break;
      }
      String notes = convertStrToNote(scanner.nextLine());
      weeks[index] = notes;
      size++;
    }
    for (int i = 0; i < size; i++) {
      System.out.println("Week " + (i + 1) + " " + weeks[i]);
    }
    System.exit(0);
  }
}


