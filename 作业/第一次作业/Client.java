import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client extends Thread {
    public static void main(String[] args) throws InterruptedException {
        Client[] cs=new Client[10];
        for(int i=0;i<10;i++){
            cs[i]=new Client();
            cs[i].id=i;
            cs[i].start();
        }
    }
    int id;
    @Override
    public void run() {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 2345));

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String str="A";
            for(int i =0;i<10;i++) {
                socketChannel.write(ByteBuffer.wrap(str.getBytes()));
                buffer.clear();
                socketChannel.read(buffer);
                buffer.flip();
                str=Utils.buf2str(buffer);
                System.out.println("Recv"+str);
                str="ce"+id+str;
                Thread.sleep(10);
            }
            socketChannel.write(ByteBuffer.wrap("Bye".getBytes()));
            socketChannel.close();
        } catch (IOException | InterruptedException e) {
        }
    }
}