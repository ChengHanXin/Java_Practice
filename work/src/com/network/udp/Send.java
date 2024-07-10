package com.network.udp;

import java.io.IOException;
import java.net.*;

public class Send {
    public static void main(String[] args) throws IOException {

        // 创建Socket对象
        DatagramSocket socket = new DatagramSocket();

        // 创建数据包对象，用来打包数据
        String str = "你好";
        byte[] buf = str.getBytes();
        InetAddress ia = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(buf, str.length(), ia, 10086);

        // 发送数据
        socket.send(packet);

        // 关闭发送端
        socket.close();

    }
}
