package ATMStates;

import java.util.ArrayList;

import ATMObj.*;

public class SelectOperationState extends ATMState {
    ArrayList<TransactionType> transactionTypeList = new ArrayList<>();

    public SelectOperationState() {

        for (TransactionType type : TransactionType.values()) {
            transactionTypeList.add(type);
        }
        showOperations();
    }

    @Override
    public void selectOperation(ATM atmObject, Card card, int indexOfOperation) {
     
        if(indexOfOperation>transactionTypeList.size()){
            exit(atmObject);
            return;
        }
        TransactionType transactionType = transactionTypeList.get(indexOfOperation-1);

        switch (transactionType) {
            case CASH_WITHDRAWAL:
                atmObject.setCurrentATMState(new CashWithdrawalState());
                
                break;
            case BALANCE_CHECK:

                atmObject.setCurrentATMState(new CheckBalanceState(atmObject,card));
              
                break;
            default: {
             
                exit(atmObject);

            }
        }

    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Invalid Operation Selected");
      
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }

    private void showOperations() {
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionTypes();
    }
}
