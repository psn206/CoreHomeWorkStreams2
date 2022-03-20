import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long underage = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Количество несовершеннолетних: " + underage);
        List<String> conscript = persons.stream()
                .filter(person -> person.getAge() > 18)
                .filter(person -> person.getSex() == Sex.MAN)
                .map(person -> person.getFamily())
                .collect(Collectors.toList());
//        System.out.println("Призывники: " +  conscript);
        List<String> worker = persons.stream()
                .filter(person -> person.getAge() > 18)
                .filter(person -> person.getEducation() == Education.HIGHER)
                .map(person -> person.getFamily())
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
//        System.out.println("Работники с высшим образованием: " + worker);





    }
}
