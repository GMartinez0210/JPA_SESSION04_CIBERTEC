package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {
	// realizar un registro de un nuevo usuario
	
	// obtener la conexion -> DAO
	static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
	static EntityManager em = fabrica.createEntityManager();
	
	public static void main(String[] args) {
		Usuario u = new Usuario();
		u.setCod_usua(1);
		u.setNom_usua("Pancho");
		u.setApe_usua("Pistola");
		u.setUsr_usua("panchito");
		u.setCla_usua("choripan");
		u.setFna_usua("2000/05/13");
		u.setIdtipo(3);
		u.setEst_usua(1);
		// si el proceso es: registrar, actualizar o eliminar
		em.getTransaction().begin();
		// insert into ..... values ......
		em.persist(u);
		// confirma
		em.getTransaction().commit();
		System.out.println("Registrado...");
		
	}
}
