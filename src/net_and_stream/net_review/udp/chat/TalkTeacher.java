package net_and_stream.net_review.udp.chat;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/12/30 21:02
 */
public class TalkTeacher {
    public static void main(String[] args) {
        // 开启两个线程
        new Thread(new TalkSend(5555, "localhost", 8888)).start();
        new Thread(new TalkReceive(9999, "学生")).start();
    }
}
