package com.atguigu.proxy;

/**
 * 代理模式
 *
 * @author GuofanLee
 * @date 2019-04-26 22:31
 */
public class Proxy {

    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.browse();
    }

}

/**
 * 网络接口
 */
interface NetWork {
    /**
     * 浏览网页
     */
    void browse();
}

/**
 * 被代理类：服务器类
 */
class Server implements NetWork {

    @Override
    public void browse() {
        System.out.println("服务器访问网络");
    }

}

/**
 * 代理类
 */
class ProxyServer implements NetWork {

    private NetWork work;

    public ProxyServer(NetWork work) {
        this.work = work;
    }

    public void check() {
        System.out.println("联网之前的检查工作");
    }

    @Override
    public void browse() {
        check();
        work.browse();
    }

}