package com.company;

import java.io.*;
import java.net.*;

class udpServer
{
    private static int amount=1000;
    public static void main(String args[]) throws Exception
    {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true)
        {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String( receivePacket.getData());
            String StringToSend="";


            if(sentence.contains("withdraw"))
            {
                String amountInString[]=sentence.split(" ");
                amount= amount-Integer.parseInt(amountInString[1].trim());
                StringToSend="Withdraw request is received. New amount "+ amount;
            }
            else if(sentence.contains("deposit"))
            {
                String amountInString[]=sentence.split(" ");
                amount+=Integer.parseInt(amountInString[1].trim());
                StringToSend="Withdraw request is received. New amount "+ amount;
            }
            else if(sentence.contains("exit"))
            {
                StringToSend="exit";
                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();

                sendData = StringToSend.getBytes();
                DatagramPacket sendPacket =
                        new DatagramPacket(sendData, sendData.length, IPAddress, port);
                serverSocket.send(sendPacket);
                return;
            }
            else
            {
                StringToSend="Please use <action> <amount> format.";
            }

            System.out.println("RECEIVED: " + sentence);
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            sendData = StringToSend.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}
