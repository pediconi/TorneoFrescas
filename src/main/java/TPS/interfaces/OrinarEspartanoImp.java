package TPS.interfaces;

public class OrinarEspartanoImp implements Orinar {

    public int orinando(){
        return (int) (Math.random()*5);  // tolerancia extra, se mea menos
    }
}
