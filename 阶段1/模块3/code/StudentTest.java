import java.util.*;
import java.util.function.BiConsumer;

public class StudentTest {


    public static void main(String[] args) {
        Map<Student,String> mp=new HashMap<>();
        mp.put(new Student("a",1),"a");
        mp.put(new Student("b",2),"b");


        for(Map.Entry<Student,String> entry:mp.entrySet()){
            
            System.out.println(entry.getKey() + "::" + entry.getValue());
        }
        System.out.println("------------------");

        for(Student key:mp.keySet()){
            System.out.println(key + "::" + mp.get(key));
        }
        System.out.println("------------------");

        for(Iterator<Map.Entry<Student, String>> iterator = mp.entrySet().iterator();iterator.hasNext();){
            Map.Entry<Student, String> entry = iterator.next();
            System.out.println(entry.getKey() + "::" + entry.getValue());
        }
        System.out.println("------------------");
        mp.forEach(new BiConsumer<Student, String>() {
            @Override
            public void accept(Student student, String s) {
                System.out.println(student + "::" + s);
            }
        });
    }
}
