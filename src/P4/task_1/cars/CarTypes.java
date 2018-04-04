package P4.task_1.cars;

public enum CarTypes {
    MINIBUS("Minibus Car"),
    TRUCK("Truck"),
    PASSENGER("Passenger Ca");

    private String carType;

    CarTypes(String carType) {
        this.carType = carType;
    }
    public String getCarType(){
        return carType;
    }

}
