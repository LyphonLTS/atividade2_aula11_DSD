package com.atividade2.aula11.atividade2_aula11.service;

import com.atividade2.aula11.atividade2_aula11.exceptions.UnsupportedMathOperationException;

public class NumberConverter {
  public static boolean isNumeric(String strNumber) {
    if (strNumber == null) {
      return false;
    }

    String number = strNumber.replaceAll(",", ".");

    return number.matches("[-+]?[0-9]*\\.?[0-9]+");
  }

  public static double convertToDouble(String strNumber) throws Exception {
    if (strNumber == null)
      throw new UnsupportedMathOperationException("Número inválido");

    String number = strNumber.replaceAll(",", ".");

    if (isNumeric(number))
      return Double.parseDouble(number);
    else
      throw new Exception("Não foi possível converter a informação para double.");
  }
}
