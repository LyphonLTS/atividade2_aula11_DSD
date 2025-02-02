package com.atividade2.aula11.atividade2_aula11.controller;

import org.springframework.web.bind.annotation.*;

import com.atividade2.aula11.atividade2_aula11.exceptions.UnsupportedMathOperationException;
import com.atividade2.aula11.atividade2_aula11.service.MathService;
import com.atividade2.aula11.atividade2_aula11.service.NumberConverter;

@RestController
public class Calculadora {

  @GetMapping("/soma")
  public double soma(@RequestParam String n1, @RequestParam String n2) throws Exception {
    if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
      throw new UnsupportedMathOperationException("Número inválido");
    }

    return MathService.soma(NumberConverter.convertToDouble(n1), NumberConverter.convertToDouble(n2));
  }

  @GetMapping("/subtracao")
  public double subtracao(@RequestParam String n1, @RequestParam String n2) throws Exception {
    if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
      throw new UnsupportedMathOperationException("Número inválido");
    }

    return MathService.subtracao(NumberConverter.convertToDouble(n1), NumberConverter.convertToDouble(n2));
  }

  @GetMapping("/multiplicacao")
  public double multiplicacao(@RequestParam String n1, @RequestParam String n2) throws Exception {
    if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
      throw new UnsupportedMathOperationException("Número inválido");
    }

    return MathService.multiplicacao(NumberConverter.convertToDouble(n1), NumberConverter.convertToDouble(n2));
  }

  @GetMapping("/divisao")
  public double divisao(@RequestParam String n1, @RequestParam String n2) throws Exception {
    if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2)) {
      throw new UnsupportedMathOperationException("Número inválido");
    }

    return n2.equals("0") ? 0
        : MathService.divisao(NumberConverter.convertToDouble(n1), NumberConverter.convertToDouble(n2));
  }

  @GetMapping("/radiciacao")
  public double radiciacao(@RequestParam String n1) throws Exception {
    if (!NumberConverter.isNumeric(n1)) {
      throw new UnsupportedMathOperationException("Número inválido");
    }

    return MathService.radiciacao(NumberConverter.convertToDouble(n1));
  }

  @GetMapping("/exponenciacao")
  public double exponenciacao(@RequestParam String n1, @RequestParam String n2) throws Exception {
    if (!NumberConverter.isNumeric(n1)) {
      throw new UnsupportedMathOperationException("Número inválido");
    }

    return MathService.exponenciacao(NumberConverter.convertToDouble(n1), NumberConverter.convertToDouble(n2));
  }

  @GetMapping("/inverso")
  public double inverso(@RequestParam String n1) throws Exception {
    if (!NumberConverter.isNumeric(n1)) {
      throw new UnsupportedMathOperationException("Número inválido");
    }

    return n1.equals("0") ? 0 : MathService.inversao(NumberConverter.convertToDouble(n1));
  }

  @RequestMapping(value = "/modulo", method = RequestMethod.GET)
  public double modulo(@RequestParam String n1) throws Exception {
    if (!NumberConverter.isNumeric(n1)) {
      throw new UnsupportedMathOperationException("Número inválido");
    }

    return MathService.modulo(NumberConverter.convertToDouble(n1));
  }

  @RequestMapping(value = "/fatorial", method = RequestMethod.GET)
  public double fatorial(@RequestParam String n1) throws Exception {
    if (!NumberConverter.isNumeric(n1)) {
      throw new UnsupportedMathOperationException("Número inválido");
    }

    return MathService.fatorial(NumberConverter.convertToDouble(n1));
  }

  @RequestMapping(value = "/media", method = RequestMethod.GET)
  public double media(@RequestParam String n1, @RequestParam String n2, @RequestParam String n3,
      @RequestParam String n4, @RequestParam String n5) throws Exception {
    if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2) || !NumberConverter.isNumeric(n3)
        || !NumberConverter.isNumeric(n4) || !NumberConverter.isNumeric(n5)) {
      throw new UnsupportedMathOperationException("Número inválido");
    }

    double[] values = { NumberConverter.convertToDouble(n1), NumberConverter.convertToDouble(n2),
        NumberConverter.convertToDouble(n3), NumberConverter.convertToDouble(n4),
        NumberConverter.convertToDouble(n5) };

    return MathService.media(values);
  }

  @RequestMapping(value = "/mediana", method = RequestMethod.GET)
  public double mediana(@RequestParam String n1, @RequestParam String n2, @RequestParam String n3,
      @RequestParam String n4, @RequestParam String n5) throws Exception {
    if (!NumberConverter.isNumeric(n1) || !NumberConverter.isNumeric(n2) || !NumberConverter.isNumeric(n3)
        || !NumberConverter.isNumeric(n4) || !NumberConverter.isNumeric(n5)) {
      throw new UnsupportedMathOperationException("Número inválido");
    }

    double[] values = { NumberConverter.convertToDouble(n1), NumberConverter.convertToDouble(n2),
        NumberConverter.convertToDouble(n3), NumberConverter.convertToDouble(n4),
        NumberConverter.convertToDouble(n5) };

    return MathService.mediana(values);
  }

}
