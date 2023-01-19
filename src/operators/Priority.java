package operators;

public class Priority {
    public static void main(String[] args) {
        System.out.println("1: " + (5 / 2 * 2));
        System.out.println("2: " + (9. / 2 * 5));
        boolean a = true, b = false, c = false;
        System.out.println("3: " + (a && b || c));
        char ch = 'c';
        System.out.println("4: " + ('a' + 1 < ch));
        int i = 1, j = 2, k = 3;
        System.out.println("5: " + (-i - 5 * j >= k + 1));
        i = 1;
        if (a || (++i == 2)) {
            System.out.println("6: " + i);
        }
        i = 1;
        if (a | (++i == 2)) {
            System.out.println("7: " + i);
        }
    }
}
