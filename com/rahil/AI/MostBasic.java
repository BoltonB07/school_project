package com.rahil.AI;

public class MostBasic {
    public static void main(String[] args) {
        double neuron=5.00;int random;
        while(true){
            random = ((Math.random()*10>neuron))?2:1;
            if(random==1)
                neuron-=neuron/2;
            else{
             if(Math.random()>0.5)
                 neuron+=Math.random()/10;
             else
                 neuron+=Math.random()/10;
            }
        System.out.println("NEURON: "+neuron+"\tNUMBER: "+random);
        }
    }

}
