class TransactionProcessing implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - Processing transaction - Count: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class BalanceUpdating implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - Updating balance - Count: " + i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class SMSNotification implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - Sending SMS notification - Count: " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class BankingThreads {
    public static void main(String[] args) {
        Thread transactionThread = new Thread(new TransactionProcessing());
        Thread balanceThread = new Thread(new BalanceUpdating());
        Thread smsThread = new Thread(new SMSNotification());

        transactionThread.setName("Transaction Thread");
        balanceThread.setName("Balance Thread");
        smsThread.setName("SMS Thread");

        transactionThread.start();
        balanceThread.start();
        smsThread.start();
    }
}
