/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import bean.Producto;
import java.util.List;

/**
 *
 * @author TATO
 */
public interface ProductoService {
    
    public void guardar(Producto producto);
    
    public void borrar(int idProducto);
    
    public List<Producto> listar();
    
    public void actualizar(Producto producto);
    
    
}
