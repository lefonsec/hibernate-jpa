package leo.principal;

import java.time.LocalDateTime;
import java.time.Month;

import javax.persistence.EntityManager;

import leo.entity.CategoriaLivro;
import leo.entity.Livro;
import leo.entity.Localizacao;
import leo.entity.Usuario;
import leo.entity.singleton.Singleton;

public class Main {

	public static void main(String[] args) {
		EntityManager em = Singleton.getEntityManagerFactory().createEntityManager();
		
		Usuario us1 = new Usuario("Caio", LocalDateTime.now(),LocalDateTime.now(),"caio@gmail.com");
		Usuario us2 = new Usuario("Marcela", LocalDateTime.of(1970, Month.MARCH, 14, 23, 15),LocalDateTime.now(),"marcela@gmail.com");
		Usuario us3 = new Usuario("Pedro", LocalDateTime.now(),LocalDateTime.of(1980, Month.APRIL, 21, 15, 45),"pedro@gmail.com");
		
		
		Localizacao loc1 = new Localizacao("edificio sede", null);
		Localizacao loc2 = new Localizacao("1 andar", loc1);
		Localizacao loc3 = new Localizacao("estante 2", loc2);
		
		
		CategoriaLivro ca1 = new CategoriaLivro("Comedia", null);
		CategoriaLivro ca2 = new CategoriaLivro("ação", ca1);
		CategoriaLivro ca3 = new CategoriaLivro("Terror", ca2);
		CategoriaLivro ca4 = new CategoriaLivro("subComedia",ca1);
		
		Livro lv1 = new Livro("Tropa de elite","AB56123","José",LocalDateTime.now(), loc3, ca2);
		Livro lv2 = new Livro("The walking dead","CB234","Stephin kings",LocalDateTime.of(2020, Month.FEBRUARY, 23, 12, 45), loc1, ca3);
		Livro lv3 = new Livro("It a coisa","KBP2343","Tony",LocalDateTime.now(), loc2, ca3);
		
		
		em.getTransaction().begin();
		//em.persist(us1);
		//em.persist(us2);
		//em.persist(us3);
		
		//em.persist(loc1);
		//em.persist(loc2);
		//em.persist(loc3);
		
//		em.persist(ca1);
//		em.persist(ca2);
//		em.persist(ca3);
//		em.persist(ca4);
		
		em.persist(lv1);
		em.persist(lv2);
		em.persist(lv3);
		
		em.getTransaction().commit();
		
		em.close();
		Singleton.getInstance().closeFactory();

	}

}
