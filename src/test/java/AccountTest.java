import io.qameta.allure.junit4.DisplayName;
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
                {"David Guetta", true }, //example correct name
                {"", false}, //no symbol""
                {"Da", false}, //2 symbol
                {"D a", true}, // 3 symbol
                {"TestingDavid Guetta", true}, // 19 symbol
                {" David", false}, // space begin line
                {"Guetta ", false}, // space end line
                {"DavidGuetta", false}, // no space
                {"Da vid Guet ta", false}, // more than 1 space
                {"David AbramovichGuetta", false}, // more 19 symbol
                {null, false}
        };
    }

    @Test
    @DisplayName("checkNameToEmbossTest")

    public void checkNameTest(){
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals("condition not met",expected, actual);
    }
}
