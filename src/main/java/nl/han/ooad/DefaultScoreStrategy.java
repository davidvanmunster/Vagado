package nl.han.ooad;

public class DefaultScoreStrategy implements ScoreStrategy {

    @Override
    public int getScoreCorrect() {
        return 10;
    }

    @Override
    public int getScoreAllCorrect() {
        return 50;
    }

    @Override
    public int calculateScoreSpeed(int time) {
        return 10000 / (time + 69) - 42;
    }
}
