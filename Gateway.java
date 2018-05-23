package com.company;

import java.util.ArrayList;

public class Gateway {
    String ip; //Router's ip
    ArrayList<Integer> dist; //Distance between me and others
    ArrayList<Gateway> komsu; //Routers as neighbors
    int size; //number of neighbors


    Gateway(String p)
    {
        ip = p;
        dist = new ArrayList<Integer>(); //initialize an empty distance array
        komsu = new ArrayList<Gateway>(); //initialize an empty neighbor array
        size = 0;
    }

    public void addNeighbor(Gateway n, Integer d)
    {
        dist.add(d);
        komsu.add(n);
        size++;
    }

    public Gateway getNeighbor(Integer index)
    {
        return komsu.get(index);
    }
    public Integer getNeighborDist(Integer index)
    {
        return dist.get(index);
    }

    public int getSize() {
        return size;
    }

    public ArrayList<Gateway> getKomsu() {
        return komsu;
    }
}
