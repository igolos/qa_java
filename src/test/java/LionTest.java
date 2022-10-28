import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Spy
    Feline feline;

    @Test
    public void constructorThrowsExceptionOnUnsupportedSex() {
        Exception exception = null;
        try {
            Lion lion = new Lion(feline,"Непонятно");
        } catch (Exception ex) {
            exception = ex;
        }
        Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }
    @Test
    public void hashManeTrue() throws Exception {
        Lion lion = new Lion(feline,"Самец");
        boolean expectedMane = true;

        boolean actualMane = lion.doesHaveMane();
        Assert.assertEquals("Does not have mane", expectedMane, actualMane);
    }
    @Test
    public void hashManeFalse() throws Exception {
        Lion lion = new Lion(feline,"Самка");
        boolean expectedMane = false;

        boolean actualMane = lion.doesHaveMane();
        Assert.assertEquals("Have mane", expectedMane, actualMane);
    }
    @Test
    public void getLionKittensValidValue() throws Exception {
        Lion lion=new Lion(feline, "Самец");
        int expectedLionKittens=1;
        Mockito.when(lion.getKittens()).thenReturn(1);
        int actualLionKittens=lion.getKittens();
        Assert.assertEquals("Not valid value", expectedLionKittens, actualLionKittens);
    }
@Test
    public void getFoodLionValidValue() throws Exception{
    Lion lion=new Lion(feline, "Самец");
    Mockito.when(lion.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
    List<String> expectedFoodLion = List.of("Животные", "Птицы", "Рыба");

    List<String> actualFoodLion = lion.getFood();

    Assert.assertEquals("Not a food for predator", expectedFoodLion, actualFoodLion);
}


}