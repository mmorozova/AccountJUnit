public class SimpleAccount extends Account{

    @Override
    public boolean add(long amount) {
        balance += amount;
        return true;
    }
}
