package br.com.teste.models;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
 public class Pessoa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name="NOME", length=80)
    private String nome;
    @Column(name="ENDERECO", length=80)
    private String endereco;
    @Column(name="NUMERO", length=20)
    private String numero;
    @Column(name="TELEFONE", length=20)
    private String telefone;
    @Column(name="CIDADE", length=80)
    private String cidade;
    @Column(name="SEXO", length=80)
    private String sexo; 
    @Column(name="CPF", length=80)
    private String cpf;
    @Column(name="login",length=50)
    private String login;
    @Column(name="EMAIL",length=80)
    private String email;
 
 public String getCidade() {
 return cidade;
 }
 
 public void setCidade(String cidade) {
 this.cidade = cidade;
 }
 public String getEndereco() {
 return endereco;
 }
 
 public void setEndereco(String endereco) {
 this.endereco = endereco;
 } 
 public String getNome() {
 return nome;
 }
 
 public void setNome(String nome) {
 this.nome = nome;
 }
 public String getNumero() {
 return numero;
 }
 
 public void setNumero(String numero) {
 this.numero = numero;
 }
 public String getTelefone() {
 return telefone;
 }
 
 public void setTelefone(String telefone) {
 this.telefone = telefone;
 }
 public String getSexo(){
 return sexo;
 }
 
 public void setSexo(String sexo){
 this.sexo = sexo;
 } 
  public String getCpf(){
 return cpf;
 }
 
 public void setCpf(String cpf){
 this.cpf = cpf;
 }
 public String getLogin(){
 return login;
 }
 
 public void setLogin(String login){
 this.login = login;
}
 public String getEmail(){
 return email;
 }
 
 public void setEmail(String email){
 this.email = email;
 }
 public Integer getId() {
 return this.id;
 }

 public void setId(Integer id) {
 this.id = id;
 }
    
 public Pessoa() {
}

 public Pessoa(Integer id) {
 this.id = id;
}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Pessoa[ id=" + id + " ]";
    }

    
}

