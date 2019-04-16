package TPS.models;

import TPS.interfaces.Beber;
import TPS.interfaces.Orinar;

public class Vikingo extends Humano{    // seria mi contexto

    final int bebedorProfesional = 2;
    private int aguanteMaximo;

    public Vikingo(String nombre, Integer edad, Integer peso, Orinar orinar, Beber beber) {  // recibo en orinar la implementacion de orinar (OrinarVikingoImp)
        super(nombre, edad, peso, orinar, beber);
        this.aguanteMaximo = (int) ((peso * bebedorProfesional) * 0.5);
    }

    public int vBeber (){
        return this.getBeber().bebiendo();
                                                                 // llamo a la interfaz orinar (heredada de humano) y con ella accedo a la implementacion
    }

    public int vOrinar (){

        return this.getOrinar().orinando();
    }

    public int getAguanteMaximo() {
        return this.aguanteMaximo;
    }

    @Override
    public String toString() {
        return "\nVikingo{" +
                super.toString();

    }
}
