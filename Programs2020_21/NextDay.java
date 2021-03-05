package Programs2020_21;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 1. Start
 2. Accept a Day int value
 3. Accept a Month int value
 4. Accept a Year int value
 5. check if the year is a multiple of 4, if yes, then boolean isLeapYear = true;
 6. if isLeapYear = true then use the leap array  date values
 7. If not then use normal date values
 8. if greater than month limit, roll over to next month
 9. Print
 10. End
 */
public class NextDay {
    int day, month, year; int[] leapYear={31,29,31,30,31,30,31,31,30,31,30,31},notLeapYear={31,28,31,30,31,30,31,31,30,31,30,31};
    NextDay(int day, int month, int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(in);
        System.out.println("Enter date, month, and then year (in DD-MM-YYYY), one by one:");
        int date=sc.nextInt();
        int month=sc.nextInt();
        int year=sc.nextInt();
        NextDay o = new NextDay(date,month,year);
        o.calc();
    }
    void calc(){
        //This if statement checks if the year is a leap year or not
        if(year%4==0) {
            for (int i =0; i <= leapYear.length - 1; i++) {
                if (day==leapYear[i]){
                    //condition for the last day of the year
                    if(month==12){
                        year++;
                        month=1;
                    }
                    //condition for the last day of any month other than the last day
                    else{
                        month++;
                    }
                    day=1;
                    break;
                }
                //condition for any other day
                else{
                    day++;
                    break;
                }
            }
        }
        else{
            for (int i=0; i <= notLeapYear.length - 1; i++) {
                if (day==notLeapYear[i]){
                    //condition for the last day of the year
                    if(month==12){
                        year++;
                        month=1;
                    }
                    //condition for the last day of any month other than the last day
                    else{
                        month++;
                    }
                    day=1;
                    break;
                }
                //condition for any other day
                else{
                    day++;
                    break;
                }
            }
        }
        out.println("The next day is (YYYY-MM-DD): "+year+"-"+month+"-"+day+".");
    }
}
