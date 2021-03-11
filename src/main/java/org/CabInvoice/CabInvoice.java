package org.CabInvoice;

/**
 * Hello world!
 *
 */
public class CabInvoice
{
    public int Cost_Per_Km = 10;
    public int Cost_Per_Min = 1;
    public int Minimum_Fare = 5;
    RideRepository rideRepository;

    public void SetValue(RideCategory rideCategory)
    {
        Cost_Per_Km = rideCategory.Min_Cost_Per_Km;
        Cost_Per_Min = rideCategory.Cost_Per_Min;
        Minimum_Fare = rideCategory.Minimum_Fare;
    }
    public CabInvoice()
    {
        this.rideRepository = new RideRepository();
    }

    public double CalculateFare(double distance, double time,RideCategory rideCategory)
    {   SetValue(rideCategory);
       double fare = distance * Cost_Per_Km + time * Cost_Per_Min;
       if ( fare < Minimum_Fare)
       {
           return Minimum_Fare;
       }
       return fare;
    }

    public InvoiceSummary CalculateRide(Ride[] ride)
    {
        double TotalFare = 0;
        for (Ride rides : ride)
            TotalFare += this.CalculateFare(rides.distance,rides.time,rides.rideCategory);
        return new InvoiceSummary(ride.length,(int) TotalFare);

    }

    public void AddRides(String UserId,Ride[] ride)
    {
        rideRepository.AddRide(UserId,ride);
    }

    public  InvoiceSummary getInvoiceSummary(String UserId)
    {
        return this.CalculateRide(rideRepository.getRides(UserId));
    }




}


