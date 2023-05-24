import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
//
public class LionTest {
    private Lion lion;
    private Feline feline;

    @Before
    public void setUp() throws Exception {
        feline = mock(Feline.class);
        lion = new Lion(feline, "Самец");
    }

    @Test
    public void getKittensTest() {
        when(feline.getKittens()).thenReturn(10);
        int kittens = lion.getKittens();
        assertEquals(10, kittens);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> food = new ArrayList<>();
        food.add("meat");
        when(feline.getFood("Хищник")).thenReturn(food);
        List<String> actualFood = lion.getFood();
        assertEquals(food, actualFood);
    }
    @Test(expected = Exception.class)
    public void lionIncorrectInstance() throws Exception {
        new Lion(feline, "female");
    }
}
