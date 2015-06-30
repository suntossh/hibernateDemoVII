package com.suntossh.data;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.suntossh.data.entities.TimeTest;
import com.suntossh.data.entities.User;

public class Application {

	public static void main_forTemporal(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();
		
		TimeTest test =  new TimeTest(new Date());
		
		
		session.save(test);	
		session.getTransaction().commit();
		System.out.println(test.toString());
		
		session.refresh(test);
		
		System.out.println(test.toString());
		session.close();
	}

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();


		Transaction transaction = session.beginTransaction();

		User user = new User();
			user.setBirthDate(getMyBirthDate());
			user.setCity("Jersey City");
			user.setCreatedBy("Santoshkumar");
			user.setCreatedDate(new Date());
			user.setEmailAddress("Suntossh.numerouno@gmail.com");
			user.setFirstName("Santosh");
			user.setLastName("Pandey");
			user.setLastUpdatedBy("Santosh");
			user.setLastUpdatedDate(new Date());
			user.setState("NJ");
			user.setUserAddressLine1("400 Vanilla Avnue");
			user.setUserAddressLine2("Grove St 6th Street");
			user.setZipCode("07306");
		
		session.save(user);	
		
		System.out.println(user.getAge());
		
		session.refresh(user);
		System.out.println(user.getAge());
		transaction.commit();
		
			
		session.close();
	}

	public static Date getMyBirthDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR,1984);
		calendar.set(Calendar.MONTH,6);
		calendar.set(Calendar.DATE,22);
		return calendar.getTime();
		
	}
}
