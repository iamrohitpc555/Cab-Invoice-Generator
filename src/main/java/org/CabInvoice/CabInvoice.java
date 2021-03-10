package org.CabInvoice;

/**
 * Hello world!
 *
 */
public class CabInvoice
{
    public final int Cost_Per_Km = 10;
    public final int Cost_Per_Min = 1;
    public final int Minimum_Fare = 5;

    public double CalculateFare(double distance, double time)
    {
       double fare = distance * Cost_Per_Km + time * Cost_Per_Min;
       if ( fare < Minimum_Fare)
       {
           return Minimum_Fare;
       }
       return fare;
    }

    public InvoiceSummary CalculateFare(Ride[] ride)
    {
        double TotalFare = 0;
        for (Ride rides : ride)
            TotalFare += this.CalculateFare(rides.distance,rides.time);
        return new InvoiceSummary(ride.length,(int) TotalFare);

    }


}


