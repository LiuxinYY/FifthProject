# FifthProject
# 计G201 刘馨 2020322069
# 一、实验目的
1. 掌握字符串String及其方法的使用
2. 掌握文件的读取/写入方法
3. 掌握异常处理结构
# 二、实验要求
1. 利用已学的字符串处理知识编程完成《长恨歌》古诗的整理对齐工作，写出功能方法。
    - 每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”
    - 允许提供输入参数，统计古诗中某个字或词出现的次数
    - 输入的文本来源于文本文件B读取，把处理好的结果写入到文本文件A，并将学生的基本信息与学生处理后的作业信息写入到文本文件A中
    - 考虑操作中可能出现的异常，在程序中设计异常处理程序
2. 设计学生类（可利用之前的）
3. 采用交互式方式实例化某学生
4. 设计程序完成上述的业务逻辑处理，并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中。
# 三、实验过程
1. 创建父类Student学生封装类
    - 类中定义number,  name, sex, age，major四个变量,分别表示人员编号、姓名、性别、年龄、专业。使用set方法设置参数,设置get方法获取参数
    - 用super创建有参构造方法和无参构造方法，使用使用Object根类的toString（）方法打印人员基本信息，并在打印输出方法中使用if（）else判断人员性别
2. 创建FishWork测试类
    - 使用Scanner对象调用System.in方法输入所要查询的字，学生的基本信息等内容。
    - 获取学生输入的基本信息，并将信息封装成学生对象
    - 利用FileReader和FileWriter封装数据源，读写txt文件中的数据。
    - 利用FileWriter中的write方法向文件A中写入学生信息和处理后的作业信息。
    - 使用for循环对文件b中的内容进行整理对齐工作（每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”）
    - 利用BufferedReader类读取文本文件，将文件中读入字符数据并置入缓冲区，使用read()方法，从缓冲区中读取，获取输入所要查询的字的字符串
    - 创建GetFrequency方法，用来进行统计文本内容中字符的个数。使用得到的字符串调用GetFrequency方法进行查询该字符串出现的次数
    - 打印输出古诗中某个字或词出现的次数
    - 释放资源，关闭输入输出流
6. 添加内容
    - 对输入内容进行数据类型判断（若输入错误，则重新输入）
    - 利用for循环统计字符串和这段话逐字符进行比较
# 四、核心代码
1. 有参和无参构造方法
```
	//有参构造方法
	public Student(String name, int number, boolean sex, int age, String major) {
		super();
		this.name = name;
		this.number = number;
		this.sex = sex;
		this.age = age;
		this.major = major;
	}
	
//	无参构造方法
	public Student() {
		super();
	}
```
2. 用static定义统计字符串的GetFrequency方法
```
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
```
3. 采用Scanner类实现运行时交互式输入
```
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
```
4. 调用GetFrequency方法
```
			FileReader fr1=new FileReader("D:\\Java\\A.txt");
			BufferedReader bw=new BufferedReader(fr1);
			String source = bw.readLine();
			
//			System.out.println(source);
			int num = GetFrequency(source, key);;
```
5. 实例化对象
```
//		实例化对象（有参）
		Student s1=new Student(1,"杨洋",false,13);
		Course c1=new Course(5555, "Java", "教室306", "张老师", "15:00");
//		实例化对象 （无参）
		Course c2=new Course();
		Teacher t1=new Teacher(33, "张老师", false, 30);
```
6. 异常判断
```
		}catch(InputMismatchException e){
			System.out.println("您输入的数据错误\n");
			continue input;
		}
```
6. 封装数据源
```
		//封装数据源
		FileReader fr=new FileReader("D:\\Java\\A.txt");
		//封装
		FileWriter fw=new FileWriter("D:\\Java\\B.txt");
//		读写数据
```
7. 每7个汉字加入一个标点符号，奇数时加“，”，偶数时加“。”
```
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
```
8. 文件内容写入
```
		int len=0 ;
		fw.write(s1.toString());
		fw.write(line);
		while((len=fr.read()) !=-1){
				fw.write(len);
```
# 五、实验结果
1. 文件处理之前

![RUNOOB 图标](http://p.qlogo.cn/qqmail_head/7YEOYibLSdBqZVD4CyGuGu0fhvWt8ibzgjcEia3RtyTCL1jXRqGmNCvFYVZhRm3GD21IzReFJpz564/0)

2. 输入所要统计古诗中某个字或词，以及学生信息，数次统计次数

![RUNOOB 图标](http://p.qlogo.cn/qqmail_head/7YEOYibLSdBqZVD4CyGuGu0fhvWt8ibzgjEfV5333mJcsun6NA5VrBsRm3mrT4sVwG5Z7JSBFg2tY/0)

3. 并且把“古诗处理后的输出”结果存储到学生基本信息所在的文本文件A中，运行之后

![RUNOOB 图标](http://p.qlogo.cn/qqmail_head/7YEOYibLSdBqZVD4CyGuGu0fhvWt8ibzgjEfV5333mJctrNMMgqlgiaib15DQUvMtT0u1SlQBTAcTR0/0)


# 六、实验感想
通过本次实验所写的程序代码，通过动手编程实现，观察输出结果，掌握字符串String及其方法的使用，了解String中的使用约束，学会了文件的读取/写入方法，深入了解FileWriter中方法的具体使用，熟练掌握掌握异常处理结构，并在程序中根据输入情况做异常处理。熟练掌握数据交互式输入方法。

