package nl.hu.electricity;

import java.text.NumberFormat;
import java.util.Locale;

public class ElectricityPlan {
    private double _consumedElektricity;
    private String _company;

    /**
     * Constructor for ElectricityPlan
     * @param consumedElektricity amount of consumed electricity in kWh
     * @param company electricity company to simulate with. See docs for supported companies.
     */
    public ElectricityPlan(double consumedElektricity, String company){
        _consumedElektricity = consumedElektricity;
        _company = company.toUpperCase(); //make toUpperCase to avoid errors with capital letters
    }

    /**
     * Multiplies the consumedElectricity variable and electricity price based on the company variable.
     * @return The simulated price in a String with currency formatting.
     */
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
                break;
            case "ENGIE":
                electricityPrice = 0.210;
                break;
            case "ESSENT":
                electricityPrice = 0.210;
                break;
        }

        //Locale.GERMANY to get the Euro sign (NETHERLANDS isn't supported)
        return NumberFormat.getCurrencyInstance(Locale.GERMANY).format((electricityPrice * _consumedElektricity));
    }
}
