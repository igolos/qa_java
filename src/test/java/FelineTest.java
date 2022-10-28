import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

public class FelineTest {
    @Test
    public void getFamilyReturnValidValue() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";

        String actualFamily = feline.getFamily();

        Assert.assertEquals("Не кошачьи", expectedFamily, actualFamily);
    }

    @Test
    public void getKittensReturnValidValue() {
        Feline feline = new Feline();
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();

        Assert.assertEquals("Другое число", expectedKittens, actualKittens);
    }

    @Test
    public void getKittensCountReturnValidValue() {
        Feline feline = new Feline();
        int expectedKittensCount = 2;
        int actualKittensCount = feline.getKittens(2);

        Assert.assertEquals("Другое число", expectedKittensCount, actualKittensCount);
    }
    //подскажите как реализовать параметризацию и где
}
