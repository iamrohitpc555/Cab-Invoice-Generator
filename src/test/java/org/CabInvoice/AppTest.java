package org.CabInvoice;
import static org.junit.Assert.assertTrue;

import org.CabInvoice.CabInvoice;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void givenDistanceAndTime_ShouldReturnCorrectTotalFare()
    {
        CabInvoice InvoiceService = new CabInvoice();
        double fare = InvoiceService.CalculateFare(2,5);
        Assert.assertEquals(25,fare,0.0);
    }

    @Test
    public void givenMinDistanceAndTime_ShouldReturnCorrectTotalFare()
    {
        CabInvoice InvoiceService = new CabInvoice();
        double fare = InvoiceService.CalculateFare(0.5,3);
        Assert.assertEquals(8,fare,0.0);
    }

}

