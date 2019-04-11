package TPS.models;

import TPS.interfaces.Orinar;

public class Humano {

    private String nombre;
    private Integer edad;
    private Integer peso;
    private Orinar orinar;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Orinar getOrinar() {
        return orinar;
    }

    public void setOrinar(Orinar orinar) {
        this.orinar = orinar;
    }
}
