package vendingmachine;

public class IdleState implements VendingMachineState{


    @Override
    public void selectProduct(Product product) {

    }

    @Override
    public void insertCoin(Coin coin) {

    }

    @Override
    public void insertNote(Note note) {

    }

    @Override
    public void dispenseProduct(Product product) {

    }

    @Override
    public void returnChange() {

    }

    @Override
    public VendingMachineState getNextState() {
        return null;
    }
}
