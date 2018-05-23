package com.company;
import java.io.*;
import java.net.*;

class udpClient
{
    private static InetAddress IPAddress;
    private static DatagramSocket clientSocket;
    private static BufferedReader inFromUser;
    public static void main(String args[]) throws Exception
    {
        while(true) {
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            clientSocket = new DatagramSocket();


            IPAddress = InetAddress.getByName("10.0.55.222");

            byte[] sendData = new byte[1024];
            String sentence = inFromUser.readLine();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
            clientSocket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String ServerMessage = new String(receivePacket.getData());
            System.out.println("FROM SERVER:" + ServerMessage);
            clientSocket.close();
            if(ServerMessage.contains("exit")) break;
        }
    }

}