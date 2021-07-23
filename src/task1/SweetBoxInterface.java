package task1;

public interface SweetBoxInterface {

    void add(int index, AbstractSweets sweet);

    void addLast(AbstractSweets sweet);

    void delete(int index);

    void deleteLast();

    void printWeight();

    void printPrice();

    void printAllSweets();
}
