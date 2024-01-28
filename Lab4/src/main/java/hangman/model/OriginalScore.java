package hangman.model;

public class OriginalScore implements GameScore{
    private int score = 100;


    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        if(incorrectCount >= 0 && correctCount >= 0 ) {
            score = 100 - (10 * incorrectCount);
        }
        if(score < 0){
            score = 0;
        }
        return score;
    }

    @Override
    public int getInitialScore() {
        score = 100;
        return score;
    }
}
