import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

class CurrencyConverter{
    private static double USD = 83.5;
    private static double EUR = 91.2;
    private static double GBP = 105.0;
    private static double JPY = 0.56;

    public static double conversion(String curr1, String curr2, double amt){
        double rate1 = 0, rate2 = 0;

        if(curr1.equals("USD")) rate1 = USD;
        else if(curr1.equals("EUR")) rate1 = EUR;
        else if(curr1.equals("GBP")) rate1 = GBP;
        else if(curr1.equals("JPY")) rate1 = JPY;

        if(curr2.equals("USD")) rate2 = USD;
        else if(curr2.equals("EUR")) rate2 = EUR;
        else if(curr2.equals("GBP")) rate2 = GBP;
        else if(curr2.equals("JPY")) rate2 = JPY;

        return amt * (rate1/rate2);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        List<String> currency = Arrays.asList("USD","EUR","GBP","JPY");

        System.out.print("From: ");
        String curr1 = sc.next().toUpperCase();
        System.out.print("To: ");
        String curr2 = sc.next().toUpperCase();
        System.out.print("Amount: ");
        double amt = sc.nextDouble();

        if(!currency.contains(curr1)||!currency.contains(curr2)){
            System.out.println("The currency entered has been invalid.");
            return;
        }

        if(curr1.equals(curr2)){
            System.out.println(amt +" "+ curr1 + " = " + amt + " " + curr2);
            System.out.println("You are converting the same currency. So there will be no change.");
        }
        else{
            double val = conversion(curr1,curr2,amt);
            System.out.println(amt +" "+ curr1 + " = " + String.format("%.4f", val) + " " + curr2);
        }
        
    }
}