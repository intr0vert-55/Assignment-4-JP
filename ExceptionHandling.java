import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.lang.Character;

public class ExceptionHandling {
    public static void main(String [] args){
        divideByZero();
        myException();
        checkPhoneNumber();
        balanceException();
        try{
            Calculator calculator = new Calculator();
            calculator.calculate(1, 5, "+");
            calculator.calculate(10, 32, "*");
            calculator.calculate(1, 0, "/");
        } catch(IllegalOperationException e){
            e.printStackTrace();
        }
    }

    public static void divideByZero(){
        try{
            int num = 12/0;
            System.out.println("Result : " + num);
        } catch(ArithmeticException ae){
            System.out.println("Caught Arithmetic Exception because of the attempt to divide by zero");
        }
    }

    public static void myException(){
        try{
            throw new MyException();
        } catch(MyException me){
            me.printStackTrace();
        }
    }

    public static void checkPhoneNumber(){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter phone number : ");
        String phoneNum = s.nextLine();
        try{
            for(char ch : phoneNum.toCharArray()){
                if(!Character.isLetter(ch)){
                    throw new InputMismatchException();
                }
            }
        } catch(InputMismatchException ie){
            System.out.println("No characters are allowed in a phone number!!");
            ie.printStackTrace();
        } finally{
            s.close();
        }
    }

    public static void balanceException(){
        Bank bank = new Bank(1000);
        bank.deposit(2000);
        try{
            bank.withdraw(500);
            bank.withdraw(5000);
        } catch(InsufficientBalanceException ie){
            ie.printStackTrace();
        }
    }
}

class MyException extends Exception{
    MyException(){
        super("This is the exception I created");
    }
}

class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(int balance){
        super("You don't have enough balance. Your balance : " + balance);
    }
}

class IllegalOperationException extends Exception{
    IllegalOperationException(String message){
        super(message);
    }
    IllegalOperationException(String message, ArithmeticException ae){
        super(message);
        ae.printStackTrace();
    }
}

class Bank{
    private int balance;
    Bank(int balance){
        this.balance = balance;
    }
    public void deposit(int amount){
        balance += amount;
    }
    public void withdraw(int amount) throws InsufficientBalanceException{
        if(balance < amount)    throw new InsufficientBalanceException(balance);
        balance -= amount;
    }
}

class Calculator{
    public String calculate(int operand1, int operand2, String operation) throws IllegalOperationException{
        this.validateOperation(operation);
        int result = 0;
        switch (operation) {
            case "*":
                result = multiplication(operand1, operand2);
                break;
            case "/":
                result = divide(operand1, operand2);
                break;
            case "+":
                result = addition(operand1, operand2);
                break;
            default:
                throw new IllegalOperationException(String.format("Operation '%s' does not exist", operation));
        }
        return String.format("%s %s %s = %s", operand1, operation, operand2, result);
    }
    private void validateOperation(String operation) {
        if (Objects.isNull(operation)) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        if (operation.isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }
    }
    private int multiplication(int operand1, int operand2) {
        return operand1 * operand2;
    }
    private int addition(int operand1, int operand2) {
        return operand1 + operand2;
    }
    private int divide(int operand1, int operand2) throws IllegalOperationException{
        try {
            return operand1 / operand2;
        } catch (ArithmeticException ex) {
            throw new IllegalOperationException("Division by zero is not allowed", ex);
        }
    }
}
