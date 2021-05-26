package lab5b;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "des_matricula", length = 50, nullable = false)
    private String matricula;
    @Column(name = "des_formacao", length = 50, nullable = false)
    private String formacao;
    @Column(name = "dta_nascimento", length = 11, nullable = false)
    private String dataNasc;
	
    public Professor() {
	}

	public Professor(Integer id, String matricula, String formacao, String dataNasc) {
		this.id = id;
		this.matricula = matricula;
		this.formacao = formacao;
		this.dataNasc = dataNasc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	@Override
	public String toString() {
		return "Professor [id = " + id + ", matricula = " + matricula 
				+ ", formacao = " + formacao + ", dataNasc = " + dataNasc+ "]";
	}
	
	
    
    
    
    
    
}
