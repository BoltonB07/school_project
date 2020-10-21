package com.rahil.GraphingCalculator;

public class Tan {
    static double tan(double angle){
        return Math.sin(angle)/Math.cos(angle);
    }

    private static double roundOff(double x, int howManyPlaces){
        return ((Math.round(x*Math.pow(10,howManyPlaces)))/Math.pow(10,howManyPlaces));
    }
    static boolean isCloseEnough(double x, double y){
        return roundOff((x - y),1)==0;  //Precision of the graph, lower = less precise ; higher = more precise
    }
    public static void main(String[] args) {
        double zoomLevel=30;                         //low is far, big is near
        final double zoom=(zoomLevel/Math.PI);
        for(int i=50;i>=-50;i--){ //Vertical (Y axis)
            for(int j=-200;j<=200;j++) {  //Horizontal (X axis)
                double x = (j / (3.0 * zoom));
                double y = (i / zoom);
                boolean equation = isCloseEnough(x,tan(y));
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
