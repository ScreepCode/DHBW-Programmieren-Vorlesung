package control;

public class ShoeSize {
    public static void main(String[] args) {
        double zentimeter = 19.33;

        System.out.print("Zentimeter    | Größe\n" + "--------------+------\n");
        for(int shoeSize = 30; shoeSize <= 49; shoeSize++){
            System.out.printf("%.2f - %.2f | %d %n", (shoeSize-1)/1.5, shoeSize/1.5, shoeSize);
        }
    }
}
