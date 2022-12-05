package edu.sltc.curenncyconvertorclient.controllers;

import edu.sltc.curenncyconvertorclient.model.Currency;
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
    Currency c1 = new Currency();
    List<String> currencyList;
    @RequestMapping("/convertor")
    public String convertorPage(HttpServletRequest request, Model model) {
        stub.WebServerService demoWSService = new stub.WebServerService();
        stub.WebServer demoWSPort = demoWSService.getWebServerPort();
        String str = demoWSPort.getKeyList();
        currencyList = new ArrayList<String>(Arrays.asList(str.split("_")));
        //System.out.println(currencyList);
        System.out.println(c1.rateNames.values().stream().sorted().collect(Collectors.toList()));
        model.addAttribute("rateList", c1.rateNames.keySet().stream().sorted().collect(Collectors.toList()));
        model.addAttribute("baseRate","select currency");
        model.addAttribute("secondaryRate","select currency");
        //System.out.println(Currency.rateList.keySet());
        modelTemp=model;
        return "currency";
    }
    @RequestMapping(value = "/convertor/result", method = RequestMethod.POST)
    public String updatePage( HttpServletRequest request, Model model, String baseCurrency, String secondaryCurrency, double baseAmount) {
        stub.WebServerService demoWSService = new stub.WebServerService();
        stub.WebServer demoWSPort = demoWSService.getWebServerPort();
        double result = demoWSPort.getAmount(c1.rateNames.get(baseCurrency),c1.rateNames.get(secondaryCurrency),baseAmount);
        model.addAttribute("resultAmount",result);
        model.addAttribute("baseAmount",baseAmount);
        model.addAttribute("baseRate",baseCurrency);
        model.addAttribute("secondaryRate",secondaryCurrency);
        model.mergeAttributes((Map<String, ?>) modelTemp);
//        String str = demoWSPort.getKeyList();
//        List<String> currencyList = new ArrayList<String>(Arrays.asList(str.split("_")));
//        model.addAttribute("rateList", currencyList);
        return "currency";
    }
}
