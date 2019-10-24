package br.com.teste.controllers;
             
import DAO.PessoaDAO;
import br.com.teste.models.Pessoa;
import java.io.IOException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


@ManagedBean
@ViewScoped
public class PessoaMB {
    
    private Pessoa pessoa;
    private PessoaDAO dao = new PessoaDAO();
    private List<Pessoa> listaPessoa;
    
    public PessoaMB(){
       if (pessoa == null) {
            ExternalContext ctx = FacesContext
                                      .getCurrentInstance()
                                      .getExternalContext();
 
            String idParam = ctx.getRequestParameterMap().get("id");
 
            if (idParam != null && !idParam.equals("")) {
                try {
                    this.pessoa = dao.buscar(Integer.parseInt(idParam));
                } catch(NumberFormatException e) {
                    // log
                }
            } 
 
            if (this.pessoa == null) {
                this.pessoa = new Pessoa();
            }
        }
    }
    
    public Pessoa cadastrar() throws Exception{
        pessoa = dao.cadastrar(pessoa);
        if(pessoa != null){
            FacesContext.getCurrentInstance().getExternalContext().redirect("CadastradoSucess.xhtml");
        }
        
        return pessoa;
    }
    
        public void excluir(Integer id) throws IOException{
        dao.excluir(id);
        FacesContext.getCurrentInstance().getExternalContext().redirect("ListaPessoa.xhtml");
    }
    
    public List<Pessoa> listar(){
       return listaPessoa = dao.listar();
    }
    
    public Pessoa buscar(Pessoa pessoa) throws IOException{    
        pessoa = dao.buscar(pessoa.getId());         
        return pessoa;
    }
            
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    /**
     * @return the listaPessoa
     */
    public List<Pessoa> getListaPessoa() {
        return listaPessoa;
    }

    /**
     * @param listaPessoa the listaPessoa to set
     */
    public void setListaPessoa(List<Pessoa> listaPessoa) {
        this.listaPessoa = listaPessoa;
    }
}