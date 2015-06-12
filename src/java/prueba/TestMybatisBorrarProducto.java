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
public class TestMybatisBorrarProducto {

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
            service.borrar(8);
            
          // service.borrar("IPHONE");
            //int resp=service.borrarPorNombre("S6");
//            System.out.println("Respues_DELE="+resp);*/
//            //List<Producto> lista=service.buscar("APPLE");
//            List<Producto> lista=service.llamarProcedure();
//            System.out.println("lista="+lista);
            session.commit();
            System.out.println("Producto eliminado correctamente");
        }catch(Exception e){
            System.err.println("Error "+ e.getMessage());
        }
        
        finally {
        session.close();
        }
    }
    
}
