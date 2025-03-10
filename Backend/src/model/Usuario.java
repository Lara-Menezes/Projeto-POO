package model;

public class Usuario {

    private String nomeUsuario;
    private String senha;
    private String perfil; 
    
    
    //Contrutor limpo para serialização e desserialização do json
    public Usuario() {
    	
    }
    
    public Usuario(String nomeUsuario, String senha, String perfil) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.perfil = perfil;
    }

    //Getters e setters
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

    //Equals para comparação entre objetos
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return nomeUsuario.equals(usuario.nomeUsuario);  
    }
    
    //Para exibir as informações do objeto
    public String toString() {
        return "\nLogin: " +
               "\n Usuário='" + nomeUsuario  +
               "\n Perfil=" + perfil;
    }
}
