package task3;

public class SellerRunnable implements Runnable{
    private Tickets tickets;

    public SellerRunnable(Tickets tickets){
        this.tickets=tickets;
    }

    @Override
    public void run() {
        int tid=0;
        while (-1!=(tid=tickets.sell())) {
            System.out.printf("售货员%s正在卖第%d张票\n",Thread.currentThread().getName(),tid);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("售货员%s无票可卖\n",Thread.currentThread().getName());
    }
}
