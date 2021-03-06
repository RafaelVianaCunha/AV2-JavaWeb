/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package av1.model;


import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author rafae
 */

@Entity
@Table(name="processo")
@SequenceGenerator(name="PROCESSO_SEQ", sequenceName="PROCESSO_SEQ", allocationSize=1, initialValue=0)
public class Processo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROCESSO_SEQ")
    private long id;
    
    @Column(nullable=false, length=1000)
    @NotEmpty(message = "O Campo é Obrigatório.")
    @NotNull(message = "O Campo é Obrigatório.")
    private String relatorioFiscalizacao;
	
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date dateRelatorio;
	
    @Column(nullable=false, length=100)
    @NotEmpty(message = "O Campo é Obrigatório.")
    @NotNull(message = "O Campo é Obrigatório.")
    private String fiscalResponsavel;

    @ManyToOne(cascade=CascadeType.DETACH)
    private Fornecedor fornecedor;

    private String numeroProcesso;
    
    private String idFornecedor;

    public long getId() {
            return id;
    }

    public void setId(long id) {
            this.id = id;
    }

    public String getRelatorioFiscalizacao() {
            return relatorioFiscalizacao;
    }

    public void setRelatorioFiscalizacao(String relatorioFiscalizacao) {
            this.relatorioFiscalizacao = relatorioFiscalizacao;
    }

    public Date getDateRelatorio() {
            return dateRelatorio;
    }

    public void setDateRelatorio(Date dateRelatorio) {
            this.dateRelatorio = dateRelatorio;
//            DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
//            this.dateRelatorio = (Date)formatter.parse(dateRelatorio);
    }

    public String getFiscalResponsavel() {
            return fiscalResponsavel;
    }

    public void setFiscalResponsavel(String fiscalResponsavel) {
            this.fiscalResponsavel = fiscalResponsavel;
    }

    public Fornecedor getFornecedor() {
            return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
            this.fornecedor = fornecedor;
    }

      public String getIdFornecedor() {
            return idFornecedor;
    }

    public void setIdFornecedor(String id_fornecedor) {
            this.idFornecedor = id_fornecedor;
    }   
        
        
    public String getNumeroProcesso() {
            return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
            this.numeroProcesso = numeroProcesso;
    }
     
    public void gerarNumeroProcesso(){
        
            Calendar calendario = Calendar.getInstance();
            this.numeroProcesso = calendario.get(Calendar.YEAR) + "" + calendario.get(Calendar.MONTH + 1) + 
                    "" + calendario.get(Calendar.DATE) + "" + calendario.get(Calendar.HOUR_OF_DAY) + "" + 
                    calendario.get(Calendar.MINUTE) + "" + calendario.get(Calendar.SECOND) + "" + this.fornecedor.getCNPJ();
            
            this.numeroProcesso = this.numeroProcesso.replaceAll("[^a-zZ-Z1-9 ]", "");
                
    }

    
}
