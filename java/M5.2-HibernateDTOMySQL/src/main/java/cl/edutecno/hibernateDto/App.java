package cl.edutecno.hibernateDto;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cl.edutecno.hibernateDto.modelEntidad.Curso;
import cl.edutecno.hibernateDto.util.HibernateUtil;
/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		//hibernate.cfg.xml
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();// obtenemos la session de HibernateUtil
		session.beginTransaction();// realizamos la transaccion con la base de datos

		Curso curso = new Curso();// instancia del objeto a mapear
	
		curso.setDescripcion("Spring");// seteo de datos mediante los setters
		curso.setPrecio(2000);
		
		saveCurso(curso, session);//guardando curso
		
		System.out.println(findAllCursos(session));//buscando todos los cursos e imprimiendo
		
		session.getTransaction().commit();//se realiza un commit a la base de datos
	}
	//metodo  para guardar un curso
	public static void saveCurso(Curso curso, Session session) {
		session.save(curso); //realiza un INSERT INTO CURSO
	}
	//metodo para consultar los cursos
	public static List<Curso> findAllCursos(Session session) {
		Query query = session.createQuery("from Curso");//SELECT * FROM CURSO
		List<Curso> list = query.list();
		return list;
	}
}
