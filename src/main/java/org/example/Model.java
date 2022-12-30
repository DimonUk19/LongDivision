package org.example;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private final StringBuilder result = new StringBuilder();
    private final List<String> digitForResult = new ArrayList<>();

    public String divide(int dividend, int divider) {

        String answer = "";
        if(dividend < 0 | divider < 0){
            answer += "-";
            if(dividend < 0 & divider < 0){
                answer ="";
            }
        }
        dividend = Math.abs(dividend);
        divider = Math.abs(divider);

        if (dividend < divider) {
            result.append(dividend + "|" + divider + "\n");
            result.append(assemblyString(Integer.toString(dividend).length(), ' ') + "|" +
                    assemblyString(Integer.toString(divider).length(), '-') + "\n");
            result.append(assemblyString(Integer.toString(dividend).length(), ' ') + "|0");
            return result.toString();
        }

        String numberForRun = "";
        String[] digits = String.valueOf(dividend).split("");

        for (int i = 0; i < digits.length; i++) {

            Integer reminderNumber;
            numberForRun += digits[i];
            reminderNumber = Integer.parseInt(numberForRun);

            if(reminderNumber >= divider){
                digitForResult.add(String.valueOf(reminderNumber));
                digitForResult.add(String.valueOf(reminderNumber - reminderNumber%divider));
                answer += reminderNumber/ divider;
                if(reminderNumber%divider == 0 & reminderNumber >= 10 & reminderNumber != dividend){
                    numberForRun = "";
                    answer += 0;
                }else{
                    numberForRun = String.valueOf(reminderNumber%divider);
                }
                if(i == digits.length-1){
                    digitForResult.add(String.valueOf(reminderNumber%divider));
                }

            }

        }
        digitForResult.set(0, String.valueOf(dividend));
        digitForResult.add(checkMethodPeriodAndChangeIfTrue(answer));
        return addToAnswer(dividend,divider);
    }
    private String addToAnswer(int dividend, int divider){
        int space = 1;
        result.append("_" + dividend + "|" + divider + "\n");
        result.append(" " + digitForResult.get(1) + assemblyString(digitForResult.get(0).length() - digitForResult.get(1).length(), ' ')
                + "|" + assemblyString(checkDividerOrAnswerLonger(divider,digitForResult.get(digitForResult.size() - 1)), '-') + "\n");
        result.append(assemblyString(space,' ') + assemblyString(digitForResult.get(1).length(), '-')
                + assemblyString(digitForResult.get(0).length() - digitForResult.get(1).length(), ' ')
                + "|" + digitForResult.get(digitForResult.size() - 1) + "\n");
        for(int i = 2, j = 1; i < (digitForResult.size() - 3); i+=2,j++){
            result.append(pairsNumbersDisplayRemainder(digitForResult.get(i), digitForResult.get(i+1),space = j));
            result.append(assemblyString(space = j + 1,' ') + assemblyString(digitForResult.get(i+1).length(),'-') + "\n");
        }
        result.append(assemblyString(space += digitForResult.get(digitForResult.size() - 3).length() - digitForResult.get((digitForResult.size() - 2)).length(),' ')
                + digitForResult.get((digitForResult.size() - 2)));
        return result.toString();
    }

    private String assemblyString(int numberOfSymbols, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            string.append(symbol);
        }
        return string.toString();
    }

    private String pairsNumbersDisplayRemainder(String firstNumber, String secondNumber, int amountSpaces) {
        String string = "";
        string += assemblyString(amountSpaces, ' ') + "_" + firstNumber + "\n";
        string += assemblyString(amountSpaces + 1, ' ') + secondNumber + "\n";
        return string;
    }

    private int checkDividerOrAnswerLonger(int divider,String answer) {
        if(Integer.toString(divider).length() > answer.length()){
            return Integer.toString(divider).length();
        }else {
            return answer.length();
        }
    }
    public String checkMethodPeriodAndChangeIfTrue(String answer){
        StringBuilder result = new StringBuilder();
        for(int i = 0;i < answer.length()-2;i++){
            if(i > 0 & answer.charAt(i) == answer.charAt(i+1) & answer.charAt(i) == answer.charAt(i+2)){
                result.append("(" + answer.charAt(i) + ")");
                return result.toString();
            }
            result.append(answer.charAt(i));
        }
        return answer;
    }
}