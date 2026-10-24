package com.example.prjtHospital.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)
    private String dataNascimento;

    private String telefone;
    private String email;

    @Column(name = "endereco_completo")
    private String enderecoCompleto;

    // O insertable/updatable false garante que o Java não tenta subscrever o CURRENT_TIMESTAMP do SQLite
    @Column(name = "data_cadastro", insertable = false, updatable = false)
    private LocalDateTime dataCadastro;

    // Pode gerar os Getters e Setters na sua IDE (Alt+Insert ou Source -> Generate Getters and Setters)
}