package TPS;

import TPS.interfaces.BeberEspartanoImp;
import TPS.interfaces.BeberVikingoImp;
import TPS.interfaces.OrinarEspartanoImp;
import TPS.interfaces.OrinarVikingoImp;
import TPS.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class App 
{
    public static void main( String[] args )
    {

        Humano c = new Cantinero("Cantinero", 56, 85, new OrinarEspartanoImp(), new BeberVikingoImp());

        Humano v1 = new Vikingo("Thor", 33, 95, new OrinarVikingoImp(), new BeberVikingoImp());
        Humano v2 = new Vikingo("Loki", 43, 103, new OrinarVikingoImp(), new BeberVikingoImp());
        Humano v3 = new Vikingo("Ivar", 26, 99, new OrinarVikingoImp(), new BeberVikingoImp());
        Humano v4 = new Vikingo("Bjorn", 19, 88, new OrinarVikingoImp(), new BeberVikingoImp());
        Humano v5 = new Vikingo("Kahl", 23, 97, new OrinarVikingoImp(), new BeberVikingoImp());

        Humano e1 = new Espartano("Carlitos", 32, 90, new OrinarEspartanoImp(), new BeberEspartanoImp());
        Humano e2 = new Espartano("Alberto", 43, 95, new OrinarEspartanoImp(), new BeberEspartanoImp());
        Humano e3 = new Espartano("Juancito", 26, 88, new OrinarEspartanoImp(), new BeberEspartanoImp());
        Humano e4 = new Espartano("Pepe", 48, 110, new OrinarEspartanoImp(), new BeberEspartanoImp());
        Humano e5 = new Espartano("Jose", 25, 96, new OrinarEspartanoImp(), new BeberEspartanoImp());

        List<Humano> vikingos = new ArrayList<>(Arrays.asList(v1,v2,v3,v4,v5));   // para crear una lista modificable, debe ser ArrayList o LinkedList
        List<Humano> espartanos = new ArrayList<>(Arrays.asList(e1,e2,e3,e4,e5));  // creo un ArrayList a partir de la lista original
        List<Humano> ganadores = new ArrayList<>();


        Taberna taberna = new Taberna(c);

        /*PRESENTO AMBOS EQUIPOS*/
        System.out.println("\nVIKINGOS ");
        System.out.println(vikingos);
        System.out.println("\nESPARTANOS ");
        System.out.println(espartanos);

        /* ORDENO A LOS EQUIPOS POR EDAD y LOS GUARDO EN UNA NUEVA LISTA (para ya poder trabajar con la lista ordenada)*/
        List<Humano> vOrdenados = taberna.ordenarVikingos(vikingos);
        List<Humano> eOrdenados = taberna.ordenarEspartanos(espartanos);

        /*LOS MUESTRO*/
        System.out.println("\nVIKINGOS ORDENADOS POR PESO");
        System.out.println(vOrdenados);
        System.out.println("\nESPARTANOS ORDENADOS POR PESO");
        System.out.println(eOrdenados);

        /*RETIRO AL PRIMERO DE CADA EQUIPO*/
        taberna.getPrimerVikingo(vOrdenados);
        taberna.getPrimerEspartano(eOrdenados);

        /*LOS MUESTRO*/
        System.out.println("\nVIKINGOS ORDENADOS SIN EL PRIMERO ");
        System.out.println(vOrdenados);
        System.out.println("\nESPARTANOS ORDENADOS SIN EL PRIMERO ");
        System.out.println(eOrdenados);

        /*COMIENZO LA BATALLA Y GUARDO A LOS GANADORES DE CADA RONDA*/
        ganadores = taberna.comenzarBatalla(vOrdenados, eOrdenados);

        /*BATALLA FINAL VS EL CANTINERO*/
        System.out.println("\nMAXIMO GANADOR :" +taberna.getMaximoGanador(ganadores));
        System.out.println("\nBATALLA FINAL VS EL CANTINERO");
        System.out.println("\nCAMPEON: "+taberna.enfrentarCantinero(taberna.getMaximoGanador(ganadores)).toString());


        /*---------------------------SQL--------------------------------------------------------------------------------------------*/

        ConnectionConfig connection = new ConnectionConfig(); // creo instancia del objeto connectionConfig
        Connection myConnection = connection.getConnection(); // solicito la conexion

        try {
            PreparedStatement statement = myConnection.prepareStatement("INSERT INTO ganadores (id_ganador, nombre_ganador ,bebida_en_cuerpo )VALUES(?,?,?)");

            for (Humano g : ganadores){
                statement.setInt(1,0 );
                statement.setString(2, g.getNombre());
                statement.setFloat(3, g.getBebidaEnCuerpo());
                statement.executeUpdate();
            }
            statement.close();
            myConnection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        /*-------------------------------------------------------------------------------------------------------------------------*/










    }
}
