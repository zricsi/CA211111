package com.company;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        ArrayList<hegy2class> hegyek = new ArrayList<>();
        try
        {
            System.setProperty("file.encoding","UTF8");
            FileReader fr = new FileReader("hegy.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while((line = br.readLine())!=null)
            {
                String[] db = line.split(";");
                String nev = db[0];
                int magassag = Integer.parseInt(db[1]);
                hegy2class hh = new hegy2class(nev,magassag);
                hegyek.add(hh);
            }
            br.close();
        }
        catch (IOException e)
        {
            System.out.println("Hiba a beolvasáskor "+e);
        }
        int max = Integer.MIN_VALUE;
        int index_01 = 0;
        for(int i = 0; i < hegyek.size(); i++)
        {
            if(hegyek.get(i).getMagassag() > max)
            {
                max = hegyek.get(i).getMagassag();
                i = index_01;
            }
        }
        System.out.println("A legmagasabb hegy: "+ hegyek.get(index_01).getNev());
        int ossz = 0;
        for(int i = 0; i < hegyek.size(); i++)
        {
           ossz+=hegyek.get(i).getMagassag();
        }
        System.out.printf("\nA magasságok átlaga: %.2f",(double)ossz/(double)hegyek.size());
        System.out.println("\n");
        int megsz = 0;
        for(int i = 0; i < hegyek.size(); i++)
        {
            if(hegyek.get(i).getMagassag() > 8000)
            {
               megsz++;
            }
            System.out.println(hegyek.get(i).getNev()+", "+hegyek.get(i).getMagassag());
        }
        System.out.println("\n8000-méternél magassabb hegyek száma: "+megsz);
    }
}
