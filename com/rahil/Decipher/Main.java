package com.rahil.Decipher;



import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    String[] charFreqArr={"e","t","a","o","i","n","s","h","r","d","l","c","u","m","w","f","g","y","p","b","v","k","j","x","q","z"}; //Most frequent to the least frequent
    String[] charArr={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    char[][] outputArr;
    char[][] inputArr;
    int[] freq=new int[26];
    String input, plainText;
    private void init() throws IOException {
        System.out.println("Please enter a sentence with no special characters apart from usual punctuations, and only ASCII characters.)");
        System.out.println("Note: 1) It will not decipher numbers\n2)Try to enter a sentence as long as possible");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        input=br.readLine();
        input=input.toLowerCase();
        System.out.println("Enter the plaintext");
        plainText = br.readLine();
        plainText = plainText.toLowerCase();

        for(int i=0;i<=freq.length-1;i++){
            freq[i]=0;
        }
        StringTokenizer tk= new StringTokenizer(input); //This part initializes outputArr with first dimension being the number of words and second dimension being the letters in those words
        outputArr=new char[tk.countTokens()][];
        for(int i=0;i<=outputArr.length-1;i++){
            outputArr[i]=new char[tk.nextToken().length()];
        }
        tk=new StringTokenizer(input);  //This part initializes inputArr with the same condition as the above comment
        inputArr=new char[tk.countTokens()][];
        for(int i=0;i<=inputArr.length-1;i++){
            inputArr[i]=new char[tk.nextToken().length()];
        }
        tk=new StringTokenizer(input);  //This part inputs the characters and words of String input in the array. To be used as alternative input.
        for(int i=0;i<=inputArr.length-1;i++){
            br=new BufferedReader(new StringReader(tk.nextToken()));
            for(int j=0;j<=inputArr[i].length-1;j++){
                inputArr[i][j]= (char) br.read();
            }
        }
    }
    private void freqCalc() {
        char temp;
        for(int i=0;i<=25;i++){
            for(int j=0;j<=input.length()-1;j++) {
                temp = input.charAt(j);
                if(temp==(charArr[i].charAt(0))){freq[i]++;}
            }
        }

        //sort the freq array in correspondence with the charArr.
        int tempVar;
        String tempString;
        for(int i=0;i<freq.length-1;i++){
            for(int j=0;j<freq.length-i-1;j++){
                if(freq[j+1]>freq[j]) {
                    tempVar = freq[j];
                    tempString = charArr[j];

                    freq[j] = freq[j + 1];
                    charArr[j] = charArr[j + 1];

                    freq[j + 1] = tempVar;
                    charArr[j + 1] = tempString;
                }
            }
        }
        for(int i=0;i<=freq.length-1;i++){System.out.print(freq[i]+charArr[i]+"\t");} //Optional; only for the programmer's quality of life
        System.out.println();
        //At least works till here. New problem: Replaces a word twice. Check changeAndPrint()
        //Problem understood: In the process of deciphering, the program changes the letter to a different letter
        //And later when that different letter needs to be swapped with another different letter, it swaps the previously swapped letter too.
    }

    private void changeAndPrint(){
        double numberOfCorrect=0.0, totalChars=0, accuracyPercentage;
        for(int i=0;i<=25;i++){
            searchAndInput(outputArr,inputArr,charArr[i],charFreqArr[i]);
        }
        ColorPrinter printer = new ColorPrinter();
        Color red = new Color(255, 0, 0, 100);
        Color green = new Color(0, 255, 0, 100);
        int index = 0;
        for(int j=0;j<=outputArr.length-1;j++){
            for(int k=0;k<=outputArr[j].length-1;k++){
                totalChars++;
                if (outputArr[j][k] == plainText.charAt(index)) {
                    printer.setBackground(green);
                    numberOfCorrect++;
                } else {
                    printer.setBackground(red);
                }
                printer.print(outputArr[j][k]);
                index++;
            }
            printer.setBackground(Color.WHITE);
            printer.print(" ");
            index++;
        }
        accuracyPercentage=(numberOfCorrect/totalChars)*100;
        System.out.println("Number of characters correct: "+numberOfCorrect+"\nOut of total: "+totalChars+"\nPercentage="+accuracyPercentage);
        printer.finish(640, 640);
    }
    private void searchAndInput(char[][] output, char[][] input, String replaceWhat,String replaceWith){
        for(int i=0;i<=input.length-1;i++){
            for(int j=0;j<=input[i].length-1;j++){
                if(input[i][j]==replaceWhat.charAt(0)){
                    output[i][j]=replaceWith.charAt(0);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main obj= new Main();
        obj.init();
        obj.freqCalc();
        obj.changeAndPrint();
    }
}