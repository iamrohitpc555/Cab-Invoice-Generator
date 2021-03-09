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
}


