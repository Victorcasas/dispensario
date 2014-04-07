package org.onedreamcsc;

import java.util.ArrayList;
import java.util.List;


public class DispensarioAction
{
	private List<String> selectList=new ArrayList<String>();
	private long stock=0;
	private Variedad variedad;
	
	public Variedad getVariedad() {
		return variedad;
	}

	public void setVariedad(Variedad variedad) {
		this.variedad = variedad;
	}

	private SocioDAO socioDao=new SocioDAO();
	private VariedadDAO variedadDAO=new VariedadDAO();
	public SocioDAO getSocioDao() {
		return socioDao;
	}

	public void setSocioDao(SocioDAO socioDao) {
		this.socioDao = socioDao;
	}

	public VariedadDAO getVariedadDAO() {
		return variedadDAO;
	}

	public void setVariedadDAO(VariedadDAO variedadDAO) {
		this.variedadDAO = variedadDAO;
	}

	private List<Variedad> variedades=variedadDAO.list();
	
	public String inicio(){
		dispensario();
		return "success";
	}
		
	public void dispensario(){
		for (Variedad variedad:getVariedades()) {
			selectList.add(variedad.getVariedadNombre());
		}
	}
	
	public String alta() {
		dispensario();
		Socio socio = new Socio();
		socio.setNombre(nombre);
		socio.setNumero(numero);
		socioDao.save(socio);
		return "success";
	}
	
	public String crear() {
		dispensario();
		setVariedad(new Variedad());
		long inicial = Long.parseLong(aporte);
		variedad.setVariedadNombre(codigo);
		variedad.setVariedadCantidad(inicial);
		setStock(inicial);
		variedadDAO.save(variedad);
		return "success";
	}
		
	public String retirar() {
		dispensario();
		setVariedad(variedadDAO.load(codigo));
		long l = Long.parseLong(retirada);
		if (variedad.getVariedadCantidad()-l>=0) { 
			variedad.setVariedadCantidad(variedad.getVariedadCantidad()-l);
			setStock(variedad.getVariedadCantidad());
			variedadDAO.save(variedad);
		}
		return "success";
	}
	
	public String aportar() {
		dispensario();
		setVariedad(variedadDAO.load(codigo));	
		long l = Long.parseLong(aporte);
		getVariedad().setVariedadCantidad(variedad.getVariedadCantidad()+l);
		setStock(getVariedad().getVariedadCantidad());
		variedadDAO.save(variedad);	
		return "success";
	}
	
	public String listar() {
		dispensario();
		setVariedades(variedadDAO.list());
		return "success";
	}
		
	public String getRetirada() {
		return retirada;
	}

	public void setRetirada(String retirada) {
		this.retirada = retirada;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAporte() {
		return aporte;
	}

	public void setAporte(String aporte) {
		this.aporte = aporte;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public List<Variedad> getVariedades() {
		return variedades;
	}

	public void setVariedades(List<Variedad> variedades) {
		this.variedades = variedades;
	}

	public List<String> getSelectList() {
		return selectList;
	}

	public void setSelectList(List<String> selectList) {
		this.selectList = selectList;
	}

	private String codigo;
	private String aporte;
	private String retirada;
	private int numero;
	private String nombre;
		
}

