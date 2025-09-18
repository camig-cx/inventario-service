package com.arka.inventario.demo_filesystem;

/**
 * Ejemplo de archivo creado con Filesystem
 * Este es un demo de las capacidades de creación de archivos
 */
public class EjemploCreacion {
    
    private String mensaje;
    
    public EjemploCreacion() {
        this.mensaje = "Archivo creado exitosamente con Filesystem";
    }
    
    public void mostrarMensaje() {
        System.out.println(mensaje);
    }
    
    public String obtenerEstado() {
        return "Archivo editado con Filesystem";
    }
    
    public void agregarFuncionalidad(String nuevaFuncion) {
        this.mensaje += " - " + nuevaFuncion;
    }
}
