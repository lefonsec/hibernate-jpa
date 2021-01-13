package leo.entity.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Singleton {
	private static Singleton instancia;
	private static EntityManagerFactory emf;
	private Singleton(){}
	
	
	public static Singleton getInstance() {
		if(instancia == null) {
			instancia = new Singleton();
		}
		return instancia;
	}
	public static EntityManagerFactory getEntityManagerFactory() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("biblioPu");
		}
		return emf;
	}
	public void closeFactory(){
		if(emf != null) {
			emf.close();
		}
		emf = null;
	
	}
}
