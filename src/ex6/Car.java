package ex6;

public class Car implements Comparable<Car> {
    private final String carBrand;
    private final String model;
    private final Integer pricePerDay;

    public Car(String carBrend, String model, int pricePerDay) {
        this.carBrand = carBrend;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getModel() {
        return model;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Car car = (Car) obj;
        if (!this.carBrand.equals(car.getCarBrand())) {
            return false;
        }
        if ( !this.model.equals(car.getModel()) ) {
            return false;
        }
        return this.pricePerDay.equals(car.getPricePerDay());

    }

    @Override
    public int hashCode() {
       int result = carBrand.hashCode();
       result = 31 * result + model.hashCode();
       result = 31 * result + pricePerDay.hashCode();
       return result;
    }

    @Override
    public int compareTo(Car car) {

        if (pricePerDay < car.getPricePerDay()) {
            return -1;
        }
        if (pricePerDay > car.getPricePerDay()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return carBrand + " " + model + " " + pricePerDay;
    }
}
