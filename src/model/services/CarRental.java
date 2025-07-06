package model.services;

import java.time.LocalDateTime;

public class CarRental implements Tax {
    private double pricePerHour;
    private double pricePerDay;
    LocalDateTime initialTime, endTime;

    public CarRental() {
        super();
    }

    public CarRental(double pricePerHour, double pricePerDay, LocalDateTime initialTime, LocalDateTime endTime) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.initialTime = initialTime;
        this.endTime = endTime;
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

    public long calculateTime() {
        return java.time.Duration.between(initialTime, endTime).toMinutes();
    }

    @Override
    public double calculateRate() {
        return (calculateTime() <= 720? (pricePerHour * Math.ceilDiv(calculateTime(), 60)):(pricePerDay * Math.ceilDiv(calculateTime(), 1440)));
    }

    @Override
    public double calculateTax() {
        return calculateRate() * (calculateRate() >= 100 ? rateAbove100 : rateBelow100);
    }

    @Override
    public double calculateTotal() {
        return calculateRate() + calculateTax();
    }

    public String toString(){
        return "INVOICE:" +
                "\nBasic payment: " + String.format("%.2f", calculateRate()) +
                "\nTax: " + String.format("%.2f", calculateTax()) +
                "\nTotal payment: " + String.format("%.2f", calculateTotal());

    }
}
