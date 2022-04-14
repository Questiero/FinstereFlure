/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finstereflure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Chloé
 */
public class Parser {

    private final File fichier;

    public Parser(String nomfichier) {
        this.fichier = new File(nomfichier);
    }

    public boolean doesFileExists() {
        try {
            return this.fichier.exists();
        } catch (SecurityException se) {
            System.out.println("Security Exception : access to file denied");
            return false;
        }
    }

    private ArrayList<String> getFileContent() {    //réc^père les données du fichier .cvs dans une liste
        if (this.doesFileExists()) {
            ArrayList<String> l = new ArrayList<>();
            try {
                FileReader freader = new FileReader(this.fichier);
                BufferedReader inputfile = new BufferedReader(freader);
                String readLine = inputfile.readLine();
                while (readLine != null) {
                    l.add(readLine);
                    readLine = inputfile.readLine();
                }
                inputfile.close();
            } catch (IOException ioe) {
                System.out.println("Probleme pendant la lecture du fichier " + this.fichier.getAbsolutePath());
                ioe.printStackTrace();
            }
            return l;
        } else {
            System.out.println("Le fichier " + this.fichier.getAbsolutePath() + " n'existe pas");
            System.exit(1);
            return null;
        }
    }

    public ArrayList<String> getAdjectifs() {   //récupère la première colonne : les adjectifs
        ArrayList<String> lignes = this.getFileContent();
        if (lignes.size() > 0) {
            ArrayList<String> adjectifs = new ArrayList<>();
            for (int i = 0; i < lignes.size(); i++) {
                String adj = this.getTextTo(lignes.get(i), ";");
                if (!adj.equals("")) {  //pour cas d'une colonne plus grande que l'autre
                    char[] temp = adj.toCharArray();
                    temp[0] = Character.toUpperCase(temp[0]);
                    adj = String.valueOf(temp);
                    adjectifs.add(adj);
                }
            }
            return adjectifs;
        } else {
            return null;
        }
    }

    public ArrayList<String> getNoms() {    //récupère la deuxième colonne : les noms
        ArrayList<String> lignes = this.getFileContent();
        if (lignes.size() > 0) {
            ArrayList<String> noms = new ArrayList<>();
            for (int i = 0; i < lignes.size(); i++) {
                String n = this.getTextFrom(lignes.get(i), ";");
                if (!n.equals("")) {  //pour cas d'une colonne plus grande que l'autre
                    char[] temp = n.toCharArray();
                    temp[0] = Character.toUpperCase(temp[0]);
                    n = String.valueOf(temp);
                    noms.add(n);
                }
            }
            return noms;
        } else {
            System.exit(2);
            return null;
        }
    }

    private String getTextFrom(String text, String begin) {
        String temp = "";
        int i = text.indexOf(begin);
        if (i >= 0) {
            temp = text.substring(i + begin.length());
        }
        return temp;
    }

    private String getTextTo(String text, String end) {
        String temp = "";
        int i = text.indexOf(end);
        if (i > 0) {
            temp = text.substring(0, i);
        }
        return temp;
    }

    
}
