package nl.hu.electricity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimulatorController {

    @RequestMapping("/plan")
    public ElectricityPlan electricityPlan(
            @RequestParam(value = "consumedElectricity", defaultValue = "-1") double consumedElectricity,
            @RequestParam(value = "company", defaultValue = "none") String company
    ){
        return new ElectricityPlan(consumedElectricity, company);
    }
}
