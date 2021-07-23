package task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SweetBox implements SweetBoxInterface {
    private final List<AbstractSweets> sweets = new ArrayList<>();

    @Override
    public void add(int index, AbstractSweets sweet) {
        sweets.add(index, sweet);
    }

    @Override
    public void addLast(AbstractSweets sweet) {
        sweets.add(sweet);
    }

    @Override
    public void delete(int index) {
        if (!sweets.isEmpty()) {
            sweets.remove(index);
        }
    }

    @Override
    public void deleteLast() {
        if (!sweets.isEmpty()) {
            sweets.remove(sweets.size() - 1);
        }
    }

    @Override
    public void printWeight() {
        System.out.println("Weight: " + getWeight());
    }

    @Override
    public void printPrice() {
        System.out.println("Price: " + getPrice());
    }

    @Override
    public void printAllSweets() {
        System.out.println("All sweets:");
        sweets.forEach(System.out::println);
    }

    private double getWeight() {
        return sweets.stream().mapToDouble(AbstractSweets::getWeight).sum();
    }

    private int getPrice() {
        return sweets.stream().mapToInt(AbstractSweets::getPrice).sum();
    }

    public void weightOptimization(double value) {
        if (sweets.isEmpty()) {
            System.out.println("Nothing to optimize. Box with sweets is empty");
        } else if (value < 0) {
            System.out.println("Invalid input. Value must be > 0");
        } else if (value < getMinWeight()) {
            System.out.println("Invalid input. Value < min weight");
        } else if (value < getMaxWeight()) {
            System.out.println("Invalid input. Value < max weight");
        } else {
            double difference = Math.round((getWeight() - value) * 100.0) / 100.0;

            if (difference > 0) {
                List<AbstractSweets> listSortedByWeight = getSortedByWeight();

                while (difference > 0) {
                    int index = listSortedByWeight.size() - 1;
                    AbstractSweets sweet = listSortedByWeight.get(index);
                    double minWeight = sweet.weight;
                    String id = sweet.uniqueID;
                    listSortedByWeight.remove(index);
                    deleteById(id);
                    difference = Math.round((difference - minWeight) * 100.0) / 100.0;
                }
            } else {
                System.out.println("This box with sweets is already optimized: current weight - " + getWeight());
            }
        }
    }

    private double getMinWeight() {
        return sweets.stream().mapToDouble(AbstractSweets::getWeight).min().getAsDouble();
    }

    private double getMaxWeight() {
        return sweets.stream().mapToDouble(AbstractSweets::getWeight).max().getAsDouble();
    }

    private List<AbstractSweets> getSortedByWeight() {
        return new ArrayList<>(sweets).stream()
                .sorted(Comparator.comparingDouble(AbstractSweets::getWeight).thenComparingInt(AbstractSweets::getPrice).reversed())
                .collect(Collectors.toList());

    }

    private void deleteById(String id) {
        int index = getIndexById(id);
        if (index >= 0) {
            sweets.remove(index);
        }
    }

    private int getIndexById(String id) {
        for (int i = 0; i < sweets.size(); i++) {
            if (sweets.get(i).getUniqueID().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
