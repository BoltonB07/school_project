package Programs2019_20;

import java.util.*;
/**
 * Dit is een programma dat controleert als een zin dat je hebt gedrukt is een VVrij zin of niet.
 * Het programma is in Nederlands. This program is in Dutch
 * @author (your name)
 * @version (a version number or a date)
 */
public class VVrij
{
    String zin; char alphabet; boolean isVVrij;
    void krijgInformatie(){    //This is in Dutch (Use Google Translate if you don't believe me)
        Scanner sc=new Scanner(System.in);
        System.out.println("Druk een zin voor dit programma te berekenen als dit zin is VVrij or niet, alsjeblieft.");
        zin=sc.nextLine();
    }

    void bereken(){     int klinker=0;    //This is in Dutch as well
        for(int i=0;i<=zin.length()-1;i++){
            alphabet=zin.charAt(i);
            if(controleerKlinker(alphabet)==true){
                klinker++;
            }
            if(klinker>0)
            {isVVrij=true;}
        }
    }

    boolean controleerKlinker(char aplha){
        if(aplha=='A'||aplha=='E'||aplha=='I'||aplha=='O'||aplha=='U'||aplha=='a'||aplha=='e'||aplha=='i'||aplha=='o'||aplha=='u'){
            return true;
        }
        else{
            return false;
        }
    }

    void ZegWaarOfValse(){
        if(isVVrij==true){
            System.out.println("De zin dat jij hebt gedrukt is een VVrij zin.");
        }
        else{
            System.out.println("De zin dat jij hebt gedrukt in geen VVrij zin");
        }
    }
    public static void main(){
        VVrij voorwerp=new VVrij();
        voorwerp.krijgInformatie();
        voorwerp.bereken();
        voorwerp.ZegWaarOfValse();
    }
}
