package net.eldiosantos.viajabessa.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Eldius on 10/02/2015.
 */
public class Pacote implements Serializable {
    private Long id;
    private String titulo;

    private String descricao;

    private BigDecimal valor;

    public Long getId() {
        return id;
    }

    public Pacote setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public Pacote setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Pacote setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Pacote setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }
}
