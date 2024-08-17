package ATMObj;

public enum TransactionType {
    CASH_WITHDRAWAL,
    BALANCE_CHECK;

    public static void showAllTransactionTypes() {
        int index = 1;
        for (TransactionType type : TransactionType.values()) {
            System.out.println(index + "->" + type.name());
            index++;
        }
    }
}
