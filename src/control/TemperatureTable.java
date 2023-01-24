package control;

public class TemperatureTable {

    public static void main(String[] args) {

        System.out.println("Fahrenheit | Celsius");
        System.out.println("-----------+--------");
        for(int fahrenheit = 0; fahrenheit <= 300; fahrenheit++){
            double celsius = (5.0/9.0) * (fahrenheit-32);
            if(fahrenheit % 20 == 0){
                System.out.printf("%-10s | %.1f \n", fahrenheit, celsius);
            }
        }

    }

}
