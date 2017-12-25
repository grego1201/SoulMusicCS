/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magesft.loginusuario;

import static junit.framework.TestCase.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ivan
 */
public class TestLogIn1 {
    static LoginUsuario c;
    
    public TestLogIn1() {
    }
    
    @BeforeClass
    public static void setUpClass() {
         c = new LoginUsuario();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
     @Test
    public void testcontraseniaerronea() {
        c.txtUsuario.setText("Comprador");
        c.txtPass.setText("contraseniaerronea");
        assertTrue(!c.login());
    }

    @Test
    public void test1() {
        c.txtUsuario.setText("Comprador");
        c.txtPass.setText("Comprador");
        assertTrue(c.login());
    }

    @Test
    public void test2() {
        c.txtUsuario.setText("Comprador");
        c.txtPass.setText("");
        assertTrue(!c.login());
    }

    @Test
    public void test3() {
        c.txtUsuario.setText("");
        c.txtPass.setText("Comprador");
        assertTrue(!c.login());
    }

    @Test
    public void test4() {
        c.txtUsuario.setText("");
        c.txtPass.setText("");
        assertTrue(!c.login());
    }
    @Before
    public void setUp() {
   
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
