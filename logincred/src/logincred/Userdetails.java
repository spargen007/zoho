package logincred;
//import java.util.*;
public class Userdetails {
	private String name;
	private int age;
	private String gender;
	private long phone;
	private long aadhar;
	private String city;
	public Userdetails(String name,int age,String gender,long phone,long aadhar,String city) {
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.phone=phone;
		this.aadhar=aadhar;
		this.city=city;
	}
	void setname(String name) {
		this.name=name;
	}
	String getname() {
		return name;
	}
	void setage(int age) {
		this.age=age;
	}
	int getage() {
		return age;
	}
	void setgender(String gender) {
		this.gender=gender;
	}
	String getgender() {
		return gender;
	}
	void setphone(long phone) {
		this.phone=phone;
	}
	long getphone() {
		return phone;
	}
	void setaadhar(long aadhar) {
		this.aadhar=aadhar;
	}
	long getaadhar() {
		return aadhar;
	}
	void setcity(String city) {
		this.city=city;
	}
	String getcity() {
		return city;
	}
}
