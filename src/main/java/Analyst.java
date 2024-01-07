import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyst extends Employee implements IEmployee {
    private int projectCount = 0;


    String analystRegex = "\\w+=(?<projectCount>\\w+)";
    private final Pattern analystPat = Pattern.compile(analystRegex);
    private final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    public Analyst(String personText) {
        super(personText);
        Matcher analystMatcher = analystPat.matcher(peopleMatcher.group("details"));

        if(analystMatcher.find()){
            this.projectCount = Integer.parseInt(analystMatcher.group("projectCount"));
        }
    }

    public int getSalary() {
        return 35  * this.projectCount;
    }

//    @Override
//    public String toString() {
//        return String.format("%s, : %s : %s", this.firstName, this.lastName, this.moneyFormat.format(getSalary()));
//    }
}
