package task2;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class IOTest {

    public static void main(String[] args){

        BufferedWriter bw=null;
        BufferedReader br=null;
        String str=null;
        Set<String> st=new TreeSet<>(new MyStringCmp());
        try{
            bw = new BufferedWriter(new FileWriter("abc.txt"));
            br = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                str = br.readLine();
                if ("end".equals(str))
                    break;
                else
                    st.add(str);
            }
            for (String s : st) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bw){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != br){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
