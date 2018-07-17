package com.boot;

import static org.junit.Assert.assertEquals;

import com.boot.controller.HomeController;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class AppTest 
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
   
    /**
     * Rigourous Test :-)
     */
	@org.junit.Test
    public void testApp()
    {
		HomeController hc = new HomeController();
		String result = hc.home();
       assertEquals(result, "Nirmal Kailash, reporting for duty!");
    }
}
