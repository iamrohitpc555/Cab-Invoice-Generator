package org.CabInvoice;
import static org.junit.Assert.assertTrue;

import org.CabInvoice.CabInvoice;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CabInvoiceTest
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

    @Test
    public void givenDistanceAndTimeForMultipleRides_ShouldReturnCorrectTotalFare() {
        CabInvoice invoiceService = new CabInvoice();
        Ride[] ride = { new Ride(2.0, 5), new Ride(0.1, 1) };

        double fare = invoiceService.CalculateFare(ride);
        Assert.assertEquals(30, fare, 0.0);
    }

}

