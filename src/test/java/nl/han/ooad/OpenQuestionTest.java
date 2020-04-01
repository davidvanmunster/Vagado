package nl.han.ooad;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OpenQuestionTest {

    private OpenQuestion sut;

    @BeforeEach
    void setUp() {
        sut = new OpenQuestion("Test question?", new ArrayList<>(List.of(
                new Answer("yes")
        )));
    }

    @Test
    void checkAnswerReturnsTrueIfCorrect() {
        Answer testAnswer = new Answer("yes");
        assertEquals(true, sut.checkAnswer(testAnswer));
    }

    @Test
    void checkAnswerReturnsFalseIfIncorrect() {
        Answer testAnswer = new Answer("noq");
        assertEquals(false, sut.checkAnswer(testAnswer));
    }
}