package model.entities;

import service.RentalService;

public class CarRental implements Vehicle {

    private String model;
    private RentalService rentalService;

    public CarRental() {
        super();
    }

    public CarRental(String model, RentalService rentals) {
        this.model = model;
        this.rentalService = rentals;

    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public RentalService getRentals() {
        return rentalService;
    }

    public void setRentals(RentalService rentals) {
        this.rentalService = rentals;
    }

    public String ToString() {
        return "\n\nINVOICE:" +
                "\nBasic payment: " + String.format("%.2f", rentalService.basicPayment()) +
                "\nTaxService: " + String.format("%.2f", rentalService.getInvoice().getTax()) +
                "\nTotal payment: " + String.format("%.2f", rentalService.getInvoice().calculateTotal());
    }
}