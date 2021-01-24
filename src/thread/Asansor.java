/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author husey
 */
public class Asansor extends Thread{
    
    private Insan insan;
    private int sleep;
    private CopyOnWriteArrayList<int[]> yolcu = new CopyOnWriteArrayList<int[]>();
    private int denetleme;
    private int kat=0, hedef=1;
    private String yon = "Yukarı";
    private boolean bisey=false;
    
    public Asansor(String name, Insan insan, int sleep){
        super (name);
        this.insan = insan;
        this.sleep = sleep;
    }
    //NewClass nc = new NewClass(0);
    
    @Override
    public void run() {
        try{
            while(bisey){
                kat_dolasma();
                
            }
        } catch (Exception e) {
        }
        
    }
    
    public void beklet(){
        bisey = false;
    }
    public void devam(){
        bisey = true;
    }
    
    public void kat_dolasma() throws InterruptedException{
        denetleme =0;
        yon="Yukarı";
        //zemin kattan insan al
        kat = 0;
        hedef = 1;
        if(insan.getGiren_kuyruk().size()>0){
            while( insan.getGiren_kuyruk().size()>0 &&(denetleme + insan.getGiren_kuyruk().get(0)[1]) <= 10 ){
                denetleme += insan.getGiren_kuyruk().get(0)[1];
                getYolcu().add(insan.getGiren_kuyruk().get(0));
                insan.getGiren_kuyruk().remove(0);
            }
        }
        
        //1. kata uğra bırakılacak varsa bırak
        Thread.sleep(sleep);
        kat = 1;
        hedef = 2;
        for(int i=0; i<getYolcu().size();i++){
            if(getYolcu().get(i)[0]==1){
                insan.setBirinci_kat(insan.getBirinci_kat()+getYolcu().get(i)[1]);
                getYolcu().remove(i);
            }
        }
        //2. kata uğra bırakılacak varsa bırak
        Thread.sleep(sleep);
        kat = 2;
        hedef = 3;
        for(int i=0; i<getYolcu().size();i++){
            if(getYolcu().get(i)[0]==2){
                insan.setIkinci_kat(insan.getIkinci_kat()+getYolcu().get(i)[1]);
                getYolcu().remove(i);
            }
        }
        //3. kata uğra bırakılacak varsa bırak
        Thread.sleep(sleep);
        kat = 3;
        hedef = 4;
        for(int i=0; i<getYolcu().size();i++){
            if(getYolcu().get(i)[0]==3){
                insan.setUcuncu_kat(insan.getUcuncu_kat()+getYolcu().get(i)[1]);
                getYolcu().remove(i);
            }
        }
        //4. kata uğra bırakılacak varsa bırak
        Thread.sleep(sleep);
        kat = 4;
        hedef = 3;
        for(int i=0; i<getYolcu().size();i++){
            if(getYolcu().get(i)[0]==4){
                insan.setDorduncu_kat(insan.getDorduncu_kat()+getYolcu().get(i)[1]);
                getYolcu().remove(i);
            }
        }
        yon = "Aşağı";
        denetleme = 0;
        
        //4.kata uğra alınacak varsa al.
        
        if(insan.getKat_4_kuyruk().size()>0){
            while(insan.getKat_4_kuyruk().size()>0 && denetleme + insan.getKat_4_kuyruk().get(0)[1] <= 10){
                denetleme += insan.getKat_4_kuyruk().get(0)[1];
                getYolcu().add(insan.getKat_4_kuyruk().get(0));
                insan.getKat_4_kuyruk().remove(0);
            }
        }
        
        
        
        //3.kata uğra alınacak varsa al.
        Thread.sleep(sleep);
        kat = 3;
        hedef = 2;
        if(insan.getKat_3_kuyruk().size()>0){
            while(insan.getKat_3_kuyruk().size()>0 && denetleme + insan.getKat_3_kuyruk().get(0)[1] <= 10){
                denetleme += insan.getKat_3_kuyruk().get(0)[1];
                getYolcu().add(insan.getKat_3_kuyruk().get(0));
                insan.getKat_3_kuyruk().remove(0);
            }
        }
        
        
        
        
        //2.kata uğra alınacak varsa al.Thread.sleep(sleep);
        Thread.sleep(sleep);
        kat = 2;
        hedef = 1;
        if(insan.getKat_2_kuyruk().size()>0){
            while(insan.getKat_2_kuyruk().size()>0 && denetleme + insan.getKat_2_kuyruk().get(0)[1] <= 10){
                denetleme += insan.getKat_2_kuyruk().get(0)[1];
                getYolcu().add(insan.getKat_2_kuyruk().get(0));
                insan.getKat_2_kuyruk().remove(0);
            }
        }
        
        
        
        //1.kata uğra alınacak varsa al.
        Thread.sleep(sleep);
        kat = 1;
        hedef = 0;
        if(insan.getKat_1_kuyruk().size()>0){
            while(insan.getKat_1_kuyruk().size()>0 && denetleme + insan.getKat_1_kuyruk().get(0)[1] <= 10){
                denetleme += insan.getKat_1_kuyruk().get(0)[1];
                getYolcu().add(insan.getKat_1_kuyruk().get(0));
                insan.getKat_1_kuyruk().remove(0);
            }
        }
        
        
        
        //Zemin katta insanları çıkart.
        Thread.sleep(sleep);
        kat = 0;
        hedef = 1;
        for(int i=0; i<getYolcu().size(); i++){
            insan.setCikan(insan.getCikan()+getYolcu().get(0)[1]);
            getYolcu().remove(0);
        }
        
        
        
    }

    /**
     * @return the kat
     */
    public int getKat() {
        return kat;
    }

    /**
     * @param kat the kat to set
     */
    public void setKat(int kat) {
        this.kat = kat;
    }

    /**
     * @return the hedef
     */
    public int getHedef() {
        return hedef;
    }

    /**
     * @param hedef the hedef to set
     */
    public void setHedef(int hedef) {
        this.hedef = hedef;
    }

    /**
     * @return the yon
     */
    public String getYon() {
        return yon;
    }

    /**
     * @param yon the yon to set
     */
    public void setYon(String yon) {
        this.yon = yon;
    }

    /**
     * @return the yolcu
     */
    public CopyOnWriteArrayList<int[]> getYolcu() {
        return yolcu;
    }

    /**
     * @param yolcu the yolcu to set
     */
    public void setYolcu(CopyOnWriteArrayList<int[]> yolcu) {
        this.yolcu = yolcu;
    }

    

    
    
}
