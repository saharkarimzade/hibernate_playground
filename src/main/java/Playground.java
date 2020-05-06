import entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Playground
{
    public static void main(String[]args)
    {


        Book book = new Book();

		book.setTitle("Java Programming");
		//book.setId(1);
		book.setDetails("Mostafa");   /// transient

        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();

        Transaction tx= session.beginTransaction();

        session.save(book);
        tx.commit();

        tx.begin();
        Book book1 = session.get(Book.class,1);
        System.out.println("before" + book1.getTitle());
        book1.setTitle("java is good");
        session.update(book1);
        tx.commit();
        System.out.println("after" + book1.getTitle());
        session.close();

    }
}
