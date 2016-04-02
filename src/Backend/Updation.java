package Backend;

import java.io.Serializable;

public class Updation implements Serializable {
String sno;
int age;
String name,father,sex,cnic,addr,cell,dob;

public Updation()
{
	}
public Updation(int age, String name, String father, String sex,
		String cnic, String addr, String cell, String dob) {
	super();
	this.sno = sno;
	this.age = age;
	this.name = name;
	this.father = father;
	this.sex = sex;
	this.cnic = cnic;
	this.addr = addr;
	this.cell = cell;
	this.dob = dob;
}
public String getSno() {
	return sno;
}
public void setSno(String sno) {
	this.sno = sno;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getFather() {
	return father;
}
public void setFather(String father) {
	this.father = father;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getCnic() {
	return cnic;
}
public void setCnic(String cnic) {
	this.cnic = cnic;
}
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
public String getCell() {
	return cell;
}
public void setCell(String cell) {
	this.cell = cell;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}

}
