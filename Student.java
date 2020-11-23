package com.bipt.lx.cn;

public class Student {
	private String name;
	private int number;
	private boolean sex;
	private int age;
	private String major;
	public Student(String name, int number, boolean sex, int age, String major) {
		super();
		this.name = name;
		this.number = number;
		this.sex = sex;
		this.age = age;
		this.major = major;
	}
	public Student() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String toString() {
		if(sex==true){
			return "学生\n  姓名：" + name + "\n 学号：" + number + "\n 性别：" + "女"
				+ "\n 年龄：" + age + "\n 专业：" + major + "\n";
		}else{
			return "学生\n  姓名：" + name + "\n 学号：" + number + "\n 性别：" + "男"
					+ "\n 年龄：" + age + "\n 专业：" + major + "\n";
		}
	}
	
}
