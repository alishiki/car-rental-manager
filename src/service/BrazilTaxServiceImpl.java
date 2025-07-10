package service;

public class BrazilTaxServiceImpl implements TaxService {

    double rateAbove100 = 0.15;
    double rateBelow100 = 0.2;

    @Override
    public double calculateTax(double amount) {
        return amount > 100 ? amount * rateAbove100 : amount * rateBelow100;
    }
}
