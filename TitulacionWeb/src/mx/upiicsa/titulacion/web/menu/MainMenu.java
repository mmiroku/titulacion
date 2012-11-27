package mx.upiicsa.titulacion.web.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import mx.upiicsa.titulacion.util.WConstants;

@ApplicationScoped
public class MainMenu extends MenuElemento {

	@PostConstruct
	public void init() {
		Map<String, String> propiedades = null;
		
		propiedades = new HashMap<String, String>();
		propiedades.put(WConstants.PERFIL_ADMIN, WConstants.PERFIL_ADMIN);
		propiedades.put(WConstants.PERFIL_TITULACION, WConstants.PERFIL_TITULACION);
		propiedades.put(WConstants.PERFIL_SEMINARIOS, WConstants.PERFIL_SEMINARIOS);
		agregarSubMenu(new MenuElemento("alumnos","#{cAlumno.init()}",propiedades));
		
		propiedades = new HashMap<String, String>();
		propiedades.put(WConstants.PERFIL_ADMIN, WConstants.PERFIL_ADMIN);
		propiedades.put(WConstants.PERFIL_TITULACION, WConstants.PERFIL_TITULACION);
		propiedades.put(WConstants.PERFIL_SEMINARIOS, WConstants.PERFIL_SEMINARIOS);
		agregarSubMenu(new MenuElemento("maestros","#{cMaestro.init()}",propiedades));
		
		propiedades = new HashMap<String, String>();
		propiedades.put(WConstants.PERFIL_ADMIN, WConstants.PERFIL_ADMIN);
		propiedades.put(WConstants.PERFIL_TITULACION, WConstants.PERFIL_TITULACION);
		agregarSubMenu(new MenuElemento("materias","#{cMateria.init()}",propiedades));
		
		propiedades = new HashMap<String, String>();
		propiedades.put(WConstants.PERFIL_ADMIN, WConstants.PERFIL_ADMIN);
		propiedades.put(WConstants.PERFIL_SEMINARIOS, WConstants.PERFIL_SEMINARIOS);
		agregarSubMenu(new MenuElemento("seminarios","#{cSeminario.init()}",propiedades));
		
		propiedades = new HashMap<String, String>();
		propiedades.put(WConstants.PERFIL_ADMIN, WConstants.PERFIL_ADMIN);
		agregarSubMenu(new MenuElemento("usuarios","#{cUsuario.init()}",propiedades));
		
		propiedades = new HashMap<String, String>();
		propiedades.put(WConstants.PERFIL_ADMIN, WConstants.PERFIL_ADMIN);
		propiedades.put(WConstants.PERFIL_TITULACION, WConstants.PERFIL_TITULACION);
		agregarSubMenu(new MenuElemento("cedulas","#{cCedula.init()}",propiedades));
		
		propiedades = new HashMap<String, String>();
		propiedades.put(WConstants.PERFIL_ADMIN, WConstants.PERFIL_ADMIN);
		propiedades.put(WConstants.PERFIL_SEMINARIOS, WConstants.PERFIL_SEMINARIOS);
		agregarSubMenu(new MenuElemento("catSeminarios","#{cCatSeminario.init()}",propiedades));
		
		propiedades = new HashMap<String, String>();
		propiedades.put(WConstants.PERFIL_ADMIN, WConstants.PERFIL_ADMIN);
		propiedades.put(WConstants.PERFIL_TITULACION, WConstants.PERFIL_TITULACION);
		agregarSubMenu(new MenuElemento("catLineas","#{cCatLinea.init()}",propiedades));
		
		propiedades = new HashMap<String, String>();
		propiedades.put(WConstants.PERFIL_ADMIN, WConstants.PERFIL_ADMIN);
		propiedades.put(WConstants.PERFIL_TITULACION, WConstants.PERFIL_TITULACION);
		agregarSubMenu(new MenuElemento("expedientes","#{cExpediente.init()}",propiedades));
		
		propiedades = new HashMap<String, String>();
		propiedades.put(WConstants.PERFIL_ADMIN, WConstants.PERFIL_ADMIN);
		propiedades.put(WConstants.PERFIL_TITULACION, WConstants.PERFIL_TITULACION);
		agregarSubMenu(new MenuElemento("Linea","#{cAlumnoLinea.init()}",propiedades));
		
		propiedades = new HashMap<String, String>();
		propiedades.put(WConstants.PERFIL_ADMIN, WConstants.PERFIL_ADMIN);
		propiedades.put(WConstants.PERFIL_TITULACION, WConstants.PERFIL_TITULACION);
		agregarSubMenu(new MenuElemento("Calificaciones","#{cAlumnoMateria.init()}",propiedades));
		
	}
	
	public List<MenuElemento> getMenu() {
		return getSubMenu();
	}
}
