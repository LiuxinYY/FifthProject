package com.bipt.lx.cn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinshWork {

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
//		
//		FileInputStream fis=null;
//		fis = new FileInputStream("D:\\Java\\1.txt");
		input:
		while(true){
			try{
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("请输入你想查询的字或词：");
		String key1 = scanner1.nextLine();
		String key = key1;
		System.out.println("请输入你的姓名：");
		String name = scanner1.nextLine();
		System.out.println("请输入你的学号：");
		int number=scanner1.nextInt();
		System.out.println("请输入你的性别：");
		Boolean sex=scanner1.nextBoolean();
		System.out.println("请输入你的年龄：");
		int age=scanner1.nextInt();
		System.out.println("请输入你的专业：");
		String major = scanner1.next();
		
		Student s1=new Student(name, number, sex, age, major);
	
		
		//封装数据源
		FileReader fr=new FileReader("D:\\Java\\A.txt");
		//封装
		FileWriter fw=new FileWriter("D:\\Java\\B.txt");
//		读写数据
		
		String tempstr=null; //临时字符串
	    int c = 0; //总汉字数
		String line = System.getProperty("line.separator");//设置换行字段
		Pattern pattern =  Pattern.compile("([\u4e00-\u9fa5]{1})");//定义匹配模式:1个汉字
		
		int len=0 ;
		fw.write(s1.toString());
		fw.write(line);
		while((len=fr.read()) !=-1){
				fw.write(len);
				//每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”
				for(int a=2;a<=238;a++){				
					fw.write(fr.read());
				if( a%7 == 0 && a%14 !=0)
				{
					fw.write("，");
					
				}
				if(a%14==0){
					fw.write(" 。");
					fw.write(line);
					}
					}
			}
		
			FileReader fr1=new FileReader("D:\\Java\\A.txt");
			BufferedReader bw=new BufferedReader(fr1);
			String source = bw.readLine();
			
//			System.out.println(source);
			int num = GetFrequency(source, key);;
//			释放资源
		bw.close();
		System.out.println("\n"+key1+ "在这段话中出现了 " + num+"次");
		fr.close();
		fw.close();
			}catch(InputMismatchException e){
				System.out.println("您输入的数据错误,请重新输入\n");
				continue input;
			}}
	}


static int GetFrequency(String source,String key){
	int i, j, count = 0;
	int len1 = source.length(); //这段话的长度
	int len2 = key.length(); //待统计词语的长度
	for(i=0; i<len1-len2; i++){
	for(j=0; j<len2; j++){ //统计词语和这段话逐字符进行比较
	if(key.charAt(j) != source.charAt(j + i)){
	break;
	}
	}
	if(j>=key.length()){
	count++;
	}
	}
	return count;
	}
}
//while((tempstr = br.readLine()) != null && tempstr != ""){
//
//    //汉字匹配，统计字数
//    Matcher matcher = pattern.matcher(tempstr);
//    while(matcher.find()) c++;
//}
//System.out.println("总汉字数：" + num_of_words);