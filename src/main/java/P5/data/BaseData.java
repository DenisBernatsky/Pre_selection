package P5.data;

import P5.cars.BaseCar;
import P5.cars.factory.FactoryType;
import P5.enums.CarTypesEnum;

class BaseData {

    BaseCar createCarByType(String type, String name, int consumption, int price){
        FactoryType factoryType = new FactoryType(name, consumption, price);
        if (type.equals(CarTypesEnum.PASSENGER.getCarType())){
            return factoryType.createPassengersType();
        }
        else if (type.equals(CarTypesEnum.MINIBUS.getCarType())){
            return factoryType.createMinibusType();
        }
        else if (type.equals(CarTypesEnum.TRUCK.getCarType())){
            return factoryType.createTruckType();
        }
        else {
            throw new NullPointerException("Current car type is not found");
        }
    }
}
