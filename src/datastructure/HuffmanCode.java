package datastructure;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class HuffmanCode {

    public static void main(String[] args) {

        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println("压缩前的数据长度为：" + contentBytes.length);//输出一下数据压缩前的长度

        //测试压缩的所有代码
        byte[] huffmanCodesBytes = huffmanZip(contentBytes);
        System.out.println("压缩后的数据长度为：" + huffmanCodesBytes.length);
        System.out.println("压缩后的结果为： " + Arrays.toString(huffmanCodesBytes));

        //测试解压数据的代码
        byte[] sourceBytes = decode( huffermanCodes, huffmanCodesBytes);
        System.out.println(" 将压缩后的数据解压后得到的结果为 ： " +  new String(sourceBytes));

        //测试压缩文件
        //String srcFile = "e:\\0810.txt";
        //String dstFile = "e:\\0810.zip";
        //zipFile(srcFile, dstFile);
        //System.out.println("文件压缩完毕！！");


        // 测试解压文件
        String zipFile = "e:\\0810.zip";
        String dstFile = "e:\\08102.word";
        unZipFile( zipFile, dstFile);
        System.out.println("文件解压完毕！！");

        //分步测试所写的压缩的代码
        /**
        ArrayList<Node2> nodes = getNodes(contentBytes);
        System.out.println("nodes = " + nodes);
        //测试一下创建的哈夫曼树
        System.out.println("所生成的哈夫曼树为：");
        Node2 huffmenTreeRoot = createHuffmanTree(nodes);
        System.out.println("前序遍历为;");
        preOrder(huffmenTreeRoot);


        //测试一下生成的哈夫曼编码表
        System.out.println("生成的哈夫曼编码表为 = " + getCodes(huffmenTreeRoot));
         */

    }

    //写一个方法，统计各个字符出现的次数，并进行存储
    private static ArrayList<Node2> getNodes(byte[] bytes) {
        //创建一个列表
        ArrayList<Node2> nodes = new ArrayList<>();
        //创建一个HashMap,用于存储每个字符出现的次数
        HashMap<Byte,Integer> counts = new HashMap<>();
        //遍历，统计
        for (byte b : bytes) {
            Integer count = counts.get(b);//每个字符的个数个数
            if(count == null) {
                //表示Map中还没有这个数据
                //也就是这个数据的第一次存储
                counts.put( b, 1);
            } else {
                counts.put( b, count + 1);
            }
        }
        //将每一个键值对转成一个node对象，并加入到nodes集合
        //遍历map
        for (HashMap.Entry<Byte,Integer> entry : counts.entrySet()) {
            nodes.add(new Node2( entry.getKey(), entry.getValue()));
        }
        return nodes;
    }



    //写一个前序遍历的方法
    private static void preOrder(Node2 root) {
        if(root != null) {
            root.preOrder();
        } else {
            System.out.println("赫夫曼数为空，无法遍历~~");
        }
    }
    //根据List生成对应的哈夫曼树
    private static Node2 createHuffmanTree(ArrayList<Node2> nodes) {
        while(nodes.size() > 1) {
            //将数组从小到大进行排序
            Collections.sort(nodes);

            //取出根节点权值最小的两颗二叉树
            //1）取出权值最小的结点（二叉树）
            Node2 leftNode = nodes.get(0);
            //2)取出权值第二小的结点（二叉树）
            Node2 rightNode = nodes.get(1);
            //3)构建一颗新的二叉树
            //这棵树的根节点为前两个结点之和
            Node2 parent = new Node2(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            //4)从ArrayList中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //5)将parent加入到nodes
            nodes.add(parent);
        }
        //循环结束后，列表中仅剩一个值，即为最终结果
        //返回哈夫曼树的root点
        return nodes.get(0);
    }


    //生成哈夫曼树对应的哈夫曼编码、并形成表
    //思路分析
    //1.将哈夫曼编码存放成表的形式——> Map<Byte,String>形式
    //最终生成的赫夫曼表就是这种形式：{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
    static HashMap< Byte, String> huffermanCodes = new HashMap<>();
    //2.在生成的哈夫曼编码表的时候，需要去拼接路径（也就是拼接路径对应的编码“0”或着“1”）————> 用StrinBuffer来存储某个叶子节点的路径
    static StringBuilder stringBuilder = new StringBuilder();

    /**
     * 功能;将传入的node节点的所有叶子节点的哈夫曼编码得到，并放入到huffermanCodes集合中去
     * @param node 传入节点
     * @param code 路径：规定路径为左子节点为0、右子节点为1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(Node2 node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        //将code加入到stringBuilder1
        stringBuilder1.append(code);
        //判断输入的结点需不需要处理
        // 如果node为空，不处理
        if(node != null) {
            //判断当前的节点是叶子节点还是非叶子节点
            //非叶子节点不存放数据，叶子节点里存放了数据
            if(node.data == null) {
                //非叶子节点——> 递归处理——> 规定路径为左0右1
                //向左递归
                getCodes( node.left, "0" ,stringBuilder1);
                // 向右递归
                getCodes( node.right, "1" ,stringBuilder1);
            } else {
                //叶子节点 ——> 表示找到某个叶子节点的最后
                huffermanCodes.put( node.data, stringBuilder1.toString());
            }
        }
    }

    //为了调用方便，重载一下getCodes方法
    private static HashMap<Byte, String> getCodes(Node2 root) {
        if(root == null) {
            return null;
        }
        //处理root的左子树
        getCodes( root.left, "0", stringBuilder);
        // 处理root的右子树
        getCodes( root.right, "1", stringBuilder);
        return huffermanCodes;
    }



    //编写一个方法，将字符串对应的byte[]数组，通过生成的哈夫曼编码表，返回一个哈夫曼编码解压的byte数组

    /**
     *
     * @param bytes 这是原始字符串对应的byte[]
     * @param huffermanCodes  生成的哈夫曼编码map
     * @return 返回哈夫曼编码处理后的byte[]
     *
     * 举例：String content = "i like like like java do you like a java"; ==》 byte[] contentBytes = content.getByte();
     * 返回的是：10101000101111111100100010……
     * ===>  其结果对应的byte[] huffmanCodeBytes ,即8位对应一个byte，放入到huffmanCodeBytes中
     * 转换：huffmanCodeBytes[0] = (前八位：)10101000 ==> byte [推导：10101000 (补码)  ==>  （符号为不变，补码-1 ）10101000 - 1 = 10100111（反码） ===> (符号位不变其他位变反) 11011000 = -88]
     * 所以 huffmanCodeBytes[0] = -88
      */
    private static byte[] zip(byte[] bytes, HashMap<Byte, String> huffermanCodes) {
        //1.利用huffermanCodes将bytes转成哈夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes数组
        for (byte b : bytes) {
            stringBuilder.append(huffermanCodes.get(b));
        }
        //将“1010100010……”转成byte[]

        //统计返回byte[] huffmanCodeBytes 的长度
        int len;
        if(stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        //创建 存储压缩之后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;//用于记录是第几个byte
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            //因为每8位对应一个byte，所以步长为8
            String strByte;
            if(i + 8 > stringBuilder.length()) {//该位数，不足8位
                strByte = stringBuilder.substring(i);//从i开始一直取完
            } else {
                strByte = stringBuilder.substring( i, i + 8);//从i开始取，取8位
            }
            //将strByte 转成byte,放入到huffmanCodeBytes
            huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte, 2);//将二进制码转换成十进制，并且要加强制转换类型(byte)
            index ++;
        }
        return huffmanCodeBytes;
    }


    //使用一个方法，将前面的方法封装起来，便于我们调用

    /**
     *
     * @param bytes 原始的字符串对应的字节数组
     * @return 返回的是经过哈夫曼编码处理后的字节数组（压缩后的数组）
     */
    private static byte[] huffmanZip(byte[] bytes) {
        ArrayList<Node2> nodes = getNodes(bytes);
        //根据nodes创建哈夫曼树
        Node2 huffmanTreeRoot = createHuffmanTree(nodes);
        //对应的哈夫曼编码
        HashMap<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        //根据生成的哈夫曼编码，压缩得到压缩后的哈夫曼编码字节数组
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }


    //数据的解压方法
    //1.先写一个将字节数组转换成二进制的字符串的方法

    /**
     * 功能：将一个byte转成一个二进制的字符串
     * @param flag 传入需要转换的字节数组
     * @param b 标记是否需要补高位，如果是true，表示需要补高位；如果是false，表示不补；如果是最后一个字节，无需补高位
     * @return 返回的是该字节数组所对应的二进制的字符串（【注意】返回的是补码）
     */
    private static String byteToBitString(boolean flag, byte b) {
        //使用变量保存b
        int temp = b;
        //如果是整数，我们还存在补高位的情况
        if(flag) {
            temp |= 256;//按位与 256 1 0000 0000  |  0000 0001 ==> 1 0000 0001
        }
        String str = Integer.toBinaryString(temp);//返回的是temp对应的二进制的字符串
        if(flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }
    //2.数据的解码
    private static byte[] decode(HashMap<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        //1.先得到huffmanByte 对应的二进制的字符串，形式如：1010100010111……
        StringBuilder stringBuilder = new StringBuilder();
        //将字节数组转成二进制的字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            //判断是不是最后一个字符——最后一个字符无需补高位
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString( !flag, b));
        }
        //把字符串压缩好的哈夫曼编码进行解码
        //把哈夫曼编码表的内容进行调换，因为反向查询：a —— 100， 100 —— a
        HashMap<String, Byte> map = new HashMap<>();
        for (HashMap.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        //创建集合，存放byte
        ArrayList<Byte> list = new ArrayList<>();
        //i可以理解为索引值，为了扫描stringBuilder
        for (int i = 0; i < stringBuilder.length(); ) {//i的增值为count + 1(不定长)
            int count = 0;//计数器
            boolean flag = true;
            Byte b = null;

            while(flag){
                String key = stringBuilder.substring( i, i + count);//i不动，让count移动，指定匹配到一个字符
                b = map.get(key);
                if(b == null) {//说明没有匹配到
                    count++;
                } else {
                    //匹配到了
                    flag = false;
                }
            }
            list.add(b);
            i = i + count;//i直接移动到count的位置
        }
        //当for循环结束后，list中就存放了所有字符"i like like like java do you like a java"
        // 把list中的数据放入字节数组byte[]中并返回
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }


    //压缩文件的方法

    /**
     *
     * @param srcFile 传入的希望进行压缩的文件的全路径
     * @param dstFile 将压缩后的文件放在哪个目录
     */
    public static void zipFile(String srcFile, String dstFile) {
        //创建输出流
        OutputStream os = null;
        ObjectOutputStream oos = null;
        // 创建文件的输入流
        FileInputStream is = null;
        try {
            //创建文件的输入流
            is = new FileInputStream(srcFile);
            //创建一个和源文件大小一样的byte[]
            byte[] b = new byte[is.available()];
            //读取文件
            is.read(b);
            //直接对源文件压缩
            byte[] huffmanBytes = huffmanZip(b);
            //创建文件的输出流，存放存储文件
            os = new FileOutputStream(dstFile);
            //创建一个和文件输出流关联的ObjectOutputStream
            oos = new ObjectOutputStream(os);
            //把哈夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            //这里我们是以对象流的方式写入 哈夫曼编码， 是为了以后我们恢复源文件时使用
            // 【注意】一定要把哈夫曼编码 写入压缩文件
            oos.writeObject(huffermanCodes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                is.close();
                oos.close();
                os.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    // 解压文件的方法

    /**
     *
     * @param zipFile 准备解压的文件
     * @param dstFile 将文件解压到那个路径
     */
    public static void unZipFile(String zipFile, String dstFile) {
        //定义文件的输入流
        InputStream is = null;
        // 定义一个对象的输入流
        ObjectInputStream ois = null;
        // 定义文件的输出流
        OutputStream os = null;
        try {
            //创建文件输入流
            is = new FileInputStream(zipFile);
            //创建一个和is关联的对象输入流
            ois = new ObjectInputStream(is);
            //读取byte数组 huffmanBytes
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取哈夫曼编码表
            HashMap<Byte, String> huffmanCodes = (HashMap<Byte, String>)ois.readObject();

            //解码
            byte[] bytes = decode(huffmanCodes, huffmanBytes);
            //将bytes数组写入到目标文件
            os = new FileOutputStream(dstFile);
            //写数据到dstFile文件
            os.write(bytes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                os.close();
                ois.close();
                is.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}

//创建Node，表示待存取的数据+权值
class Node2 implements Comparable<Node2> {
    Byte data;//存放数据（字符）本身，比如 'a'==> 97 ; 空格 ==> 32
    int weight;//权值，表示字符出现的次数
    Node2 left;//指向该节点的左子结点
    Node2 right;//指向该结点的右子节点

    public Node2(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{ data =" + data + "; weight = " + weight + '}';
    }

    @Override
    public int compareTo(Node2 o) {
        //将数从大到小排序
        return this.weight - o.weight;
    }

    //写一个前序遍历的方法用于测试生成的哈夫曼树
    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }
}