package com.example.prjtHospital;

import com.example.prjtHospital.entity.Paciente;
import com.example.prjtHospital.entity.Pessoa;
import com.example.prjtHospital.repository.PacienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PrjtHospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrjtHospitalApplication.class, args);
	}

	@Bean
	CommandLineRunner testarBanco(PacienteRepository pacienteRepository) {
		return args -> {
			System.out.println("A iniciar o teste de base de dados...");

			// 1. Criar os dados base da pessoa
			Pessoa pessoa = new Pessoa();
			pessoa.setNomeCompleto("João Tycoon da Silva");
			pessoa.setCpf("111.222.333-44");
			pessoa.setDataNascimento("1990-05-15");
			pessoa.setTelefone("912345678");

			// 2. Criar a ficha de paciente e ligar à pessoa
			Paciente paciente = new Paciente();
			paciente.setPessoa(pessoa); // O relacionamento OneToOne a acontecer aqui
			paciente.setTipoSanguineo("O+");
			paciente.setAlergias("Penicilina");

			// 3. O método save() vai inserir primeiro na tabela pessoa e depois na tabela paciente automaticamente
			pacienteRepository.save(paciente);

			System.out.println("SUCESSO: Paciente inserido no SQLite com sucesso!");
		};
	}
}

