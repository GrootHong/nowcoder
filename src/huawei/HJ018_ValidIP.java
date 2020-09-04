package huawei;

import java.util.Scanner;
import java.util.stream.Stream;

/*
题目描述
请解析IP地址和对应的掩码，进行分类识别。
要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
所有的IP地址划分为 A,B,C,D,E五类
A类地址1.0.0.0~126.255.255.255;
B类地址128.0.0.0~191.255.255.255;
C类地址192.0.0.0~223.255.255.255;
D类地址224.0.0.0~239.255.255.255；
E类地址240.0.0.0~255.255.255.255
私网IP范围是：
10.0.0.0～10.255.255.255
172.16.0.0～172.31.255.255
192.168.0.0～192.168.255.255
子网掩码为二进制下前面是连续的1，然后全是0。
（例如：255.255.255.32就是一个非法的掩码）
注意二进制下全是1或者全是0均为非法
注意：
1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，
也不属于不合法ip地址，计数时可以忽略
2. 私有IP地址和A,B,C,D,E类地址是不冲突的
输入描述:
多行字符串。每行一个IP地址和掩码，用~隔开。
输出描述:
统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
示例1
输入
10.70.44.68~255.254.255.0
1.0.0.1~255.0.0.0
192.168.0.2~255.255.255.0
19..0.~255.255.255.0
输出
1 0 1 0 0 2 1
 */
public class HJ018_ValidIP {
    private int A, B, C, D, E, ErrorIP, ErrorMask, privateIP;

    public static void main(String[] args) {
        String regex = "(\\d+\\.){3}\\d+";
        Scanner scanner = new Scanner(System.in);
        String string;
        while ((string = scanner.nextLine()) != null) {
            String[] ss = string.split("~");
            boolean flag = string.matches(regex);
            System.out.println(flag);
        }
    }

    /**
     * 内部类 IP
     */
    private class IP {
        int first;
        int second;
        int third;
        int fourth;
        boolean flag = false;
        /**
         * 构造IP类
         * @param string 传入字符串
         */
        public IP(String string) {
            String[] strings = string.split("\\.");
            if (strings.length == 4) {
                first = Integer.parseInt(strings[0]);
                second = Integer.parseInt(strings[1]);
                third = Integer.parseInt(strings[2]);
                fourth = Integer.parseInt(strings[3]);
                if ((first >= 1 && first <= 126) || (first >= 128 && first <= 255)) {
                    if ((second >= 0 && second <= 255) && (third >= 0 && third <= 255) && (fourth >= 0 && fourth <= 255)) {
                        flag = true;
                    }
                }
            }
        }
        /**
         * 返回IP是否有效
         * @return
         */
        public boolean isValid(){
            return flag;
        }
        /**
         * 查看IP是否是私网IP
         */
        public boolean isPrivate(){
            if(first==10){
                return true;
            } else if(first==172&&second>=16&&second<=31){
                return true;
            } else if(first==192&&second==168){
                return true;
            } else {
                return false;
            }
        }

        /**
         * 查看属于哪一类IP
         */
        public String IPType(){
            if(first>=1&&first<=126){
                return "A";
            } else if(first>=128&&first<=191){
                return "B";
            } else if(first>=192&&first<=223){
                return "C";
            } else if(first>=240&&first<=255){
                return "E";
            } else {
                return "error";
            }
        }
    }

    private class Mask{
        int first;
        int second;
        int third;
        int fourth;
        boolean valid = false;

        /**
         * 构造函数
         * @param string 传入字符串
         */
        public Mask(String string){
            String[] strings = string.split("\\.");
            if(strings.length==4){
                first = Integer.parseInt(strings[0]);
                second = Integer.parseInt(strings[1]);
                third = Integer.parseInt(strings[2]);
                fourth = Integer.parseInt(strings[3]);
            }
        }

        /**
         * 查看掩码是否合法
         * @return 返回真假
         */
        public boolean isValid(){
            return false;
        }
    }
}



































