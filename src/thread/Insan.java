/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author husey
 */
public class Insan {

    private CopyOnWriteArrayList<int[]> giren_kuyruk = new CopyOnWriteArrayList<int[]>();
    private CopyOnWriteArrayList<int[]> kat_1_kuyruk = new CopyOnWriteArrayList<int[]>();
    private CopyOnWriteArrayList<int[]> kat_2_kuyruk = new CopyOnWriteArrayList<int[]>();
    private CopyOnWriteArrayList<int[]> kat_3_kuyruk = new CopyOnWriteArrayList<int[]>();
    private CopyOnWriteArrayList<int[]> kat_4_kuyruk = new CopyOnWriteArrayList<int[]>();
    private int birinci_kat=0,ikinci_kat=0,ucuncu_kat=0,dorduncu_kat=0,cikan=0;
    
    public Insan(){
    }

    /**
     * @return the birinci_kat
     */
    public int getBirinci_kat() {
        return birinci_kat;
    }

    /**
     * @param birinci_kat the birinci_kat to set
     */
    public void setBirinci_kat(int birinci_kat) {
        this.birinci_kat = birinci_kat;
    }

    /**
     * @return the ikinci_kat
     */
    public int getIkinci_kat() {
        return ikinci_kat;
    }

    /**
     * @param ikinci_kat the ikinci_kat to set
     */
    public void setIkinci_kat(int ikinci_kat) {
        this.ikinci_kat = ikinci_kat;
    }

    /**
     * @return the ucuncu_kat
     */
    public int getUcuncu_kat() {
        return ucuncu_kat;
    }

    /**
     * @param ucuncu_kat the ucuncu_kat to set
     */
    public void setUcuncu_kat(int ucuncu_kat) {
        this.ucuncu_kat = ucuncu_kat;
    }

    /**
     * @return the dorduncu_kat
     */
    public int getDorduncu_kat() {
        return dorduncu_kat;
    }

    /**
     * @param dorduncu_kat the dorduncu_kat to set
     */
    public void setDorduncu_kat(int dorduncu_kat) {
        this.dorduncu_kat = dorduncu_kat;
    }
    
    /**
     * @return the giren_kuyruk
     */
    public CopyOnWriteArrayList<int[]> getGiren_kuyruk() {
        return giren_kuyruk;
    }

    /**
     * @param giren_kuyruk the giren_kuyruk to set
     */
    public void setGiren_kuyruk(CopyOnWriteArrayList<int[]> giren_kuyruk) {
        this.giren_kuyruk = giren_kuyruk;
    }

  

    /**
     * @return the kat_1_kuyruk
     */
    public CopyOnWriteArrayList<int[]> getKat_1_kuyruk() {
        return kat_1_kuyruk;
    }

    /**
     * @param kat_1_kuyruk the kat_1_kuyruk to set
     */
    public void setKat_1_kuyruk(CopyOnWriteArrayList<int[]> kat_1_kuyruk) {
        this.kat_1_kuyruk = kat_1_kuyruk;
    }

    /**
     * @return the kat_2_kuyruk
     */
    public CopyOnWriteArrayList<int[]> getKat_2_kuyruk() {
        return kat_2_kuyruk;
    }

    /**
     * @param kat_2_kuyruk the kat_2_kuyruk to set
     */
    public void setKat_2_kuyruk(CopyOnWriteArrayList<int[]> kat_2_kuyruk) {
        this.kat_2_kuyruk = kat_2_kuyruk;
    }

    /**
     * @return the kat_3_kuyruk
     */
    public CopyOnWriteArrayList<int[]> getKat_3_kuyruk() {
        return kat_3_kuyruk;
    }

    /**
     * @param kat_3_kuyruk the kat_3_kuyruk to set
     */
    public void setKat_3_kuyruk(CopyOnWriteArrayList<int[]> kat_3_kuyruk) {
        this.kat_3_kuyruk = kat_3_kuyruk;
    }

    /**
     * @return the kat_4_kuyruk
     */
    public CopyOnWriteArrayList<int[]> getKat_4_kuyruk() {
        return kat_4_kuyruk;
    }

    /**
     * @param kat_4_kuyruk the kat_4_kuyruk to set
     */
    public void setKat_4_kuyruk(CopyOnWriteArrayList<int[]> kat_4_kuyruk) {
        this.kat_4_kuyruk = kat_4_kuyruk;
    }

    /**
     * @return the cikan
     */
    public int getCikan() {
        return cikan;
    }

    /**
     * @param cikan the cikan to set
     */
    public void setCikan(int cikan) {
        this.cikan = cikan;
    }
    
}
