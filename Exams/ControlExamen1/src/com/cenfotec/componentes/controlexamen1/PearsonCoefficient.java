/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cenfotec.componentes.controlexamen1;

/**
 *
 * @author Pablo
 */
public class PearsonCoefficient {
    private String sequence;
    private double table[][];
    private double n;
    private double sumX, sumY, sumXPowTwo, sumYPowTwo, sumXY;
    private double complementX, complementY;
    private double Sx, Sy;
    private double pearsonCoefficient;
    
    public PearsonCoefficient() {}

    public PearsonCoefficient(String sequence) {
        this.sequence = sequence;
        tableBuilder();
        tableFiller();
        sumX();
        sumY();
        sumXPowTwo();
        sumYPowTwo();
        sumXY();
        complementX(this.sumX, this.n);
        complementY(this.sumY, n);
        Sx(sumXPowTwo, complementX, n);
        Sy(sumYPowTwo, complementY, n);
        pearsonCoefficient(this.sumXY, this.complementX, this.complementY, this.Sx, this.Sy, this.n);
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public double[][] getTable() {
        return table;
    }

    public void setTable(double[][] table) {
        this.table = table;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public double getSumX() {
        return sumX;
    }

    public void setSumX(double sumX) {
        this.sumX = sumX;
    }

    public double getSumY() {
        return sumY;
    }

    public void setSumY(double sumY) {
        this.sumY = sumY;
    }

    public double getSumXPowTwo() {
        return sumXPowTwo;
    }

    public void setSumXPowTwo(double sumXPowTwo) {
        this.sumXPowTwo = sumXPowTwo;
    }

    public double getSumYPowTwo() {
        return sumYPowTwo;
    }

    public void setSumYPowTwo(double sumYPowTwo) {
        this.sumYPowTwo = sumYPowTwo;
    }

    public double getSumXY() {
        return sumXY;
    }

    public void setSumXY(double sumXY) {
        this.sumXY = sumXY;
    }

    public double getComplementX() {
        return complementX;
    }

    public void setComplementX(double complementX) {
        this.complementX = complementX;
    }

    public double getComplementY() {
        return complementY;
    }

    public void setComplementY(double complementY) {
        this.complementY = complementY;
    }

    public double getSx() {
        return Sx;
    }

    public void setSx(double Sx) {
        this.Sx = Sx;
    }

    public double getSy() {
        return Sy;
    }

    public void setSy(double Sy) {
        this.Sy = Sy;
    }

    public double getPearsonCoefficient() {
        return pearsonCoefficient;
    }

    public void setPearsonCoefficient(double pearsonCoefficient) {
        this.pearsonCoefficient = pearsonCoefficient;
    }

    
    
    private void tableBuilder() {
        String[] sArr = this.sequence.split(";");
        int rows  = sArr.length;
        int cols = 5;
        this.n = rows;
        this.table = new double[rows][cols];
    }

    private void tableFiller() {
        String[] sArr = sequence.split(";");

        for (int i = 0; i < sArr.length; i++) {
            this.table[i][0] = Double.parseDouble(sArr[i].split(",")[0]);
            this.table[i][1] = Double.parseDouble(sArr[i].split(",")[1]);
            this.table[i][2] = Math.pow(Double.parseDouble(sArr[i].split(",")[0]), 2);
            this.table[i][3] = Math.pow(Double.parseDouble(sArr[i].split(",")[1]), 2);
            this.table[i][4] = Double.parseDouble(sArr[i].split(",")[0]) * Double.parseDouble(sArr[i].split(",")[1]);
        }
    }

    public void sumX() {
        double res = 0;
        for (int i = 0; i < this.table.length; i++) {
            res += table[i][0];
        }
        this.sumX = res;
    }
    
    public void sumY() {
        double res = 0;
        for (int i = 0; i < this.table.length; i++) {
            res += table[i][1];
        }
        this.sumY = res;
    }

    public void sumXPowTwo() {
        double res = 0;
        for (int i = 0; i < this.table.length; i++) {
            res += table[i][2];
        }
        this.sumXPowTwo = res;
    }

    public void sumYPowTwo() {
        double res = 0;
        for (int i = 0; i < this.table.length; i++) {
            res += table[i][3];
        }
        this.sumYPowTwo = res;
    }

    public void sumXY() {
        double res = 0;
        for (int i = 0; i < this.table.length; i++) {
            res += table[i][4];
        }
        this.sumXY = res;
    }

    public final void complementX(double sumX, double n) {
        this.complementX = (sumX / n);
    }

    public final void complementY(double sumY, double n) {
        this.complementY = (sumY / n);
    }

    public final void Sx(double sumXPowTwo, double complementX, double n) {
        this.Sx = (Math.sqrt( (sumXPowTwo/n) - Math.pow(complementX, 2)));
    }

    public final void Sy(double sumYPowTwo, double complementY, double n) {
        this.Sy = (Math.sqrt( (sumYPowTwo/n) - Math.pow(complementY, 2)));
    }

    public final void pearsonCoefficient(double sumXY, double complementX, double complementY, double Sx, double Sy, double n) {
        this.pearsonCoefficient = ( ((sumXY/n) - (complementX*complementY)) / (Sx*Sy) );
    }
}
