package ATMObj;
import ATMStates.*;

public class ATM{
    private static ATM atmObject=new ATM();
    ATMState currentATMState;

    private int atmBalance;
    int noOfTwoThousandNotes;
    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;

    private ATM(){

    }
    public void setCurrentATMState(ATMState currentATMState){
        this.currentATMState=currentATMState;
    }
    public ATMState getCurrentATMState(){
        return currentATMState;
    }
    public static ATM getATMObject(){
        atmObject.setCurrentATMState(new IdleState());
        return atmObject;
    }
    public int getAtmBalance(){
        return atmBalance;
    }
    public void setAtmBalance(int atmBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes)
    {
        this.atmBalance=atmBalance;
        this.noOfOneHundredNotes=noOfOneHundredNotes;
        this.noOfTwoThousandNotes=noOfTwoThousandNotes;
        this.noOfFiveHundredNotes=noOfFiveHundredNotes;
    }
    public int getNoOfTwoThousandNotes(){
        return noOfTwoThousandNotes;
    }
    public int getNoOfFiveHundredNotes(){
        return noOfFiveHundredNotes;
    }
    public int getNoOfOneHundredNotes(){
        return noOfOneHundredNotes;
    }
    public void deductATMBalance(int amount){
        atmBalance-=amount;
    }
    public void deductTwoThousandNotes(int number)
    {
        noOfTwoThousandNotes-=number;
    }
    public void deductOneHundredNotes(int number)
    {
        noOfOneHundredNotes-=number;
    }
    public void deductFiveHundredNotes(int number)
    {
        noOfFiveHundredNotes-=number;
    }
    public void  printCurrentATMStatus(){
        System.out.println("Balance: "+ atmBalance);
        System.out.println("2kNotes: "+ noOfTwoThousandNotes);
        System.out.println("500Notes: "+ noOfFiveHundredNotes);
        System.out.println("100Notes: "+noOfOneHundredNotes);
    }

}