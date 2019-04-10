package TPS;

import TPS.interfaces.OrinarVikingoImp;
import TPS.models.ContextoOrinar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ContextoOrinar contextoOrinar = new ContextoOrinar(new OrinarVikingoImp());    // le paso una implementacion
        System.out.println("Orinada Vikinga: " + contextoOrinar.ejecutar(10));

        /*context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));*/
    }
}
