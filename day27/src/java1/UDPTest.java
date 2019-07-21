package java1;

import org.junit.Test;

import javax.naming.ldap.SortKey;
import java.io.IOException;
import java.net.*;

/**
 * 实现TCP网络编程
 *
 * @author GuofanLee
 * @date 2019-05-05 17:24
 */
public class UDPTest {

    /**
     * 发送端
     */
    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String str = "我是UDP方式发送数据";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, inet, 9090);
        socket.send(packet);
        socket.close();
    }

    /**
     * 接收端
     */
    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] bytes = new byte[100];
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
        socket.receive(packet);

        System.out.println(new String(packet.getData(), 0, packet.getLength()));

        socket.close();
    }

}
