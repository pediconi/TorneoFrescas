package TPS;

import TPS.interfaces.BeberVikingoImp;
import TPS.interfaces.OrinarVikingoImp;
import TPS.models.Humano;
import TPS.models.Vikingo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Humano v1 = new Vikingo("John", 33, 90, new OrinarVikingoImp(), new BeberVikingoImp());
        Humano v2 = new Vikingo("Loki", 43, 90, new OrinarVikingoImp(), new BeberVikingoImp());
        Humano v3 = new Vikingo("Ivar", 26, 90, new OrinarVikingoImp(), new BeberVikingoImp());
        Humano v4 = new Vikingo("Bjorn", 19, 90, new OrinarVikingoImp(), new BeberVikingoImp());
        Humano v5 = new Vikingo("Kahl", 23, 90, new OrinarVikingoImp(), new BeberVikingoImp());

        System.out.println(((Vikingo) v1).vComenzar());   // con esto saco el resultado

        List<Humano> vikings = Arrays.asList(v1,v2,v3,v4,v5);

        vikings.stream()
                .sorted(Comparator.comparing(v -> v.getEdad()))
                .collect(Collectors.toList())
                .forEach(System.out::println);





    }
}
