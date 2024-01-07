import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEO extends Employee implements IEmployee, Flyer {
    private int avgStockPrice = 0;
    private Flyer flyer = new Pilot(1000, true);

    private final String ceoRegex = "\\w+=(?<avgStockPrice>\\w+)";
    private final Pattern ceoPat = Pattern.compile(ceoRegex);
    private final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    public CEO(String personText) {
        super(personText);
        Matcher managerMatcher = ceoPat.matcher(peopleMatcher.group("details"));

        if(managerMatcher.find()){
            this.avgStockPrice = Integer.parseInt(managerMatcher.group("avgStockPrice"));
        }
    }

    public int getSalary() {
        return 35 * this.avgStockPrice;
    }

//    @Override
//    public String toString() {
//        return String.format("%s, : %s : %s", this.firstName, this.lastName, this.moneyFormat.format(getSalary()));
//    }


    public int getHoursFlown() {
        return flyer.getHoursFlown();
    }

    public void setHoursFlown(int hoursFlown) {
        flyer.setHoursFlown(hoursFlown);
    }

    public boolean isIfr() {
        return flyer.isIfr();
    }

    public void setIfr(boolean ifr) {
        flyer.setIfr(ifr);
    }

    public void fyl() {
        flyer.fyl();
    }
}
