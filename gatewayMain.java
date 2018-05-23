package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    private static ArrayList<Gateway> allGateways;

    public static void main(String args[]) throws IOException
    {
        allGateways = new ArrayList<Gateway>();
        for(int i=0; i<30; i++)
        {
            allGateways.add(new Gateway(Integer.toString(i)));
        }


        buildTable();
        showTable();
        System.out.print(shortestPath(0,2)); ;



    }
    public static void buildTable() throws IOException
    {


        File file = new File("routers.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        int j=0;
        while ((line = bufferedReader.readLine()) != null) {
            String[] a=line.split(",");
             for(int i =0;i<a.length ;i++)
             {
                 if(!Objects.equals(a[i], "0") && !Objects.equals(a[i], "-1"))
                 {
                     allGateways.get(j).addNeighbor(allGateways.get(i),Integer.parseInt(a[i]));
                 }
             }
             j++;
        }


    }


    public static void showTable()
    {
        for(int i=0; i<30; i++)
        {
            for(int j=0;j<allGateways.get(i).getSize();j++)
            {
                System.out.print(allGateways.get(i).getNeighbor(j).ip+"->"+allGateways.get(i).getNeighborDist(j)+"  ");
            }
            System.out.println();
        }
    }

    public static Integer shortestPath(Integer a, Integer b)
    {
        if(allGateways.get(a).getKomsu().contains(allGateways.get(b)))
        {
            for(int j=0;j<allGateways.get(a).getSize();j++)
            {
                if(allGateways.get(a).getNeighbor(j)==allGateways.get(b))
                {
                    return allGateways.get(a).getNeighborDist(j);
                }
            }

        }
        else
        {

        }
        return 0;
    }




}

