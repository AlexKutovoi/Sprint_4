import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expected;

    public AccountTest(String name, boolean expected){
        this.name = name;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {"David Guetta", true},
                {"Da", false},
                {"D a", true},
                {"TestingDavid Gue", true},
                {" David", false},
                {"Guetta ", false},
                {"DavidGuetta", false},
                {"Da vid Guet ta", false},
                {null, false}
        };
    }
    @Test
    public void checkNameTest(){
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(actual, expected);
    }
}
