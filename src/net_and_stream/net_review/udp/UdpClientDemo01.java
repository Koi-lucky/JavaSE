package net_and_stream.net_review.udp;

import java.net.*;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/12/30 20:02
 */

// 不需要连接服务器
public class UdpClientDemo01 {

    public static void main(String[] args) throws Exception {

        // 1.建立一个socket
        DatagramSocket socket = new DatagramSocket();

        // 2.创建一个数据包
        String msg = "你好啊，服务器！";
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9999;
        // 新建包的【4个】参数信息：数据，数据的起始长度，数据的终止长度, 要发送给谁
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, new InetSocketAddress( localhost, port));// 客户端四个参数

        // 3.发送数据包
        socket.send(packet);

        // 4.关闭资源
        socket.close();
    }
}
