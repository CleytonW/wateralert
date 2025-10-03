package com.compesa_abastecimento.wateralert.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity //Indica que esta classe é uma entidade do banco de dados
@Table(name = "usuario") //Nome da tabela no banco de dados
public class Usuario {

    @Id //Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremento
    private Long id;

    @NotBlank(message = "O CEP é obrigatório") //Validação para não permitir valor nulo ou vazio
    @Pattern(regexp = "\\d{8}", message = "O CEP deve ter 8 dígitos") //Validação para o formato só com números (8 dígitos)
    @Column(length = 8, nullable = false) //Define o tamanho máximo da coluna no banco e que não pode ser nula
    private String cep;

    
    @NotBlank(message = "Número WhatsApp é obrigatório")
    @Pattern(regexp = "\\d{10,11}", message = "Número WhatsApp deve ter 10 ou 11 dígitos") //Validação para o formato só com números (10 ou 11 dígitos) Ex: 81999887766
    @Column(length = 11, nullable = false) 
    private String whatsapp;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "ativo", nullable = false)
    private boolean ativo = true; //Por padrão, o usuário é ativo

    // Construtor padrão
    public Usuario() {
    }
    
    // Construtor com parâmetros
    public Usuario(Long id, String cep, String whatsapp) {
        this.id = id;
        this.cep = cep;
        this.whatsapp = whatsapp;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
