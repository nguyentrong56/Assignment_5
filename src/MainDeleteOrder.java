import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDeleteOrder {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Order.class).
				addAnnotatedClass(Product.class).

				buildSessionFactory();



		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			Order order = new Order();
			order.setId(1);
			session.delete(order);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
			factory.close();
		}
		System.out.println("Deleting order");
	}

}
