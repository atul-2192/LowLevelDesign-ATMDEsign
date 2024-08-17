package ATMStates;

import ATMObj.*;
import AmountWithdrawal.*;

public class CashWithdrawalState extends ATMState {
    public CashWithdrawalState() {
        System.out.println("Please enter the withdrawal Amount");
        System.out.println("Enter amount in multiple of 100/500/2000");
    }

    public void cashWithdrawal(ATM atmObject, Card card, int withdrawalAmountRequest) {

        if (atmObject.getAtmBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the ATM Machine");
            exit(atmObject);
        } else if (card.getBankBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the ATM Machine");
            exit(atmObject);
        } else {
            card.deductBankBalance(withdrawalAmountRequest);
            atmObject.deductATMBalance(withdrawalAmountRequest);

            CashWithdrawProcessor withdrawProcessor = new TwoThousandWithdrawProcessor(
                    new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));

            withdrawProcessor.withdraw(atmObject, withdrawalAmountRequest);
            System.out.println("Please Collect Cash : "+ withdrawalAmountRequest);
            exit(atmObject);
        }

    }

    @Override
    public void exit(ATM atmObject) {
        returnCard();
        atmObject.setCurrentATMState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please Collect you Card");
    }
}
