import java.util.regex.Pattern;

public class Account {

    private final String NAME_PATTERN = "(?=.{3,19}$)[а-яА-Яa-zA-Z]+\\s{1}[а-яА-Яa-zA-Z]+";
    private final Pattern pattern = Pattern.compile(NAME_PATTERN);
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if (name != null){
            return name.matches(NAME_PATTERN);
        }
        else {
            return false;
        }
    }
}
