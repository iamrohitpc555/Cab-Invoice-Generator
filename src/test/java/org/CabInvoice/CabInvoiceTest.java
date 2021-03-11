package org.CabInvoice;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CabInvoiceTest {

    CabInvoice InvoiceService;
    RideRepository rideRepository;

    @Before
    public void setUp() throws Exception {
        InvoiceService = new CabInvoice();
        rideRepository = new RideRepository();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnCorrectTotalFare() {
        double fare = InvoiceService.CalculateFare(2, 5,RideCategory.NORMAL);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenMinDistanceAndTime_ShouldReturnCorrectTotalFare() {
        double fare = InvoiceService.CalculateFare(0.5, 3,RideCategory.NORMAL);
        Assert.assertEquals(8, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeForMultipleRides_ShouldReturnCorrectTotalFare()
    {


        Ride[] ride =
                {
                        new Ride(2,5,RideCategory.NORMAL),
                        new Ride(0.1,1,RideCategory.NORMAL)};

        InvoiceSummary invoiceSummary = InvoiceService.CalculateRide(ride);
        InvoiceSummary expeectedInvoiceSummary = new InvoiceSummary(2,30);
        Assert.assertEquals(expeectedInvoiceSummary,invoiceSummary);

    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {

        String UserId = "rohit@gmail.com";
        Ride[] ride = { new Ride(2.0, 5,RideCategory.NORMAL), new Ride(0.1, 1,RideCategory.NORMAL) };
        InvoiceService.AddRides(UserId, ride);
        InvoiceSummary invoiceSummary = InvoiceService.getInvoiceSummary(UserId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);

    }


    @Test
    public void givenUserIdAndPremiumRides_ShouldReturnInvoiceSummary()
    {

        String UserId = "rce@gmail.com";
        Ride[] rides = {
                new Ride(2,5,RideCategory.PREMIUM),
                new Ride(0.1,1,RideCategory.PREMIUM)};

        InvoiceService.AddRides(UserId,rides);
        InvoiceSummary summary = InvoiceService.getInvoiceSummary(UserId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,60);
        Assert.assertEquals(expectedInvoiceSummary,summary);
        }

        @Test
        public void givenUserIdAndNormalAndPremiumRides_ShouldReturnInvoiceSummary()
        {
            String UserId = "vfx@gmail.com";
            Ride[] rides = {
                    new Ride(2,5,RideCategory.NORMAL),
                    new Ride(2,5,RideCategory.PREMIUM)};
            InvoiceService.AddRides(UserId,rides);
            InvoiceSummary summary = InvoiceService.getInvoiceSummary(UserId);
            InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,65);
            Assert.assertEquals(expectedInvoiceSummary,summary);

        }
        }



