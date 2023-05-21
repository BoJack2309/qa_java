import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CatTest {
    private Cat cat;
    private Feline feline;

    @Before
    public void setUp(){
        feline = mock(Feline.class);
        cat = new Cat(feline);
    }

    @Test
    public void getSoundTest() {
        String sound = cat.getSound();
        Assert.assertEquals("Мяу", sound);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> food = new ArrayList<>();
        food.add("meat");
        when(feline.eatMeat()).thenReturn(food);
        List<String> catFood = cat.getFood();
        Assert.assertEquals(food, catFood);
    }
}