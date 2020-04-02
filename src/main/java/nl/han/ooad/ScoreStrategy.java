package nl.han.ooad;

public interface ScoreStrategy {

    int getScoreCorrect();

    int getScoreAllCorrect();

    int calculateScoreSpeed(int time);
}
