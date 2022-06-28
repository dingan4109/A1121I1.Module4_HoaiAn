package calculator.controller;

import calculator.model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @GetMapping
    public String getIndex() {
        return "index";
    }

    @GetMapping("/calculate")
    public ModelAndView calculate(Calculator calculator){
        double number1 = Double.parseDouble(calculator.getNumber1());
        double number2 = Double.parseDouble(calculator.getNumber2());
        double result = 0;
        boolean flag = true;
        switch (calculator.getOperator()) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "x":
                result = number1 * number2;
                break;
            case ":":
             try{
                 result = number1/number2;
             }catch (ArithmeticException e) {
                 e.printStackTrace();
             }

                break;
        }
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("calculator", calculator);
        modelAndView.addObject("result",result);
        modelAndView.addObject("flag",flag);
        return modelAndView;
    }
}
