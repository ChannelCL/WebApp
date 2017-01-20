package com.test.netty;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by jiaxl on 2017/1/19.
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 65535);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        Scanner scanner=new Scanner(System.in);
        while (true) {
            out.write(scanner.nextLine().getBytes());
        }
    }
}
