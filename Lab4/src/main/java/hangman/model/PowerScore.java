package hangman.model;
import java.lang.Math;
public class PowerScore implements GameScore{
    private int score = 0;
    private int previousIncorrect =0;
    private int previousCorrect = 0;
    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        if(previousCorrect < correctCount ){
            previousCorrect = correctCount;
            score += Math.pow(5,correctCount);
        }else if(previousIncorrect < incorrectCount && score > 0){
            previousIncorrect = incorrectCount;
            score -= 8;
        }
        if(score >= 500){
            score = 500;
        }
        return score;
    }

    @Override
    public int getInitialScore() {
        score = 0;
        previousCorrect = 0;
        previousIncorrect = 0;
        return score;
    }

}
