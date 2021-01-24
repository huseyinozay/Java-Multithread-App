/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.logging.Level;
import java.util.logging.Logger;
import thread.Asansor;

/**
 *
 * @author husey
 */
public class Kontrol extends Thread{
    private Insan insan;
    private Asansor asansor1;
    private Asansor asansor2;
    private Asansor asansor3;
    private Asansor asansor4;
    private int sleep;
    
    public Kontrol(String name, Insan insan, int sleep, Asansor asansor1,Asansor asansor2,Asansor asansor3,Asansor asansor4){
        super (name);
        this.insan = insan;
        this.asansor1 = asansor1;
        this.asansor2 = asansor2;
        this.asansor3 = asansor3;
        this.asansor4 = asansor4;
        this.sleep = sleep;
    }
    
    @Override
    public void run() {
        
        
        
        while(true){
                
                int kuyruk_toplam = 0;
                for(int i=0; i<insan.getGiren_kuyruk().size();i++){
                    kuyruk_toplam += insan.getGiren_kuyruk().get(i)[1];
                }
                for(int i=0; i<insan.getKat_1_kuyruk().size();i++){
                    kuyruk_toplam += insan.getKat_1_kuyruk().get(i)[1];
                }
                for(int i=0; i<insan.getKat_2_kuyruk().size();i++){
                    kuyruk_toplam += insan.getKat_2_kuyruk().get(i)[1];
                }
                for(int i=0; i<insan.getKat_3_kuyruk().size();i++){
                    kuyruk_toplam += insan.getKat_3_kuyruk().get(i)[1];
                }
                for(int i=0; i<insan.getKat_4_kuyruk().size();i++){
                    kuyruk_toplam += insan.getKat_4_kuyruk().get(i)[1];
                }

                if(asansor1.isAlive()==false && asansor2.isAlive()==false && asansor3.isAlive()==false && asansor4.isAlive()==false){
                    if(kuyruk_toplam>20){
                        asansor1 = new Asansor("Asansör1", insan, 200);
                        asansor1.start();
                        asansor1.devam();
                    }
                }
                if(asansor1.isAlive()==true && asansor2.isAlive()==false && asansor3.isAlive()==false && asansor4.isAlive()==false){
                    if(kuyruk_toplam>40){
                        asansor2 = new Asansor("Asansör2", insan, 200);
                        asansor2.start();
                        asansor2.devam();
                    }
                    if(kuyruk_toplam<20){
                        asansor1.beklet();
                        asansor2.beklet();
                        asansor3.beklet();
                        asansor4.beklet();
                    }
                }
                
                if(asansor1.isAlive()==true && asansor2.isAlive()==true && asansor3.isAlive()==false && asansor4.isAlive()==false){
                    if(kuyruk_toplam>60){
                        asansor3 = new Asansor("Asansör3", insan, 200);
                        asansor3.start();
                        asansor3.devam();
                    }
                    if(kuyruk_toplam<30){
                        asansor2.beklet();
                        asansor3.beklet();
                        asansor4.beklet();
                    }
                }
                
                if(asansor1.isAlive()==true && asansor2.isAlive()==true && asansor3.isAlive()==true && asansor4.isAlive()==false){
                    if(kuyruk_toplam>80){
                        asansor4 = new Asansor("Asansör4", insan, 200);
                        asansor4.start();
                        asansor4.devam();
                    }
                    if(kuyruk_toplam<40){
                        asansor3.beklet();
                        asansor4.beklet();
                    }
                }
                if(asansor1.isAlive()==true && asansor2.isAlive()==true && asansor3.isAlive()==true && asansor4.isAlive()==true){
                    if(kuyruk_toplam<50){
                        asansor4.beklet();
                    }
                }
                try {
                Thread.sleep(sleep);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Kontrol.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            
        }
    }

    /**
     * @return the asansor1
     */
    public Asansor getAsansor1() {
        return asansor1;
    }

    /**
     * @param asansor1 the asansor1 to set
     */
    public void setAsansor1(Asansor asansor1) {
        this.asansor1 = asansor1;
    }

    /**
     * @return the asansor2
     */
    public Asansor getAsansor2() {
        return asansor2;
    }

    /**
     * @param asansor2 the asansor2 to set
     */
    public void setAsansor2(Asansor asansor2) {
        this.asansor2 = asansor2;
    }

    /**
     * @return the asansor3
     */
    public Asansor getAsansor3() {
        return asansor3;
    }

    /**
     * @param asansor3 the asansor3 to set
     */
    public void setAsansor3(Asansor asansor3) {
        this.asansor3 = asansor3;
    }

    /**
     * @return the asansor4
     */
    public Asansor getAsansor4() {
        return asansor4;
    }

    /**
     * @param asansor4 the asansor4 to set
     */
    public void setAsansor4(Asansor asansor4) {
        this.asansor4 = asansor4;
    }


    
}
