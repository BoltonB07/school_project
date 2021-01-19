package Journal_Programs;

import java.util.Scanner;

public class DateNumber {
    int dayNum, dplusdx, dx, year;

    DateNumber(int dayNum, int dplusdx, int dx, int year) {
        this.dayNum = dayNum;
        this.dplusdx = dplusdx;
        this.dx = dx;
        this.year = year;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the day number:");
        int dayNum = sc.nextInt();
        System.out.println("Year:");
        int year = sc.nextInt();
        System.out.println("Enter the day after (in days)");
        int dx = sc.nextInt();
        int dplusdx = dayNum + dx;
        DateNumber o = new DateNumber(dayNum, dplusdx, dx, year);
        o.calc();
    }

    void calc() {
        System.out.print("Date: ");
        print(year, dayNum);
        System.out.print("Date after " + dx + " days: ");
        print(year, dplusdx);
    }

    void print(int year, int dayNum) {
        switch (year % 4) {
            case 0:
                //leap year
                if (dayNum >= 1 && dayNum <= 31)
                    System.out.println(dayNum + "th January, " + year);
                else if (dayNum >= 32 && dayNum <= 60)
                    System.out.println((dayNum - 31) + "th February, " + year);
                else if (dayNum >= 61 && dayNum <= 91)
                    System.out.println((dayNum - 60) + "th March, " + year);
                else if (dayNum >= 92 && dayNum <= 121)
                    System.out.println((dayNum - 91) + "th April, " + year);
                else if (dayNum >= 122 && dayNum <= 152)
                    System.out.println((dayNum - 121) + "th May, " + year);
                else if (dayNum >= 153 && dayNum <= 182)
                    System.out.println((dayNum - 152) + "th June, " + year);
                else if (dayNum >= 183 && dayNum <= 213)
                    System.out.println((dayNum - 181) + "th July, " + year);
                else if (dayNum >= 214 && dayNum <= 244)
                    System.out.println((dayNum - 213) + "th August, " + year);
                else if (dayNum >= 245 && dayNum <= 274)
                    System.out.println((dayNum - 243) + "th September, " + year);
                else if (dayNum >= 275 && dayNum <= 305)
                    System.out.println((dayNum - 274) + "th October, " + year);
                else if (dayNum >= 306 && dayNum <= 335)
                    System.out.println((dayNum - 305) + "th November, " + year);
                else if (dayNum >= 336 && dayNum <= 366)
                    System.out.println((dayNum - 335) + "th December, " + year);

                break;
            default:
                if (dayNum >= 1 && dayNum <= 31)
                    System.out.println(dayNum + "th January, " + year);
                else if (dayNum >= 32 && dayNum <= 59)
                    System.out.println((dayNum - 31) + "th February, " + year);
                else if (dayNum >= 60 && dayNum <= 90)
                    System.out.println((dayNum - 59) + "th March, " + year);
                else if (dayNum >= 91 && dayNum <= 120)
                    System.out.println((dayNum - 90) + "th April, " + year);
                else if (dayNum >= 121 && dayNum <= 151)
                    System.out.println((dayNum - 120) + "th May, " + year);
                else if (dayNum >= 152 && dayNum <= 181)
                    System.out.println((dayNum - 151) + "th June, " + year);
                else if (dayNum >= 182 && dayNum <= 212)
                    System.out.println((dayNum - 181) + "th July, " + year);
                else if (dayNum >= 213 && dayNum <= 243)
                    System.out.println((dayNum - 212) + "th August, " + year);
                else if (dayNum >= 244 && dayNum <= 273)
                    System.out.println((dayNum - 243) + "th September, " + year);
                else if (dayNum >= 274 && dayNum <= 304)
                    System.out.println((dayNum - 273) + "th October, " + year);
                else if (dayNum >= 305 && dayNum <= 334)
                    System.out.println((dayNum - 304) + "th November, " + year);
                else if (dayNum >= 335 && dayNum <= 365)
                    System.out.println((dayNum - 354) + "th December, " + year);
                break;
        }
    }
}