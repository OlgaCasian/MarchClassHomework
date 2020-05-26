public class Apple {
    String kind; //"Honey Crisp", "Golden Delicious", "Pink Lady"
    String color; //"red", "yellow", "green"
    double  weight; //around 1.5 pounds/68.7 g (60-100g/apple)

    public Apple(String kind, String color, double weight) {
        this.kind = kind;
        this.color = color;
        this.weight = weight;
    }

    public String getKind() {
        return kind;
    }

    public String getColor() {
        return color;
    }


    void wash() {
        System.out.println("I wash the apple");
    }
    void cut() {
        System.out.println("I cut the apple");
    }
    void peel() {
        System.out.println("I peel the apple");
    }
    void eat() {
        System.out.println("I eat the apple");
    }
}
