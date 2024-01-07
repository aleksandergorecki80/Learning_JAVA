import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager extends Employee implements IEmployee {
    private int orgSize = 0;
    private int directorReports = 0;

    private final String mgrRegex = "\\w+=(?<orgSize>\\w+),\\w+=(?<dr>\\w+)";
    private final Pattern mgrPat = Pattern.compile(mgrRegex);
    private final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    public Manager(String personText) {
        super(personText);
        Matcher managerMatcher = mgrPat.matcher(peopleMatcher.group("details"));

        if(managerMatcher.find()){
            this.orgSize = Integer.parseInt(managerMatcher.group("orgSize"));
            this.directorReports = Integer.parseInt(managerMatcher.group("dr"));
        }
    }

    public int getSalary() {
        return 35 + this.orgSize * this.directorReports;
    }

//    @Override
//    public String toString() {
//        return String.format("%s, : %s : %s", this.firstName, this.lastName, this.moneyFormat.format(getSalary()));
//    }
}
