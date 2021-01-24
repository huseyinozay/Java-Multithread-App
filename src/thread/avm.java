/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.awt.Color;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author husey
 */
public class avm extends javax.swing.JFrame {

    /**
     * Creates new form avm
     */
    public avm() throws InterruptedException {
        initComponents();
        
        
        Insan insan = new Insan();
        Giris_Thread gt = new Giris_Thread("Giriş", insan, 1000);
        Cikis_Thread ct = new Cikis_Thread("Çıkış", insan, 500);
        Asansor asansor = new Asansor("Asansör", insan, 200);
        Asansor asansor1 = new Asansor("Asansör1", insan, 200);
        Asansor asansor2 = new Asansor("Asansör2", insan, 200);
        Asansor asansor3 = new Asansor("Asansör3", insan, 200);
        Asansor asansor4 = new Asansor("Asansör4", insan, 200);
        Kontrol kontrol = new Kontrol("Kontrol", insan,0,asansor1,asansor2,asansor3,asansor4);
        
        
        
        
        gt.start();
        ct.start();
        asansor.start();
        asansor.devam();
        kontrol.start();
        
        
        Thread islemler = new Thread(){
            
            @Override
            public void run(){
                while(true){
                    //String s=String.valueOf(kontrol.getKuyruk_toplam());
                    //zemin.setText(s);
                    String girenler="";
                    int gk=0;
                    for(int[] name:insan.getGiren_kuyruk()) {
                        girenler = girenler + ("[" + name[0]+"][" + name[1]+"],");
                        gk += name[1];
                    }
                    String birinci="";
                    int bir=0;
                    for(int[] name:insan.getKat_1_kuyruk()) {
                        birinci = birinci + ("[" + name[0]+"][" + name[1]+"],");
                        bir += name[1];
                    }
                    String ikinci="";
                    int iki=0;
                    for(int[] name:insan.getKat_2_kuyruk()) {
                        ikinci = ikinci + ("[" + name[0]+"][" + name[1]+"],");
                        iki += name[1];
                    }
                    String ucuncu="";
                    int uc=0;
                    for(int[] name:insan.getKat_3_kuyruk()) {
                        ucuncu = ucuncu + ("[" + name[0]+"][" + name[1]+"],");
                        uc += name[1];
                    }
                    String dorduncu="";
                    int dort=0;
                    for(int[] name:insan.getKat_4_kuyruk()) {
                        dorduncu = dorduncu + ("[" + name[0]+"][" + name[1]+"],");
                        dort += name[1];
                    }
                    zemin.setText("Zemin kat : Kuyruk : "+ gk);
                    kat_1.setText("1.Kat : "+insan.getBirinci_kat()+"  Kuyruk : "+ bir);
                    kat_2.setText("2.Kat : "+insan.getIkinci_kat()+"  Kuyruk : "+ iki);
                    kat_3.setText("3.Kat : "+insan.getUcuncu_kat()+"  Kuyruk : "+ uc);
                    kat_4.setText("4.Kat : "+insan.getDorduncu_kat()+"  Kuyruk : "+ dort);
                    zemin_sira.setText("Zemin Kat : "+girenler);
                    kat_1_sira.setText("1.Kat : "+birinci);
                    kat_2_sira.setText("2.Kat : "+ikinci);
                    kat_3_sira.setText("3.Kat : "+ucuncu);
                    kat_4_sira.setText("4.Kat  : "+dorduncu);
                    
                    asansor_1.setText("1. Asansör : " + asansor.isAlive());
                    asansor_2.setText("2. Asansör : " + kontrol.getAsansor1().isAlive());
                    asansor_3.setText("3. Asansör : " + kontrol.getAsansor2().isAlive());
                    asansor_4.setText("4. Asansör : " + kontrol.getAsansor3().isAlive());
                    asansor_5.setText("5. Asansör : " + kontrol.getAsansor4().isAlive());
                    asansor_1.setOpaque(true);
                    asansor_2.setOpaque(true);
                    asansor_3.setOpaque(true);
                    asansor_4.setOpaque(true);
                    asansor_5.setOpaque(true);
                    floor1.setText("Kat : " + asansor.getKat());
                    floor2.setText("Kat : " + kontrol.getAsansor1().getKat());
                    floor3.setText("Kat : " + kontrol.getAsansor2().getKat());
                    floor4.setText("Kat : " + kontrol.getAsansor3().getKat());
                    floor5.setText("Kat : " + kontrol.getAsansor4().getKat());
                    destination1.setText("Hedef Kat : " + asansor.getHedef());
                    destination2.setText("Hedef Kat : " + kontrol.getAsansor1().getHedef());
                    destination3.setText("Hedef Kat : " + kontrol.getAsansor2().getHedef());
                    destination4.setText("Hedef Kat : " + kontrol.getAsansor3().getHedef());
                    destination5.setText("Hedef Kat : " + kontrol.getAsansor4().getHedef());
                    direction1.setText("Yön : " +asansor.getYon() );
                    direction2.setText("Yön : " +kontrol.getAsansor1().getYon() );
                    direction3.setText("Yön : " +kontrol.getAsansor2().getYon() );
                    direction4.setText("Yön : " +kontrol.getAsansor3().getYon() );
                    direction5.setText("Yön : " +kontrol.getAsansor4().getYon() );
                    
                    String s="";
                    int ci=0;
                    for(int[] name:asansor.getYolcu()) {
                        s = s+("[" + name[0]+"][" + name[1]+"],");
                        ci += name[1];
                    }
                    String s1="";
                    int ci1=0;
                    for(int[] name:kontrol.getAsansor1().getYolcu()) {
                        s1 = s1+("[" + name[0]+"][" + name[1]+"],");
                        ci1 += name[1];
                    }
                    String s2="";
                    int ci2=0;
                    for(int[] name:kontrol.getAsansor2().getYolcu()) {
                        s2 = s2+("[" + name[0]+"][" + name[1]+"],");
                        ci2 += name[1];
                    }
                    String s3="";
                    int ci3=0;
                    for(int[] name:kontrol.getAsansor3().getYolcu()) {
                        s3 = s3+("[" + name[0]+"][" + name[1]+"],");
                        ci3 += name[1];
                    }
                    String s4="";
                    int ci4=0;
                    for(int[] name:kontrol.getAsansor4().getYolcu()) {
                        s4 = s4+("[" + name[0]+"][" + name[1]+"],");
                        ci4 += name[1];
                    }
                    count_inside1.setText("Yolcu Sayısı : " + ci);
                    count_inside2.setText("Yolcu Sayısı : " + ci1);
                    count_inside3.setText("Yolcu Sayısı : " + ci2);
                    count_inside4.setText("Yolcu Sayısı : " + ci3);
                    count_inside5.setText("Yolcu Sayısı : " + ci4);
                    
                    inside.setText("İçerideki Yolcular : " + s);
                    inside1.setText("İçerideki Yolcular : " + s1);
                    inside2.setText("İçerideki Yolcular : " + s2);
                    inside3.setText("İçerideki Yolcular : " + s3);
                    inside4.setText("İçerideki Yolcular : " + s4);
                    
                    cikanlar.setText("Çıkanlar : "+insan.getCikan());
                    
                    if(asansor.isAlive()){
                        asansor_1.setBackground(Color.green);
                        mode1.setText("Durum : Çalışıyor");
                    }
                    else{
                        asansor_1.setBackground(Color.red);
                        mode1.setText("Durum : Beklemede");
                        
                        
                    }
                    if(kontrol.getAsansor1().isAlive()){
                        asansor_2.setBackground(Color.green);
                        mode2.setText("Durum : Çalışıyor");
                    }
                    else{
                        asansor_2.setBackground(Color.red);
                        mode2.setText("Durum : Beklemede");
                    }
                    if(kontrol.getAsansor2().isAlive()){
                        asansor_3.setBackground(Color.green);
                        mode3.setText("Durum : Çalışıyor");
                    }
                    else{
                        asansor_3.setBackground(Color.red);
                        mode3.setText("Durum : Beklemede");
                    }
                    if(kontrol.getAsansor3().isAlive()){
                        asansor_4.setBackground(Color.green);
                        mode4.setText("Durum : Çalışıyor");
                    }
                    else{
                        asansor_4.setBackground(Color.red);
                        mode4.setText("Durum : Beklemede");
                    }
                    if(kontrol.getAsansor4().isAlive()){
                        asansor_5.setBackground(Color.green);
                        mode5.setText("Durum : Çalışıyor");
                    }
                    else{
                        asansor_5.setBackground(Color.red);
                        mode5.setText("Durum : Beklemede");
                    }
                    
                }
                
            }
            
        };
        islemler.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        zemin = new javax.swing.JLabel();
        kat_1 = new javax.swing.JLabel();
        kat_3 = new javax.swing.JLabel();
        kat_2 = new javax.swing.JLabel();
        cikanlar = new javax.swing.JLabel();
        kat_4 = new javax.swing.JLabel();
        inside = new javax.swing.JLabel();
        mode1 = new javax.swing.JLabel();
        capacity1 = new javax.swing.JLabel();
        floor1 = new javax.swing.JLabel();
        count_inside1 = new javax.swing.JLabel();
        destination1 = new javax.swing.JLabel();
        direction1 = new javax.swing.JLabel();
        asansor_1 = new javax.swing.JLabel();
        inside1 = new javax.swing.JLabel();
        count_inside2 = new javax.swing.JLabel();
        capacity2 = new javax.swing.JLabel();
        direction2 = new javax.swing.JLabel();
        destination2 = new javax.swing.JLabel();
        floor2 = new javax.swing.JLabel();
        mode2 = new javax.swing.JLabel();
        asansor_2 = new javax.swing.JLabel();
        inside3 = new javax.swing.JLabel();
        count_inside4 = new javax.swing.JLabel();
        capacity4 = new javax.swing.JLabel();
        direction4 = new javax.swing.JLabel();
        destination4 = new javax.swing.JLabel();
        floor4 = new javax.swing.JLabel();
        mode4 = new javax.swing.JLabel();
        asansor_4 = new javax.swing.JLabel();
        inside4 = new javax.swing.JLabel();
        count_inside5 = new javax.swing.JLabel();
        capacity5 = new javax.swing.JLabel();
        direction5 = new javax.swing.JLabel();
        destination5 = new javax.swing.JLabel();
        floor5 = new javax.swing.JLabel();
        mode5 = new javax.swing.JLabel();
        asansor_5 = new javax.swing.JLabel();
        inside2 = new javax.swing.JLabel();
        count_inside3 = new javax.swing.JLabel();
        capacity3 = new javax.swing.JLabel();
        direction3 = new javax.swing.JLabel();
        destination3 = new javax.swing.JLabel();
        floor3 = new javax.swing.JLabel();
        mode3 = new javax.swing.JLabel();
        asansor_3 = new javax.swing.JLabel();
        kat_4_sira = new javax.swing.JLabel();
        kat_3_sira = new javax.swing.JLabel();
        kat_2_sira = new javax.swing.JLabel();
        kat_1_sira = new javax.swing.JLabel();
        zemin_sira = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1600, 900));

        zemin.setText("Kat 0");

        kat_1.setText("Kat 1");

        kat_3.setText("Kat 3");

        kat_2.setText("Kat 2");

        cikanlar.setText("Çıkanlar");

        kat_4.setText("Kat 4");

        inside.setText("inside");

        mode1.setText("mode");

        capacity1.setText("Kapasite : 10");

        floor1.setText("floor");

        count_inside1.setText("count_inside");

        destination1.setText("destination");

        direction1.setText("direction");

        asansor_1.setText("AsansorActive 1");

        inside1.setText("inside");

        count_inside2.setText("count_inside");

        capacity2.setText("Kapasite : 10");

        direction2.setText("direction");

        destination2.setText("destination");

        floor2.setText("floor");

        mode2.setText("mode");

        asansor_2.setText("AsansorActive 2");

        inside3.setText("inside");

        count_inside4.setText("count_inside");

        capacity4.setText("Kapasite : 10");

        direction4.setText("direction");

        destination4.setText("destination");

        floor4.setText("floor");

        mode4.setText("mode");

        asansor_4.setText("AsansorActive 4");

        inside4.setText("inside");

        count_inside5.setText("count_inside");

        capacity5.setText("capacity");

        direction5.setText("direction");

        destination5.setText("destination");

        floor5.setText("floor");

        mode5.setText("mode");

        asansor_5.setText("AsansorActive 5");

        inside2.setText("inside");

        count_inside3.setText("count_inside");

        capacity3.setText("Kapasite : 10");

        direction3.setText("direction");

        destination3.setText("destination");

        floor3.setText("floor");

        mode3.setText("mode");

        asansor_3.setText("AsansorActive 3");

        kat_4_sira.setText("Kat 4");

        kat_3_sira.setText("Kat 3");

        kat_2_sira.setText("Kat 2");

        kat_1_sira.setText("Kat 1");

        zemin_sira.setText("Kat 0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cikanlar, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(asansor_3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(count_inside3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(capacity3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(direction3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(destination3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(floor3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mode3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inside2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(asansor_1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(77, 77, 77)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(count_inside1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(capacity1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(direction1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(destination1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(floor1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(mode1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(inside, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(37, 37, 37))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(zemin, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(kat_4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(kat_3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(kat_2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(kat_1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(108, 108, 108)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(zemin_sira, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kat_4_sira, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kat_3_sira, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kat_2_sira, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kat_1_sira, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(asansor_2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(77, 77, 77)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(count_inside2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(capacity2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(direction2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(destination2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(floor2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(mode2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(inside1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(asansor_4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(count_inside4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(capacity4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(direction4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(destination4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(floor4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mode4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inside3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(asansor_5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(count_inside5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(capacity5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(direction5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(destination5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(floor5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mode5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inside4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(zemin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kat_1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kat_2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kat_3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kat_4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(zemin_sira, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kat_1_sira, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kat_2_sira, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kat_3_sira, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kat_4_sira, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cikanlar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mode2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(floor2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(destination2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(asansor_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(direction2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(capacity2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(count_inside2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inside1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mode3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(floor3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(destination3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(asansor_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(direction3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(capacity3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(count_inside3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inside2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(mode1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(floor1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(destination1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(asansor_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(direction1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(capacity1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(count_inside1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inside, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(mode4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(floor4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(destination4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(asansor_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(direction4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(capacity4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(count_inside4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inside3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(80, 80, 80)
                        .addComponent(mode5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(floor5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(destination5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(asansor_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(direction5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(capacity5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(count_inside5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inside4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(avm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(avm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(avm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(avm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new avm().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(avm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel asansor_1;
    private javax.swing.JLabel asansor_2;
    private javax.swing.JLabel asansor_3;
    private javax.swing.JLabel asansor_4;
    private javax.swing.JLabel asansor_5;
    private javax.swing.JLabel capacity1;
    private javax.swing.JLabel capacity2;
    private javax.swing.JLabel capacity3;
    private javax.swing.JLabel capacity4;
    private javax.swing.JLabel capacity5;
    private javax.swing.JLabel cikanlar;
    private javax.swing.JLabel count_inside1;
    private javax.swing.JLabel count_inside2;
    private javax.swing.JLabel count_inside3;
    private javax.swing.JLabel count_inside4;
    private javax.swing.JLabel count_inside5;
    private javax.swing.JLabel destination1;
    private javax.swing.JLabel destination2;
    private javax.swing.JLabel destination3;
    private javax.swing.JLabel destination4;
    private javax.swing.JLabel destination5;
    private javax.swing.JLabel direction1;
    private javax.swing.JLabel direction2;
    private javax.swing.JLabel direction3;
    private javax.swing.JLabel direction4;
    private javax.swing.JLabel direction5;
    private javax.swing.JLabel floor1;
    private javax.swing.JLabel floor2;
    private javax.swing.JLabel floor3;
    private javax.swing.JLabel floor4;
    private javax.swing.JLabel floor5;
    private javax.swing.JLabel inside;
    private javax.swing.JLabel inside1;
    private javax.swing.JLabel inside2;
    private javax.swing.JLabel inside3;
    private javax.swing.JLabel inside4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel kat_1;
    private javax.swing.JLabel kat_1_sira;
    private javax.swing.JLabel kat_2;
    private javax.swing.JLabel kat_2_sira;
    private javax.swing.JLabel kat_3;
    private javax.swing.JLabel kat_3_sira;
    private javax.swing.JLabel kat_4;
    private javax.swing.JLabel kat_4_sira;
    private javax.swing.JLabel mode1;
    private javax.swing.JLabel mode2;
    private javax.swing.JLabel mode3;
    private javax.swing.JLabel mode4;
    private javax.swing.JLabel mode5;
    private javax.swing.JLabel zemin;
    private javax.swing.JLabel zemin_sira;
    // End of variables declaration//GEN-END:variables
}
