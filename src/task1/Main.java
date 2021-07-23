package task1;

public class Main {

    public static void main(String[] args) {
        Candy candy1 = new Candy("Candy1", 2.1, 50);
        Candy candy2 = new Candy("Candy2", 8.5, 45);
        Chocolate chocolate1 = new Chocolate("Chocolate1", 51.2, 2_000);
        Chocolate chocolate2 = new Chocolate("Chocolate2", 40.8, 230);
        Cookie cookie1 = new Cookie("Cookie1", 9.1, 32);
        Cookie cookie2 = new Cookie("Cookie2", 8.5, 28);
        Lollipop lollipop1 = new Lollipop("Lollipop1", 2.1, 18);
        Lollipop lollipop2 = new Lollipop("Lollipop2", 2.1, 15);

        SweetBox box1 = new SweetBox();
        box1.addLast(candy1);
        box1.addLast(candy2);
        box1.addLast(chocolate1);
        box1.addLast(chocolate2);
        box1.addLast(cookie1);
        box1.addLast(cookie2);
        box1.addLast(lollipop1);
        box1.addLast(lollipop2);

        box1.printWeight();
        box1.printPrice();
        box1.weightOptimization(92.0);
        box1.printWeight();
        box1.printPrice();
        box1.printAllSweets();
    }
}
