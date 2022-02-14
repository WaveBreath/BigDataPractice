import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WorkerTest {
    public static void main(String[] args) {
        List<Worker> lst = new ArrayList<>();
        lst.add(new Worker("凤姐", 18, 20000));
        lst.add(new Worker("欧阳峰", 60, 8000));
        lst.add(new Worker("刘德华", 40, 30000));
        System.out.println("增加3人"+lst);
        lst.add(2,new Worker("张柏芝", 35, 3300));
        System.out.println("增加张柏芝"+lst);
        lst.remove(3);
        System.out.println("删除刘德华"+lst);
        for(Worker w:lst){
            System.out.println(w.toString());
        }
        for(Iterator<Worker> wit=lst.iterator(); wit.hasNext();){
            wit.next().work();
        }
    }
}
