import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDelete {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Professor.class).
				addAnnotatedClass(Customer.class).
				buildSessionFactory();


		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();



			Professor professor = new Professor();
			professor.setId(1);
			session.delete(professor);

			Customer _customer = new Customer();
			_customer.setId(1);
			session.delete(_customer);
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();

		}
	}
}
