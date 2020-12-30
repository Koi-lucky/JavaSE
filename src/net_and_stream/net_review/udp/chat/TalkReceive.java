package net_and_stream.net_review.udp.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/12/30 21:01
 */
public class TalkReceive implements Runnable{
    DatagramSocket socket = null;

    private int port;
    private String msgFrom;

    public TalkReceive(int port, String msgFrom) {
        this.port = port;
        this.msgFrom = msgFrom;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            // 准备接收包裹
            try {
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                socket.receive(packet);

                // 断开连接
                byte[] data = packet.getData();
                java.lang.String receiveData = new String(data, 0, data.length);

                System.out.println(msgFrom + " : " + receiveData);

                if (receiveData.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        socket.close();
    }
}
