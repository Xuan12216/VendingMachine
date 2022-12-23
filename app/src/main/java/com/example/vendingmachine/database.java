package com.example.vendingmachine;

public class database {
    public static double depositMoney=0.0,selectProductMoney=0.0;//depositMoney=投幣金額，selectProductMoney=需付金額
    public static double totalBills=0.0,totalCoins=0.0;//totalBills=紙幣總金額，totalCoins=硬幣總金額
    public static int[] Bills= {0,0,0,0};//bills $1,$5,$10,$20，如果選擇終止交易，要把錢還原退回
    public static int[] Coins= {0,0,0};//coins $5,$10,$25，，如果選擇終止交易，要把錢還原退回
    public static String[] ProductName={
             "A. 可口可樂             "//這裏不要改
            ,"B. 美粒果柳橙汁     "//這裏不要改
            ,"C. 依雲礦泉水         "//這裏不要改
            ,"D. MM's巧克力       "//這裏不要改
            ,"E. 好時巧克力         "//這裏不要改
            ,"F. OREO夾心餅乾   "//這裏不要改
            ,"G. 多力多滋             "//這裏不要改
            ,"H. 品客洋芋片         "};//這裏不要改
    public static int[] Product={0,0,0,0,0,0,0,0};//product數量
    public static double[] Price={1.65,3.50,2.80,1.50,1.85,1.00,3.25,3.40};//product price
}
