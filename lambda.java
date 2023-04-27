import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class lambda {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);

        List<List<Integer>> lst = new ArrayList<>();
        lst.add(list);
        lst.add(list);

        List<Integer> lt = lst.stream().flatMap(List::stream).collect(Collectors.toList());
        lt.forEach(x-> System.out.println(x));
        List<Integer> lts = lt.stream().map(x->
        {
            if (x  % 5 == 0) {
                return x*x;
            } else {
                return x;
            }
        }).collect(Collectors.toList());
        lts.forEach(x-> System.out.println(x));
    }
}
