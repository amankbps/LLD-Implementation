package vendingmachine.state;

import vendingmachine.VendingMachine;
import vendingmachine.model.Coin;
import vendingmachine.model.Note;
import vendingmachine.model.Product;

public class ReturnChangeState implements VendingMachineState {

    private final VendingMachine vendingMachine;
    public ReturnChangeState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(Product product) {
        System.out.println("Please collect the change first.");
    }

    @Override
    public void insertCoin(Coin coin) {
       System.out.println("Please collect the change first.");
    }

    @Override
    public void insertNote(Note note) {
     System.out.println("Please collect the change first.");
    }

    @Override
    public void dispenseProduct() {
     System.out.println("Please collect the change first.");
    }

    @Override
    public void returnChange() {

        double change=vendingMachine.getTotalPayment()-vendingMachine.getSelectedProduct().getPrice();
        if(change>0) {
            System.out.println("Change return: "+change);
        }else{
            System.out.println("No change return");
        }
        vendingMachine.resetPayment();
        vendingMachine.resetSelectedProduct();
        vendingMachine.setState(vendingMachine.getIdleState());

    }
}
