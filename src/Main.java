import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(final String[] args) {
        final ArrayList<Boy> boys = new ArrayList<>() {{
            add(new Boy("Николай", 68));
            add(new Boy("Пётр", 53));
            add(new Boy("Василий", 25));
            add(new Boy("Михаил", 19));
            add(new Boy("Алексей", 6));
            add(new Boy("Николай", 86));
            add(new Boy("Пётр", 35));
            add(new Boy("Михаил", 111));
            add(new Boy("Алексей", 22));
            add(new Boy("Михаил", 1));
            add(new Boy("Яков", 30));
        }};
        Map<String, Long> filtered = boys.stream()
                .filter(boy -> boy.getAge() >= 18)
                .map(Boy::getName)
                .sorted()
                .distinct()
                .limit(4)
                .collect(Collectors.toMap(name -> name, name -> countDuplicateNames(name, boys)));
        System.out.println(filtered.toString());
    }

    public static long countDuplicateNames(final String name, final ArrayList<Boy> boys) {
        return boys.stream()
                .map(Boy::getName)
                .filter(s -> s.equals(name))
                .count() - 1;
    }
}