public class SimpleFractions {
    private int numerator;
    private int denominator;

    public SimpleFractions() {
        this.numerator = 1;
        this.denominator = 1;
    }

    public SimpleFractions(int num, int den) {
        this.numerator = num;
        this.denominator = den;
        System.out.print(numerator + "/" + denominator + " ");
    }

    static SimpleFractions sum(SimpleFractions Fr1, SimpleFractions Fr2) {
        System.out.println(" ");
        SimpleFractions SUM = new SimpleFractions();
        int numL = Fr1.numerator * Fr2.denominator + Fr1.denominator * Fr2.numerator;
        int denL = Fr1.denominator * Fr2.denominator;
        return new SimpleFractions(numL,denL);
    }

    static SimpleFractions min(SimpleFractions Fr1, SimpleFractions Fr2) {
        System.out.println(" ");
        int numL = Fr1.numerator * Fr2.denominator - Fr1.denominator * Fr2.numerator;
        int denL = Fr1.denominator * Fr2.denominator;
        return new SimpleFractions(numL,denL);
    }

    static SimpleFractions multiply(SimpleFractions Fr1, SimpleFractions Fr2) {
        System.out.println(" ");
        int numL = Fr1.numerator * Fr2.numerator;
        int denL = Fr1.denominator * Fr2.denominator;
        return new SimpleFractions(numL,denL);
    }

    static SimpleFractions divide(SimpleFractions Fr1, SimpleFractions Fr2) {
        System.out.println(" ");
        int numL = Fr1.numerator * Fr2.denominator;
        int denL = Fr1.denominator * Fr2.numerator;
        return new SimpleFractions(numL,denL);
    }

    /////////////////////////////////// 2 СПОСОБ ///////////////////////////////////////////////
    void sum(SimpleFractions Fr2) {
        int nom = Fr2.numerator;
        int denom = Fr2.denominator;
        int x1 = 0;
        int y1 = 0;
        x1 = this.numerator * denom + this.denominator * nom;
        y1 = this.denominator * denom;
        System.out.println("Сложение: " + x1 + "/" + y1);
    }

    void min(SimpleFractions Fr2) {
        int nom = Fr2.numerator;
        int denom = Fr2.denominator;
        int x2 = 0;
        int y2 = 0;
        x2 = this.numerator * denom - this.denominator * nom;
        y2 = this.denominator * denom;
        System.out.println("Вычитание: " + x2 + "/" + y2);
    }

    void multiply(SimpleFractions Fr2) {
        int nom = Fr2.numerator;
        int denom = Fr2.denominator;
        int x3 = 0;
        int y3 = 0;
        x3 = this.numerator * nom;
        y3 = this.denominator * denom;
        System.out.println("Умножение: " + x3 + "/" + y3);
    }

    void divide(SimpleFractions Fr2) {
        int nom = Fr2.numerator;
        int denom = Fr2.denominator;
        int x = 0;
        int y = 0;
        x = this.numerator * denom;
        y = this.denominator * nom;
        System.out.println("Деление: " + x + "/" + y);
    }
}