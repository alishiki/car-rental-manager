package model.services;

public interface  Tax {
    double rateAbove100 = 0.15;
    double rateBelow100 = 0.2;

    public double calculateRate();
    public double calculateTotal();
    public double calculateTax();
}