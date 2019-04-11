package TPS.models;

import TPS.interfaces.Beber;
import TPS.interfaces.Orinar;

public class Vikingo extends Humano{    // seria mi contexto

    final int bebedorProfesional = 10;


    public Vikingo(String nombre, Integer edad, Integer peso, Orinar orinar, Beber beber) {  // recibo en orinar la implementacion de orinar (OrinarVikingoImp)
        super(nombre, edad, peso, orinar, beber);
    }


    public int vComenzar (){
        return this.getBeber().bebiendo() - this.getOrinar().orinando();  // llamo a la interfaz orinar (heredada de humano) y con ella accedo a la implementacion
    }



}
