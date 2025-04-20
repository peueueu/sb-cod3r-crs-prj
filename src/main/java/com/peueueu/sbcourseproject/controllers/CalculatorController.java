package com.peueueu.sbcourseproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
//    @PostMapping("/sum")
//    public Double calculateSum(@RequestBody Map<String, Double> body){
//        System.out.println(body);
//        return body.get("firstNumber") + body.get("secondNumber");
//    }
//
//    @PostMapping("/subtract")
//    public Double calculateSubtraction(@RequestBody Map<String, Double> body){
//        return body.get("firstNumber") - body.get("secondNumber");
//    }
//
//    @PostMapping("/multiply")
//    public Double calculateMultiplication(@RequestBody Map<String, Double> body){
//        return body.get("firstNumber") * body.get("secondNumber");
//    }
//
//    @PostMapping("/divide")
//    public Double calculateDivision(@RequestBody Map<String, Double> body){
//        return body.get("firstNumber") / body.get("secondNumber");
//    }

    @PostMapping("/{operation}")
    public ResponseEntity<Map<String, Double>> calculate(@PathVariable String operation, @RequestBody Map<String, Double> body) throws Exception {
        double firstNumber = body.get("firstNumber");
        double secondNumber = body.get("secondNumber");
        double result = switch (operation) {
            case "sum" -> firstNumber + secondNumber;
            case "subtract" -> firstNumber - secondNumber;
            case "multiply" -> firstNumber * secondNumber;
            case "divide" -> firstNumber / secondNumber;
            default -> throw new IllegalArgumentException("Invalid operation");
        };

        return ResponseEntity.ok(Map.of("result", result));
    }
}
