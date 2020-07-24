package net_and_stream.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建BS版本的TCP服务器
 */
public class BS_TCPServer {

    public static void main(String[] args) throws IOException {
        //1.创建一个服务器ServerSocket对象和系统要指定的端口号
        ServerSocket server = new ServerSocket(8080);
        /*
            浏览器解析服务器回写的html页面，页面中如果有图片，那么浏览器就会单独的开启一个线程，读取服务器的图片
            我们就得让服务器一直处于监听状态，客户端请求一次，服务器就回写一次
         */
        while (true) {
            //2.使用ServerSocket对象中的方法accept。获取到请求的客户端对象Socket(浏览器)
            Socket socket = server.accept();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //3.使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream对象
                        InputStream is = socket.getInputStream();
                        //4.把is网络字节数入流对象，转换为字符缓冲流对象
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));

                        //5.把客户端请求信息的第一行读取出来
                        String line = br.readLine();
                        //把读取的信息进行切割，只要中间部分
                        String[] arr = line.split(" ");
                        //把路径前边的/去掉，进行截取
                        String htmlpath = arr[1].substring(1);

                        //6.创建一个本地字节输入流，构造方法中绑定要读取的html路径
                        FileInputStream fis = new FileInputStream(htmlpath);
                        //7.使用Socket对象中的方法getOutputStream()获取网络字节输出流OutputStream对象
                        OutputStream os = socket.getOutputStream();

                        //8.写入http协议响应头，固定写法
                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content-Type:text/html\r\n".getBytes());
                        //必须要写入空行，否则浏览器不解析
                        os.write("\r\n".getBytes());

                        //9.一读一写复制文件，把服务器读取的html文件回写到客户端
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while((len = fis.read(bytes)) != -1) {
                            os.write(bytes, 0, len);
                        }

                        //10.释放资源
                        fis.close();
                        socket.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            }).start();
        }

        //server.close();
    }
}
