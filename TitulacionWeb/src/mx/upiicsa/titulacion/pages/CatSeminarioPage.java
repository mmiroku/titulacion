package mx.upiicsa.titulacion.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import mx.upiicsa.titulacion.model.CatSeminario;

@Named("pCatSeminario")
@SessionScoped
public class CatSeminarioPage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private CatSeminario catSeminario = new CatSeminario();
	
	private CatSeminario filtro = new CatSeminario(); 
	
	private List<CatSeminario> catSeminarios = new ArrayList<CatSeminario>();
	
	public void setCatSeminario(CatSeminario catSeminario) {
		this.catSeminario = catSeminario;
	}
	
	public CatSeminario getCatSeminario() {
		return catSeminario;
	}
	
	public void setCatSeminarios(List<CatSeminario> catSeminarios) {
		this.catSeminarios = catSeminarios;
	}
	
	public List<CatSeminario> getCatSeminarios() {
		return catSeminarios;
	}
	
	public void setFiltro(CatSeminario filtro) {
		this.filtro = filtro;
	}
	
	public CatSeminario getFiltro() {
		return filtro;
	}
		
}
