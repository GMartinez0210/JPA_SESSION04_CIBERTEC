package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo06 {
	// realizar un listado de los usuarios
	
	// obtener la conexion -> DAO
	static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
	static EntityManager em = fabrica.createEntityManager();
	
	public static void main(String[] args) {
		
		// select * from tb_xxxx ---> obj List
		
		List<Usuario> lstUsuarios = 
		em.createQuery("select u from Usuario u",Usuario.class).getResultList();
		
		for (Usuario x : lstUsuarios) {
			System.out.println("Código...: " + x.getCod_usua());
			System.out.println("Nombre...: " + x.getNom_usua());
			System.out.println("Apellido.: " + x.getApe_usua());
			System.out.println("Tipo.....: " + x.getIdtipo());
			System.out.println(" " + x.getObjtipo().getDescripcion());
			System.out.println("------------------------------");
		}
		
	}
}
