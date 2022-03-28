import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Objects;

public class Rebuild {
    public static String operation;
    public static String operation2;
    public static int num1 = 1;
    public static int num2 = 1;
    public static int num3 = 1;
    public static int den1 = 1;
    public static int den2 = 1;
    public static int den3 = 1;

    public static void Rebuild() {
        String text = null;
        String pattern1 = "^(-?\\d{1,10})/(-?\\d{1,10})( )[-+*:]( )(-?\\d{1,10})/(-?\\d{1,10})$";
        Pattern p = Pattern.compile(pattern1);
        String pattern2 = "^(-?\\d{1,10})/(-?\\d{1,10})( )[-+*:]( )(-?\\d{1,10})/(-?\\d{1,10})( )[-+*:]( )(-?\\d{1,10})/(-?\\d{1,10})$";
        Pattern p2 = Pattern.compile(pattern2);
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println(" ");
            System.out.println("Введите выражение состоящее из двух простых дробей вида: 'num/den (+,-,:,*) num2/den2'");
            text = in.nextLine();
            Matcher m = p.matcher(text);
            Matcher m2 = p2.matcher(text);
            if (m.matches() == true) {
                String[] parts = text.split("[/( )]+");
                num1 = Integer.parseInt(parts[0]);
                den1 = Integer.parseInt(parts[1]);
                num2 = Integer.parseInt(parts[3]);
                den2 = Integer.parseInt(parts[4]);
                operation = parts[2];
                System.out.println("Дроби:");
                SimpleFractions Fr1 = new SimpleFractions(num1, den1);
                SimpleFractions Fr2 = new SimpleFractions(num2, den2);
                System.out.println(" ");
                if (Rebuild.operation.contains("+")) {
                    SimpleFractions.sum(Fr1, Fr2);
                }
                if (Rebuild.operation.contains("-")) {
                    SimpleFractions.min(Fr1, Fr2);
                }
                if (Rebuild.operation.contains("*")) {
                    SimpleFractions.multiply(Fr1, Fr2);
                }
                if (Rebuild.operation.contains(":")) {
                    SimpleFractions.divide(Fr1, Fr2);
                }
            } else if (m2.matches() == true) {
                String[] parts = text.split("[/( )]+");
                num1 = Integer.parseInt(parts[0]);
                den1 = Integer.parseInt(parts[1]);
                num2 = Integer.parseInt(parts[3]);
                den2 = Integer.parseInt(parts[4]);
                num3 = Integer.parseInt(parts[6]);
                den3 = Integer.parseInt(parts[7]);
                operation = parts[2];
                operation2 = parts[5];
                System.out.println("Дроби:");
                SimpleFractions Fr1 = new SimpleFractions(num1, den1);
                SimpleFractions Fr2 = new SimpleFractions(num2, den2);
                SimpleFractions Fr3 = new SimpleFractions(num3, den3);
                System.out.println(" ");
                if ((Rebuild.operation.contains("*")&(Rebuild.operation2.contains("*")))|(Rebuild.operation.contains("+")&(Rebuild.operation2.contains("+")))|(Rebuild.operation.contains("-")&(Rebuild.operation2.contains("-")))|(Rebuild.operation.contains(":")&(Rebuild.operation2.contains(":"))))
                {
                    if (Rebuild.operation.contains("+")) {
                        SimpleFractions.sum(SimpleFractions.sum(Fr1, Fr2), Fr3);
                    }
                    if (Rebuild.operation.contains("-")) {
                        SimpleFractions.min(SimpleFractions.min(Fr1, Fr2), Fr3);
                    }
                    if (Rebuild.operation.contains("*")) {
                        SimpleFractions.multiply(SimpleFractions.multiply(Fr1, Fr2), Fr3);
                    }
                    if (Rebuild.operation.contains(":")) {
                        SimpleFractions.divide(SimpleFractions.divide(Fr1, Fr2), Fr3);
                    }
                } else if ((Rebuild.operation.contains("*")&(Rebuild.operation2.contains(":")))|(Rebuild.operation.contains("+")&(Rebuild.operation2.contains("-")))|(Rebuild.operation.contains("-")&(Rebuild.operation2.contains("+")))|(Rebuild.operation.contains(":")&(Rebuild.operation2.contains("*")))){
                    if (Rebuild.operation.contains("+")) {
                        SimpleFractions.min(SimpleFractions.sum(Fr1, Fr2), Fr3);
                    }
                    if (Rebuild.operation.contains("-")) {
                        SimpleFractions.sum(SimpleFractions.min(Fr1, Fr2), Fr3);
                    }
                    if (Rebuild.operation.contains("*")) {
                        SimpleFractions.divide(SimpleFractions.multiply(Fr1, Fr2), Fr3);
                    }
                    if (Rebuild.operation.contains(":")) {
                        SimpleFractions.multiply(SimpleFractions.divide(Fr1, Fr2), Fr3);
                    }
                }
                else if (((Rebuild.operation.contains(":"))|(Rebuild.operation.contains("*")))&((Rebuild.operation2.contains("+"))|(Rebuild.operation2.contains("-")))){
                    if ((Rebuild.operation2.contains("+"))|(Rebuild.operation.contains("*"))) {
                        SimpleFractions.sum(SimpleFractions.multiply(Fr1, Fr2), Fr3);
                    }
                    if ((Rebuild.operation2.contains("-"))|(Rebuild.operation.contains("*"))) {
                        SimpleFractions.min(SimpleFractions.multiply(Fr1, Fr2), Fr3);
                    }
                    if ((Rebuild.operation2.contains("+"))|(Rebuild.operation.contains(":"))) {
                        SimpleFractions.sum(SimpleFractions.divide(Fr1, Fr2), Fr3);
                    }
                    if ((Rebuild.operation2.contains("-"))|(Rebuild.operation.contains(":"))) {
                        SimpleFractions.min(SimpleFractions.divide(Fr1, Fr2), Fr3);
                    }
                }
                else if (((Rebuild.operation2.contains(":"))|(Rebuild.operation2.contains("*")))&((Rebuild.operation.contains("+"))|(Rebuild.operation.contains("-")))){
                    if ((Rebuild.operation.contains("+"))&(Rebuild.operation2.contains("*"))) {
                        SimpleFractions.sum(SimpleFractions.multiply(Fr2, Fr3), Fr1);
                    }
                    if ((Rebuild.operation.contains("-"))&(Rebuild.operation2.contains("*"))) {
                        SimpleFractions.min(Fr1, SimpleFractions.multiply(Fr2, Fr3));
                    }
                    if ((Rebuild.operation.contains("+"))&(Rebuild.operation2.contains(":"))) {
                        SimpleFractions.sum(SimpleFractions.divide(Fr2, Fr3), Fr1);
                    }
                    if ((Rebuild.operation.contains("-"))&(Rebuild.operation2.contains(":"))) {
                        SimpleFractions.min(Fr1, SimpleFractions.divide(Fr2, Fr3));
                    }
                }
            } else if (Objects.equals(text, "quit")) {
                System.out.println("Завершение программы из-за введеного слова 'quit', хорошего вам дня!");
                break;
            } else {
                System.out.println("Выражение введено неверно, введите выражение ещё раз.");
            }
        }
        in.close();
    }
}