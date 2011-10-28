/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nst.controlenst.persistence.dao.obj.impl;

<<<<<<< HEAD
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
=======
import nst.controlenst.enums.EnumTypeFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nst.controlenst.enums.EnumDAO;
>>>>>>> emidio/master
import nst.controlenst.model.entity.Cargo;
import nst.controlenst.persistence.dao.factory.interfaces.CargoDAO;
import nst.controlenst.persistence.dao.util.FabricaDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pablosouza
 */
public class JDBCCargoTest {
    
    //private JDBCCargo instance = null;
    private CargoDAO instance;
    
    public JDBCCargoTest() {
        try {
            //instance = JDBCCargo.getInstance();
<<<<<<< HEAD
            instance = FabricaDAO.getFactoryType().getCargoDAO();
=======
            instance = (CargoDAO)FabricaDAO.getFactoryType(EnumTypeFactory.JDBC).getDAO(EnumDAO.CARGODAO);
>>>>>>> emidio/master
        } catch (Exception ex) {
            Logger.getLogger(JDBCCargoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    
        /**
     * Test of save method, of class JDBCCargo.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Cargo cargo = new Cargo();
        cargo.setDescricao("Teste Cargo");
        JDBCCargo instance = JDBCCargo.getInstance();
        instance.save(cargo);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    
            /**
     * Test of save method, of class JDBCCargo.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Cargo cargo = new Cargo();
        cargo.setId(1);
        cargo.setDescricao("testUpdate");
        instance.save(cargo);
        
    }

    /**
     * Test of delete method, of class JDBCCargo.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Cargo cargo = new Cargo();
        cargo.setId(2);
        instance.delete(cargo);
        
    }

    /**
     * Test of getAll method, of class JDBCCargo.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        List result = instance.getAll();
        assertNotNull(result);
        
    }

    /**
     * Test of getByPrimaryKey method, of class JDBCCargo.
     */
    @Test
    public void testGetByPrimaryKey() {
        
        Integer id = 10;
        Cargo result = instance.getByPrimaryKey(id);
        assertNotNull(result);
        
    }

    
}
