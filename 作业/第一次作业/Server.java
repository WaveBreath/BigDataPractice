import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress("127.0.0.1", 2345));
            ssc.configureBlocking(false);

            Selector selector = Selector.open();
            // 注册 channel，并且指定感兴趣的事件是 Accept
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            ByteBuffer buff = ByteBuffer.allocate(2048);
            while (true) {
                System.out.println("Blocking");
                int nReady = selector.select();
                if(nReady==0)break;
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();

                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();

                    if (key.isAcceptable()) {
                        SocketChannel socketChannel = ssc.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        System.out.println("Accept");
                    }
                    else if (key.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        buff.clear();
                        socketChannel.read(buff);
                        buff.flip();
                        String str=Utils.buf2str(buff);
                        System.out.println("received : " + str);
                        if("Bye".compareTo(str)==0){
                            socketChannel.close();
                        }else{
                            str="se"+str;
                            socketChannel.write(ByteBuffer.wrap(str.getBytes()));
                        }

                    }
                }
            }
            selector.close();
            ssc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}