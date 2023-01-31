package arrays;

public class Eratostenes {
    public static void main(String[] args) {
        int grenze = 100;

        boolean[] sieve = new boolean[grenze];
        String primes = "Alle Primzahlen von 2-" + grenze + ": ";
        for(int i = 0; i < sieve.length; i++){
            sieve[i] = false;
        } //false ist noch drin

        for(int i = 2; i < sieve.length; i++){
            if(sieve[i] == false){
                sieve[i] = true;
                primes += i + " ";

                for(int j = i+1; j < sieve.length; j++){
                    if (j%i == 0){
                        sieve[j] = true;
                    }
                }
            }
        }
        System.out.println(primes);
    }
}
