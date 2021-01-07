package multithread.thread;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/7 21:27
 */
public class ThreadTestPC1 {

    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Productor(container).start();
        new Consumer(container).start();
    }
}

// 生产者
class Productor extends Thread {
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    // 生产
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了第 --> " + i + "只鸡");
            try {
                container.push(new Chicken(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
// 消费者
class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    // 消费
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println("消费了第 --> " + container.pop().id + "只鸡");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
// 产品
class Chicken {
    int id;// 产品编号

    public Chicken(int id) {
        this.id = id;
    }
}
// 缓冲区
class SynContainer {

    // 需要一个容器大小
    Chicken[] chickens = new Chicken[10];
    // 容器的计数器
    int count = 0;

    // 生产者放入产品
    public synchronized void push(Chicken chicken) throws InterruptedException {
        // 如果容器满了，就需要等待消费者来消费
        if (count == chickens.length) {
            // 通知消费者来消费，生产等待
            this.wait();
        }

        // 如果没有满，我们就要放入产品
        chickens[count] = chicken;
        count++;

        // 可以通知消费者来消费
        this.notifyAll();
    }

    // 消费者来消费产品
    public synchronized Chicken pop() throws InterruptedException {
        // 判断是否能消费
        if (count == 0) {
            // 通知生产者生产，消费者等待
            this.wait();
        }

        // 如果可以消费
        count--;
        Chicken chicken = chickens[count];

        // 消费者消费完了，通知生产者来生产
        this.notifyAll();

        return chicken;

    }
}