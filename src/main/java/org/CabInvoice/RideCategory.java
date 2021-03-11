package org.CabInvoice;

public enum RideCategory {

    PREMIUM(15,2,20),NORMAL(10,1,5);

    public int Min_Cost_Per_Km , Minimum_Fare;
    public int Cost_Per_Min;

    RideCategory(int Min_Cost_Per_Km , int Cost_Per_Min , int Minimum_Fare )
    {
        this.Min_Cost_Per_Km = Min_Cost_Per_Km;
        this.Cost_Per_Min = Cost_Per_Min;
        this.Minimum_Fare = Minimum_Fare;
    }
}
