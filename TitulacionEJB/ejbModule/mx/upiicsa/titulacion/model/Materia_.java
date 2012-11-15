package mx.upiicsa.titulacion.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-11-14T19:30:10.732-0600")
@StaticMetamodel(Materia.class)
public class Materia_ {
	public static volatile SingularAttribute<Materia, String> idMateria;
	public static volatile SingularAttribute<Materia, Linea> linea;
	public static volatile SingularAttribute<Materia, String> nombre;
	public static volatile SingularAttribute<Materia, Integer> semestre;
	public static volatile SingularAttribute<Materia, String> descripcion;
	public static volatile SingularAttribute<Materia, Academia> academia;
}
