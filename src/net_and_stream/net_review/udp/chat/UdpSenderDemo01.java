package net_and_stream.net_review.udp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/12/30 21:00
 */
public class UdpSenderDemo01 {

    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(8888);

        // 准备数据包：从控制台读取System.in
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String data = reader.readLine();
            byte[] datas = data.getBytes();
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("127.0.0.1", 6666));

            socket.send(packet);
            if (data.equals("byebye")) {
                break;
            }
        }

        // 关闭资源
        reader.close();
        socket.close();
    }
}
