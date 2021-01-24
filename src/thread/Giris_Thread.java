/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author husey
 */
public class Giris_Thread extends Thread {
    private Insan insan;
    private int sleep;
    private int[] giris = new int[2];
    private CopyOnWriteArrayList<int[]> temp = new CopyOnWriteArrayList<int[]>();
     public Giris_Thread(String name, Insan insan, int sleep){
         super(name);
         this.insan = insan;
         this.sleep = sleep;
     }
     
    @Override
     public void run(){
         while(true){
             Random insan_sayisi = new Random(10);
             Random rand = new Random();
             giris = new int[2];
             int kat = rand.nextInt(4);
             int kisi = rand.nextInt(10);
             
             //System.out.println("Kat :" + kat + "Kişi :" +kisi+ "  ");
             
             giris[0] = kat+1;
             giris[1] = kisi+1;
             insan.getGiren_kuyruk().add(giris);
             
             
             try {
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(Giris_Thread.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        
     }
}
