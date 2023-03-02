package de.niklas.strings;

import java.util.Scanner;

public class RomanNumber {

    public RomanNumber(){
        String romanNumberString = readRomanNumber();
        String rightNumberString = convertToRightNumber(romanNumberString);
        int solution = convertToInteger(rightNumberString);
        System.out.printf("Der Wert der Zahl %s ist %s", romanNumberString, solution);
    }

    public String readRomanNumber(){
        System.out.print("Bitte geben Sie eine röm. Zahl ein: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public String convertToRightNumber(String romanNumberString){
        String convertNumber = romanNumberString;
        convertNumber = convertNumber.replaceAll("IV", " 4 ");
        convertNumber = convertNumber.replaceAll("IX", " 9 ");
        convertNumber = convertNumber.replaceAll("XL", " 40 ");
        convertNumber = convertNumber.replaceAll("XC", " 90 ");
        convertNumber = convertNumber.replaceAll("CD", " 400 ");
        convertNumber = convertNumber.replaceAll("CM", " 900 ");

        convertNumber = convertNumber.replaceAll("I", " 1 ");
        convertNumber = convertNumber.replaceAll("X", " 10 ");
        convertNumber = convertNumber.replaceAll("L", " 50 ");
        convertNumber = convertNumber.replaceAll("C", " 100 ");
        convertNumber = convertNumber.replaceAll("D", " 500 ");
        convertNumber = convertNumber.replaceAll("M", " 1000 ");

        convertNumber = convertNumber.replaceAll("  ", " ");

        return convertNumber;
    }

    public int convertToInteger(String numberString){
        String[] numberArr = numberString.split(" ");
        int solution = 0;

        for(int i = 1; i < numberArr.length; i++){
            solution += Integer.parseInt(numberArr[i]);
        }
        return solution;
    }

    public static void main(String[] args) {
        new RomanNumber();
    }
}
