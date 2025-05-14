package com.main.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.main.dto.Engine;

public class EngineDao {
	public static void addEngine() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Engine e = new Engine();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter cc : ");
		double cc= sc.nextDouble();
		e.setCc(cc);
		System.out.print("Enter Fuel type : ");
		String type= sc.next();
		e.setType(type);
		
		et.begin();
		em.persist(e);
		et.commit();
	}
	
	public static void findEngineById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Engine e =em.find(Engine.class, id);
		System.out.println(e.getEngineId()+"  "+e.getCc()+"  "+e.getType());
	}
	
	public static void removeEngineById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Engine e =em.find(Engine.class, id);
		em.remove(e);
		System.out.println("Engine is successfully deleted");
	}
}
