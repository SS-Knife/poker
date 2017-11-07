package NO2_Level3_haoshuyi_2017213075;

import com.sun.org.apache.xpath.internal.SourceTree;
import oracle.jrockit.jfr.StringConstantPool;

import java.util.Random;

public class poker {
    private int color[] = new int[54];
    private int number[] = new int[54];

    public void setColor(int i, int color) {
        this.color[i] = color;
    }

    public int getColor(int i) {
        return color[i];
    }

    public String getColor_1(int i) {
        String a;
        switch (color[i]) {
            case 0:
                a = "♠";
                break;
            case 1:
                a = "♣";
                break;
            case 2:
                a = "♥";
                break;
            case 3:
                a = "♦";
                break;
            default:
                a = "";
        }
        return a;
    }

    public int getNumber(int i) {
        return number[i];
    }

    public String getNumber_1(int i) {
        String a;
        switch (number[i]) {
            case 1:
                a = "A";
                break;
            case 11:
                a = "J";
                break;
            case 12:
                a = "Q";
                break;
            case 13:
                a = "K";
                break;
            case 53:
                a = "BLACK-JOKER";
                break;
            case 54:
                a = "RED-JOKER";
                break;
            default:
                a = "" + number[i];
        }
        return a;
    }

    public void setNumber(int i, int number) {
        this.number[i] = number;
    }

    public void print_card() {
        for (int i = 0; i < 54; i++) {
            System.out.print(getColor_1(i) + getNumber_1(i) + "   ");
        }
        System.out.println("");
    }

    public void set() {
        System.out.println("原序列");
        for (int i = 0; i < 54; i++) {
            if (i >= 52) {
                setColor(i, 4);
                setNumber(i, i + 1);
            } else {
                setColor(i, i / 13);
                setNumber(i, i + 1 - (i / 13) * 13);
            }
        }
        print_card();
    }

    public void wash1() {
        System.out.println("方法一：中间分开，2摞牌交叉洗3次");
        int[] x = new int[54];
        int[] y = new int[54];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 27; j++) {
                x[j * 2] = color[j];
                y[j * 2] = number[j];
                x[j * 2 + 1] = color[53 - j];
                y[j * 2 + 1] = number[53 - j];
            }
            for (int j = 0; j < 54; j++) {
                color[j] = x[j];
                number[j] = y[j];
            }
        }
        print_card();
    }

    public void wash2() {
        System.out.println("方法二：从后至前随机交换");
        for (int i = 53; i >= 0; i--) {
            int c_color;
            int c_number;
            int random = new Random().nextInt(53);
            c_color = color[i];
            color[i] = color[random];
            color[random] = c_color;
            c_number = number[i];
            number[i] = number[random];
            number[random] = c_number;
        }
        print_card();
    }

    public void wash3() {
        System.out.println("方法三：铺在桌上完全打乱，再随机拾取");
        int[] x = new int[54];
        int[] y = new int[54];
        int[] z = new int[54];
        for (int i = 0; i < 54; i++) {
            z[i] = 0;
        }
        for (int j = 0;j < 54;j++ ) {
            int random = new Random().nextInt(53);
            int a = 1;
            for(int i = random; i >= 0; i+=a){
                if (z[i] == 0) {
                    x[j] = color[i];
                    y[j] = number[i];
                    z[i] = 1;
                    break;
                }
                if(i == 53){
                    i = random;
                    a = -1;
                }
            }
        }
        for (int i = 53; i >= 0; i--) {
            color[i] = x[i];
            number[i] = y[i];
        }
        print_card();
    }
}
