import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class StreamData {
    public static void main(String[] args) {
        String peopleString = """
                     Glinstone, Fred, 1/1/1900, Programmer, {locpd=900,yoe=10,iq=120}
                     Glinstone, Fred, 1/1/1900, Programmer, {locpd=900,yoe=10,iq=240}
                     Glinstone, Fred, 1/1/1900, Programmer, {locpd=900,yoe=10,iq=180}
                     Glinstone, Fred, 1/1/1900, Programmer, {locpd=900,yoe=10,iq=170}
                     Glinstone, Fred, 1/1/1900, Programmer, {locpd=900,yoe=10,iq=190}
                     Glinstone, Fred, 1/1/1900, Programmer, {locpd=900,yoe=10,iq=100}
                     Glinstone, Fred, 1/1/1900, Programmer, {locpd=900,yoe=10,iq=70}
                     Flinstone, Fred1, 1/1/1900, Programmer, {locpd=1000,yoe=10,iq=140}
                     Flinstone, Fred2, 1/1/1900, Programmer, {locpd=130,yoe=14,iq=100}
                     Flinstone3, Fred3, 1/1/1900, Programmer, {locpd=230,yoe=8,iq=105}
                     Alinstone4, Fred4, 1/1/1900, Programmer, {locpd=163,yoe=3,iq=115}
                     Flinstone5, Fred5, 1/1/1900, ProgrammerNNNN, {locpd=5,yoe=10,iq=104}
                     Duplikat, Duplikat, 2/2/1905, Manager, {orgSize=300,dr=10}
                     Duplikat, Duplikat, 2/2/1905, Manager, {orgSize=300,dr=10}
                     Duplikat, Duplikat, 2/2/1905, Manager, {orgSize=300,dr=10}
                     Duplikat, Duplikat, 2/2/1905, Manager, {orgSize=300,dr=10}
                     Duplikat, Duplikat, 2/2/1905, Manager, {orgSize=300,dr=10}
                     Duplikat, Duplikat, 2/2/1905, Manager, {orgSize=300,dr=10}
                     Duplikat, Duplikat, 2/2/1905, Manager, {orgSize=300,dr=10}
                     Duplikat, Duplikat, 2/2/1905, Manager, {orgSize=300,dr=10}
                     Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
                     Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
                     Rubble, Barney, 2/2/1905, Manager, {orgSize=400,dr=10}
                     Rubble, Barney, 2/2/1905, Manager, {orgSize=500,dr=10}
                     Rubble, Barney, 2/2/1905, Manager, {orgSize=600,dr=10}
                     Rubble, Barney, 2/2/1905, Manager, {orgSize=700,dr=10}
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

//        int sum = peopleString
//                .lines()
////                .map(s -> Employee.createEmployee(s))
//                .map(Employee::createEmployee)
//                .mapToInt(IEmployee::getSalary)
//                .sum();
//
//        System.out.println(sum + "This prints sum");
//
//
//        peopleString
//                .lines()
//                .map(Employee::createEmployee)
//                .map(IEmployee::getSalary)
//                .forEach(System.out::println);




//        Collection<String> listOfNumbers = List.of("one", "two", "three", "four");
//
//        listOfNumbers
//                .stream()
//                .map(String::toUpperCase)
//                .map(String::hashCode)
//                .map(Integer::toHexString)
//                .map(String::length)
//                .map(number -> number *2)
//                .forEach(System.out::println);
//
//        listOfNumbers
//                .stream()
//                .map(String::hashCode)
//                .forEach(h ->System.out.printf("%h%n", h));
//
//        Stream.of(1,2,3)
//                .map(Integer::doubleValue)
//                .forEach(h ->System.out.printf("%h%n", h));
//
//        record Car(String make, String model){};
//
//        Stream.of(new Car("Opel", "Cadet"), new Car("Opel", "Corsa"), new Car("Opel", "Vectra"))
//                .filter(car -> car.model.equals("Corsa"))
//                .forEach(System.out::println);
//
//        Stream.of("hello")
//                .forEach(System.out::println);
//
//        String myValues = null;
//
//        Stream.ofNullable(myValues)
//                .forEach(System.out::println);
//
//        IntStream.range(1, 11)
//                .forEach(System.out::println);
//
//        IntStream.rangeClosed(1, 19)
//                .mapToObj(String::valueOf)
//                .map(s -> s.concat("-"))
//                .forEach(System.out::print);
//
//        IntStream.rangeClosed(1, 19)
//                .boxed()
//                .map(String::valueOf)
//                .map(s -> s.concat("-"))
//                .forEach(System.out::print);
//
//        String[] names = {"Jack", "Alan", "Charly"};
//
//        Arrays.stream(names)
//                .forEach(System.out::println);

//        try {
//            Files.lines(Path.of("C:/Users/justy/Desktop/JAVA/UDEMY__Java_Foundations/Section_7__TestingCode/Section_08_More-On-OOP/src/main/java/employees.txst"))
//                    .forEach(System.out::println);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        Predicate<String>  dummyEmployeeSelector = e -> e.contains("ProgrammerNNNN");

        Predicate<Employee> dummyEmployeeSelector = employee -> "No name".equals(employee.getLastName());
        Predicate<Employee> overSommeAmount = employee -> employee.getSalary() > 1000000;
        int sum2 = peopleString
                .lines()
//                .filter(dummyEmployeeSelector.negate())
//                .map(s -> Employee.createEmployee(s))
                .map(Employee::createEmployee)
//                .sorted()
//                .sorted((x, y) -> Integer.compare(x.getSalary(), y.getSalary()))
                .map(e -> (Employee) e)
                .filter(e -> e instanceof Programmer)
//                .filter(not(e -> e.getLastName().equals("No name")))
                .filter(dummyEmployeeSelector.negate().and(overSommeAmount))
//                .distinct()
                .collect(Collectors.toSet()).stream()
                .sorted(Comparator.comparing(Employee::getLastName)
                        .thenComparing(Employee::getFirstName)
                        .thenComparingInt(Employee::getSalary).reversed())
                .mapToInt(StreamData::showEmployeeAndGetSalary)
                .sum();

        System.out.println(sum2 + " = This prints sum2");


        peopleString
                .lines()
                .map(Employee::createEmployee)
                .map(e -> (Employee)e)
                .map(Employee::getFirstName)
                .map(firstName -> firstName.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);

        boolean doesAllEmployeeGetMoreThan = peopleString
                .lines()
                .map(Employee::createEmployee)
                .map(e -> (Employee) e)
                .filter(dummyEmployeeSelector.negate())
//                .allMatch(e -> e.getSalary() > 30);
                .anyMatch(e -> e.getSalary() > 30000);

        System.out.println(doesAllEmployeeGetMoreThan);

        Predicate<Employee> filterUotAll = employee -> employee.getFirstName().equals("Not existing");

        Optional<Employee> first = peopleString
                .lines()
                .map(Employee::createEmployee)
                .map(e -> (Employee) e)
                .filter(filterUotAll)
//                .allMatch(e -> e.getSalary() > 30);
                .findFirst();

        System.out.println(first
                .map(Employee::getFirstName)
                .orElse("Nothing found"));

        OptionalInt result = peopleString
                .lines()
                .map(Employee::createEmployee)
                .map(e -> (Employee) e)
                .filter(e -> e instanceof Programmer)
                .filter(dummyEmployeeSelector.negate().and(overSommeAmount))
                .collect(Collectors.toSet()).stream()
                .sorted(Comparator.comparing(Employee::getLastName)
                        .thenComparing(Employee::getFirstName)
                        .thenComparingInt(Employee::getSalary).reversed())
                .mapToInt(StreamData::showEmployeeAndGetSalary)
                .max();

        System.out.println(result.orElse(0) + " = This prints result");

        long reduceResult = peopleString
                .lines()
                .map(Employee::createEmployee)
                .map(e -> (Employee) e)
                .filter(e -> e instanceof Programmer)
                .filter(dummyEmployeeSelector.negate().and(overSommeAmount))
                .collect(Collectors.toSet()).stream()
                .sorted(Comparator.comparing(Employee::getLastName)
                        .thenComparing(Employee::getFirstName)
                        .thenComparingInt(Employee::getSalary).reversed())
                .mapToInt(StreamData::showEmployeeAndGetSalary)
                .reduce(0, (a, b) -> a + b);

        System.out.println(reduceResult + " = This prints reduceResult");

        OptionalInt minimumResult = peopleString
                .lines()
                .map(Employee::createEmployee)
                .map(e -> (Employee) e)
                .filter(e -> e instanceof Programmer)
                .filter(dummyEmployeeSelector.negate().and(overSommeAmount))
                .collect(Collectors.toSet()).stream()
                .sorted(Comparator.comparing(Employee::getLastName)
                        .thenComparing(Employee::getFirstName)
                        .thenComparingInt(Employee::getSalary).reversed())
                .mapToInt(StreamData::showEmployeeAndGetSalary)
                .reduce( (a, b) -> a < b ? a : b);

        System.out.println(minimumResult.orElse(-1) + " = This prints reduceResult");


        Optional<String> reduceStrings = Stream.of("tom", "mery", "jerry", "bob")
                .reduce((a, b) -> a.concat("_").concat(b));

        System.out.println(reduceStrings.orElse("Nothing found"));


    }



    public static int showEmployeeAndGetSalary(IEmployee e) {
        System.out.println(e + " - - - This prints Employee");
        return e.getSalary();
    }
}
