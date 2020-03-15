package AttendanceEvaluation;
import java.util.*;
import java.io.*;
/**
 * Temporary program. It is here only for help/reference. Not really needed.
 * @author yodenharsh
 */
public class date
{
    public static void main()throws IOException
    {
        System.out.println("Enter day");
        Scanner in=new Scanner(System.in);
        String sc=in.next();
        System.out.println("Enter month in words(all lowercase)");
        sc=" "+ in.next();
        System.out.println("Enter year");
        sc=" "+ in.next();
        FileReader fr=new FileReader("ok.txt");
        BufferedReader br=new BufferedReader(fr);
        while(br.readLine()!=null)
        {
            String str=br.readLine();
            if((str.startsWith(sc)))
            {
                System.out.println(str);
            }
        }
    }
}