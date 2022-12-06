package edu.sltc.curenncyconvertorclient.model;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class Currency {
    private String baseCurrency;
    private String secondaryCurrency;
    private double baseCurrencyAmount;
    private double secondaryCurrencyAmount;
    public static HashMap<String,String> rateNames = new HashMap<>();
    public static HashMap<String,String> temp = new HashMap<>();


    public Currency(String baseCurrency, String secondaryCurrency, double baseCurrencyAmount, double secondaryCurrencyAmount) {
        this.baseCurrency = baseCurrency;
        this.secondaryCurrency = secondaryCurrency;
        this.baseCurrencyAmount = baseCurrencyAmount;
        this.secondaryCurrencyAmount = secondaryCurrencyAmount;

    }

    public Currency() {
        String s = getJson.nameJson;
        Object obj = JSONValue.parse(s);
        JSONObject jsonObject = (JSONObject) obj;
        temp = (HashMap<String, String>) jsonObject.get("names");
        Set<String> values = temp.keySet();
        Collection<String> keys =  temp.values();
        int i=0;
        for (String a :values) {
            rateNames.put(keys.stream().collect(Collectors.toList()).get(i),a);
            i++;
        }
    }


    public double getSecondaryCurrencyAmount() {
        return secondaryCurrencyAmount;
    }

    public void setSecondaryCurrencyAmount(double secondaryCurrencyAmount) {
        this.secondaryCurrencyAmount = secondaryCurrencyAmount;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getSecondaryCurrency() {
        return secondaryCurrency;
    }

    public void setSecondaryCurrency(String secondaryCurrency) {
        this.secondaryCurrency = secondaryCurrency;
    }

    public double getBaseCurrencyAmount() {
        return baseCurrencyAmount;
    }

    public void setBaseCurrencyAmount(double baseCurrencyAmount) {
        this.baseCurrencyAmount = baseCurrencyAmount;
    }
}
