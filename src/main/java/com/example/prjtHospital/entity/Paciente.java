package com.example.prjtHospital.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Aqui está a magia do Spring Data JPA. Em vez de lidar com o ID (número) solto, lidamos com o objeto inteiro.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = false, unique = true)
    private Pessoa pessoa;

    @Column(name = "tipo_sanguineo")
    private String tipoSanguineo;

    private String alergias;

    @Column(name = "contato_emergencia_nome")
    private String contatoEmergenciaNome;

    @Column(name = "contato_emergencia_telefone")
    private String contatoEmergenciaTelefone;

    // Não se esqueça de gerar os Getters e Setters
}