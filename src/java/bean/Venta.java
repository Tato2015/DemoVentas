package bean;

import java.util.Date;

public class Venta {
    
    private int idVenta;
    private String cliente;
    private String fecha;//convertir a date para validar en mysql
    private double importe;
    private int idEmpleado;

    public Venta() {
    }

    public Venta(int idVenta, String cliente, String fecha, double importe, int idEmpleado) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.fecha = fecha;
        this.importe = importe;
        this.idEmpleado = idEmpleado;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    
    
}