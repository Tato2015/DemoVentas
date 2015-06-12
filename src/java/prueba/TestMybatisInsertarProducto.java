/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import bean.Producto;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import services.ProductoService;


/**
 *
 * @author Profesor
 */
public class TestMybatisInsertarProducto {

    private static SqlSessionFactory sessionFac = null;
    private static Reader reader;

    private static String CONFIGURATION_FILE = "sqlmap-config.xml";
    
      static{
        try {
            reader = Resources.getResourceAsReader(CONFIGURATION_FILE);
            sessionFac = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
      
    public static void main(String[] args) {
         SqlSession session = sessionFac.openSession();
        try {
            ProductoService service = session.getMapper(ProductoService.class);
            
           Producto product = new Producto();
            product.setIdProducto(8);
            product.setIdCategoria(1);
            product.setNombre("LAVADORA");
            product.setPrecio(1200.00);
            product.setStock(120);
            service.guardar(product);
            
          // service.borrar("IPHONE");
            //int resp=service.borrarPorNombre("S6");
//            System.out.println("Respues_DELE="+resp);*/
//            //List<Producto> lista=service.buscar("APPLE");
//            List<Producto> lista=service.llamarProcedure();
//            System.out.println("lista="+lista);
            session.commit();
            System.out.println("Producto ingresado correctamente");
        }catch(Exception e){
            System.err.println("Error "+ e.getMessage());
        }
        
        finally {
        session.close();
        }
    }
    
}
