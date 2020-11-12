package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Regalo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario regalador;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario beneficiario;
	@ManyToOne
	@JoinColumn(nullable = false)
	private CajaDeRegalo cajaDeRegalo;
	@ManyToOne
	@JoinColumn(nullable = true)
	private Experiencia experiencia;
	@Column(columnDefinition = "boolean default false")
	private Boolean canjeado = false;
		
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getRegalador() {
		return regalador;
	}
	public void setRegalador(Usuario regalador) {
		this.regalador = regalador;
	}
	public Usuario getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(Usuario beneficiario) {
		this.beneficiario = beneficiario;
	}
	public CajaDeRegalo getCajaDeRegalo() {
		return cajaDeRegalo;
	}
	public void setCajaDeRegalo(CajaDeRegalo cajaDeRegalo) {
		this.cajaDeRegalo = cajaDeRegalo;
	}
	public Experiencia getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}
	public Boolean getCanjeado() {
		return canjeado;
	}
	public void setCanjeado(Boolean canjeado) {
		this.canjeado = canjeado;
	}
}
