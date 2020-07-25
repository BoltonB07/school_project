package com.rahil.GraphingCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * double evaluate(String eqn, double x) takes an equation in x and y in the form y=c_1 + c_2+ c_3... + c_n and a value for x and returns the value of y.
 * This algorithm is made by BoltonB07.
 * @author BoltonB07
 * @version 0.1.2 (24/7/2020)
 */
public class EquationReader {
    double evaluate(String eqn,double x){
        eqn=eqn.replaceAll(" ",""); //Gets rid of all spaces
        StringBuffer sb=new StringBuffer(eqn); //Assuming eqn is in y=c_1 + c_2+ c_3... + c_n form (for now at least.)
        int j;
        String coefft;
        double termValue;
        double yIs=0.0d;
        boolean isExponent=false;
        char[] symbols={'+','-','=','*','/','^','(',')'};
        for(int i=0;i<=sb.length()-1;i++){
            if(sb.charAt(i)=='x'){
                j=i; //Problem in next line: where x=5, 2x^2 = garbage
                while(j-1!=-1&&sb.charAt(j-1)!='='&&sb.charAt(j-1)!='+'&&sb.charAt(j-1)!='-'&&sb.charAt(j-1)!='/'&&sb.charAt(j-1)!='*'&&sb.charAt(j-1)!='^'&&sb.charAt(j-1)!='('&&sb.charAt(j-1)!=')') {
                    if(sb.charAt(j+1)=='^') {
                        isExponent=true;break;
                    }
                    j--;
                }
                coefft=sb.substring(j,i);
                if(isExponent){
                    sb.replace(j,i+1, "*("+x+")");
                }
                else if(coefft.length()!=0) {
                    termValue = Double.parseDouble(coefft) * x;
                    sb.replace(j, i + 1, String.valueOf(termValue));
                }
                else{
                    sb.replace(j,i+1, String.valueOf(x));
                }
                isExponent=false; //Re-initializing values for the next iteration.
                i=0;
            }
        }
        System.out.println(sb);
        for(int i=0;i<=sb.length()-1;i++){    //Assuming that the equation is in y=c_1 + c_2+ c_3... + c_n form.
            if(sb.charAt(i)=='=')
                yIs=Calculate.eval(sb.substring(i+1));
        }
        return yIs;
    }
    void test(){
        StringBuilder b=new StringBuilder("Apples");
        System.out.println(b.charAt(-1));
    }



    public static void main(String[] args) throws IOException {
        EquationReader o = new EquationReader();
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter an equation in the form of y=m_1x+...+m_nx+c_1+...+c_n:");
        String eqn=buff.readLine();
        System.out.println("Enter a value for x:");
        double x= Double.parseDouble(buff.readLine());
        System.out.println("\n"+eqn+" where x="+x);
        double i =o.evaluate(eqn,x);
        System.out.println("y="+i);
    }
}
