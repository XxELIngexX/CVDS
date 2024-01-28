package hangman.model;

public interface GameScore {

    /**
     * Let me know the game's score
     * @param correctCount Number of correct letters
     * @param incorrectCount Number of incorrect letters
     * @return The score at the end of the turn
     */
    public int calculateScore(int correctCount,int incorrectCount);

    /**
     * Get the start score
     * @return the initial score
     */
    public int getInitialScore();
    }

