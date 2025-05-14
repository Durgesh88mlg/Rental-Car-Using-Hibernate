package com.main;

import java.time.LocalDate;
import java.util.Scanner;

import com.main.dao.CarDao;
import com.main.dao.CustomerDao;
import com.main.dao.EngineDao;

public class Driver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("CAR RENTAL SYSTEM");
		System.out.println("-------------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println("-----Admin Operations-----");
		System.out.println("1. Insert Car");
		System.out.println("2. Add Engine Data");
		System.out.println("3. Allocate Engine to car");
		System.out.println("4. Display All Available Car");
		System.out.println("5. Get Car By Id");
		System.out.println("6. Remove Car By Id");
		System.out.println("7. Deallocate Engine to car");
		System.out.println("8. Find Engine By Id");
		System.out.println("9. Find Customer By Id");
		System.out.println("10. Display All Customer ");
		System.out.println();
		System.out.println("-----Customer Operation-----");
		System.out.println("11. Add Customer Details");
		System.out.println("12. Take A car On Rent By Providing Date");
		System.out.println();
		System.out.println();
		
		
		System.out.print("Enter a Number :");
		int choice = sc.nextInt();
		switch(choice) {
		case 1: CarDao.insertCar(); break;
		case 2: EngineDao.addEngine(); break;
		case 3: {
					System.out.print("Enter Car Id : ");
					int cid = sc.nextInt();
					System.out.print("Enter Engine Id : ");
					int eid = sc.nextInt();
					CarDao.allocateEngine(cid,eid); break;
		}
		case 4: CarDao.displayAllCar(); break;
		case 5: {
					System.out.print("Enter Car Id : ");
					int id = sc.nextInt();
					CarDao.getCarById(id); break;
				}
		case 6: {
					System.out.print("Enter Car Id : ");
					int id = sc.nextInt();
					CarDao.removeCarById(0); break;
				}
		
		case 7: {
					System.out.print("Enter Car Id : ");
					int id = sc.nextInt();
					CarDao.deallocateEngine(id); break;
				}
		
		case 8: {
					System.out.print("Enter Engine Id : ");
					int id = sc.nextInt();
					EngineDao.findEngineById(id); break;
				}
		case 9: {
					System.out.print("Enter Customer Id : ");
					int id = sc.nextInt();
					CustomerDao.getCustomerById(id); break;
				}
		case 10: CustomerDao.getAllCustomer(); break;
		case 11: CustomerDao.addCustomer(); break;
		case 12: CustomerDao.allocateCarToCoustomer(LocalDate.of(2025, 4, 12),LocalDate.of(2025, 4, 15) ); break;
		default: System.out.println("InvalidChoice");
		}
		
		
	
	}
}
