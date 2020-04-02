package nl.han.ooad;

public class Player {

    private int balance = 100;

    public void addBalance(int amount) {
        balance += amount;
    }

    public void subtractBalance(int amount) {
        balance -= amount;
    }
}
