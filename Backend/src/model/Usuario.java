package model;

public class Usuario {

    private String nomeUsuario;
    private String senha;
    private String perfil; 
    
    
    public Usuario() {
    	
    }
    
    public Usuario(String nomeUsuario, String senha, String perfil) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.perfil = perfil;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

 
    public String toString() {
        return "\nLogin: " +
               "\n Usuário='" + nomeUsuario  +
               "\n Perfil=" + perfil;
    }
}
