import java.util.Arrays;
import java.util.Comparator;

public class Lesson3 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{22, 44, 5, 10, 22, 2, 222, 3, 1};
        mySort(arr);
        System.out.println(Arrays.toString(arr));

        var list = new MyList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        System.out.println(list.get(7));

        for(var item : list){
            System.out.println(item);
        }
    }

    public static void mySort(Integer[] arr){
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 % 10 > o2 % 10)
                    return 1;
                else if (o2 % 10 == o1 % 10)
                    return o1-o2;
                else
                    return -1;
            }
        });
    }
}