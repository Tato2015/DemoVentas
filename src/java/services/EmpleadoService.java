package services;

import bean.Empleado;

public interface EmpleadoService {

    public void guardar(Empleado Empleado);
    
    public void eliminar(int idEmpleado);
    
    public void actualizar(Empleado empleado);
    
}
