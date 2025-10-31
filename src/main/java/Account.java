public abstract class Account {
    protected long balance;
    public abstract boolean add(long amount);
    public boolean pay(long amount){
        if (balance < amount)
            return false;

        balance -= amount;
        return true;
    }
    public boolean transfer(Account account, long amount){
        if (pay(amount)) {
            if (account.add(amount)) {
                return true;
            }
            add(amount);
        }
        return false;
    }
    public long getBalance(){
        return balance;
    }
}
