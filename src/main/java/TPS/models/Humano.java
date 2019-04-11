package TPS.models;

import TPS.interfaces.Beber;
import TPS.interfaces.Orinar;

public class Humano {

    private String nombre;
    private Integer edad;
    private Integer peso;
    private Orinar orinar;
    private Beber beber;

    public Humano(String nombre, Integer edad, Integer peso, Orinar orinar, Beber beber) {  // recibe una implementacion de la interface orinar (orinarVikingImp o orinarEspart)
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.orinar = orinar;
        this.beber = beber;
    }

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

    public Beber getBeber() {
        return beber;
    }

    public void setBeber(Beber beber) {
        this.beber = beber;
    }

    @Override
    public String toString() {
        return "Humano{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", orinar=" + orinar.orinando() +
                ", beber=" + beber.bebiendo() +
                '}';
    }
}
