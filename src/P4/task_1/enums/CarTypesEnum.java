package P4.task_1.enums;

public enum CarTypesEnum {
    MINIBUS("Minibus Car"),
    TRUCK("Truck"),
    PASSENGER("Passenger Car");

    private String carType;

    CarTypesEnum(String carType) {
        this.carType = carType;
    }

    public String getCarType(){
        return carType;
    }

}
