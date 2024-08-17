package ATMStates;
import ATMObj.*;

public class ATMState {
    public void insertCard(ATM atm,Card card){
        System.out.println("OOPS!! Something went Wrong");
    }
    public void authenticatePin(ATM atm,Card card, int pin){
        System.out.println("OOPS!! Something went Wrong");
    }
    public void selectOperation(ATM atm, Card card,int indexOfOperation)
    {
        System.out.println("OOPS!! Something went Wrong");
    }
    public void cashWithdrawal(ATM atm, Card card,int withdrawalAmountRequest)
    {
        System.out.println("OOPS!! Something went Wrong");
    }
    public void displayBalance(ATM atm,Card card){
        System.out.println("OOPS!! Something went Wrong");
    } 
    public void returnCard(){
            System.out.println("OOPS!! Something went Wrong");
    }
    public void exit(ATM atm){
        System.out.println("OOPS!! Something went Wromg");
    }
 
}
