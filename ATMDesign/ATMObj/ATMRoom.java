package ATMObj;

import java.util.Scanner;
import ATMStates.CashWithdrawalState;

public class ATMRoom {
    ATM atm;
    User user;

    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();

        atmRoom.atm.printCurrentATMStatus();
        try (Scanner sc = new Scanner(System.in)) {
            atmRoom.atm.getCurrentATMState().insertCard(atmRoom.atm, atmRoom.user.card);
            int pin = sc.nextInt();
            atmRoom.atm.getCurrentATMState().authenticatePin(atmRoom.atm, atmRoom.user.card, pin);
            int indexOfOperation = sc.nextInt();
           
            atmRoom.atm.getCurrentATMState().selectOperation(atmRoom.atm, atmRoom.user.card, indexOfOperation);
            
            if(atmRoom.atm.getCurrentATMState() instanceof CashWithdrawalState)
            {
                int withdrawalAmountRequest = sc.nextInt();
                while (withdrawalAmountRequest % 100 != 0) {
                    System.out.println("Enter amount in multiple of 100/500/2000");
                    withdrawalAmountRequest = sc.nextInt();
    
                }
                atmRoom.atm.getCurrentATMState().cashWithdrawal(atmRoom.atm, atmRoom.user.card, withdrawalAmountRequest);
            }
           
        }
    }

    private void initialize() {
        atm = ATM.getATMObject();
        atm.setAtmBalance(3500, 1, 2, 5);

        this.user = createUser();
    }

    private Card createCard() {
        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    private User createUser() {
        User user = new User();
        user.setCard(createCard());
        return user;

    }

    private UserBankAccount createBankAccount() {
        UserBankAccount bankAccount = new UserBankAccount();
        bankAccount.balance = 3000;
        return bankAccount;
    }

}
