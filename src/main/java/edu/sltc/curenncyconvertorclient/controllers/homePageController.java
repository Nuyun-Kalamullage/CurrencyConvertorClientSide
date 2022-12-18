package edu.sltc.curenncyconvertorclient.controllers;

import edu.sltc.curenncyconvertorclient.model.currencyListString;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class homePageController {
    Model modelTemp;
    List<String> currencyList = new ArrayList<String>(Arrays.asList(currencyListString.getNames().split(",")));;
    @RequestMapping("/convertor")
    public String convertorPage(HttpServletRequest request, Model model) {
        stub.WebServerService demoWSService = new stub.WebServerService();
        stub.WebServer demoWSPort = demoWSService.getWebServerPort();
        model.addAttribute("rateList", currencyList);
        model.addAttribute("baseRate", currencyList.get(59));//currencyList[59]
        model.addAttribute("secondaryRate", currencyList.get(132));//currencyList[123]
        modelTemp=model;

        return "currency";
    }
    @RequestMapping(value = "/convertor/", method = RequestMethod.POST)
    public String updatePage( HttpServletRequest request, Model model, String baseCurrency, String secondaryCurrency, double baseAmount) {
        stub.WebServerService demoWSService = new stub.WebServerService();
        stub.WebServer demoWSPort = demoWSService.getWebServerPort();
        double result = demoWSPort.getAmount(baseCurrency,secondaryCurrency,baseAmount);
        model.addAttribute("resultAmount",result);
        model.addAttribute("baseAmount",baseAmount);
        model.addAttribute("baseRate",baseCurrency);
        model.addAttribute("secondaryRate",secondaryCurrency);
        model.mergeAttributes((Map<String, ?>) modelTemp);
        model.addAttribute("rateList", currencyList);

        return "currency";
    }
}
