package nl.hu.test;

import nl.hu.electricity.ElectricityPlan;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ElectricityPlanTest {
    private ElectricityPlan _plan;

    @Before
    public void setup() throws Exception{
        _plan = new ElectricityPlan(123.45, "Eneco");
    }

    @Test
    public void testInitializeElectricityPlanWithCorrectCompany(){
        ElectricityPlan testPlan = new ElectricityPlan(678.90, "Oxxio");
        assertEquals("Oxxio", testPlan.getCompany());
    }

    @Test
    public void testInitializeElectricityPlanWithCorrectConsumedElectricity(){
        ElectricityPlan testPlan = new ElectricityPlan(678.90, "Oxxio");
        assertEquals(678.90, testPlan.getConsumedElektricity(), 0);
    }

    @Test
    public void testGetConsumedElectricity(){
        assertEquals(123.45, _plan.getConsumedElektricity(), 0);
    }

    @Test
    public void testGetCompany(){
        assertEquals("Eneco", _plan.getCompany());
    }

    @Test
    public void testSetConsumedElectricity(){
        _plan.setConsumedElektricity(135.79);
        assertEquals(135.79, _plan.getConsumedElektricity(), 0);
    }

    @Test
    public void testSetCompany(){
        _plan.setCompany("Essent");
        assertEquals("Essent", _plan.getCompany());
    }

    @Test
    public void testSimulateWithEneco(){
       assertEquals("24,57 €",_plan.getSimulatedElectricityPrice());
    }

    @Test
    public void testSimulateWithNuon(){
        _plan.setCompany("Nuon");
        assertEquals("26,17 €", _plan.getSimulatedElectricityPrice());
    }
}
