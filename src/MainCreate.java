import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreate {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Professor.class).
				addAnnotatedClass(Customer.class).
				buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Professor professor = new Professor("C123", "Computer Science");

			Customer customer = new Customer("admin","123 Holywoord");


			professor.setCustomer(customer);
			session.save(customer);
			session.save(professor);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
		System.out.println("Adding customer....");


	}

}
