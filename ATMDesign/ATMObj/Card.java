package ATMObj;
public class Card {
    private int cardNumber;
    private int cvv;
    private int expiryDate;
    private String holderName;
    public int getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    public int getCvv() {
        return cvv;
    }
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    public int getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(int expiryDate) {
        this.expiryDate = expiryDate;
    }
    public String getHolderName() {
        return holderName;
    }
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    static int PIN_NUMBER=2192;
    private UserBankAccount bankAccount;
    public boolean isCorrectPINEntered(int pin)
    {
        if(pin==PIN_NUMBER)
        {
            return true;
        }
        return false;
    }
    public int getBankBalance(){
        return bankAccount.balance;
    }
    public void deductBankBalance(int amount)
    {
        bankAccount.withdrawalBalance(amount);
    }
    public void setBankAccount(UserBankAccount bankAccount)
    {
        this.bankAccount=bankAccount;
    }
}
