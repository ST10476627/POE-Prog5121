/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package reg_feature;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class REG_FEATURETest {
    
    public REG_FEATURETest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class REG_FEATURE.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        REG_FEATURE instance = new REG_FEATURE();
        instance.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateUsername method, of class REG_FEATURE.
     */
    @Test
    public void testValidateUsername() {
        System.out.println("validateUsername");
        REG_FEATURE instance = new REG_FEATURE();
        boolean expResult = false;
        boolean result = instance.validateUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validatePasswordComplexity method, of class REG_FEATURE.
     */
    @Test
    public void testValidatePasswordComplexity() {
        System.out.println("validatePasswordComplexity");
        REG_FEATURE instance = new REG_FEATURE();
        boolean expResult = false;
        boolean result = instance.validatePasswordComplexity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of vaildateCellphoneNumber method, of class REG_FEATURE.
     */
    @Test
    public void testVaildateCellphoneNumber() {
        System.out.println("64");
        REG_FEATURE instance = new REG_FEATURE();
        boolean expResult = false;
        boolean result = instance.vaildateCellphoneNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateCellphoneNumber method, of class REG_FEATURE.
     */
    @Test
    public void testValidateCellphoneNumber() {
        System.out.println("validateCellphoneNumber");
        REG_FEATURE instance = new REG_FEATURE();
        boolean expResult = false;
        boolean result = instance.validateCellphoneNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
