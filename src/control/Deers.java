package control;

public class Deers {
    public static void main(String[] args) {
        int deers = 200;
        int duration = 0;
        while(deers <= 300){
            duration++;
            deers = (int) (deers * 1.1);
            deers -= 15;

            System.out.printf("%d: %d Hirsche %n", duration, deers);
        }
    }

}
