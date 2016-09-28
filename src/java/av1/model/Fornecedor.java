/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av1.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

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
    
    @Column(nullable=false, length=18)
    @NotEmpty(message = "O Campo é Obrigatório.")
    private String CNPJ;
    
    @Column(nullable=false, length=200)
    @NotEmpty(message = "O Campo é Obrigatório.")
    private String razaoSocial;
    
    @Column(length=11)
    private String inscricaoMunicipal;
    
    @NotNull(message = "O Campo é Obrigatório.")
    @Min(0) @Max(10000000)
    private String receitaBruta;

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private Endereco endereco;
    
//    @OneToMany(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
//    @JoinColumn(name="FORNECEDOR_ID")
//    @Column(nullable=true)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedor")
    private List<Processo> processos;
    
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
