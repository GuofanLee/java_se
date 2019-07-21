package java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 请填写类的描述
 *
 * @author GuofanLee
 * @date 2019-05-05 00:44
 */
public class InetAdressTest {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress inet1 = InetAddress.getByName("192.168.0.1");
        System.out.println(inet1);

        InetAddress inet2 = InetAddress.getByName("www.baidu.com");
        System.out.println(inet2);

        InetAddress inet3 = InetAddress.getByName("localhost");
        System.out.println(inet3);

        InetAddress inet4 = InetAddress.getLocalHost();
        System.out.println(inet4);

        System.out.println(inet2.getHostName());
        System.out.println(inet2.getHostAddress());

    }

}
