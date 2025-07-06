package model.entities;

import model.services.CarRental;

import java.util.List;

public class Car implements Automobile {

    private String model;
    private List<CarRental> rentals;

    public Car(){
        super();
    }

    public Car(String model) {
        this.model = model;
    }

    @Override
    public String getModel(){
        return model;
    }

    public List<CarRental> getRentals(){
        return rentals;
    }

    public void addRentals(CarRental rentals){
        this.rentals.add(rentals);
    }

}
