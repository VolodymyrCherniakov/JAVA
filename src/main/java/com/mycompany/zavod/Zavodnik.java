package com.mycompany.zavod;

import java.io.ObjectStreamConstants;

public class Zavodnik {

    private Time start;
    private Time finish;
    private Time result;
    private String name;
    private String surname;
    private String race;
    private String team;
    private String pohlavi;
    private int birthYear;
    private int number;
    private int wave;
    private int rank;
    private boolean isPaid;

    public Zavodnik() {
        this.start = new Time(0,0,0);
        this.finish = new Time(0,0,0);
        this.result = new Time(0,0,0);
        this.name = ""; //
        this.surname = ""; // 
        this.race = ""; // 
        this.team = ""; // 
        this.pohlavi = ""; // 
        this.birthYear = 0; // 
        this.number = 0; //
        this.wave = 0; //
        this.rank = 0; // 
        this.isPaid = false;
    }

    public String getRace() {
        return race;
    }
    public void setRace(String race) {
        this.race = race;
    }

    public String getPohlavi() {
        return pohlavi;
    }

    public void setPohlavi(String pohlavi) {
        this.pohlavi = pohlavi;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getBornYear() {
        return birthYear;
    }

    public void setBornYear(int bornYear) {
        this.birthYear = bornYear;
    }

    //++++++it seems to be working++++++++++++//
    public int getNumber() {
        return this.number;
    }
    
    public int getWave() {
        return this.wave;
    }

    public int getRank() {
        return this.rank;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Time getStart() {
        return start;
    }

    public Time getFinish() {
        return finish;
    }

    public Time getResult() {
        return result;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    @Override
    public String toString() {
        return "Zavodnik{" + "start=" + start + ", finish=" + finish + ", result=" + result + ", name=" + name + ", surname=" + surname + ", race=" + race + ", team=" + (team == "" ? "not entered" : team) + ", pohlavi=" + pohlavi + ", birthYear=" + birthYear + ", number=" + number + ", wave=" + wave + ", rank=" + rank + ", isPaid=" + isPaid + '}';
    }
    
    public void print(){
        System.out.println(name  + "\t\t" + surname + "\t" + number + "\t\t" + (team == "" ? "not entered" : team) + "\t" + (pohlavi == "" ? "not entered"  : pohlavi) + "\t" + (birthYear == 0 ? "not entered" : birthYear) + "\t\t\t" + (wave == 0 ? "not entered" : wave) + "\t" + (rank == 0 ? "not entered" : rank)+"\t" +(isPaid == true ? "paid" : "not paid") +"\t\t\t" + start + "\t\t" + finish + "\t\t" + result);
    }
    public void Registration(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.number = this.name.hashCode() + this.surname.hashCode();
        this.number /= (this.number % 10000);
    }

    public void Start(int HH, int MM, int SS) {
        if (isPaid) {
            this.start = new Time(HH, MM, SS);
        }
    }

    public void Finish(int HH, int MM, int SS) {
        if (this.start.getHH() > 0 || this.start.getMM() > 0 || this.start.getSS() > 0) {
            if(HH >= this.start.getHH() || MM >= this.start.getMM() || SS >= this.start.getSS()){
                this.finish = new Time(HH, MM, SS);
                int startSec = this.start.getSS() + this.start.getMM() * 60 + this.start.getHH() * 3600;
                int finishSec = this.finish.getSS() + this.finish.getMM() * 60 + this.finish.getHH() * 3600;
                int resSec = finishSec - startSec;
                this.result = new Time(resSec / 3600, (resSec % 3600) / 60, (resSec % 3600) % 60);
            }
        }
    }

    public void Pay() {
        this.isPaid = true;
    }

    public static void main(String[] args) {
        Zavodnik man = new Zavodnik();
        man.Registration("Ivan", "Pantelus");
        man.setBornYear(1945);
        man.Start(12, 17, 20);
        man.Finish(10, 27, 30);
        
        System.out.println(man);
        
    }
}
