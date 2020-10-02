package com.rahil.GraphingCalculator;

public class ASCIIGrapher {
    static double tan(double angle){
        return Math.sin(angle)/Math.cos(angle);
    }

    private static double roundOff(double x, int howManyPlaces){
        return ((Math.round(x*Math.pow(10,howManyPlaces)))/Math.pow(10,howManyPlaces));
    }

    public static void notSomain(String[] args) {
        double precision=0.01;
        System.out.println("x,\t\tarctan(x)");
        for(double x=-Math.PI/2;x<=+Math.PI/2;x+=precision) {
            //System.out.println(roundOff(tan(x), 4) + ",\t\t" + roundOff(x, 4));
            print(roundOff(x,4));
        }

    }
    static void print(double value){
        int printAt=50-( (int) (value/0.05));
        //Each character will be 0.05 units
        for(int i=0;i<=100;i++){
            if(i==50&&printAt!=0){System.out.print("|");}
            else if(i==printAt){
                System.out.print(".");
            }
            else{System.out.print(" ");}
        }
        System.out.println();
    }

    static boolean isCloseEnough(double x, double y){

        return roundOff((x - y),1)==0;  //Precision of the graph, lower = less precise ; higher = more precise
    }
    public static void main(String[] args) {
        double zoomLevel=35;                         //low is far, big is near
        final double zoom=(zoomLevel/Math.PI);
        for(int i=50;i>=-50;i--){ //Vertical (Y axis)
            for(int j=-200;j<=200;j++) {  //Horizontal (X axis)
                double x = (j / (3.0 * zoom));
                double y = (i / zoom);
                boolean equation = isCloseEnough(tan(y), x);
                // Define Domain
                boolean domainLowerLim=-200<x;  //Default value: -200<x
                boolean domainHigherLim=200>x;  //Default value: 200>x
                //Define Range
                boolean rangeLowerLim=-50<y;    //Default value: -50<y
                boolean rangeHigherLim=50>y;    //Default value: 50>y
                if (domainLowerLim&&domainHigherLim&&rangeLowerLim&&rangeHigherLim) {
                    if (equation) {
                        System.out.print(".");
                    } else if (i == 0) {
                        if (j == 0)
                            System.out.print("+");
                        else
                            System.out.print("-");
                    } else if (j == 0) {
                        System.out.print("|");
                    } else
                        System.out.print(" ");
                }
                else{
                    if (i == 0) {
                        if (j == 0)
                            System.out.print("+");
                        else
                            System.out.print("-");
                    } else if (j == 0) {
                        System.out.print("|");
                    } else
                        System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
