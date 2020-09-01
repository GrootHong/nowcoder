package huawei.HJ105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0
本题有多组输入数据，输入到文件末尾，请使用while(cin>>)读入
数据范围小于1e6
输入描述:
输入任意个整数
输出描述:
输出负数个数以及所有非负数的平均值
示例1
输入
-13
-4
-7
输出
3
0.0
 */
public class MinusCounting {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int totalCount = 0;
        int minusCount = 0;
        String string;
        int temp;
        int sum = 0;
        while((string = bufferedReader.readLine())!=null){
            temp = Integer.parseInt(string);
            totalCount++;
            if(temp<0){
                minusCount++;
            } else {
                sum += temp;
            }
        }
        temp = totalCount-minusCount;
        int avg = temp==0?0:sum/(totalCount-minusCount);
        System.out.println(minusCount+"\r\n"+avg);
    }

}
