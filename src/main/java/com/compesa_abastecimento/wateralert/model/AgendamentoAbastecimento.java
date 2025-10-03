package com.compesa_abastecimento.wateralert.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agendamento_abastecimento")
public class AgendamentoAbastecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 8, nullable = false)
    private String cep;

    @Column(name = "data_abastecimento", nullable = false)
    private LocalDate dataAbastecimento; // Data do abastecimento

    @Column(name = "horario_inicio")
    private LocalTime horarioInicio; // Exemplo: 06:00

    @Column(name = "horario_fim")
    private LocalTime horarioFim; // Exemplo: 10:00

    @Column(length = 100, name = "bairro")
    private String bairro; // Bairro atendido no CEP

    @Enumerated(EnumType.STRING)// Salvar como texto no banco
    @Column(name = "status_alerta")
    private StatusAlerta statusAlerta = StatusAlerta.PENDENTE; 

    
    // Enum para controlar se já foi enviado o alerta ou não
    public enum StatusAlerta {
        PENDENTE, 
        ENVIADO,
        CANCELADO
    }

    // Construtor padrão
    public AgendamentoAbastecimento() {
    }

    public AgendamentoAbastecimento(String cep, LocalDate dataAbastecimento, LocalTime horarioInicio,
            LocalTime horarioFim) {
        this.cep = cep;
        this.dataAbastecimento = dataAbastecimento;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
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
    
    public LocalDate getDataAbastecimento() {
        return dataAbastecimento;
    }
    
    public void setDataAbastecimento(LocalDate dataAbastecimento) {
        this.dataAbastecimento = dataAbastecimento;
    }
    
    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }
    
    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }
    
    public LocalTime getHorarioFim() {
        return horarioFim;
    }
    
    public void setHorarioFim(LocalTime horarioFim) {
        this.horarioFim = horarioFim;
    }
    
    public String getBairro() {
        return bairro;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    public StatusAlerta getStatusAlerta() {
        return statusAlerta;
    }
    
    public void setStatusAlerta(StatusAlerta statusAlerta) {
        this.statusAlerta = statusAlerta;
    }
}
