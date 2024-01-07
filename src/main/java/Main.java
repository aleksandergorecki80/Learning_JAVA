import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;

public class Main {

    private static Set<IEmployee> employees;
    private static Map<String, Integer> employeeSalaryMap;

    public static void main(String[] args) {

        Flyer flyer = new CEO("Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}");
        flyer.fyl();
        System.out.println(flyer.getHoursFlown());

        Chef programmerThatCooks = new Programmer("Flinstone1, Fred1, 1/1/1900, Programmer, {locpd=1000,yoe=10,iq=140}");
        System.out.println(programmerThatCooks.yellAtPeople());


        String people = """
                     Glinstone, Fred, 1/1/1900, Programmer, {locpd=900,yoe=10,iq=140}
                     Glinstone, Fred, 1/1/1900, Programmer, {locpd=900,yoe=10,iq=140}
                     Glinstone, Fred, 1/1/1900, Programmer, {locpd=900,yoe=10,iq=140}
                     Glinstone, Fred, 1/1/1900, Programmer, {locpd=900,yoe=10,iq=140}
                     Glinstone, Fred, 1/1/1900, Programmer, {locpd=900,yoe=10,iq=140}
                     Glinstone, Fred, 1/1/1900, Programmer, {locpd=900,yoe=10,iq=140}
                     Glinstone, Fred, 1/1/1900, Programmer, {locpd=900,yoe=10,iq=140}
                     Flinstone, Fred1, 1/1/1900, Programmer, {locpd=1000,yoe=10,iq=140}
                     Flinstone, Fred2, 1/1/1900, Programmer, {locpd=130,yoe=14,iq=100}
                     Flinstone3, Fred3, 1/1/1900, Programmer, {locpd=230,yoe=8,iq=105}
                     Alinstone4, Fred4, 1/1/1900, Programmer, {locpd=163,yoe=3,iq=115}
                     Flinstone5, Fred5, 1/1/1900, ProgrammerNNNN, {locpd=5,yoe=10,iq=104}
                     Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
                     Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
                     Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
                     Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
                     Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
                     Rubble2, Barney2, 2/2/1905, Manager, {orgSize=100,dr=4}
                     Rubble3, Barney3, 2/2/1905, Manager, {orgSize=200,dr=2}
                     Aubble4, Barney4, 2/2/1905, Manager, {orgSize=500,dr=8}
                     Wubble5, Barney5, 2/2/1905, Manager, {orgSize=175,dr=20}
                     Flinstone, Wilmaa, 3/3/1910, Analyst, {projectCount=3}
                     Flinstone2, Wilma, 3/3/1910, Analyst, {projectCount=4}
                     Flinstone3, Wilma3, 3/3/1910, Analyst, {projectCount=5}
                     Flinstone4, Wilma4, 3/3/1910, Analyst, {projectCount=6}
                     Flinstone5, Wilma5, 3/3/1910, Analyst, {projectCount=9}
                     Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
                     Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
                """;

        Matcher peopleMatcher = Employee.PEOPLE_MATCHER.matcher(people);

        int totalSalaries = 0;
        IEmployee employee = null;

//        Set<IEmployee> employees  = new LinkedHashSet<>();
        employees = new TreeSet<>();
        employeeSalaryMap = new TreeMap<>();

        while (peopleMatcher.find()) {
            employee = Employee.createEmployee(peopleMatcher.group());
            Employee emp = (Employee) employee;
            boolean add = employees.add(employee);
            employeeSalaryMap.put(emp.firstName, emp.getSalary());

//            System.out.println(employeeSalaryMap + " ==== employeeSalaryMap");

//            employees.add(employee);
////            System.out.println(employees + " === employees");
//
//            if(employee.getClass().equals(Programmer.class)){
//                System.out.println("=====PROGRAMMER=====");
//            }
//
//            if(employee instanceof Programmer){
//                System.out.println("-------- instance of PROGRAMMER -----");
//                System.out.println(((Programmer) employee).getIq());
//            }
//
//            if(employee instanceof Programmer coder){
//                System.out.println("-------- instance of PROGRAMMER with pattern matching-----");
//                System.out.println(coder.getIq());
//            }
        }

//        IEmployee seventh =  new ArrayList<>(employees).get(7);
//
//        System.out.println(seventh + " === seventh");

//        employees.remove(4);

//        IEmployee employee1 = employees.get(0);
//        IEmployee employee2 = employees.get(1);
//        IEmployee employee3 = employees.get(2);

//        List<String> undesirables = new ArrayList<>(List.of("Wilma5", "Barney4", "Fred2"));
//        undesirables.sort(Comparator.naturalOrder());
//
//        Programmer programmer1 = new Programmer("Flinstone1, Fred1, 1/1/1900, Programmer, {locpd=1000,yoe=10,iq=141}");
//        Programmer programmer2 = new Programmer("Flinstone1, Fred1, 1/1/1900, Programmer, {locpd=1000,yoe=10,iq=140}");

//        System.out.println(programmer1.equals(programmer2) + " == programmer1 equals programmer2");

//        Collections.sort(employees, (o1, o2) -> {
//            // if there is an "o1" that is an instance of Employee make the variable "emp1" of type Employee
//            if( o1 instanceof Employee emp1 && o2 instanceof Employee emp2 ){
////                    Employee emp1 = (Employee) o1;
////                    Employee emp2 = (Employee) o2;
//                int lastNameResult = emp1.lastName.compareTo(emp2.lastName);
//                return lastNameResult != 0 ? lastNameResult : Integer.compare(emp1.getSalary(), emp2.getSalary());
//            }
//            return 0;
//        });

//        Collections.sort(employees, Comparator.naturalOrder());

        for (IEmployee worker : employees){
            System.out.println("=======  " + worker.toString());
            totalSalaries+= worker.getSalary();
        }

        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
//        System.out.println("The total payout should be %s%n", currencyInstance.format(totalSalaries), totalSalaries);

        System.out.println(employees.size() + "=== size");
        System.out.println(employeeSalaryMap);
        System.out.println(employeeSalaryMap.values());
        System.out.println(employeeSalaryMap.keySet());
        System.out.println(employeeSalaryMap.entrySet());

        for (Map.Entry<String, Integer> entry : employeeSalaryMap.entrySet()) {
            System.out.printf("Key = %s, Value = %s%n", entry.getKey(), entry.getValue());
        };

//
//        System.out.println(totalSalaries);
//        System.out.println(employees);
//
//        Weirdo larry = new Weirdo("Larry", "Moore", LocalDate.of(1925, 1, 12));
//        System.out.println(larry.firstName());
//        System.out.println(larry.doSomething());
//
//        Weirdo snake = new Weirdo("Jack", "Snake");
//        System.out.println(snake.sayHello());
//

    }

    public int getSalary(String firstName) {
       return employeeSalaryMap.get(firstName);
    }

    public int getSalaryOrDefault(String firstName) {
        return employeeSalaryMap.getOrDefault(firstName, -1);
    }




    private static void removeUndesirables(List<IEmployee> employees, List<String> removalNames) {
        for(Iterator<IEmployee> iterator = employees.iterator(); iterator.hasNext(); ){
            IEmployee worker = iterator.next();
            if(worker instanceof Employee tempWorker){
//                Employee tempWorker = (Employee) worker;
                if(removalNames.contains(tempWorker.firstName)){
                    iterator.remove();
                }
            }
        }
    }
}

