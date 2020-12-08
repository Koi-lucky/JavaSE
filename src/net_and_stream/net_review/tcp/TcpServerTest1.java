package net_and_stream.net_review.tcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/12/7 18:20
 */
public class TcpServerTest1 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            // 1.服务器自己得有一个地址，供客户端使用识别
            serverSocket = new ServerSocket(9999);
            // 2.等待客户端连接过来
            socket = serverSocket.accept();
            // 3.读取客户端发送来的消息
            is = socket.getInputStream();
            // 4.利用管道流的方式接收数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write( buffer, 0, len);
            }
            // 输出接收到的数据
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5.关闭连接
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
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
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
