/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av1.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

/**
 *
 * @author rafae
 */

@Entity
@SequenceGenerator(name="fornecedor_seq", sequenceName="fornecedor_seq", 
        allocationSize= 1, initialValue = 1)
public class Fornecedor {
    @Id    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fornecedor_seq")
    private long id;
    private String CNPJ;           
    private String razaoSocial;     
    private String inscricaoMunicipal;
    private String receitaBruta;
//    @OneToOne
//    @PrimaryKeyJoinColumn
//    private Endereco endereco;
        @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private Endereco endereco;
    
    public long getId() {
            return id;
    }
    public void setId(long fornecedorId) {
            this.id = fornecedorId;
    }
    public String getCNPJ() {
            return CNPJ;
    }
    public void setCNPJ(String cNPJ) {
            CNPJ = cNPJ;
    }
    public String getRazaoSocial() {
            return razaoSocial;
    }
    public void setRazaoSocial(String razaoSocial) {
            this.razaoSocial = razaoSocial;
    }
    public String getInscricaoMunicipal() {
            return inscricaoMunicipal;
    }
    public void setInscricaoMunicipal(String inscricaoMunicipal) {
            this.inscricaoMunicipal = inscricaoMunicipal;
    }
    public String getReceitaBruta() {
            return receitaBruta;
    }
    public void setReceitaBruta(String receitaBruta) {
            this.receitaBruta = receitaBruta;
    }
    public Endereco getEndereco() {
            return endereco;
    }
    public void setEndereco(Endereco endereco) {
            this.endereco = endereco;
    }    
}
