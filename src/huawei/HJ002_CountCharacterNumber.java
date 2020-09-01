package huawei;

/*
题目描述
写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
输入描述:
第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
输出描述:
输出输入字符串中含有该字符的个数。
示例1
输入
ABCDEF
A
输出
1
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 思路：
 * 使用hashmap能在O(1)时间内找到对应字符出现的次数，
 * 整个算法时间复杂度O(n),空间复杂度O(n).
 * 能不能时间更短？
 *
 * 我傻了。。
 * 直接遍历一遍字符串不就行了
 */
public class HJ002_CountCharacterNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        char ch = sc.next().charAt(0);
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<string.length();i++){
            char temp = string.charAt(i);
            if(temp>='A'&&temp<='Z'){
                temp = Character.toLowerCase(temp);
            }
            if(map.get(temp)==null){
                map.put(temp,1);
            } else {
                map.put(temp,map.get(temp)+1);
            }
        }
        Integer num = map.get(ch);
        System.out.println(num==null?0:num);
    }
}
