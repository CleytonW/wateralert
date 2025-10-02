package com.compesa_abastecimento.wateralert.model;

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

    private LocalDateTime dataCadastro;
    // Getters e Setters
}
