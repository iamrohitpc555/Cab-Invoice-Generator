package org.CabInvoice;

public class InvoiceSummary {

    public int Total_Fare;
    public int Total_No_Of_Rides;
    public int Average_Fare;

    public InvoiceSummary(int Total_No_Of_Rides , int Total_Fare)
    {
        this.Total_No_Of_Rides = Total_No_Of_Rides;
        this.Total_Fare = Total_Fare;
        this.Average_Fare = this.Total_Fare / this.Total_No_Of_Rides;
    }

    @Override
    public boolean equals(Object o )
    {
        if (this == o )
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        InvoiceSummary that = (InvoiceSummary) o;
        return Total_Fare == that.Total_Fare && Total_No_Of_Rides == that.Total_No_Of_Rides && Double.compare(that.Average_Fare,Average_Fare) == 0;
    }
}
