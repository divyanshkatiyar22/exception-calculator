import java.util.Scanner;

class InvalidInputException extends Exception{
    public String toString(){
        return "You have given the wrong input!! This is not the valid input for calculation";
    }
}
class CannotDivideBy0Exception extends Exception{
    public String toString(){
        return "Divide any value by 0 is not possible in mathematics";
    }
}
class MaxInputException extends Exception{
    public String toString(){
        return "The input value cannot be exceed 100000";
    }
}
class MaxMultiplierReachedException extends Exception{
    public String toString(){
        return "The input for multiplication can not be exceed 70000";
    }
}

public class cw87__customCalculator{
    public static void addition(double a,double b){
        System.out.print("Answer is: "  + (a+b));
    }
    public static void substraction(double a,double b){
        System.out.print("Answer is: " + (a-b));
    }
    public static void multiplication(double a,double b) throws  MaxMultiplierReachedException{
        try{
            if(a>7000 || b>7000){
                throw new MaxMultiplierReachedException();
            }
            System.out.println("Answer is: " + (a*b));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void division(double a,double b)throws CannotDivideBy0Exception{
        try{
            if(b==0){
                throw new CannotDivideBy0Exception();
            }
            System.out.println("Answer is: " + (a/b));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter value 1");
        double a=sc.nextDouble();
        System.out.println("Enter value 2");
        double b=sc.nextDouble();
        System.out.println("What will you want to do with this values");
        // here string is used to enter the operator.
        String str=sc.next();
        try{
            if(a>100000 || b>100000){
                throw new MaxInputException();
            }
            try{
                if(str.equals("+")){
                    addition(a,b);
                }
                else if(str.equals("-")){
                    substraction(a,b);
                }
                else if(str.equals("*")){
                    multiplication(a,b);
                }
                else if(str.equals("/")){
                    division(a,b);
                }
                else{
                    throw new InvalidInputException();
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println("Thanks for using  my custom calculator.");

    }
}
