package av1.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;


@Entity
@SequenceGenerator(name="cliente_seq", sequenceName="cliente_seq", 
        allocationSize= 1, initialValue = 1)
public class Cliente implements Serializable {
    @Id    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    private long clienteId;
    
    @Size(min = 3, message = "O nome deve ter pelo menos 3 carateres.")
    private String nome;    
    
    private String CPF;    
    
    private String endereco;    
    
    private String telefone;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(long id, String nome, String CPF, String endereco, String telfone) {
        this.clienteId = id;
        this.nome = nome;
        this.CPF = CPF;
        this.endereco = endereco;
        this.telefone = telfone;
    }

    public long getId() {
        return clienteId;
    }

    public void setId(long id) {
        this.clienteId = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telfone) {
        this.telefone = telfone;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
