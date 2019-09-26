import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        Comparator<String> comparator = (o1, o2) -> o1.compareToIgnoreCase(o2);
/*        new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        };*/
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("abd");
//        Arrays.sort(list, comparator);
        list.sort(comparator);

    }
}
