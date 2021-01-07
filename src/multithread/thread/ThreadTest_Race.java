package multithread.thread;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/7 16:03
 */
public class ThreadTest_Race implements Runnable {

    // 模拟龟兔赛跑

    // 胜利者
    private static String winner;

    @Override
    public void run() {
        // 100米的赛道，每跑一步就减少一米
        for (int i = 1; i < 101; i++) {
            // 模拟兔子休息
            if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 判断比赛是否结束
            boolean flag = isGameOver(i);
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了第" + i + "步");
        }
    }

    // 判断是否完成比赛
    private Boolean isGameOver(int step) {
        // 判断是否有胜利者
        if (winner != null) {
            // 此时已经存在胜利者
            return true;
        }else {
            if (step >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner is " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ThreadTest_Race tr = new ThreadTest_Race();
        new Thread(tr,"兔子").start();
        new Thread(tr,"乌龟").start();
    }
}
