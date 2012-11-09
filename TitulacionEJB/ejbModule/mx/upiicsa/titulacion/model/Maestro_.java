package mx.upiicsa.titulacion.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2012-11-05T23:33:37.907-0600")
@StaticMetamodel(Maestro.class)
public class Maestro_ {
	public static volatile SingularAttribute<Maestro, Integer> IdMaestro;
	public static volatile SingularAttribute<Maestro, String> aPaterno;
	public static volatile SingularAttribute<Maestro, String> aMaterno;
	public static volatile SingularAttribute<Maestro, String> nombre;
	public static volatile SingularAttribute<Maestro, String> Titulo;
	public static volatile SingularAttribute<Maestro, Date> AnioIngreso;
	public static volatile SingularAttribute<Maestro, Academia> academia;
	public static volatile SingularAttribute<Maestro, String> Abreviatura;
}
