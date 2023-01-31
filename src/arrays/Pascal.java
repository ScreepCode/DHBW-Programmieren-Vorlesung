package arrays;

public class Pascal {
    public static void main(String[] args) {
        int zeilenAnzahl = 9;
        int[][] pascalDreieck = new int[zeilenAnzahl][zeilenAnzahl];
        pascalDreieck[0][0] = 1;

        for(int i = 0; i < zeilenAnzahl; i++){
            pascalDreieck[i][0] = 1;
            for(int j = 1; j <= i; j++){
                pascalDreieck[i][j] = pascalDreieck[i-1][j-1] + pascalDreieck[i-1][j];
            }
        }

        for(int i = 0; i < zeilenAnzahl; i++){
            for(int j = 0; j < zeilenAnzahl - i; j++) {
                System.out.print("   ");
            }
            for(int j = 0; j <= i; j++){
                System.out.printf("%6s", pascalDreieck[i][j]);
            }
            System.out.println();
        }
    }
}
