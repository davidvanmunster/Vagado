package nl.han.ooad;

public class Results {

    private int totalScore = 0;
    private int bonusScore = 0;
    private int coins = 0;
    private boolean highScoreBeaten = false;

    public Results() {
    }

    public void addTotalScore(int amount) {
        totalScore += amount;
    }

    public void addCoins(int amount) {
        coins += amount;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getCoins() {
        return coins;
    }

    public boolean isHighScoreBeaten() {
        return highScoreBeaten;
    }

    public void setHighScoreBeaten(boolean highScoreBeaten) {
        this.highScoreBeaten = highScoreBeaten;
    }

    public int getBonusScore() {
        return bonusScore;
    }

    public void setBonusScore(int bonusScore) {
        this.bonusScore = bonusScore;
    }
}
