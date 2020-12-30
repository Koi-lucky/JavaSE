package net_and_stream.net_review.udp.chat;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/12/30 21:02
 */
public class TalkStudent {
    public static void main(String[] args) {
        // 开启两个线程
        new Thread(new TalkSend( 7777, "127.0.0.1", 9999)).start();
        new Thread(new TalkReceive( 8888, "老师")).start();
    }
}
