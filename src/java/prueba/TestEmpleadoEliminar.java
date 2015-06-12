package prueba;

import bean.Empleado;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import services.EmpleadoService;

public class TestEmpleadoEliminar {

    private static SqlSessionFactory sessionFac = null;
    private static Reader reader;

    private static String CONFIGURATION_FILE = "sqlmap-config_2.xml";

    static {
        try {
            reader = Resources.getResourceAsReader(CONFIGURATION_FILE);
            sessionFac = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ParseException {
        SqlSession session = sessionFac.openSession();

        try {

            EmpleadoService service = session.getMapper(EmpleadoService.class);            
            service.eliminar(1005);

            // service.borrar("IPHONE");
            //int resp=service.borrarPorNombre("S6");
//            System.out.println("Respues_DELE="+resp);*/
//            //List<Empleado> lista=service.buscar("APPLE");
//            List<Empleado> lista=service.llamarProcedure();
//            System.out.println("lista="+lista);
            session.commit();
            System.out.println("Empleado eliminado correctamente");
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        } finally {
            session.close();
        }
    }

}
