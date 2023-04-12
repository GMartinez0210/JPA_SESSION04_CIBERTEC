package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Productos;
import model.Usuario;

public class Demo07 {
	// realizar un listado de los usuarios
	
	// obtener la conexion -> DAO
	static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
	static EntityManager em = fabrica.createEntityManager();
	
	public static void main(String[] args) {
		
		// select * from tb_xxxx ---> obj List
		List<Productos> lstProductos = 
		em.createQuery("select p from Productos p",Productos.class).getResultList();
		
		for (Productos p : lstProductos) {
			System.out.println("Código...: " + p.getId_prod());
			System.out.println("Nombre...: " + p.getDes_prod());
			System.out.println("Stock....: " + p.getStk_prod());
			System.out.println("Precio...: " + p.getPre_prod());
			System.out.println("Categoría: " + p.getObjCategoria().getDescripcion());
			System.out.println("Proveedor: " + p.getObjProveedor().getNombre_rs());
			System.out.println("------------------------------");
		}
		
	}
}
