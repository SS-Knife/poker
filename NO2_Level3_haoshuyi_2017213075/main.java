package NO2_Level3_haoshuyi_2017213075;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        poker pokers = new poker();
        pokers.set();
        System.out.println("亲爱的Miss.Tenderloin,你看起来很苦恼。");//Tenderloin意为里脊肉
        System.out.println("啊哈，原来是不会洗牌，让我来帮助你，亲爱的Miss.Tenderloin，你想用哪种方法洗牌呢？");
        System.out.println("(请用数字输入你想使用的方法)");
        System.out.println("方法一：中间分开，2摞牌交叉洗3次");
        System.out.println("方法二：从后至前随机交换");
        System.out.println("方法三：铺在桌上完全打乱，再随机拾取");
        int x = in.nextInt();
        switch (x) {
            case 1:
                pokers.wash1();
                break;
            case 2:
                pokers.wash2();
                break;
            case 3:
                pokers.wash3();//铺在桌上全部打乱，再随机拾取
                break;
            default:
                System.out.println("很抱歉，就算聪明如我也没法帮助你了，亲爱的Miss.Tenderloin。");
        }
    }
}
