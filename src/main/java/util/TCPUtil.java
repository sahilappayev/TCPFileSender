/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import lombok.SneakyThrows;

/**
 *
 * @author SahilAppayev
 */
public class TCPUtil {
    
    @SneakyThrows
    public static void requireSendingAddress() {
        String filePath = InputUtil.inportText("Enter file path:");
        String serverIpAndPort = InputUtil.inportText("Enter server IP and Port (Ex: 127.0.0.1:5678):");
        String[] arr = serverIpAndPort.split(":");
        String ip = arr[0];
        int port = Integer.parseInt(arr[1]);
        try {
            clientFileAsByteNew(ip, port, filePath);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
    }

    //////////Server\\\\\\\
    public static void connectServerForFileNew(int port, String fileName) throws Exception {
        ServerSocket ourFirstSocket = new ServerSocket(port);// localhost ve ya 127.0.0.1
        while (true) {
            Socket connectionSocket = ourFirstSocket.accept();
            InputStream is = connectionSocket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            int length = dis.readInt();
            byte[] bytes = new byte[length];
            dis.readFully(bytes);
            writeBytes(fileName, bytes);
            System.out.println("File accepted!");
        }
    }

    public static void writeBytes(String fileName, byte[] data) throws Exception {
        File file = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
//            byte[] bytes = object.toString().getBytes();
            fos.write(data);
            fos.flush(); // topladigi melumatlari yazir ve prosesi tesdiqleyir
        }
//        System.out.println("Done");
    }

    /////////////Client\\\\\\\\\\\\
    
    public static void clientFileAsByteNew(String ip, int port, String filePath) throws Exception {
        try (Socket clientSocket = new Socket(ip, port)) {//Autoclosable
            OutputStream os = clientSocket.getOutputStream();
            DataOutputStream outToStream = new DataOutputStream(os);// melumati gonderir
            byte[] bytes = readBytes(filePath);
            outToStream.writeInt(bytes.length);
            outToStream.write(bytes);
            System.out.println("Done!");
        }
    }

    public static byte[] readBytes(String fileName) throws Exception {/// yarimchiq
        File file = new File(fileName);
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);
            return bytes;
        }
    }
}
