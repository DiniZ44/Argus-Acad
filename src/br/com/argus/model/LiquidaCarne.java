/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author santo
 */

@Entity
@Table(name = "liquida_carne")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = LiquidaCarne.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class LiquidaCarne extends Entidade{
    
    public static final long serialVersionUID = 1L;
    protected static final String SEQUENCE_ENTIDADE = "liquidaCarne_sequence";
    
    @Column(nullable = true)
    private boolean pago;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Carne_Pagamento carne_Pagamento;

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public Carne_Pagamento getCarne_Pagamento() {
        return carne_Pagamento;
    }

    public void setCarne_Pagamento(Carne_Pagamento carne_Pagamento) {
        this.carne_Pagamento = carne_Pagamento;
    }
    
    
}
