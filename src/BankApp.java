// Абстрактный класс Client
abstract class Client {
    protected double balance;

    public Client(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Пополнение на " + amount + " рублей. Баланс: " + balance + " рублей.");
    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Снятие " + amount + " рублей. Баланс: " + balance + " рублей.");
    }

    public void printInfo() {
        System.out.println("Баланс: " + balance + " рублей.");
    }
}

// Класс для физических лиц
class Individual extends Client {
    public Individual(double balance) {
        super(balance);
    }
}

// Класс для юридических лиц
class LegalEntity extends Client {
    public LegalEntity(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amount) {
        double commission = amount * 0.01;
        super.withdraw(amount + commission);
        System.out.println("Комиссия за снятие: " + commission + " рублей.");
    }
}

// Класс для индивидуальных предпринимателей
class Entrepreneur extends Client {
    public Entrepreneur(double balance) {
        super(balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount < 1000) {
            double commission = amount * 0.01;
            super.deposit(amount - commission);
            System.out.println("Комиссия за пополнение: " + commission + " рублей.");
        } else {
            double commission = amount * 0.005;
            super.deposit(amount - commission);
            System.out.println("Комиссия за пополнение: " + commission + " рублей.");
        }
    }
}

public class BankApp {
    public static void main(String[] args) {
        // Пример использования
        Individual individual = new Individual(1000);
        individual.deposit(500);
        individual.withdraw(200);
        individual.printInfo();

        LegalEntity legalEntity = new LegalEntity(2000);
        legalEntity.deposit(1000);
        legalEntity.withdraw(500);
        legalEntity.printInfo();

        Entrepreneur entrepreneur = new Entrepreneur(1500);
        entrepreneur.deposit(800);
        entrepreneur.withdraw(300);
        entrepreneur.printInfo();
    }
}
