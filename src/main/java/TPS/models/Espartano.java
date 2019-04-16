package TPS.models;

import TPS.interfaces.Beber;
import TPS.interfaces.Orinar;

public class Espartano extends Humano{

    final int toleranciaExtra = 150;
    private int aguanteMaximo;


    public Espartano(String nombre, Integer edad, Integer peso, Orinar orinar, Beber beber) {  // recibo en orinar la implementacion de orinar (OrinarVikingoImp)
        super(nombre, edad, peso, orinar, beber);
        this.aguanteMaximo = (int) ((peso + toleranciaExtra) * 0.5);
    }


    public int eBeber (){
        return this.getBeber().bebiendo();  // llamo a la interfaz orinar (heredada de humano) y con ella accedo a la implementacion
    }

    public int eOrinar (){
        return this.getOrinar().orinando();
    }

    public int getAguanteMaximo() {
        return this.aguanteMaximo;
    }

    @Override
    public String toString() {
        return "\nEspartano{" +
                super.toString();

    }

}
