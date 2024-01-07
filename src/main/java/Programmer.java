import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//public class Programmer extends Employee implements Apple, IEmployee {
public class Programmer extends Employee implements IEmployee, Chef {
    private int linesOfCode = 0;
    private int yearsOfExperience = 0;
    private int iq = 0;

    private final String programmerRegex = "\\w+\\=(?<locpd>\\w+)\\,\\w+\\=(?<yoe>\\w+)\\,\\w+\\=(?<iq>\\w+)";
    private final Pattern programmerPat = Pattern.compile(programmerRegex);

    public Programmer(String personText) {
        super(personText);
        Matcher programmerMatcher = programmerPat.matcher(this.peopleMatcher.group("details"));

        if(programmerMatcher.find()){
            this.linesOfCode = Integer.parseInt(programmerMatcher.group("locpd"));
            this.yearsOfExperience = Integer.parseInt(programmerMatcher.group("yoe"));
            this.iq = Integer.parseInt(programmerMatcher.group("iq"));
        }
    }
    public int getSalary() {
        return 30 + this.linesOfCode * this.yearsOfExperience * this.iq;
    }

    public int doSomething(){
        return 11;
    }

    public String yellAtPeople() {
        return "WTF";
    }

    public int getLinesOfCode() {
        return linesOfCode;
    }

    public void setLinesOfCode(int linesOfCode) {
        this.linesOfCode = linesOfCode;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public String getProgrammerRegex() {
        return programmerRegex;
    }

    public Pattern getProgrammerPat() {
        return programmerPat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Programmer that = (Programmer) o;
        return iq == that.iq;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), iq);
    }
}
