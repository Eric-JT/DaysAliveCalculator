import java.util.*;
import java.util.Scanner;

public class DaysAliveTwo {



  public static boolean isLeapYear(int year){
    // check if the year is a Leap Year

    if (year % 400 == 0) {
      return true;
    }
    else if (year % 100 == 0){
      return false;
    }
    else if (year % 4 == 0){
      return true;
    }
    else{
      return false;
    }
  }

  public static int daysInMonth(int year, int month){
    // check how many days in the there there are
    int days = 0;
    switch (month) {
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        days = 31;
        break;
      case 4:
      case 6:
      case 9:
      case 11:
        days = 30;
        break;
      case 2:
        if(isLeapYear(year)){
          days = 29;
        }
        else {
          days = 28;
        }
        break;
      default:
        System.out.println("You fucked up your inputs, Bitch!");
        break;
      }
      return days;
  }

  public static int[] nextDay(int[] date){

    if (date[2] < daysInMonth(date[0], date[1])){
      //date[0], date[1], date[2] = year, month, day++;
      date[0] = date[0];
      date[1] = date[1];
      date[2] = ++date[2];
      return date;
    }
    else {
      if (date[1] == 12) {
        //date[0], date[1], date[2] = year++, 1, 1;
        date[0] = ++date[0];
        date[1] = 1;
        date[2] = 1;
        return date;
      }
      else {
        //date[0], date[1], date[2] = year, month++, 1;
        date[0] = date[0];
        date[1] = ++date[1];
        date[2] = 1;
        return date;
      }
    }
  }

  public static boolean isDateBefore(int[] dateOne, int[] dateTwo){
    // Checks if valid dates
    if (dateOne[0] < dateTwo[0]){
      return true;
    }
    else if (dateOne[0] ==  dateTwo[0]){
      if (dateOne[1] < dateTwo[1]){
        return true;
      }
      else if (dateOne[1] == dateTwo[1]){
        return dateOne[2] < dateTwo[2];
      }
    }
    return false;
  }

  // Work on This method

  public static int daysBetweenDates(int[] dateOne, int[] dateTwo){

    int days = 0;
    while (isDateBefore(dateOne, dateTwo)){
      dateOne = nextDay(dateOne);
      //month1 = nextDay(year1, month1, day1);
      //day1 = nextDay(year1, month1, day1);
      days+=1;
    }
    return days;
  }

  public static void main(String[] args) {
      int[] dateOne = new int[3];

      int[] dateTwo = new int[3];

    Scanner usrInput = new Scanner(System.in);
    System.out.println("Enter year of birth: ");
    dateOne[0] = usrInput.nextInt();
    System.out.println("Enter month of birth: ");
    dateOne[1] = usrInput.nextInt();
    System.out.println("Enter day of birth: ");
    dateOne[2] = usrInput.nextInt();
    System.out.println("Enter current year: ");
    dateTwo[0] = usrInput.nextInt();
    System.out.println("Enter current month: ");
    dateTwo[1] = usrInput.nextInt();
    System.out.println("Enter current day: ");
    dateTwo[2] = usrInput.nextInt();

    System.out.println(daysBetweenDates(dateOne, dateTwo));

  }
}
