package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int pos = 5;

        double[] arraySalarios = new double[pos];
        double[] arrayDescontosINSS = new double[pos];
        double[] arrayDescontosIR = new double[pos];
        double[] arraySalariosLiquidos = new double[pos];

        double faixaINSS1 = 1212.00;
        double faixaINSS2 = 2427.35;
        double faixaINSS3 = 3641.03;

        double descINSS1 = 7.5;
        double descINSS2 = 9;
        double descINSS3 = 12;
        double descINSS4 = 14;

        double faixaIR1 = 1903.98;
        double faixaIR2 = 2826.65;
        double faixaIR3 = 3751.05;
        double faixaIR4 = 4664.68;

        double descIR1 = 7.5;
        double descIR2 = 15;
        double descIR3 = 22.5;
        double descIR4 = 27.5;

        armazenarSalarios(arraySalarios, scn);

        calcularDescontosESalariosLiq(arraySalarios, faixaINSS1, descINSS1, arrayDescontosINSS, arrayDescontosIR, faixaIR1, descINSS2, faixaINSS2, descIR1, faixaIR2, descINSS3, faixaINSS3, descIR2, faixaIR3, descINSS4, faixaIR4, descIR3, descIR4, arraySalariosLiquidos);

        imprimirValores(arraySalarios, arrayDescontosINSS, arrayDescontosIR, arraySalariosLiquidos);

    }

    private static void calcularDescontosESalariosLiq(double[] arraySalarios, double faixaINSS1, double descINSS1, double[] arrayDescontosINSS, double[] arrayDescontosIR, double faixaIR1, double descINSS2, double faixaINSS2, double descIR1, double faixaIR2, double descINSS3, double faixaINSS3, double descIR2, double faixaIR3, double descINSS4, double faixaIR4, double descIR3, double descIR4, double[] arraySalariosLiquidos) {
        for(int i = 0; i < arraySalarios.length; i++){
            double salarioAtual = arraySalarios[i];
            if(salarioAtual <= faixaINSS1) {
                double descINSS = (salarioAtual * descINSS1) / 100;
                double descIR = 0;
                arrayDescontosINSS[i] = descINSS;
                arrayDescontosIR[i] = descIR;

            }
            else if(salarioAtual <= faixaIR1 && salarioAtual > faixaINSS1){
                double descINSS = (salarioAtual * descINSS2) / 100;
                double descIR = 0;;
                arrayDescontosINSS[i] = descINSS;
                arrayDescontosIR[i] = descIR;

            }
            else if(salarioAtual > faixaIR1 && salarioAtual <= faixaINSS2){
                double descINSS = (salarioAtual * descINSS2) / 100;
                double descIR = (salarioAtual * descIR1) / 100;
                arrayDescontosINSS[i] = descINSS;
                arrayDescontosIR[i] = descIR;

            }
            else if(salarioAtual <= faixaIR2 && salarioAtual > faixaINSS2){
                double descINSS = (salarioAtual * descINSS3) / 100;
                double descIR = (salarioAtual * descIR1) / 100;
                arrayDescontosINSS[i] = descINSS;
                arrayDescontosIR[i] = descIR;

            }
            else if(salarioAtual > faixaIR2 && salarioAtual <= faixaINSS3){
                double descINSS = (salarioAtual * descINSS3) / 100;
                double descIR = (salarioAtual * descIR2) / 100;
                arrayDescontosINSS[i] = descINSS;
                arrayDescontosIR[i] = descIR;

            }
            else if(salarioAtual <= faixaIR3 && salarioAtual > faixaINSS3){
                double descINSS = (salarioAtual * descINSS4) / 100;
                double descIR = (salarioAtual * descIR2) / 100;
                arrayDescontosINSS[i] = descINSS;
                arrayDescontosIR[i] = descIR;

            }
            else if(salarioAtual > faixaIR3 && salarioAtual <= faixaIR4){
                double descINSS = (salarioAtual * descINSS4) / 100;
                double descIR = (salarioAtual * descIR3) / 100;
                arrayDescontosINSS[i] = descINSS;
                arrayDescontosIR[i] = descIR;

            }
            else if(salarioAtual > faixaIR4){
                double descINSS = (salarioAtual * descINSS4) / 100;
                double descIR = (salarioAtual * descIR4) / 100;
                arrayDescontosINSS[i] = descINSS;
                arrayDescontosIR[i] = descIR;

            }

            arraySalariosLiquidos[i] = arraySalarios[i] - arrayDescontosINSS[i] - arrayDescontosIR[i];
        }
    }

    private static void imprimirValores(double[] arraySalarios, double[] arrayDescontosINSS, double[] arrayDescontosIR, double[] arraySalariosLiquidos) {
        System.out.println("Salarios Brutos: "+ Arrays.toString(arraySalarios));
        System.out.println("Descontos INSS: "+ Arrays.toString(arrayDescontosINSS));
        System.out.println("Descontos IR: "+ Arrays.toString(arrayDescontosIR));
        System.out.println("Salários Líquidos: "+ Arrays.toString(arraySalariosLiquidos));
    }

    private static void armazenarSalarios(double[] arraySalarios, Scanner scn) {
        for(int i = 0; i < arraySalarios.length; i++){
            System.out.println("Digite o "+(i+1)+"° salario: ");
            arraySalarios[i] = Double.parseDouble(scn.nextLine());
        }
    }
}