package TPS.interfaces;

public class BeberVikingoImp implements Beber{

    @Override
    public int bebiendo() {
        return (int) (Math.random()*15);   // le pega menos
    }
}
