import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
public class test {
    public static void main(String[] args){
        System.out.println("su");
        List<String> list =new ArrayList<String>();
        String text="hive";
        list.add("hadoop");
        list.add("spark");
        list.add("hive");
        System.out.println(list);
        for (String word:list){
            if(text.contains(word)){
                System.out.println(text+" is in "+list);
            }
        }
        System.out.println("");
    }
}
