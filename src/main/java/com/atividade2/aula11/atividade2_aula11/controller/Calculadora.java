package com.atividade2.aula11.atividade2_aula11.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculadora {

  @RequestMapping(value = "/soma", method = RequestMethod.GET)
  public double soma(@RequestParam String n1, @RequestParam String n2) throws Exception {
    if (!isNumeric(n1) || !isNumeric(n2)) {
      throw new Exception();
    }

    return convertToDouble(n1) + convertToDouble(n2);
  }

  @RequestMapping(value = "/subtracao", method = RequestMethod.GET)
  public double subtracao(@RequestParam String n1, @RequestParam String n2) throws Exception {
    if (!isNumeric(n1) || !isNumeric(n2)) {
      throw new Exception();
    }

    return convertToDouble(n1) - convertToDouble(n2);
  }

  @RequestMapping(value = "/multiplicacao", method = RequestMethod.GET)
  public double multiplicacao(@RequestParam String n1, @RequestParam String n2) throws Exception {
    if (!isNumeric(n1) || !isNumeric(n2)) {
      throw new Exception();
    }

    return convertToDouble(n1) * convertToDouble(n2);
  }

  @RequestMapping(value = "/divisao", method = RequestMethod.GET)
  public double divisao(@RequestParam String n1, @RequestParam String n2) throws Exception {
    if (!isNumeric(n1) || !isNumeric(n2)) {
      throw new Exception();
    }

    return n2.equals("0") ? 0 : convertToDouble(n1) / convertToDouble(n2);
  }

  @RequestMapping(value = "/radiciacao", method = RequestMethod.GET)
  public double radiciacao(@RequestParam String n1) throws Exception {
    if (!isNumeric(n1)) {
      throw new Exception();
    }

    return Math.sqrt(convertToDouble(n1));
  }

  @RequestMapping(value = "/exponenciacao", method = RequestMethod.GET)
  public double exponenciacao(@RequestParam String n1, @RequestParam String n2) throws Exception {
    if (!isNumeric(n1) || !isNumeric(n2)) {
      throw new Exception();
    }

    return Math.pow(convertToDouble(n1), convertToDouble(n2));
  }

  @RequestMapping(value = "/inverso", method = RequestMethod.GET)
  public double inverso(@RequestParam String n1) throws Exception {
    if (!isNumeric(n1)) {
      throw new Exception();
    }

    return n1.equals("0") ? 0 : 1 / convertToDouble(n1);
  }

  @RequestMapping(value = "/modulo", method = RequestMethod.GET)
  public double modulo(@RequestParam String n1) throws Exception {
    if (!isNumeric(n1)) {
      throw new Exception();
    }

    return convertToDouble(n1) < 0 ? convertToDouble(n1) * -1 : convertToDouble(n1);
  }

  @RequestMapping(value = "/fatorial", method = RequestMethod.GET)
  public double fatorial(@RequestParam String n1, @RequestParam String n2) throws Exception {
    if (!isNumeric(n1) || !isNumeric(n2)) {
      throw new Exception();
    }

    return n2.equals("0") ? 0 : convertToDouble(n1) / convertToDouble(n2);
  }

  @RequestMapping(value = "/media", method = RequestMethod.GET)
  public double media(@RequestParam String n1, @RequestParam String n2, @RequestParam String n3,
      @RequestParam String n4, @RequestParam String n5) throws Exception {
    if (!isNumeric(n1) || !isNumeric(n2)) {
      throw new Exception();
    }

    return (convertToDouble(n1) + convertToDouble(n2) + convertToDouble(n3) + convertToDouble(n4) + convertToDouble(n5))
        / 5;
  }

  @RequestMapping(value = "/mediana", method = RequestMethod.GET)
  public double mediana(@RequestParam String n1, @RequestParam String n2) throws Exception {
    if (!isNumeric(n1) || !isNumeric(n2)) {
      throw new Exception();
    }

    return n2.equals("0") ? 0 : convertToDouble(n1) / convertToDouble(n2);
  }

  private boolean isNumeric(String strNumber) {
    if (strNumber == null) {
      return false;
    }

    String number = strNumber.replaceAll(",", ".");

    return number.matches("[-+]?[0-9]*\\.?[0-9]+");
  }

  private double convertToDouble(String strNumber) throws Exception {
    if (strNumber == null)
      throw new Exception();

    String number = strNumber.replaceAll(",", ".");

    if (isNumeric(number))
      return Double.parseDouble(number);
    else
      throw new Exception("Não foi possível converter a informação para double.");
  }

}
