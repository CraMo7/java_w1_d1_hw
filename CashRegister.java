import static java.lang.Math.toIntExact;

/**
   A cash register totals up sales and computes change due.
*/
public class CashRegister
{
   private double purchase;
   private double payment;
   /**
      Constructs a cash register with no money in it.
   */
   public CashRegister()
   {
      purchase = 0;
      payment = 0;
   }

   /**
      Records the sale of an item.
      @param amount the price of the item
   */
   public void recordPurchase(double amount)
   {
      double total = purchase + amount;
      purchase = total;
   }

   /**
      Enters the payment received from the customer.
      @param amount the amount of the payment
   */
   public void enterPayment(double amount)
   {
      payment = amount;
   }

   /**
      Computes the change due and resets the machine for the next customer.
      @return the change due to the customer
   */
   public double calculateChange()
   {   
      double change = payment - purchase;
      purchase = 0;
      payment = 0;
      return change;
   }

   public String[] giveCoins(double changeAmount)
   {  

      // converting to integer (2 steps for clarity)
      long changePenniesLong = Math.round(changeAmount*100);
      int changePennies = Math.toIntExact(changePenniesLong);
      // apparently Math.toIntExact is new in Java 8

      //coin type counters:
      int twoPounds = 0, onePound = 0, fiftyPence = 0, twentyPence = 0, tenPence = 0, fivePence = 0, twoPence = 0, onePenny = 0;

      //results array:
      String[] coins = new String[8];

      // I tried to do this without if statements, as Val suggested for a bit of "hard mode" and a shot at the "100 points"(????) that are up for grabs.
      //I read up on lookup Hashes in java but I think I'd understand those much more easily if taught them in class rather than trying to learn from docs + youtube tutorials
      //a while loop was my first thought, but that's basically the same as a huge if-elseif-elseif chain anyway
      //So I did use if statements, but I found a more fun and interesting (to me) method of flow control, in using the continue keyword.
      // Although looping once for every penny in the change amount is likely a massive waste of clock time, I am attempting to migtigate this(successfully or not, I don't know enough about Java performance yet to say) by using continue to at least limit the of comparisons done per iteration to 1.
      // Remembering from class today that most time-intensive operations in java are creating new objects, I'm going to presume based on that that creating or altering variables is also slower than some other operations.
      //This is why I only altar variables when a coin-value amount is found, and do nothing other than fail the comparison on loops where no coin-value amount has been found.
      //Also the fact that the number of pennies unassigned to any coin (and therefore the number of iterations of my subsequent for loops) dwindles quickly after the first few loops tot up all the larger coin values.

      for (int pennies = changePennies; pennies > 0; pennies--){
         if (pennies % 200 != 0){
            continue;
         }
         changePennies -= 200;
         twoPounds++;
      }
      for (int pennies = changePennies; pennies > 0; pennies--) {
         if (pennies % 100 != 0){
            continue;
         }
         changePennies -= 100;
         onePound++;
      }
      for (int pennies = changePennies; pennies > 0; pennies--) {
         if (pennies % 50 != 0){
            continue;
         }
         changePennies -= 50;
         fiftyPence++;
      }
      for (int pennies = changePennies; pennies > 0; pennies--) {
         if (pennies % 20 != 0){
            continue;
         }
         changePennies -= 20;
         twentyPence++;
      }
      for (int pennies = changePennies; pennies > 0; pennies--) {
         if (pennies % 10 != 0){
            continue;
         }
         changePennies -= 10;
         tenPence++;
      }
      for (int pennies = changePennies; pennies > 0; pennies--) {
         if (pennies % 5 != 0){
            continue;
         }
         changePennies -= 5;
         fivePence++;
      }
      for (int pennies = changePennies; pennies > 0; pennies--) {
         if (pennies % 2 != 0){
            continue;
         }
         changePennies -= 2;
         twoPence++;
      }
      for (int pennies = changePennies; pennies > 0; pennies--) {
         if (pennies % 1 != 0){
            continue;
         }
         changePennies -= 1;
         onePenny++;
      }

      // this seems very ugly code but I enjoyed researching possibilities for how to do this any trying them out.

      coins[0] = String.format("| £2 x %1d|", twoPounds);
      coins[1] = String.format("| £1 x %1d|", onePound);
      coins[2] = String.format("|50p x %1d|", fiftyPence);
      coins[3] = String.format("|20p x %1d|", twentyPence);
      coins[4] = String.format("|10p x %1d|", tenPence);
      coins[5] = String.format("| 5p x %1d|", fivePence);
      coins[6] = String.format("| 2p x %1d|", twoPence);
      coins[7] = String.format("| 1p x %1d|", onePenny);

      // dashFormatting(coins);

      // for (int i = 0; i < coins.length; i++){
      //    System.out.print(coins[i] + " ");
      // }
      // System.out.print("\n");

      // dashFormatting(coins);

      return coins;

   }

   public static void dashFormatting(String[] coins){
      for (int i = 0; i < coins.length; i++){
         System.out.print("--------- ");
      }   
      System.out.print("\n");
   }


   public double getPayment()
   {
      return payment;
   }

   public double getPurchase()
   {
      return purchase;
   }


}
