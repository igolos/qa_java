import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

@RunWith(value = Parameterized.class)
public class LionTest {
   String sexLion;
   boolean hasManeResult;

    public LionTest(String sexLion, boolean hasManeResult) {
        this.sexLion = sexLion;
        this.hasManeResult = hasManeResult;
    }
    @Parameterized.Parameters
    public static Object[] getParams()
    {
        return new Object[][]
                {
                        {"Самец", true},
                        {"Самка", false}
                };
    }
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
    @Spy
    Feline feline;

    @Test
    public void constructorThrowsExceptionOnUnsupportedSex() {
        Exception exception = null;
        try {
            Lion lion = new Lion(feline, "Непонятно");
        } catch (Exception ex) {
            exception = ex;
        }
        Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    @Test
    public void hasManeTrue() throws Exception {
      Lion lion = new Lion(feline, sexLion);

    Assert.assertEquals(lion.doesHaveMane(),hasManeResult);
    }


    @Test
    public void getLionKittensValidValue() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        int expectedLionKittens = 1;
        Mockito.when(lion.getKittens()).thenReturn(1);
        int actualLionKittens = lion.getKittens();
        Assert.assertEquals("Not valid value", expectedLionKittens, actualLionKittens);
    }

    @Test
    public void getFoodLionValidValue() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(lion.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFoodLion = List.of("Животные", "Птицы", "Рыба");

        List<String> actualFoodLion = lion.getFood();

        Assert.assertEquals("Not a food for predator", expectedFoodLion, actualFoodLion);
    }
}