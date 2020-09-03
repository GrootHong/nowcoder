package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
题目描述
将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
接口说明
  反转句子
  @param sentence 原句子
  @return 反转后的句子
public String reverse(String sentence);
输入描述:
将一个英文语句以单词为单位逆序排放。
输出描述:
得到逆序的句子
示例1
输入
I am a boy
输出
boy a am I
 */
public class HJ13_reverseString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        string = reverse(string);
        System.out.println(string);
    }
    private static String reverse(String string){
        String[] ss = string.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=ss.length-1;i>=0;i--){
            sb.append(ss[i]+" ");
        }
        return sb.toString();
    }
}
