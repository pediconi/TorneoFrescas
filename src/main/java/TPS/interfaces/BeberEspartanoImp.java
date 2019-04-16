package TPS.interfaces;

public class BeberEspartanoImp implements Beber {

    @Override
    public int bebiendo() {
        return (int) (Math.random()*20);
    }
}
