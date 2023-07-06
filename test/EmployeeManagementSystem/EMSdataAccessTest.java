/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package EmployeeManagementSystem;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author andre
 */
public class EMSdataAccessTest {
    
    public EMSdataAccessTest() {
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

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeConnection method, of class EMSdataAccess.
     */
    @Test
    public void testCloseConnection() {
        System.out.println("closeConnection");
        EMSdataAccess instance = new EMSdataAccess();
        instance.closeConnection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveExistingEmployeeIds method, of class EMSdataAccess.
     */
    @Test
    public void testRetrieveExistingEmployeeIds() {
        System.out.println("retrieveExistingEmployeeIds");
        EMSdataAccess instance = new EMSdataAccess();
        List<String> expResult = null;
        List<String> result = instance.retrieveExistingEmployeeIds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNextEmployeeId method, of class EMSdataAccess.
     */
    @Test
    public void testGetNextEmployeeId() {
        System.out.println("getNextEmployeeId");
        EMSdataAccess instance = new EMSdataAccess();
        String expResult = "";
        String result = instance.getNextEmployeeId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEmployee method, of class EMSdataAccess.
     */
    @Test
    public void testAddEmployee() {
        System.out.println("addEmployee");
        Object employee = null;
        EMSdataAccess instance = new EMSdataAccess();
        boolean expResult = false;
        boolean result = instance.addEmployee((Employee) employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
