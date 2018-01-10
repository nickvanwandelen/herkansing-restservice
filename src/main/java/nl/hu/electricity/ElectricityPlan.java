package nl.hu.electricity;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ElectricityPlan {
    private double _consumedElektricity;
    private String _company;

    public ElectricityPlan(double consumedElektricity, String company){
        _consumedElektricity = consumedElektricity;
        _company = company.toUpperCase();
    }

    public double getConsumedElektricity() {
        return _consumedElektricity;
    }

    public String getCompany() {
        return _company;
    }

    public String getSimulatedElectricityPrice(){
        double electricityPrice = 0.0;

        switch(_company){
            case "NUON":
                electricityPrice = 0.212;
                break;
            case "ENERGIEDIRECT":
                electricityPrice = 0.195;
                break;
            case "ENECO":
                electricityPrice = 0.199;
                break;
            case "OXXIO":
                electricityPrice = 0.198;
            case "ENGIE":
                electricityPrice = 0.210;
                break;
            case "ESSENT":
                electricityPrice = 0.210;
        }

        return NumberFormat.getCurrencyInstance(Locale.GERMANY).format((electricityPrice * _consumedElektricity));
    }
}
