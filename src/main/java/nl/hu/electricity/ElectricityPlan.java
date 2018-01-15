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
        _company = company;
    }

    /**
     * Multiplies the consumedElectricity variable and electricity price based on the company variable.
     * @return The simulated price in a String with currency formatting.
     */
    public String getSimulatedElectricityPrice(){
        double electricityPrice = 0.0;

        switch(_company.toUpperCase()){
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
            case "NONE":
            default: //REST default value
                electricityPrice = 0.2; //Average electricity price in The Netherlands is 20 cents per kWh
                break;
        }

        //Locale.GERMANY to get the Euro sign (NETHERLANDS isn't supported)
        return NumberFormat.getCurrencyInstance(Locale.GERMANY).format((electricityPrice * _consumedElektricity));
    }

    public double getConsumedElektricity() {
        return _consumedElektricity;
    }

    public void setConsumedElektricity(double consumedElektricity) {
        this._consumedElektricity = consumedElektricity;
    }

    public String getCompany() {
        return _company;
    }

    public void setCompany(String company) {
        this._company = company;
    }
}
