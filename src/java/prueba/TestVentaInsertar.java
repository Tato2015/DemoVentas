package prueba;

import bean.Venta;
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
import services.VentaService;

public class TestVentaInsertar {

    private static SqlSessionFactory sessionFac = null;
    private static Reader reader;

    private static String CONFIGURATION_FILE = "sqlmap-config_1.xml";

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

            VentaService service = session.getMapper(VentaService.class);
            
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String strFecha = formatter.format(date);
            
            Venta venta = new Venta();
            venta.setIdVenta(1);
            venta.setCliente("GERALDO ACHUY MOLINA");
            System.out.println("" + strFecha);
            venta.setFecha(strFecha);
            venta.setImporte(3600.00);
            venta.setIdEmpleado(1002);
            service.guardar(venta);

            // service.borrar("IPHONE");
            //int resp=service.borrarPorNombre("S6");
//            System.out.println("Respues_DELE="+resp);*/
//            //List<Venta> lista=service.buscar("APPLE");
//            List<Venta> lista=service.llamarProcedure();
//            System.out.println("lista="+lista);
            session.commit();
            System.out.println("Venta ingresada correctamente");
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        } finally {
            session.close();
        }
    }

}
