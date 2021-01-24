/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author husey
 */
public class Cikis_Thread extends Thread {
    private Insan insan;
    private int sleep;
    private int[] giris = new int[2];
    private int kat, kisi, i;
     public Cikis_Thread(String name, Insan insan, int sleep){
         super(name);
         this.insan = insan;
         this.sleep = sleep;
     }
     
     @Override
     public synchronized void run(){
         while(true){
             Random insan_sayisi = new Random(10);
             Random rand = new Random();
             
             kat = rand.nextInt(4);
             kisi = rand.nextInt(5);
             
             if(kat == 0){
                 if(insan.getBirinci_kat()>=kisi+1){
                    insan.setBirinci_kat(insan.getBirinci_kat()-(kisi+1));
                    giris = new int[2];
                    giris[0] = 0;
                    giris[1] = kisi+1;
                    insan.getKat_1_kuyruk().add(giris);
                 }
                 else if(insan.getBirinci_kat()>0){
                    
                    giris = new int[2];
                    giris[0] = 0;
                    giris[1] = insan.getBirinci_kat();
                    insan.getKat_1_kuyruk().add(giris);
                    insan.setBirinci_kat(0);
                 }
                 
             }
             if(kat == 1){
                 if(insan.getIkinci_kat()>=(kisi+1)){
                    insan.setIkinci_kat(insan.getIkinci_kat()-(kisi+1));
                    giris = new int[2];
                    giris[0] = 0;
                    giris[1] = kisi+1;
                    insan.getKat_2_kuyruk().add(giris);
                 }
                 else if(insan.getIkinci_kat()>0){
                    giris = new int[2];
                    giris[0] = 0;
                    giris[1] = insan.getIkinci_kat();
                    insan.getKat_2_kuyruk().add(giris);
                    insan.setIkinci_kat(0);
                 }
             }
             if(kat == 2){
                 if(insan.getUcuncu_kat()>=(kisi+1)){
                    insan.setUcuncu_kat(insan.getUcuncu_kat()-(kisi+1));
                    giris = new int[2];
                    giris[0] = 0;
                    giris[1] = kisi+1;
                    insan.getKat_3_kuyruk().add(giris);
                 }
                 else if(insan.getUcuncu_kat()>0){
                    giris = new int[2];
                    giris[0] = 0;
                    giris[1] = insan.getUcuncu_kat();
                    insan.getKat_3_kuyruk().add(giris);
                    insan.setUcuncu_kat(0);
                 }
             }
             if(kat == 3){
                 if(insan.getDorduncu_kat()>=(kisi+1)){
                    insan.setDorduncu_kat(insan.getDorduncu_kat()-(kisi+1));
                    giris = new int[2];
                    giris[0] = 0;
                    giris[1] = kisi+1;
                    insan.getKat_4_kuyruk().add(giris);
                 }
                 else if(insan.getDorduncu_kat()>0){
                    giris = new int[2];
                    giris[0] = 0;
                    giris[1] = insan.getDorduncu_kat();
                    insan.getKat_4_kuyruk().add(giris);
                    insan.setDorduncu_kat(0);
                 }
                 
             }
             
             
             
             try {
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(Giris_Thread.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
        
     }
    
}
