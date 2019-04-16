package TPS.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Taberna {

    private Humano cantinero;

    public Taberna(Humano cantinero) {
        this.cantinero = cantinero;
    }

    public Humano getCantinero() {
        return cantinero;
    }

    public void mostrarVikingos (List<Humano> vikingos){
        vikingos.stream()
                .forEach(System.out::println);
    }

    public void mostrarEspartanos (List<Humano> espartanos){
        espartanos.stream()
                .forEach(System.out::println);
    }


    public List<Humano> ordenarVikingos (List<Humano> vikingos){
        return vikingos.stream()
                .sorted(Comparator.comparing(v -> v.getPeso()))
                .collect(Collectors.toList());

    }

    public List<Humano> ordenarEspartanos (List<Humano> espartanos){
        return espartanos.stream()
                .sorted(Comparator.comparing(v -> v.getPeso()))
                .collect(Collectors.toList());

    }

    public Humano getPrimerVikingo (List<Humano> vikingos){
        return vikingos.remove(0);
    }

    public Humano getPrimerEspartano (List<Humano> espartanos){
        return espartanos.remove(0);
    }

    /**
     * Machea recibo las listas de vikingos y espartanos y los enfrento uno a uno vaciando ambas mencionadas listas
     * @param vikingos
     * @param espartanos
     * @return devuelve una lista con los ganadores
     */
    public List<Humano> comenzarBatalla(List<Humano> vikingos, List<Humano> espartanos ){

        int  i =0;
        Humano vikingo, espartano, ganador;
        List<Humano> ganadores = new ArrayList<>();

        while (!vikingos.isEmpty()){
            i++;
            System.out.println("\nRONDA "+i);
            vikingo = this.getPrimerVikingo(vikingos);
            espartano = this.getPrimerEspartano(espartanos);
            System.out.println(vikingo.getNombre()+ "(" +((Vikingo) vikingo).getAguanteMaximo()+ ") Vs "+espartano.getNombre()+"("+ ((Espartano) espartano).getAguanteMaximo()+")" );

            ganador = this.enfrentar(vikingo, espartano);
            ganadores.add(ganador);
            System.out.println("GANADOR RONDA "+ganador);
        }
        return ganadores;
    }

    /**
     * Metodo que desarrolla el algoritmo de enfrentamiento entre vikingo y espartano
     * @param vikingo
     * @param espartano
     * @return retorna al ganador
     */
    public Humano enfrentar(Humano vikingo , Humano espartano){

        do{
            vikingo.setBebidaEnCuerpo( vikingo.getBebidaEnCuerpo() + ((Vikingo) vikingo).vBeber() );
            espartano.setBebidaEnCuerpo( espartano.getBebidaEnCuerpo() + ((Espartano) espartano).eBeber() );

            System.out.println(vikingo.getNombre() +" "+ vikingo.getBebidaEnCuerpo());
            System.out.println(espartano.getNombre() +" "+ espartano.getBebidaEnCuerpo());

        }while (vikingo.getBebidaEnCuerpo() < ((Vikingo) vikingo).getAguanteMaximo() && espartano.getBebidaEnCuerpo() < ((Espartano) espartano).getAguanteMaximo()); // hacerlo hasta q excedan su limite

        if (vikingo.getBebidaEnCuerpo() >= ((Vikingo) vikingo).getAguanteMaximo()) { // se meo el vikingo
            System.out.println(vikingo.getNombre()+" Se meo");
            ((Vikingo) vikingo).vOrinar();
            return espartano;

        }else{
            System.out.println(espartano.getNombre()+" Se meo");
            ((Espartano) espartano).eOrinar();
            return vikingo;
        }

    }

    /**
     * metodo que desarrolla el algoritmo para enfrentar al cantinero
     * @param guerrero puede recibir un vikingo o un espartano
     * @return
     */
    public Humano enfrentarCantinero(Humano guerrero){

        guerrero.setBebidaEnCuerpo(0);  // labaje de estomago para el que gano , asi empieza en iguales condicones que el cantinero

        if (guerrero instanceof Vikingo){    // esto lo tengo q hacer por el casteo

            do{
                guerrero.setBebidaEnCuerpo( guerrero.getBebidaEnCuerpo() + ((Vikingo) guerrero).vBeber() );
                this.cantinero.setBebidaEnCuerpo(this.cantinero.getBebidaEnCuerpo() + ((Cantinero) this.cantinero).cBeber() );

                System.out.println(guerrero.getNombre() +" "+ guerrero.getBebidaEnCuerpo());
                System.out.println(this.cantinero.getNombre() +" "+ this.cantinero.getBebidaEnCuerpo());

            }while (guerrero.getBebidaEnCuerpo() < ((Vikingo) guerrero).getAguanteMaximo() && this.cantinero.getBebidaEnCuerpo() < ((Cantinero) this.cantinero).getAguanteMaximo()); // hacerlo hasta q excedan su limite

            if (guerrero.getBebidaEnCuerpo() >= ((Vikingo) guerrero).getAguanteMaximo()) { // se meo el vikingo
                System.out.println(guerrero.getNombre()+" Se meo");
                ((Vikingo) guerrero).vOrinar();
                return this.cantinero;

            }else{
                System.out.println(this.cantinero.getNombre()+" Se meo");
                ((Cantinero) this.cantinero).cOrinar();
                return guerrero;
            }

        }else if (guerrero instanceof Espartano){

            do{
                guerrero.setBebidaEnCuerpo( guerrero.getBebidaEnCuerpo() + ((Espartano) guerrero).eBeber() );
                this.cantinero.setBebidaEnCuerpo( this.cantinero.getBebidaEnCuerpo() + ((Cantinero) this.cantinero).cBeber() );

                System.out.println(guerrero.getNombre() +" "+ guerrero.getBebidaEnCuerpo());
                System.out.println(this.cantinero.getNombre() +" "+ this.cantinero.getBebidaEnCuerpo());

            }while (guerrero.getBebidaEnCuerpo() < ((Espartano) guerrero).getAguanteMaximo() && this.cantinero.getBebidaEnCuerpo() < ((Cantinero) this.cantinero).getAguanteMaximo()); // hacerlo hasta q excedan su limite

            if (guerrero.getBebidaEnCuerpo() >= ((Espartano) guerrero).getAguanteMaximo()) { // se meo el vikingo
                System.out.println(guerrero.getNombre()+" Se meo");
                ((Espartano) guerrero).eOrinar();
                return this.cantinero;

            }else{
                System.out.println(this.cantinero.getNombre()+" Se meo");
                ((Cantinero) this.cantinero).cOrinar();
                return guerrero;
            }

        }else return null;

    }

    /**
     * Busco entre los ganadores de cada ronda al que mas bebio
     * @param ganadores
     * @return
     */
    public Humano getMaximoGanador (List<Humano> ganadores){

        return ganadores.stream()
                .max(Comparator.comparing(Humano::getBebidaEnCuerpo))
                .orElseThrow(NoSuchElementException::new);
    }



}