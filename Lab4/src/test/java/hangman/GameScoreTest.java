package hangman;

import hangman.model.BonusScore;
import hangman.model.OriginalScore;
import hangman.model.PowerScore;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class GameScoreTest {

    private final OriginalScore origin = new OriginalScore();
    private final BonusScore bonus = new BonusScore();
    private final PowerScore power = new PowerScore();
    @Test
    public void validateOriginPlay() {
        int result = origin.calculateScore(0, 0);
        Assert.assertEquals(100, result);
        result = origin.calculateScore(0, 1);
        Assert.assertEquals(90, result);
        result = origin.calculateScore(1, 1);
        Assert.assertEquals(90, result);
        result = origin.calculateScore(1, 2);
        Assert.assertEquals(80, result);
    }

    @Test
    public void validateBonusPalyscorrct(){
        int result = bonus.calculateScore(0, 0);
        Assert.assertEquals(0, result);
        result = bonus.calculateScore(1, 0);
        Assert.assertEquals(10, result);
        result = bonus.calculateScore(1, 1);
        Assert.assertEquals(5, result);
        result = bonus.calculateScore(2, 1);
        Assert.assertEquals(15, result);
    }

    @Test
    public void validateNotResiveNegativeNumber() {
        int result = origin.calculateScore(0, 0);
        Assert.assertEquals(100, result);
        result = origin.calculateScore(0, -1);
        Assert.assertEquals(100, result);
        result = bonus.calculateScore(0, -1);
        Assert.assertEquals(0, result);
        result = power.calculateScore(0, -1);
        Assert.assertEquals(0, result);
    }

    @Test
    public void validateOriginDownToNegativesNumbers() {
        int result = origin.calculateScore(0, 11);
        Assert.assertEquals(0, result);
    }

    @Test
    public void validatesPowerScoreNotPass500() {
        int result = power.calculateScore(1, 0);
        Assert.assertEquals(5, result);
        result = power.calculateScore(2, 0);
        Assert.assertEquals(30, result);
        result = power.calculateScore(3, 0);
        Assert.assertEquals(155, result);
        result = power.calculateScore(4, 0);
        Assert.assertEquals(500, result);
    }
    @Test
    public void validatesBonusOrPowerCouldHasNegativeScore() {
        int result = power.calculateScore(0, 1);
        Assert.assertEquals(0, result);
        result = power.calculateScore(0, 2);
        Assert.assertEquals(0, result);
    }

    @Test
    public void validates(){
        int result = bonus.calculateScore(0, 1);
        Assert.assertEquals(0, result);
        result = bonus.calculateScore(0, 2);
        Assert.assertEquals(0, result);
        result = bonus.calculateScore(1, 2);
        Assert.assertEquals(10, result);
    }
}
