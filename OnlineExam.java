class RemainingTime implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - Remaining Time: " + (10 - i) + " minutes");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class AutoSave implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - Saving answers automatically");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class NetworkCheck implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - Checking network connection");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class OnlineExam {
    public static void main(String[] args) {
        Thread timeThread = new Thread(new RemainingTime());
        Thread saveThread = new Thread(new AutoSave());
        Thread networkThread = new Thread(new NetworkCheck());

        timeThread.setName("Time Thread");
        saveThread.setName("Auto-Save Thread");
        networkThread.setName("Network Thread");

        timeThread.start();
        saveThread.start();
        networkThread.start();
    }
}
