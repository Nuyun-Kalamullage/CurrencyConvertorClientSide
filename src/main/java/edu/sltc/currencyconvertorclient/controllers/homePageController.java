package edu.sltc.currencyconvertorclient.controllers;

import edu.sltc.currencyconvertorclient.model.currencyListString;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class homePageController {
    Model modelTemp;
    List<String> currencyList = new ArrayList<String>(Arrays.asList(currencyListString.getNames().split(","))).stream().sorted().collect(Collectors.toList());
    stub.WebServerService soapWebService = new stub.WebServerService();
    stub.WebServer serverPort = soapWebService.getWebServerPort();
    @RequestMapping("/")
    public String convertorPage(HttpServletRequest request, Model model) {
        model.addAttribute("rateList", currencyList);
        model.addAttribute("baseRate", currencyList.get(141));//currencyList[59]
        model.addAttribute("secondaryRate", currencyList.get(161));//currencyList[123]
        modelTemp=model;

        return "currency";
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String updatePage( HttpServletRequest request, Model model, String baseCurrency, String secondaryCurrency, double baseAmount) {
        double result = serverPort.getAmount(baseCurrency,secondaryCurrency,baseAmount);
        model.addAttribute("resultAmount",result);
        model.addAttribute("baseAmount",baseAmount);
        model.addAttribute("baseRate",baseCurrency);
        model.addAttribute("secondaryRate",secondaryCurrency);
        model.mergeAttributes((Map<String, ?>) modelTemp);
        model.addAttribute("rateList", currencyList);

        return "currency";
    }
}
