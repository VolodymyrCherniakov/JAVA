package com.mycompany.zavod;

import java.io.ObjectStreamConstants;
import java.util.Scanner;

public class Zavod{

    String name;
    Zavodnik[] arr = new Zavodnik[0];

    public String getName() {
        return name;
    }

    public Zavod(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getSize(){
        return this.arr.length;
    }
    public void addPlayer(Zavodnik player) {
        Zavodnik[] temp = new Zavodnik[arr.length+1];
        if(arr.length == 0){
            
            temp[0] = player;
        }else{
            
            for(int i = 0; i<arr.length; i++){
                temp[i] = arr[i];
            }
            temp[arr.length+1] = player;
        }
        arr = temp;
    }

    public void print(){
        System.out.println("Name of race: " + this.name);
        System.out.println("\n\nName\t\tSurname\t\tNumber\t\tTeam\t\tSex\t\tYear of birth\t\tWave\t\tRank\t\tFee status\t\tTime of start\t\tTime of finish\t\tTotal time");
        for(int i = 0; i<arr.length; i++){
            arr[i].print();
        }
    }
    
    public static void main(String[] args) {
        Zavod race = new Zavod("F1");
        Zavodnik man = new Zavodnik();
        man.Registration("Ivan", "Pantelus");
        man.setBornYear(1945);
        man.Pay();
        man.Start(10, 17, 20);
        man.Finish(12, 27, 30);
        man.print();
        race.addPlayer(man);
        System.out.println(race.getSize());
        race.print();
    }

    

}
