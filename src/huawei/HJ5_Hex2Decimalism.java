package huawei;

/*
写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
输入描述:
输入一个十六进制的数值字符串。
输出描述:
输出该数值的十进制字符串。
示例1
输入
0xA
输出
10
 */

import sun.rmi.server.Activation$ActivationSystemImpl_Stub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 思路：
 * 1、将读到的字符串，从后往前读。
 * 2、定义一个计数器，记录当前读到的位置是倒数第多少位。
 * 3、对于每一位数，让其本身乘以16的位置减一次方。并将其加到总数上。
 * 4、遍历完整个字符串，输出结果即可
 */
public class HJ5_Hex2Decimalism {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string;
        while(( string = bufferedReader.readLine()) !=null){
            if(string.length()<3){
                return;
            }
            int temp = 0;
            int index = 0;
            for(int i=string.length()-1;i>=2;i--){
                char ch = string.charAt(i);
                if(ch>='A'&&ch<='F'){
                    ch = Character.toLowerCase(ch);
                }
                if(ch>='a'&&ch<='f'){
                    temp += ((int)(ch-'a')+10) * Math.pow(16,index);
                }
                else if(ch>='0'&&ch<='9'){
                    temp += (int)(ch-'0') * Math.pow(16,index);
                }
                index += 1;
            }
            System.out.println(temp);
        }
    }

    //将十六进制表示的数字转换成十进制数字
    public static void toDecimalism(String string){
        if(string.length()<3){
            return;
        }
        int temp = 0;
        int index = 0;
        for(int i=string.length()-1;i>=2;i--){
            char ch = string.charAt(i);
            if(ch>='A'&&ch<='F'){
                ch = Character.toLowerCase(ch);
            }
            if(ch>='a'&&ch<='f'){
                temp += ((int)(ch-'a')+10) * Math.pow(16,index);
            }
            else if(ch>='0'&&ch<='9'){
                temp += (int)(ch-'0') * Math.pow(16,index);
            }
            index += 1;
        }
        System.out.println(temp);
    }

}
