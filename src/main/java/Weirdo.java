import java.time.LocalDate;

public record Weirdo(String firstName, String lastName, LocalDate dateOfBirth) implements Apple {
    public Weirdo(String firstName, String lastName){
        this(firstName, lastName, null );
    }

    public String sayHello() {
        return this.firstName + " " + this.lastName + " " + "says hello";
    }

    @Override
    public int doSomething() {
        return 0;
    }
}
