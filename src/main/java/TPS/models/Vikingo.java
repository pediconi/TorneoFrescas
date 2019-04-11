package TPS.models;

public class Vikingo extends Humano{

    private int bebedorProfesional = 10;


    public Vikingo(int bebedorProfesional) {
        this.bebedorProfesional = bebedorProfesional;
    }

    public int beber (){
        return this.getOrinar().comenzarOrinada() + bebedorProfesional;  // llamo a la interfaz orinar (heredada de humano)
    }                                                                    // y con ella accedo a la implementacion
}
