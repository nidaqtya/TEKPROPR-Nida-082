public class Commission extends Hourly
{
    private double totalSales;
    private double commissionRate;

    // constructor
    public Commission(String name, String address, String phone,
                      String socSecNumber, double rate, double commissionRate)
    {
        super(name, address, phone, socSecNumber, rate);
        this.commissionRate = commissionRate;
        totalSales = 0;
    }

    // menambahkan total penjualan
    public void addSales(double sales)
    {
        totalSales += sales;
    }

    // menghitung gaji
    public double pay()
    {
        double payment = super.pay() + (totalSales * commissionRate);
        totalSales = 0;
        return payment;
    }

    // menampilkan informasi
    public String toString()
    {
        String result = super.toString();
        result += "\nTotal Sales: " + totalSales;
        return result;
    }
}