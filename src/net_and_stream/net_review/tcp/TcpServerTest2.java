package net_and_stream.net_review.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/12/8 20:28
 */
public class TcpServerTest2 {

    public static void main(String[] args) throws IOException {

        // 1.创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        // 2.等待（监听）客户端的连接
        Socket socket = serverSocket.accept();// 阻塞式监听，会一直等待客户端的连接
        // 3.获取输入流
        InputStream is = socket.getInputStream();

        // 4.文件输出
        FileOutputStream fos = new FileOutputStream(new File("receive.txt"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        // 通知客户端，我已经接收完毕了
        OutputStream os = socket.getOutputStream();
        os.write("我已经接收完毕了，你可以断开了~~".getBytes());


        // 5.关闭资源
        os.close();
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
