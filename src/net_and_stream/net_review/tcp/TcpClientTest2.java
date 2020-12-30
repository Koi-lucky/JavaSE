package net_and_stream.net_review.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/12/8 20:27
 */
public class TcpClientTest2 {

    public static void main(String[] args) throws IOException {

        // 1.创建一个socket连接
        Socket socket = new Socket(InetAddress.getByName("localhost"), 9000);
        // 2.创建一个输出流
        OutputStream os = socket.getOutputStream();

        // 3.读取文件
        FileInputStream fis = new FileInputStream(new File(".//send.txt"));
        // 4.写出文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }


        // 通知服务器端，我已经传送完毕了
        socket.shutdownOutput();// 我已经传输结束了！

        // 确定服务器接收完毕之后，才能够断开连接
        InputStream is = socket.getInputStream();
        // 通过字节数组加快读取的速度
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2 = is.read(buffer2)) != -1) {
            baos.write( buffer2, 0, len2);
        }
        System.out.println(baos.toString());

        // 5.关闭资源
        baos.close();
        is.close();
        fis.close();
        os.close();
        socket.close();
    }
}
