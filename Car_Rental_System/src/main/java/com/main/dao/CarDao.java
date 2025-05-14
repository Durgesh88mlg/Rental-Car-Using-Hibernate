package com.main.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.main.dto.Car;

public class CarDao {
	//inserting new car
	public static void insertCar() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Car c = new Car();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Car Company : ");
		String company = sc.next();
		c.setCompany(company);
		System.out.print("Enter Car Model : ");
		String model = sc.next();
		c.setModel(model);
		System.out.print("Enter Price per Day : ");
		double price = sc.nextDouble();
		c.setPrice(price);
		System.out.print("Enter Car Type : ");
		String type = sc.next();
		c.setType(type);
		
		et.begin();
		em.persist(c);
		et.commit();
		
	}
	//Display All Cars
	public static void displayAllCar() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Query q = em.createQuery("Select c from Car c");
		List<Car> carList=q.getResultList();
		carList.forEach(al->System.out.println(al.getCompany()+"  "+al.getModel()+"  "+al.getType()+"  "+al.getPrice()+"  "+al.getEngine().getCc()+"  "+al.getEngine().getType()));
		
	}
	//get car By Id
	public static void getCarById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car car=em.find(Car.class, id);
		System.out.println(car.getCompany()+"  "+car.getModel()+"  "+car.getType()+"  "+car.getPrice()+"  "+car.getEngine().getCc()+"  "+car.getEngine().getType());
	}
	//Delete Car from Table
	public static void removeCarById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car car=em.find(Car.class, id);
		et.begin();
		em.remove(car);
		et.commit();
	}
	public static void allocateEngine(int car_id, int engine_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		String jpql="Update Car c set c.engine.id=:e_id where c.id=:c_id";
		Query q= em.createQuery(jpql);
		q.setParameter("e_id",engine_id);
		q.setParameter("c_id",car_id);
		et.begin();
		int count=q.executeUpdate();
		et.commit();
		System.out.println(count+" record is updated");
	}
	public static void deallocateEngine(int car_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		String jpql="Update Car c set c.engine.id=:e_id where c.id=:c_id";
		Query q= em.createQuery(jpql);
		q.setParameter("e_id", null);
		q.setParameter("c_id", car_id);
		et.begin();
		int count = q.executeUpdate();
		et.commit();
		System.out.println(count+" record is updated");
		
	}
}
