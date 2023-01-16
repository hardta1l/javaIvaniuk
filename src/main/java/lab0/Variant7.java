package lab0;

public class Variant7 {
    // Дано двозначне число. Знайти суму та добуток його цифр.
    public int[] integerNumbersTask(int a) {
        if(a < 10 || a > 99){
            throw new IllegalArgumentException(" 9 < a < 100");
        }
        int []arr = new int[2];
        arr[0] = a/10 + a%10;
        arr[1] = (a/10) * (a%10);
        return arr;
    }
    /*Дано три цілих числа: A , B ,  C . Перевірити істинність висловлювання:
    «Число  B знаходиться між числами  A і  C ».
     */


    public boolean booleanTask(int a, int b, int c) {
        return (b > a && b < c || b <a && b > c);
    }
    // Дано два числа. Вивести порядковий номер меншого з них.


    public int ifTask(int a, int b) {
        if (a < b) return 1;
        return 2;
    }
    /* Одиниці маси пронумеровані так: 1 — кілограм, 2 — міліграм, 3 — грам, 4 — тонна, 5 — центнер.
    Дано номер одиниці маси (ціле число в діапазоні 1-5) і маса тіла в цих одиницях (дійсне число).
    Знайти масу тіла у кілограмах.*/

    public double switchTask(int si, double weight) {
        if(si < 1 || si > 5){
            throw new IllegalArgumentException("0 < si < 6");
        }
        switch (si){
            case 1:
                return weight;
            case 2:
                return weight * 1000000;
            case 3:
                return weight * 1000;
            case 4:
                return weight * 0.001;
            case 5:
                return weight * 0.01;
        }
        return weight;
    }
    //For7 . Дано два цілих числа  A і  B ( A  <  B ). Знайти суму всіх цілих чисел від  A до  B включно.

    public int forTask(int a, int b) {
        if(a > b ){
            throw new IllegalArgumentException("Enter a < b");
        }
        int sum = 0;
        for(int i = a; i <= b; i++){
            sum += i;
        }
        return sum;
    }

    /*Дано ціле число  N (> 0). Знайти найменше ціле позитивне число  K  ,  квадрат якого перевищує  N : K2 > N .
    Функцію вилучення квадратного кореня не використовувати.
     */


    public int whileTask(int n) {
        if(n < 0){
            throw new IllegalArgumentException("Enter n > 0");
        }
        int i = 0;
        while (i*i <= n){
            i++;
        }
        return i;
    }
    // Дано масив розміру  N . Вивести його елементи у зворотному порядку.

    public int[] arrayTask(int [] array, int n) {
        if(n <= 1){
            throw new IllegalArgumentException("n > 1");
        }
        int []arr = new int[n];
        int j = 0;
        for(int i = n-1; i >= 0; i--){
            arr[j] = array[i];
            j++;
        }
        return arr;
    }
    /* Дана матриця розміру  M  N і  ціле число  K (1  K K M ) .
    Вивести елементи K -го рядка даної матриці.

     */

    public int[]  twoDimensionArrayTask(int[][] matrix, int n, int m, int k) {
        if(k < 1 || k > m ){
            throw new IllegalArgumentException(" 1 < k < m");
        }
        int[] row = new int[m];
        for(int i = 0; i < m; i++){
            row[i] = matrix[k][i];
        }
        return row;
    }

    public static void main(String... strings) {
        System.out.println("Done!!!");
    }

}