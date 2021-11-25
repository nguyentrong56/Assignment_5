import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDeleteProduct {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Product.class).
				addAnnotatedClass(Order.class).
				buildSessionFactory();



		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Product product = new Product();
			product.setId(2);
			session.delete(product);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
			factory.close();
		}
		System.out.println(" Deleting product");
	}
}
