package model;

import java.util.Objects;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
    
	//Construtor limpo para serialização e desserialização do json
    public Cliente() {
    	
    }

    public Cliente(String nome, String cpf, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }


    //getters e setters
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
    	this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
    	this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    //Métodos para comparação com json
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cpf.equals(cliente.cpf);  
    }

    public int hashCode() {
        return Objects.hash(cpf); 
    }

    //Exibição das informações doobjeto em formato String
    public String toString() {
        return "\nCliente:" +
                "\nNome= " + nome + 
                "\nCPF= " + cpf + 
                "\nTelefone= " + telefone + 
                "\nEmail= " + email ;
    }

}
