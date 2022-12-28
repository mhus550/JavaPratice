package Review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamReduce {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 5, 6, 2, 1, 3));
        // [     ] -> [     ]  -> [    ] -> [    ]
        System.out.println(list);
        // [4, 5, 6, 2, 1, 3]
        // [true, false, true, true, false, false]
        List<Boolean> listB = list.stream().map(el -> el % 2 == 0).collect(Collectors.toList());
        System.out.println(listB);
        // map

        List<String> names = new ArrayList<>(Arrays.asList("Bek", "Kuba", "Alex", "Masha", "Beknazar"));
        System.out.println(names);
        // [Bek, Kuba, Alex, Masha, Beknazar]
        // [3, 4, 4, 5, 8]

        List<Integer> namesLength = names.stream().map(el -> el.length()).collect(Collectors.toList());
        System.out.println(namesLength);
        System.out.println("---");

        // filter
        list = new ArrayList<>(Arrays.asList(4, 5, 6, 2, 1, 3));
        System.out.println(list); // [4, 5, 6, 2, 1, 3]
        List<Integer> oddList = list.stream().filter(el -> el % 2 == 1).collect(Collectors.toList());
        System.out.println(oddList); // [5, 1, 3]

        // forEach
        System.out.println("---");
        System.out.println(list);
        list.stream().forEach(el -> System.out.println(el));

        // reduce - combine
        System.out.println("---");
        System.out.println(list); // [4, 5, 6, 2, 1, 3]
        int sum = list.stream().reduce((result, element) -> result + element).orElse(0);
        System.out.println("Sum: " + sum);

        String str = list.stream()
                .filter(el -> el % 2 == 0)
                .map(el -> String.valueOf(el))
                .reduce((result, element) -> result + element)
                .orElse("");
        System.out.println("Result: " + str); // 456213
    }
}
