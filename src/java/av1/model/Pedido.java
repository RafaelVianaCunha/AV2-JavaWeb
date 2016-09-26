package av1.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

@Entity
@SequenceGenerator(name="pedido_seq", sequenceName="pedido_seq", 
        allocationSize= 1, initialValue = 1)
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_seq")
    private long pedidoId;    
    
    private String status;    
    
    private Date dataPedido;
    
    //@Size(min = 3, message = "O produto deve ter pelo menos 3 carateres.")
    private String produto;
    
    @ManyToOne
    private Cliente cliente;

    public Pedido() {
    }    
    
    public Pedido(long pedidoId, String status, Date dataPedido, String produto) {
        this.pedidoId = pedidoId;
        this.status = status;
        this.dataPedido = dataPedido;
        this.produto = produto;
    }

    public long getId() {
        return pedidoId;
    }

    public void setId(long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String Produto) {
        this.produto = Produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }    
}
