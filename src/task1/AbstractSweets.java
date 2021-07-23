package task1;

import java.util.Objects;
import java.util.UUID;

public abstract class AbstractSweets {
    protected String name;
    protected double weight;
    protected int price;
    protected final String uniqueID;

    protected AbstractSweets(String name, double weight, int price) {
        Objects.requireNonNull(name, "name must not be null");
        this.name = name;
        if (checkNegativeValue(weight, "Weight")) {
            this.weight = weight;
        }
        if (checkNegativeValue(price, "Price")) {
            this.price = price;
        }
        this.uniqueID = UUID.randomUUID().toString();
    }

    protected double getWeight() {
        return weight;
    }

    protected int getPrice() {
        return price;
    }

    protected String getUniqueID() {
        return uniqueID;
    }

    private boolean checkNegativeValue(double value, String name) {
        if (value > 0) {
            return true;
        } else {
            throw new IllegalArgumentException("invalid value: " + value + ". " + name + " must be > 0");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractSweets that = (AbstractSweets) o;

        if (Double.compare(that.weight, weight) != 0) return false;
        if (price != that.price) return false;
        if (!name.equals(that.name)) return false;
        return uniqueID.equals(that.uniqueID);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + price;
        result = 31 * result + uniqueID.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", weight: " + weight +
                ", price: " + price +
                ", uniqueID: " + uniqueID;
    }
}
