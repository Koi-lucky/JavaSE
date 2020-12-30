package net_and_stream.net_review.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/12/30 20:02
 */

// 但是还是要等待客户端的连接
public class UdpServerDemo01 {

    public static void main(String[] args) throws IOException {

        // 1.开放端口
        DatagramSocket socket = new DatagramSocket(9999);
        // 2.接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);// 服务器三个参数

        socket.receive(packet);// 阻塞接收

        System.out.println(packet.getAddress().getHostAddress());
        System.out.println(new String(packet.getData(), 0, packet.getLength()));

        // 3.关闭资源
        socket.close();
    }
}
