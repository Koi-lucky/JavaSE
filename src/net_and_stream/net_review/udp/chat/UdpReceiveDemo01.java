package net_and_stream.net_review.udp.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/12/30 21:00
 */
public class UdpReceiveDemo01 {

    public static void main(String[] args) throws IOException {

        // 开放端口
        DatagramSocket socket = new DatagramSocket(6666);
        // 接受数据包
        while (true) {

            // 准备接受数据包
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            socket.receive(packet);// 阻塞式接收包裹

            // 断开连接
            byte[] data = packet.getData();
            String receiveData = new String(data, 0, data.length);

            System.out.println(receiveData);
            if (receiveData.equals("byebye")) {
                break;
            }
        }
        // 关闭资源
        socket.close();

    }
}
