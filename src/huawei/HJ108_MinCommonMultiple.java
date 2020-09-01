package huawei;

/*
正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
输入描述:
输入两个正整数A和B。
输出描述:
输出A和B的最小公倍数。
示例1
输入
5 7
输出
35
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 思路：
 * 直接想法：首先找到最大公约数，然后将这两个数相乘再除以最大公约数就是结果。
 * 找到最大公约数的方法：
 * 从一到最小值开始遍历，如果一个数能够被这两个数整除，则这个数就是公约数，
 * 一直循环，找到最大公约数。
 * 时间复杂度：O(min(m,n));
 */
public class HJ108_MinCommonMultiple {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        int A = Integer.parseInt(string.substring(0,string.indexOf(' ')));
        int B = Integer.parseInt(string.substring(string.indexOf(' ')+1));
        int max = 1;
        int min = A>B?B:A;
        for(int i=2;i<=min;i++){
            if(A%i==0&&B%i==0){
                max = i;
            }
        }
        System.out.println(A*B/max);
    }
}
