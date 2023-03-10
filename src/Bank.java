
public class Bank {

    Long currentBalance = 0L;

    private static void menu() {
        System.out.println("1 - check your balance");
        System.out.println("2 - credit your account");
        System.out.println("3 - debit your account");
    }

    private Long showBalance() {
        return currentBalance;
    }


    private Long creditBalance(Long amountCredited) {
        return currentBalance + amountCredited;
    }

    private Long debitBalance(Long amountDebited) {
        return currentBalance - amountDebited;
    }


}

