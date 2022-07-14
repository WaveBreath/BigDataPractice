import java.nio.ByteBuffer;

public class Utils {
    static String buf2str(ByteBuffer bb){
        byte[] tmp=new byte[bb.limit()];
        bb.get(tmp,0,bb.limit());
        return new String(tmp).trim();
    }
}
