import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateProduct {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Product.class).
				addAnnotatedClass(Order.class).
				buildSessionFactory();



		Session session = factory.getCurrentSession();
		try {

			session.beginTransaction();

			Product product = new Product("book");
			session.save(product);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();

		}
		System.out.println("Adding product");
	}
}



