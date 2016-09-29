/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av1.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author rafae
 */
@Entity
@SequenceGenerator(name="endereco_seq", sequenceName="endereco_seq", 
        allocationSize= 1, initialValue = 1)
public class Endereco implements Serializable{
    @Id    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_seq")
    private long id;
    
    @Column(nullable=false, length=100)
    @NotEmpty(message = "O Campo é Obrigatório.")
    private String logradouro;
    
    @Column(nullable=false, length=50)
    @NotEmpty(message = "O Campo é Obrigatório.")
    private String numero;
    
    @Column(nullable=false, length=100)
    @NotEmpty(message = "O Campo é Obrigatório.")
    private String bairro;
    
    @Column(nullable=true, length=50)
    private String complemento;
    
    @Column(nullable=false, length=200)
    @NotEmpty(message = "O Campo é Obrigatório.")
    private String municipio;
    
    @Column(nullable=false, length=8)
    @NotEmpty(message = "O Campo é Obrigatório.")
    private String cep;
    
    @Column(nullable=false, length=8)
    @NotEmpty(message = "O Campo é Obrigatório.")
    private String uf;
//    @MapsId
//    @OneToOne
//    @JoinColumn(name="id")    
//    private Fornecedor fornecedor;
    @OneToOne(mappedBy = "endereco")
    private Fornecedor fornecedor;
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
}
