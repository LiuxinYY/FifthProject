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
    - 实现一门课程只由一门老师教授：在学生封装类中，判断教师是否教授此门课程，若教授，输出教师信息，若不教授，则只输出学生选课信息
# 四、核心代码
1. 有参和无参构造方法
```
	//有参构造方法
	public People(int number, String name, Boolean sex, int age) {
		super();
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
//	无参构造方法
	public People() {
		super();
	}
```
2. Object根类的toString（）方法
```
//	Object根类的toString（）方法,判断Boolean类型的男女性别
	public String toString() {
		if(sex==true){
		return "People [编号" + number + ", 名字" + name + ", 性别" + "女"
				+ ", 年龄" + age + "]";
		}else
			return "[编号" + number + ", 名字" + name + ", 性别" + "男"
					+ ", 年龄" + age + "]";
	}
```
3. 使用super调用父类中的构造方法
```
//	使用super调用父类中的构造方法
	public Student(int number, String name, Boolean sex, int age) {
		super(number, name, sex, age);
	}
```
4. 实现一门课程只由一门老师教授
```
//实现一门课程只由一门老师教授
	@Override
	public String toString() {
		if(tea.getName()==c.getTeacher()){
			return "学生："+super.toString()+"\n所选课程" +c+"\n教师信息"+tea;
		}else
			return "学生："+super.toString()+"\n所选课程" +c;		
	}
	public String show(){
		return "学生："+super.toString();
		 
	}
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
6. 设置和获取对象成员值
```
public int getCnumber() {
		return cnumber;
	}
	public void setCnumber(int cnumber) {
		this.cnumber = cnumber;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
```
6. 变量赋值
```
//		为变量赋值
//		s1.setCourse(c2);
		s1.setCourse(c1);
		t1.setCourse(c1);
		s1.setTea(t1);
```
7. 调用方法
```
//		判断学生是否选课
		if(s1.getC().getCnumber()==0){
			System.out.println(s1.show()+"\n该学生已经退课");
		}else
			System.out.println(s1.toString());
```
# 五、实验结果
1. 学生选课成功，并且课程中老师信息与所给老师信息相等时（一门课程只由一门老师教授），输出结果

![RUNOOB 图标](https://p.qlogo.cn/qqmail_head/ajNVdqHZLLCjXzl2bwPUPHEQOOzARqLRmZFqzPgyAkzdweOBibC68M8Sof8atNPjFjb2wpZzEibR0/0)

2. 学生选课成功，并且课程中老师信息与所给老师信息不相等时（一门课程只由一门老师教授），输出结果

![RUNOOB 图标](https://p.qlogo.cn/qqmail_head/ajNVdqHZLLCjXzl2bwPUPHEQOOzARqLRmZFqzPgyAkxxj7ugl4HFaGiaYWicV4yplW9ky95b9BPns/0)

3. 学生退课成功时，输出结果，只输出学生信息

![RUNOOB 图标](https://p.qlogo.cn/qqmail_head/ajNVdqHZLLCjXzl2bwPUPHEQOOzARqLRmZFqzPgyAkxkiaN2uoskv5iavEaia1oQicokVAG3ET75cOM/0)


# 六、实验感想
通过本次实验所写的程序代码，通过动手编程实现，观察输出结果，了解系统中的实体及其关系，学会定义类中的属性以及方法，掌握面向对象的类设计方法（属性、方法）。 学会使用类的继承用法，通过构造方法实例化对象，学会使用super()，用于实例化子类，调用父类中的构造方法，学会使用Object根类的toString（）方法,应用在相关对象的信息输出中。
