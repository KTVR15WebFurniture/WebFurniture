/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Worker;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pupil
 */
public class WorkerControllerTest {
    
    public WorkerControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Worker worker = new Worker("manager","Emir","Belov","34906124679","anb@em.ee","+37236603914");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of init method, of class WorkerController.
     */
    @Test
    public void testInit() throws Exception {
        System.out.println("init");
        WorkerController instance = new WorkerController();
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of processRequest method, of class WorkerController.
     */
    @Test
    public void testProcessRequest() throws Exception {
        System.out.println("processRequest");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        WorkerController instance = new WorkerController();
        instance.processRequest(request, response);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of doGet method, of class WorkerController.
     */
    @Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        WorkerController instance = new WorkerController();
        instance.doGet(request, response);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of doPost method, of class WorkerController.
     */
    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        WorkerController instance = new WorkerController();
        instance.doPost(request, response);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getServletInfo method, of class WorkerController.
     */
    @Test
    public void testGetServletInfo() {
        System.out.println("getServletInfo");
        WorkerController instance = new WorkerController();
        String expResult = "";
        String result = instance.getServletInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
