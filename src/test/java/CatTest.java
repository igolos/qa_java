import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Spy
    private Feline feline;

    @Test
    public void getSoundValidValue() {
        Cat cat = new Cat(feline);
        String expectedSound = "Мяу";

        String actualSound = cat.getSound();

        Assert.assertEquals("Not a cat sound", expectedSound, actualSound);
    }

    @Test
    public void getFoodValidValue() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(cat.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");


        List<String> actualFood = cat.getFood();

        Assert.assertEquals("Not a food for predator", expectedFood, actualFood);
    }
}
