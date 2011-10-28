
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import nst.controlenst.controller.business.impl.ProjetoBO;
import nst.controlenst.model.entity.Coordenador;
import nst.controlenst.model.entity.EmailCoordenador;
import nst.controlenst.model.entity.Participante;
import nst.controlenst.model.entity.Projeto;
import nst.controlenst.model.entity.Situacao;
import nst.controlenst.model.entity.Tipo;
import nst.controlenst.persistence.dao.factory.impl.JDBCFactory;
import nst.controlenst.persistence.dao.factory.interfaces.CoordenadorDAO;
import nst.controlenst.persistence.dao.factory.interfaces.EmailCoordenadorDAO;
import nst.controlenst.persistence.dao.obj.impl.JDBCEmailCoordenadores;
import nst.controlenst.persistence.dao.util.FabricaDAO;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pablosouza
 */
public class TestarJDBCCoordenador {
    public static void main(String[] args) throws Exception {
/*
        //Primeiro seta o tipo de Persistencia
        //FabricaDAO.setFactoryType(new JDBCFactory());
        
        CoordenadorDAO coordenadorDAO = FabricaDAO.getFactoryType().getCoordenadorDAO();
        
//        //Adcionar um coordenador
//        Coordenador coordenador0 = new Coordenador();
//        coordenador0.setNome("Pablo Souza");
//        coordenadorDAO.save(coordenador0);
//        
//        
//        Coordenador coordenador1 = new Coordenador(); 
//        coordenador1.setNome("Vanessa Souza");
//        coordenadorDAO.save(coordenador1);
//        
//        
//        //Pegar pelo ID
//        System.out.println(coordenadorDAO.getByPrimaryKey(1).getNome());
//        
//        //Atualizar um registro
//        Coordenador coordeUpd = new Coordenador(1, "Pablo Delicia de coco");
//        coordenadorDAO.save(coordeUpd);
//        
//        //Pegar todos
//        List<Coordenador> todos = coordenadorDAO.getAll();
//        for (Coordenador coordenador : todos) {
//            System.out.println("Nome: "+coordenador.getNome());
//        }
        
        EmailCoordenador email = new EmailCoordenador();
        email.setCoordenador(coordenadorDAO.getByPrimaryKey(1));
        email.setDescricao("pvrsouza@gmail.com");
        //EmailCoordenadorDAO emailDAO = ControlaFabricasDAO.getFactoryType().getEmailCoordenadorDAO();
        
        //Isso aqui nao e recomendado fazer poque se ouver a necessidade de trocar o tipo de persistencia isso vai dar pau.
        EmailCoordenadorDAO emailDAO = JDBCEmailCoordenadores.getInstance();
        emailDAO.save(email);
        */
        
        Date c = new Date(2011,9, 1);
        Date e = new Date(2011, 10, 1);
        Date ep = new Date(2011, 11, 1);
        Date i = new Date(2011,9, 2);
        
        Projeto p = new Projeto();
        
        p.setNome("Portal TecJorge");
        p.setDescricao("Projeto do Portal TecJorge");
        p.setIdentificador("Portal");
        
        p.setDataCadastro(new Timestamp(c.getTime()));        
        p.setDataEncerramento(new Timestamp(e.getTime()));
        p.setDataEncerramentoPrevisto(new Timestamp(ep.getTime()));
        p.setDataInicio(new Timestamp(i.getTime()));        
        p.setSituacao(new Situacao(4, "Em elaboração"));
        p.setTipo(new Tipo(1, "Desenvolvimento"));
        
        ProjetoBO proBO = new ProjetoBO();
        
        proBO.save(p);
        
        
        
        
        
    }
}
