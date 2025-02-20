import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String testName;
    private final String name;
    private final boolean expected;

    public AccountTest(String testName, String name, boolean expected) {
        this.testName=testName;
        this.name=name;
        this.expected=expected;
    }

    @Parameterized.Parameters (name = "{0}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {"3 символа", "J z", true},
                {"4 символа", "He z", true},
                {"11 символов", "Ivan Ivanov", true},
                {"18 символов", "Alexander Semenovv", true},
                {"19 символов", "Alexandr Strelnikov", true},
                {"Пустая строка", "", false},
                {"Один символ", " ", false},
                {"2 символа", " w", false},
                {"20 символов", "Alexander Strelnikov", false},
                {"21 символ", "Alexander Strelnikoff", false},
                {"24 символа", "AlexanderFive Strelnikov", false},
                {"Нет пробелов", "IvanIvanov", false},
                {"2 пробела", "Ivan Iva nov", false},
                {"5 пробела", " v a n I van", false},
                {"Пробел спереди", " IvanIvanov", false},
                {"Пробел сзади", "IvanIvanov ", false}
        };
    }

    @Test
    public void checkAccount() {
        Account account = new Account(name);
        Assert.assertEquals(expected, account.checkNameToEmboss());
    }
}