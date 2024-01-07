import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void testNameToSalary(){
        Main main = new Main();
        main.main(new String[0]);

        int salary = main.getSalary("Wilma");
        assertEquals(140.00, salary);
    }

    @Test
    public void testNameToSalaryOrDefault(){
        Main main = new Main();
        main.main(new String[0]);

        int salary = main.getSalaryOrDefault("Not existing name");
        assertEquals(-1, salary);
    }


}