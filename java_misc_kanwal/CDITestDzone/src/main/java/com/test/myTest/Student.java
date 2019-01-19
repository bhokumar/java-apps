package com.test.myTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Student {
	private int stId;
	private String stName;
	public int getStId() {
		return stId;
	}
	public void setStId(int stId) {
		this.stId = stId;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public Student(int stId, String stName) {
		super();
		this.stId = stId;
		this.stName = stName;
	}

	
	@Override
	public String toString() {
		return "Student [stId=" + stId + ", stName=" + stName + "]";
	}
	public static void main(String[] args) {
		
		final List<Student> stList = new ArrayList<Student>();
		stList.add(new Student(2, "Kanwal"));
		stList.add(new Student(5, "Manisha"));
		stList.add(new Student(1, "Bhuppi"));
		stList.add(new Student(8, "Daman"));
		stList.forEach(System.out::println);
		System.out.println("After-----------------------------------------------");
		Collections.sort(stList, (o1, o2) -> {return o1.getStId()>o2.getStId()?1:-1;});
		stList.forEach(System.out::println);
		
	}
	
}
