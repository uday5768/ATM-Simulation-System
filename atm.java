import java.util.ArrayList;
import java.util.Scanner;

class ATM {
    private long accountNo;
    private String name;
    private int pin;
    private double balance;
    private String mobileNo;

    public void setData(long accountNo, String name, int pin, double balance, String mobileNo) {
        this.accountNo = accountNo;
        this.name = name;
        this.pin = pin;
        this.balance = balance;
        this.mobileNo = mobileNo;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobile(String oldMobileNo, String newMobileNo) {
        if (oldMobileNo.equals(mobileNo)) {
            mobileNo = newMobileNo;
            System.out.println("\nSuccessfully Updated Mobile no.");
        } else {
            System.out.println("\nIncorrect !!! Old Mobile no");
        }
    }

    public void cashWithdraw(int amount) {
        if (amount > 0 && amount < balance) {
            balance -= amount;
            System.out.println("\nPlease Collect Your Cash");
            System.out.println("Available Balance: " + balance);
        } else {
            System.out.println("\nInvalid Input or Insufficient Balance");
        }
    }

    public void moneyDebit(int amount) {
        if (amount > 0 && amount < balance) {
            balance -= amount;
            System.out.println("\nMoney Transferred successfully !");
            System.out.println("Your account has a debit by transfer of " + amount);
            System.out.println("Available Balance: " + balance);
        } else {
            System.out.println("\nInvalid Input or Insufficient Balance");
        }
    }

    public void moneyCredit(String to, int amount) {
        balance += amount;
        System.out.println("\n" + to + "'s account has been credited with amount " + amount);
        System.out.println("Available Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ATM> accounts = new ArrayList<>();

        ATM user1 = new ATM();
        user1.setData(1010101, "Omprakash", 1111, 45000.90, "9087654321");
        accounts.add(user1);

        ATM user2 = new ATM();
        user2.setData(2020202, "Uday", 2222, 42000.00, "6370203478");
        accounts.add(user2);

        ATM user3 = new ATM();
        user3.setData(3030303, "Aditya", 3333, 52000.75, "9885673421");
        accounts.add(user3);

        ATM user4 = new ATM();
        user4.setData(4040404, "Simran", 4444, 50000.50, "8867046737");
        accounts.add(user4);

        do {
            System.out.println("\n*Welcome to ATM**");
            System.out.print("\nEnter Your User name: ");
            String username = scanner.next(); // username to be entered as i.e user1, user2, user3, user4
            char c = username.charAt(4);
            int x = Character.getNumericValue(c);
            System.out.print("\nEnter Your Account number: ");
            long enterAccountNo = scanner.nextLong();
            System.out.print("\nEnter PIN: ");
            int enterPIN = scanner.nextInt();

            if (enterAccountNo == accounts.get(x - 1).getAccountNo() && enterPIN == accounts.get(x - 1).getPin()) {
                do {
                    int choice, amount;
                    String oldMobileNo, newMobileNo, whom;
                    System.out.println("\n** Welcome to ATM ***");
                    System.out.println("Select Options ");
                    System.out.println("1. Check Balance");
                    System.out.println("2. Cash withdraw");
                    System.out.println("3. Show User Details");
                    System.out.println("4. Update Mobile no.");
                    System.out.println("5. Transfer Money");
                    System.out.println("6. Exit");

                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("\nYour current Bank balance is: " + accounts.get(x - 1).getBalance());
                            break;
                        case 2:
                            System.out.print("\nEnter the amount: ");
                            amount = scanner.nextInt();
                            accounts.get(x - 1).cashWithdraw(amount);
                            break;
                        case 3:
                            System.out.println("\n* User Details are :- ");
                            System.out.println("-> Account no  : " + accounts.get(x - 1).getAccountNo());
                            System.out.println("-> Name        : " + accounts.get(x - 1).getName());
                            System.out.println("-> Balance     : " + accounts.get(x - 1).getBalance());
                            System.out.println("-> Mobile No.  : " + accounts.get(x - 1).getMobileNo());
                            break;
                        case 4:
                            System.out.print("\nEnter Old Mobile No.: ");
                            oldMobileNo = scanner.next();
                            System.out.print("\nEnter New Mobile No.: ");
                            newMobileNo = scanner.next();
                            accounts.get(x - 1).setMobile(oldMobileNo, newMobileNo);
                            break;
                        case 5:
                            System.out.print("\nEnter username whom you want to transfer money: ");
                            whom = scanner.next(); // username to be entered as i.e user1, user2, user3, user4
                            char d = whom.charAt(4);
                            int y = Character.getNumericValue(d);
                            System.out.print("\nEnter the amount: ");
                            amount = scanner.nextInt();
                            accounts.get(x - 1).moneyDebit(amount);
                            accounts.get(y - 1).moneyCredit(whom, amount);
                            break;
                        case 6:
                            System.exit(0);
                        default:
                            System.out.println("\nEnter Valid Data !!!");
                    }

                } while (true);
            } else {
                System.out.println("\nUser Details are Invalid !!! ");
            }
        } while (true);
    }
}
