/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.enumslab;

import static brucebreslin.swg.enumslab.MathOperator.ADD;
import static brucebreslin.swg.enumslab.MathOperator.DIVIDE;
import static brucebreslin.swg.enumslab.MathOperator.MULTIPLY;
import static brucebreslin.swg.enumslab.MathOperator.SUBTRACT;
import java.util.Scanner;

/**
 *
 * @author Bruce_Breslin
 */
public class MathOperatorApp {

    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        MathOperator userOperation = getUserOperation();
        int operand1 = getOperand();
        int operand2 = getOperand();
        int answer = calculate(userOperation, operand1, operand2);
        System.out.println("The answer to your problem is: " + answer + ".");

    }

    private static MathOperator getUserOperation() {
        System.out.println("What operation would you like to perform?(Enter number)");
        System.out.println("\n  1. Add\n  2. Subtract\n  3. Multiply\n  4. Divide");
        int userChoice = userInput.nextInt();
        switch (userChoice) {
            case 1:
                return ADD;
            case 2:
                return SUBTRACT;
            case 3:
                return MULTIPLY;
            case 4:
                return DIVIDE;
            default:
                throw new UnsupportedOperationException("Invalid entry. Please try again and enter the number that corresponds with the operation you would like to perform.");
        }
    }

    private static int getOperand() {
        System.out.println("Enter a number: ");
        return userInput.nextInt();
    }

    private static int calculate(MathOperator operator, int operand1, int operand2) {
        switch (operator) {
            case ADD:
                return operand1 + operand2;
            case SUBTRACT:
                return operand1 - operand2;
            case MULTIPLY:
                return operand1 * operand2;
            case DIVIDE:
                return operand1 / operand2;
            default:
                throw new UnsupportedOperationException("Please check your inputs and try again.");
        }
    }
}
