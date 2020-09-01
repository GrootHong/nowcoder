package huawei;

/*
题目描述
•连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
•长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
输入描述:
连续输入字符串(输入2次,每个字符串长度小于100)
输出描述:
输出到长度为8的新字符串数组
示例1
输入
abc
123456789
输出
abc00000
12345678
90000000
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 思路：
 * 按行读取字符串，然后将字符串切分。
 * 只输入两次，所以只要创建最大数组为ceil(100/8)*2即可。
 */
public class HJ004_SplitString {
    public static void main(String[] args) throws IOException {
        int length = 2*(100/8)+2;
        String[] strings = new String[length];
        int index = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        String line2 = br.readLine();


        for(int i=0;i<line1.length()/8;i++){
            strings[index] = line1.substring(8*index,8*index+8);
            index++;
        }
        int temp = line1.length()%8;
        int start = line1.length()-temp;
        if(temp!=0){
            strings[index] = "00000000";
            strings[index] = line1.substring(start)+strings[index].substring(temp);
            index++;
        }
        for(int i=0;i<line2.length()/8;i++){
            strings[index] = line2.substring(8*i,8*i+8);
            index++;
        }
        temp = line2.length()%8;
        start = line2.length()-temp;
        if(temp!=0){
            strings[index] = "00000000";
            strings[index] = line2.substring(start)+strings[index].substring(temp);
            index++;
        }
        for(int i=0;i<index;i++){
            System.out.println(strings[i]);
        }
    }
}
