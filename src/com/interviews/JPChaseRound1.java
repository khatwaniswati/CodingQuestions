package com.interviews;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class JPChaseRound1 {

	public static void main(String[] args) {
		List<Student> lst = new ArrayList<>();
		Student s1 = new Student("A",500);
		Student s2 = new Student("B",700);
		Student s3 = new Student("C",300);
		Student s4 = new Student("D",400);
		lst.add(s1);lst.add(s2);lst.add(s3);lst.add(s4);
		
		Comparator<Student> com = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getMarks() - o2.getMarks();
			}
			
		};
		
		lst.stream()
			.sorted(com)
			.map(s->s.getName())
			.limit(2)
			.forEach(System.out::println);
	}

}
