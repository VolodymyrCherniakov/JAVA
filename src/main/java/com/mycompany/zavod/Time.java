package com.mycompany.zavod;

public class Time {

    private int HH;
    private int MM;
    private int SS;
    
    public Time(){
        this.HH = 0;
        this.MM = 0;
        this.SS = 0;
    }
    public Time(int HH, int MM, int SS) {
        if (HH >= 0 && HH < 24) {
            this.HH = HH;
        }
        if (MM >= 0 && MM < 60) {
            this.MM = MM;
        }
        if (SS >= 0 && SS < 60) {
            this.SS = SS;
        }
    }

    public int getHH() {
        return HH;
    }

    public void setHH(int HH) {
        if (HH >= 0 && HH < 24) {
            this.HH = HH;
        }
    }

    public int getMM() {
        return MM;
    }

    public void setMM(int MM) {
        if (MM >= 0 && MM < 60) {
            this.MM = MM;
        }
    }

    public int getSS() {
        return SS;
    }

    public void setSS(int SS) {
        if (SS >= 0 && SS < 60) {
            this.SS = SS;
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.HH, this.MM, this.SS);
    }
    
    
}
