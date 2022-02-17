package task3;

public class SellerRunnableTest {
    public static void main(String[] args) {
        Tickets pool = new Tickets(100);
        Thread[] threads = new Thread[3];
        int i;
        for(i=0;i<3;i++){
            threads[i]=new Thread(new SellerRunnable(pool),""+i);
            threads[i].start();
        }
        for(i=0;i<3;i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
