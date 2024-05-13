package ar.edu.utn.frbb.tup.usuario;

public class Cliente extends Persona{
    //private int id;
    private long telefono;

    public Cliente(String nombre, String apellido, int dni, long telefono){
        super(nombre,apellido,dni);
        this.telefono=telefono;
    }

    public long getTelefono(){
        return telefono;
    }

    public void setTelefono(long telefono){
        this.telefono=telefono;
    }
}
