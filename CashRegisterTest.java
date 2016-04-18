import java.util.Scanner;
import static java.lang.Math.toIntExact;

/**
   A class to test the CashRegister class.
*/
public class CashRegisterTest
{
   public static void main(String[] args)
   {
      CashRegister register = new CashRegister();
      register.recordPurchase(7.12);
      register.enterPayment(10);
      // System.out.println(register.getPurcahse());
      // System.out.println("Price for first item: ");
      // Scanner in = new Scanner(System.in);
      // double price1 = in.nextDouble();
      // register.recordPurchase(price1);

      // System.out.println("Price for second item: ");
      // double price2 = in.nextDouble();
      // register.recordPurchase(price2);

      // System.out.println("Payment amount: ");
      // double paymentAmount = in.nextDouble();
      // register.enterPayment(paymentAmount);

      // in.close();

      // System.out.println(register.getPurcahse());
      // System.out.println(register.getPayment());



      double change = register.calculateChange();
      System.out.print("Your change is: ");
      System.out.println(change);


      String[] coins = register.giveCoins(change);

      System.out.println("The coins that make up your change are:");

      register.dashFormatting(coins);

      for (int i = 0; i < coins.length; i++){
         System.out.print(coins[i]);
      }
      System.out.print("\n");

      register.dashFormatting(coins);





   }
}
