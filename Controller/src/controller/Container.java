/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Freddy
 */
public class Container implements Serializable{
    	String containerID;
    //aankomst
        int adatumD;
        int adatumM;
        int adatumJ;
        double aVan;
        double aTot;
        String asoortvervoer;
        String avervoerbedrijf;
        float x;
        float y;
        float z;
        String eigenaar;
        int containerNr;
    //vertrek
        int vdatumD;
        int vdatumM;
        int vdatumJ;
        double vVan;
        double vTot;
        String vsoortvervoer;
        String vvervoerbedrijf;
    //afmetingen
        double l;
        double b;
        double h;
    //gewicht
        int leeg;
        int gevuld;
    //inhoud
        String naam;
        String soort;
        String gevaar;
        String iso;
        
        public String getDatum(){
            String datum = ""+ adatumD + "-" + (adatumM) + "-200" + adatumJ;
            return datum;
        }  
}
