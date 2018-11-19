package com.spring.spring;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBSpringMain {

	private static DAOImp hibernateDaoImp;
	private static AbstractApplicationContext applicationContext;

	public DBSpringMain() {
		applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		applicationContext.registerShutdownHook();
		hibernateDaoImp = (DAOImp) applicationContext.getBean("hibernateDaoImp");
	}

	public static void main(String[] args) {
		new DBSpringMain();

		// TODO Auto-generated method stub
		int choice = 0;
		int id;
		String name;
		String fathername;
		String organization;
		String mobile;
		Person person;

		System.out.println("Menu {Save = 1; Delete = 2; Update = 3; Retrieve = 4}");
		Scanner input = new Scanner(System.in);
		choice = input.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Stuendent ID?");
			id = input.nextInt();
			System.out.println("Stuendent name?");
			name = input.nextLine();
			name = input.nextLine();
			System.out.println("Stuendent fathername?");
			fathername = input.nextLine();
			System.out.println("Stuendent organization?");
			organization = input.nextLine();
			System.out.println("Stuendent mobile?");
			mobile = input.nextLine();
			person = (Person) applicationContext.getBean("person");
			person.setId(id);
			person.setFatherName(fathername);
			person.setMobile(mobile);
			person.setOrganization(organization);
			person.setName(name);
			hibernateDaoImp.savePerson(person);
			System.out.println("Student record added successfully!");
			break;
		case 2:
			System.out.println("Stuendent ID?");
			id = input.nextInt();
			try {
				hibernateDaoImp.delPerson(id);
				System.out.println("Student record deleted successfully!");
			} catch (Exception e) {
				System.out.println("Student with the requested id does not exist");
			}
			break;
		case 3:
			System.out.println("Stuendent ID?");
			id = input.nextInt();
			System.out.println("Stuendent name?");
			name = input.nextLine();
			name = input.nextLine();
			System.out.println("Stuendent fathername?");
			fathername = input.nextLine();
			System.out.println("Stuendent organization?");
			organization = input.nextLine();
			System.out.println("Stuendent mobile?");
			mobile = input.nextLine();
			person = (Person) applicationContext.getBean("person");
			person.setId(id);
			person.setFatherName(fathername);
			person.setMobile(mobile);
			person.setOrganization(organization);
			person.setName(name);
			try {
				hibernateDaoImp.updatePerson(person);
				System.out.println("Student record updated successfully!");
			} catch (Exception e) {
				System.out.println("Student with the requested id does not exist");
			}

			break;
		case 4:
			System.out.println("Stuendent ID?");
			id = input.nextInt();
			Person per = null;
			try {
				per = hibernateDaoImp.getPerson(id);
				System.out.println("id: " + per.getId() + " Name: " + per.getName() + " Fathers Name: "
						+ per.getFatherName() + " Organization: " + per.getOrganization() + " Mobile Number: "
						+ per.getMobile() + "\n");
				System.out.println("Student record retrieved successfully!");
			} catch (Exception e) {
				System.out.println("Student with the requested id does not exist");
			}

			break;
		default:
			System.out.println("Invalid choice");
			input.close();
		}
		applicationContext.close();
	}
}
