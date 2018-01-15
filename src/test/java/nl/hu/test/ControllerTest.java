package nl.hu.test;

import static org.junit.Assert.*;

import nl.hu.electricity.ElectricityPlan;
import nl.hu.electricity.SimulatorController;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest {
    private SimulatorController _controller;

    @Before
    public void setup(){
        _controller = new SimulatorController();
    }

    @Test
    public void testSendValidDataReturnsElectricityPlan(){
        ElectricityPlan plan =_controller.simulateElectricityPlan(305.12, "EnergieDirect");
        assertEquals("59,50 €", plan.getSimulatedElectricityPrice());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSendNegativeConsumedElectricity(){
        ElectricityPlan plan =_controller.simulateElectricityPlan(-123.45, "EnergieDirect");
    }

    @Test
    public void testNoCompanySetsDefaultCompanyValue(){
        ElectricityPlan plan =_controller.simulateElectricityPlan(305.12, "");
        assertEquals("61,02 €", plan.getSimulatedElectricityPrice());
    }

    @Test
    public void testNonSupportedCompanySetsDefaultCompanyValue(){
        ElectricityPlan plan =_controller.simulateElectricityPlan(305.12, "Nicolaas Elektriciteit B.V.");
        assertEquals("61,02 €", plan.getSimulatedElectricityPrice());
    }
}
