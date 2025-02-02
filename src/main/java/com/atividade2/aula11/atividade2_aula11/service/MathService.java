package com.atividade2.aula11.atividade2_aula11.service;

import java.util.Arrays;

public class MathService {

  public static double soma(double n1, double n2) {
    return n1 + n2;
  }

  public static double subtracao(double n1, double n2) {
    return n1 - n2;
  }

  public static double multiplicacao(double n1, double n2) {
    return n1 * n2;
  }

  public static double divisao(double n1, double n2) {
    return n1 / n2;
  }

  public static double radiciacao(double n1) {
    return n1 <= 0 ? 0 : Math.sqrt(n1);
  }

  public static double exponenciacao(double n1, double n2) {
    return Math.pow(n1, n2);
  }

  public static double inversao(double n1) {
    return 1 / n1;
  }

  public static double modulo(double n1) {
    return n1 < 0 ? n1 * -1 : n1;
  }

  public static double fatorial(double n1) {
    double val = n1 <= 0 ? 1 : n1;
    double aux = val;

    while (1 < val) {
      aux *= (val - 1);
      val--;
    }

    return aux;
  }

  public static double media(double[] values) {
    double somatorio = 0;

    for (int i = 0; i < values.length; i++) {
      somatorio += values[i];
    }

    return somatorio / 5;
  }

  public static double mediana(double[] values) {
    Arrays.sort(values);

    return values[2];
  }

}
