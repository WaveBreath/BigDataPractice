package task3;

public class Tickets {

    private int cap,cnt;

    public Tickets(int cap){
        this.cap=cap;
        this.cnt=0;
    }

    public synchronized int sell(){
        if(++cnt>cap) return -1;
        else return cnt;
    }
}
