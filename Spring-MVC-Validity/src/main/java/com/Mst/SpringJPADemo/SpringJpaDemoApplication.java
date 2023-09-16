package com.Mst.SpringJPADemo;

import com.Mst.SpringJPADemo.dao.StudentDAO;
import com.Mst.SpringJPADemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;


@SpringBootApplication
public class SpringJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

		@Bean
		public CommandLineRunner cmdRunner (StudentDAO stuDao){
			return runner -> {
				//createStudent(stuDao);
				createMultipleStudents(stuDao);
				//readStudent(stuDao);
				//findAll(stuDao);
				//findByLastName(stuDao);
				//updateStudent(stuDao);
				//deleteStudent(stuDao);
				//deleteStudentsAll(stuDao);
			};
		}

	private void deleteStudentsAll(StudentDAO stuDao) {
		System.out.println("All the students are deleted!");
		int noOfRows=stuDao.deleteAll();
		System.out.println("Number of students deleted are: "+noOfRows);

	}

	private void deleteStudent(StudentDAO stuDao) {
		int studentId=2;
		stuDao.delete(studentId);
	}

	private void updateStudent(StudentDAO stuDao) {
		int studentId=1;
		System.out.println("Going to update the ID no: "+studentId);
		Student stu=stuDao.read(studentId);
		stu.setLastName("B.E. ");
		System.out.println(stu);
		stuDao.update(stu);

	}

	private void findByLastName(StudentDAO stuDao) {
		List<Student> newList=stuDao.findByLastName("Appa");
		for(Student stu:newList){
			System.out.println(stu);

		}
	}

	private void findAll(StudentDAO stuDao) {
		List<Student> stuList=stuDao.findAll();
		for(Student stu:stuList){
			System.out.println(stu);
		}
	}

	private void readStudent(StudentDAO stuDao) {
		Student s=stuDao.read(1);
		System.out.println(s);

	}

	private void createMultipleStudents(StudentDAO stuDao) {
		System.out.println("Creating Multiple Students.....");
		Student s1=new Student("Selvam","Appa","family@life.com");
		Student s2=new Student("Logambal","Amma","family@life.com");
		Student s3=new Student("Nathiya","Thangachi","family@life.com");
		stuDao.save(s1);
		stuDao.save(s2);
		stuDao.save(s3);
		System.out.println("Created Multiple Students!");

	}

	private void createStudent(StudentDAO stuDao) {

		System.out.println("Creating a new Student:");
		Student tempStudent=new Student("Thulasimani","SLN","mstofficial19@gmail.com");
		stuDao.save(tempStudent);
		System.out.println("Created Student ID: "+tempStudent.getId());
	}
}
