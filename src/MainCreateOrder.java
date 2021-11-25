import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateOrder {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
		        configure("hibernate.cfg.xml").
		        addAnnotatedClass(Order.class).
		        addAnnotatedClass(Product.class).
		        buildSessionFactory();
	
	
		Session session = factory.getCurrentSession();
		try {
			session = factory.openSession();

			session.beginTransaction();
			Product product = new Product("book");
			session.save(product);
			Order order = new Order(LocalDate.now(), "Trong");
			order.addProductToOrder(product);
			
			session.save(order);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			session.close();
			factory.close();
		}
		System.out.println("Creating Order");
	
	}
	
}
