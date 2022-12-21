package edu.sltc.currencyconvertorclient.controllers;
/**
 * @author Nuyun-Kalamullage
 * @date 21-12-2022
 * @file_name homePageController
 * @project_Name CurrencyConvertorClient
 */

import edu.sltc.currencyconvertorclient.model.currencyListString;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class homePageController {
    List<String> currencyList = new ArrayList<String>(Arrays.asList(currencyListString.getNames().split(","))).stream().sorted().collect(Collectors.toList());//get the long currency names as a list.
    stub.WebServerService soapWebService = new stub.WebServerService();
    stub.WebServer serverPort = soapWebService.getWebServerPort(); // connect the wsdl port to server port & then we can communicate with wsdl file through this server port.
    @RequestMapping("/")
    public String convertorPage(HttpServletRequest request, Model model) { //make function for get mapping
        model.addAttribute("rateList", currencyList); //adding Currency long_names to html file.
        model.addAttribute("baseRate", currencyList.get(141));//adding base currency as "Sri lanka Rupee" to html file.
        model.addAttribute("secondaryRate", currencyList.get(161));//adding secondary currency as "US Dollar" to html file.

        return "currency"; //Return the currency.html as a result.
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String updatePage( HttpServletRequest request, Model model, String baseCurrency, String secondaryCurrency, double baseAmount) {//make function for POST mapping
        double result = serverPort.convert(baseCurrency,secondaryCurrency,baseAmount); //Receive data from the server through wsdl file.
        model.addAttribute("resultAmount",result); //adding result-amount that we receive from the server to html file.
        model.addAttribute("baseAmount",baseAmount);//adding base-amount as user given earlier to html file.
        model.addAttribute("baseRate",baseCurrency);//adding base-currency as user given earlier to html file.
        model.addAttribute("secondaryRate",secondaryCurrency);//adding secondary-currency as user given earlier to html file.
        model.addAttribute("rateList", currencyList);//adding Currency long_names to html file.

        return "currency"; //Return the currency.html as a result.
    }
}
