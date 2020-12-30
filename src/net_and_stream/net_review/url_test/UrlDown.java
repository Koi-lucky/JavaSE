package net_and_stream.net_review.url_test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * TODO
 *  【文件下载（爬取）案例】
 *
 * @author Chen
 * @date 2020/12/30 20:42
 */
public class UrlDown {

    public static void main(String[] args) throws IOException {

        // 1.文件的下载地址
        // 图片
 //       URL url = new URL("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fdpic.tiankong.com%2Fud%2Frk%2FQJ8661816517.jpg&refer=http%3A%2F%2Fdpic.tiankong.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1611924299&t=e7025e955a530c1471805fb7159c5b94");
        // 音乐资源
        URL url = new URL("https://m801.music.126.net/20201230211921/79a8ee3ca29cb1af034e320a2eb6974a/jdyyaac/045a/025d/0709/30448742f6572ef1261a0c9a11a166d9.m4a");
        // 2.连接到这个资源 HTTP
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        // 3.爬取数据
        InputStream is = urlConnection.getInputStream();

//        FileOutputStream fos = new FileOutputStream("paQu.txt");// 图片资源文件
        FileOutputStream fos = new FileOutputStream("f.m4a");// 音乐资源

        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write( buffer, 0, len);
        }

        // 4.关闭资源
        fos.close();
        is.close();
        urlConnection.disconnect();
    }
}
