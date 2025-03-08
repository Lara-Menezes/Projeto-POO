package model;

import java.util.Objects;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
    
    public Cliente() {
    }
    
    public Cliente(String nome, String cpf, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cpf.equals(cliente.cpf);  // Comparar pelo CPF
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);  // Gerar hash baseado no CPF
    }


    public String toString() {
        return "\nCliente:" +
                "\nNome= " + nome + 
                "\nCPF= " + cpf + 
                "\nTelefone= " + telefone + 
                "\nEmail= " + email ;
    }

}
