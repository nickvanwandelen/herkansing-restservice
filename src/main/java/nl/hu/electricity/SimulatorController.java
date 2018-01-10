package nl.hu.electricity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimulatorController {

    /**
     *
     * @param consumedElectricity consumed electricity in kWh.
     * @param company electricity company to simulate with. See docs for supported companies.
     * @return generated ElectricityPlan object based on the given JSON variables
     */
    @RequestMapping("/plan")
    public ElectricityPlan electricityPlan(
            @RequestParam(value = "consumedElectricity", defaultValue = "-1") double consumedElectricity,
            @RequestParam(value = "company", defaultValue = "none") String company
    ){
        return new ElectricityPlan(consumedElectricity, company);
    }
}
