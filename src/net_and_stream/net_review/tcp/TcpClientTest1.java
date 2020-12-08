package net_and_stream.net_review.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/12/7 18:20
 */
public class TcpClientTest1 {

    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        try {
            // 1.先得知道服务器的地址、编口号
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            // 2.创建一个套接字进行连接
            socket = new Socket(serverIP, port);
            // 3.利用IO流给服务器端发送数据
            os = socket.getOutputStream();
            os.write("你好，欢迎学习Java编程语言！".getBytes());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭连接（先开的后关）
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
