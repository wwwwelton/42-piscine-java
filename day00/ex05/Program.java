import java.util.Scanner;

public class Program {
  private static String[] getStudents() {
    Scanner scanner = new Scanner(System.in);
    String[] students = new String[10];
    int i = 0;
    while (true) {
      if (i == 10) {
        System.err.println("Max allowed students is 10.");
        break;
      }
      String student = scanner.nextLine();
      if (student.length() > 10) {
        System.err.println("Max allowed characters for an student name is 10.");
        i--;
        continue;
      }
      if (student.equals(".")) {
        break;
      }
      students[i] = student;
      i++;
    }
    return students;
  }

  private static String[][] getClasses() {
    Scanner scanner = new Scanner(System.in);
    String[][] classes = new String[10][2];
    int i = 0;
    while (true) {
      if (i == 10) {
        System.err.println("Max allowed classes is 10.");
        break;
      }
      String classEntry = scanner.nextLine();
      if (classEntry.equals(".")) {
        break;
      }
      classes[i] = classEntry.split(" ");
      i++;
    }
    return classes;
  }

  private static String[][] getAttendances() {
    Scanner scanner = new Scanner(System.in);
    String[][] attendances = new String[10][4];
    int i = 0;
    while (true) {
      String attendance = scanner.nextLine();
      if (attendance.equals(".")) {
        break;
      }
      attendances[i] = attendance.split(" ");
      i++;
    }
    return attendances;
  }

  private static int getDay(String day) {
    day = day.toUpperCase();
    if (day.equals("SU"))
      return 1;
    if (day.equals("MO"))
      return 2;
    if (day.equals("TU"))
      return 3;
    if (day.equals("WE"))
      return 4;
    if (day.equals("TH"))
      return 5;
    if (day.equals("FR"))
      return 6;
    if (day.equals("SA"))
      return 7;
    return 0;
  }

  private static void plotAttendances(String[] students, String[][] classes,
      String[][] attendances) {
    int studentsSize = 0;
    for (int i = 0; i < students.length; i++) {
      if (students[i] != null) {
        studentsSize++;
      }
    }
    int classesSize = 0;
    for (int i = 0; i < classes.length; i++) {
      if (classes[i][0] != null) {
        classesSize++;
      }
    }
    int attendancesSize = 0;
    for (int i = 0; i < attendances.length; i++) {
      if (attendances[i][0] != null) {
        attendancesSize++;
      }
    }
    System.out.print("           ");
    for (int i = 0, j = 0, week = 0; i < 10; i++, j++) {
      if (j >= classesSize) {
        j = 0;
        week += 7;
      }
      int day = getDay(classes[j][1]) + week;
      String space = (day < 10) ? "0" : "";
      String paddedString = String.format("%-" + 12 + "s",
          classes[j][0] + ":00 " + classes[j][1] + " " + space + day + "|");
      System.out.print(paddedString);
    }
    System.out.println();

    for (int i = 0; i < studentsSize; i++) {
      String paddedString = String.format("%-" + 19 + "s", students[i]);
      System.out.print(paddedString);
      String[] markedDays = new String[10];
      for (int j = 0, k = 0, week = 0; j < 10; j++, k++) {
        if (k >= classesSize) {
          k = 0;
          week += 7;
        }
        int day = getDay(classes[k][1]) + week;
        for (int l = 0; l < attendancesSize; l++) {
          if (students[i].equals(attendances[l][0])) {
            if (attendances[l][2].equals(Integer.toString(day))
                && attendances[l][1].equals(classes[k][0])) {
              if (attendances[l][3].equals("HERE")) {
                markedDays[j] = "1";
              } else {
                markedDays[j] = "-1";
              }
            }
          }
        }
      }
      for (int x = 0; x < 10; x++) {
        if (markedDays[x] != null) {
          if (markedDays[x].equals("1")) {
            String printStr = String.format("%-" + 12 + "s", " 1|");
            System.out.print(printStr);
          } else if (markedDays[x].equals("-1")) {
            String printStr = String.format("%-" + 12 + "s", "-1|");
            System.out.print(printStr);
          }
        } else {
          String printStr = String.format("%-" + 12 + "s", "  |");
          System.out.print(printStr);
        }
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    String[] students = getStudents();
    String[][] classes = getClasses();
    String[][] attendances = getAttendances();

    plotAttendances(students, classes, attendances);
  }

}

// STUDENTS LIST
// John
// Mike
//
// STOP ENTRY
// .
//
// HOUR MONDAY
// 2 MO
// 4 WE
//
// STOP ENTRY
// .
// Mike 2 28 NOT_HERE
// John 4 9 HERE
// Mike 4 9 HERE

// NAME HOUR DAY STATUS
// Mike 4 9 HERE
// John 4 9 NOT_HERE


