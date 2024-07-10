package com.network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Recive {

    public static void main(String[] args) throws IOException {

        // 创建Socket对象
        DatagramSocket socket = new DatagramSocket(10086);

        // 创建数据包对象，用来接收数据
        byte[] buf = new byte[4096];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        // 接收数据
        socket.receive(packet);
        int port = packet.getPort();
        InetAddress ia = packet.getAddress();
        byte[] data = packet.getData();
        int len = packet.getLength();

        System.out.println("接受了从" + ia + "主机的" + port + "端口发送的数据：" + new String(data, 0, len));

        // 关闭接收端
        socket.close();

    }
}
