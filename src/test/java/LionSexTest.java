import com.example.Lion;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.mock;
//
@RunWith(Parameterized.class)
public class LionSexTest {
    private Lion lion;

    private final boolean hasMane;
    private final String sex;

    public LionSexTest(String sex, boolean hasMane) {
        this.hasMane = hasMane;
        this.sex = sex;
    }

    @Before
    public void setUp() throws Exception {
        Feline feline = mock(Feline.class);
        lion = new Lion(feline, sex);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Самец", true },
                { "Самка", false },
        });
    }

    @Test
    public void doesHaveManeTest() {
        boolean hasManeActual = lion.doesHaveMane();
        Assert.assertEquals(hasMane, hasManeActual);
    }
}