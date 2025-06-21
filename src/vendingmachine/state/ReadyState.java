package vendingmachine.state;

import vendingmachine.VendingMachine;
import vendingmachine.model.Coin;
import vendingmachine.model.Note;
import vendingmachine.model.Product;

public class ReadyState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product is already selected,Please make the payment");

    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println("Coin Inserted "+coin);
        checkPaymentStatus();

    }

    @Override
    public void insertNote(Note note) {
        vendingMachine.addNote(note);
        System.out.println("Note Inserted "+note);
        checkPaymentStatus();

    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please make payment first");
    }

    @Override
    public void returnChange() {
        System.out.println("Please make payment first");
    }

    private void checkPaymentStatus()
    {
        if(vendingMachine.getTotalPayment()>=vendingMachine.getSelectedProduct().getPrice()){
             vendingMachine.setState(vendingMachine.getDispenseState());
        }
    }
}
