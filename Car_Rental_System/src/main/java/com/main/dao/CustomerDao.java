package com.main.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.main.dto.Customer;

public class CustomerDao {
	public static void addCustomer() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Customer c = new Customer();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Customer Name : ");
		String name = sc.next();
		c.setName(name);
		
		System.out.print("Enter Email Id : ");
		String email = sc.next();
		c.setEmailId(email);
		
		et.begin();
		em.persist(c);
		et.commit();
		System.out.println("The Customer is inserted Successfully");
	}
	public static void allocateCarToCoustomer(LocalDate registerDate, LocalDate returnDate) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc = new Scanner(System.in);
		String jpql ="Update Customer c Set c.car.carId =?1,c.registerDate=?2, c.returnDate =?3  where c.cid=?4";
		Query q= em.createQuery(jpql);
		System.out.print("Enter Car Id : ");
		int carId =sc.nextInt();
		q.setParameter(1, carId);
		q.setParameter(2, registerDate);
		q.setParameter(3, returnDate);
		System.out.print("Enter customer Id : ");
		int cid = sc.nextInt();
		q.setParameter(4, cid);
		
		et.begin();
		int count=q.executeUpdate();
		et.commit();
		System.out.println(count+" is updated");
		
	}
	public static void getCustomerById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Customer c=em.find(Customer.class, id);
		System.out.println(c.getCid()+"  "+c.getName()+"  "+c.getCar().getModel()+"  "+c.getCar().getPrice()+"  "+c.getRegisterDate());
	}
	
	public static void getAllCustomer() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String jpql = "Select c from Customer c ";
		Query q = em.createQuery(jpql);
		List<Customer> li=q.getResultList();
		li.forEach(al -> System.out.println(al.getCid()+"  "+al.getName()+"  "+al.getCar().getModel()+"  "+al.getCar().getPrice()+"  "+al.getRegisterDate()));
	}
	
}
