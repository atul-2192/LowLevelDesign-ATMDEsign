package ATMStates;

import ATMObj.ATM;
import ATMObj.Card;

public class HasCardState extends ATMState {
    public HasCardState() {
        System.out.println("Enter your card pin number");
    }

    @Override
    public void authenticatePin(ATM atm, Card card, int pin) {

        boolean isCorrectPINEntered = card.isCorrectPINEntered(pin);

        if (isCorrectPINEntered) {
            atm.setCurrentATMState(new SelectOperationState());

        } else {
            System.out.println("Invalid PIN Number");
            exit(atm);
        }

    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentATMState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
