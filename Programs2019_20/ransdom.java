package Programs2019_20;

class ransdom{

    public static void main(){
               int chancnum=(int)((Math.random()*100.0))%100;
              String  chance="0.0".concat(String.valueOf(chancnum));
               float roundOff=Float.parseFloat(chance);
               System.out.println(roundOff);
              float mutChance=0.1f;
               while(true){
               if(roundOff<mutChance){System.out.println("true");
                mutChance+=0.001;}
               
               else{System.out.println("false");}
            }
    }
}