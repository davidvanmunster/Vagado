package nl.han.ooad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);
    private Quiz currentQuiz;
    private List<Quiz> quizzes = new ArrayList<>();
    private Player player;
    private int currentQuestionIndex = 0;

    public Game(Player player) {
        this.player = player;


        quizzes.add(new Quiz("Trivia", 5, true));
        quizzes.get(0).addOpenQuestion(
                "Wat is het snelst verkocht product in winkels de laatste periode?", new ArrayList<>(List.of(
                        new Answer("toiletpapier"),
                        new Answer("toilet papier"),
                        new Answer("toilet-papier"),
                        new Answer("wcpapier"),
                        new Answer("wc papier"),
                        new Answer("wc-papier")
                )));

        quizzes.get(0).addMultipleChoiceQuestion(
                "1 + 1 = ?", new Answer("2"), new ArrayList<>(List.of(
                        new Answer("3"),
                        new Answer("4"),
                        new Answer("5")
                )));

        quizzes.get(0).addOpenQuestion(
                "Een appel valt niet ver van een ?", new ArrayList<>(List.of(
                        new Answer("boom")
                )));

        quizzes.get(0).addMultipleChoiceQuestion(
                "COVID-?", new Answer("19"), new ArrayList<>(List.of(
                        new Answer("21"),
                        new Answer("420"),
                        new Answer("69")
                )));

        quizzes.get(0).addOpenQuestion(
                "IntelliJ of Eclipse?", new ArrayList<>(List.of(
                        new Answer("intellij"),
                        new Answer("eclipse")
                )));

        quizzes.get(0).addMultipleChoiceQuestion(
                "Waarom was een man gearresteerd in het Technovium?", new Answer("Hij had een nepwapen."), new ArrayList<>(List.of(
                        new Answer("Hij heeft alle broodjes in de kantine gestolen."),
                        new Answer("Hij sloeg alle leraren kapot."),
                        new Answer("Hij was buitenlands.")
                )));

        quizzes.get(0).addOpenQuestion(
                "Hoe worden mensen uit India genoemd?", new ArrayList<>(List.of(
                        new Answer("indiase"),
                        new Answer("indische"),
                        new Answer("indisch"),
                        new Answer("indiaas")
                )));

        quizzes.get(0).addMultipleChoiceQuestion(
                "Wat is de nieuwe kleur van de nieuwe huisstijl van de HAN?", new Answer("#e50056"), new ArrayList<>(List.of(
                        new Answer("#9b59b6"),
                        new Answer("#e74c3c"),
                        new Answer("#e67e22")
                )));

        quizzes.get(0).addOpenQuestion(
                "Noem één van de populairste huisdiersoorten.", new ArrayList<>(List.of(
                        new Answer("kat"),
                        new Answer("poes"),
                        new Answer("huiskat"),
                        new Answer("hond"),
                        new Answer("goudvis"),
                        new Answer("vis")
                )));

        quizzes.get(0).addMultipleChoiceQuestion(
                "Wat is de gemiddelde studieschuld?", new Answer("€21.000 tot €24.000"), new ArrayList<>(List.of(
                        new Answer("€17.000 tot €21.000"),
                        new Answer("€13.000 tot €17.000"),
                        new Answer("€9.000 tot €13.000")
                )));

        quizzes.add(new Quiz("Test Trivia", 5, true));
        quizzes.get(1).addMultipleChoiceQuestion(
                "1 3 1 6 1 9 ? ?", new Answer("1 12"), new ArrayList<>(List.of(
                        new Answer("1 11"),
                        new Answer("200"),
                        new Answer("Kan je niet weten.")
                )));
    }

    public void play() {
        while (true) {
            System.out.println("\nPlease select a quiz: ");
            for (int i = 0; i < quizzes.size(); i++) {
                System.out.println(i + ": " + quizzes.get(i).getName());
            }
            String quizId = scanner.nextLine();
            selectQuiz(Integer.parseInt(quizId));
            for (int i = 0; i < currentQuiz.getQuestionsCount(); i++) {
                System.out.println(getCurrentQuestion().getQuestion());
                String answer = scanner.nextLine();
                printAnswerFeedback(answerQuestion(new Answer(answer)));
            }
            printResults();
            currentQuestionIndex = 0;
        }
    }

    private void selectQuiz(int quizId) {
        currentQuiz = quizzes.get(quizId);
        currentQuiz.startStopWatch();
    }

    public boolean answerQuestion(Answer inputAnswer) {
        boolean checkedAnswer = currentQuiz.answerQuestion(inputAnswer, currentQuestionIndex);
        currentQuestionIndex++;
        return checkedAnswer;
    }

    public void printAnswerFeedback(boolean checkedAnswer) {
        if (checkedAnswer) {
            System.out.println("Correct answer!\n");
        } else {
            System.out.println("Incorrect answer!\n");
        }
    }

    public void printResults() {
        Results results = currentQuiz.getResults();
        String print = "Congratulations!";
        if (results.isHighScoreBeaten()) {
            print += "\nYou've beaten your high score with: " + results.getTotalScore();
        } else {
            print += "\nTotal score: " + results.getTotalScore();
        }
        print += "\nIncluding " + results.getBonusScore() + " bonus points.";
        player.addBalance(results.getCoins());
        print += "\nYou've received " + results.getCoins() + " coins.";
        System.out.println(print);
    }

    public Question getCurrentQuestion() {
        return currentQuiz.getQuestion(currentQuestionIndex);
    }
}
