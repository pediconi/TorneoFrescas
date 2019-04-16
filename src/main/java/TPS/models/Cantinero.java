package TPS.models;

import TPS.interfaces.Beber;
import TPS.interfaces.Orinar;

public class Cantinero extends Humano{    // seria mi contexto

    final int bebedorProfesional = 2;
    final int toleranciaExtra = 50;
    private int aguanteMaximo;

    public Cantinero(String nombre, Integer edad, Integer peso, Orinar orinar, Beber beber) {  // recibo en orinar la implementacion de orinar (OrinarVikingoImp)
        super(nombre, edad, peso, orinar, beber);
        this.aguanteMaximo = (int) ((peso * bebedorProfesional + toleranciaExtra) * 0.5);
    }

    public int cBeber (){
        return this.getBeber().bebiendo();
        // llamo a la interfaz orinar (heredada de humano) y con ella accedo a la implementacion
    }

    public int cOrinar (){

        return this.getOrinar().orinando();
    }

    public int getAguanteMaximo() {
        return this.aguanteMaximo;
    }

    @Override
    public String toString() {
        return "\nCantinero{" +
                super.toString();

    }
}
