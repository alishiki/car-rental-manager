package service;

import model.entities.Invoice;

import java.time.LocalDateTime;

public class RentalService {
    private double pricePerHour;
    private double pricePerDay;
    private LocalDateTime initialTime, endTime;
    private TaxService taxService;
    private Invoice invoice;

    public RentalService(double pricePerHour, double pricePerDay, LocalDateTime initialTime, LocalDateTime endTime, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.initialTime = initialTime;
        this.endTime = endTime;
        this.taxService = taxService;

    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public LocalDateTime getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(LocalDateTime initialTime) {
        this.initialTime = initialTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public TaxService getTaxService() {
        return taxService;
    }

    public void setTaxService(TaxService taxService) {
        this.taxService = taxService;
    }

    public Invoice getInvoice() {
        return invoice;
    }
    // não tem setInvoice() porque Invoice é gerada a partir do metodo processInvoice()

    public long calculateTime() {
        return java.time.Duration.between(initialTime, endTime).toMinutes();
    }

    public double basicPayment() {
        return (calculateTime() <= 720? (pricePerHour * Math.ceilDiv(calculateTime(), 60)):(pricePerDay * Math.ceilDiv(calculateTime(), 1440)));
    }

    public void processInvoice() {
        this.invoice = new Invoice(basicPayment(), getTaxService().calculateTax(basicPayment()));
    }

}
