package vendingmachine.state;

import vendingmachine.VendingMachine;
import vendingmachine.model.Coin;
import vendingmachine.model.Note;
import vendingmachine.model.Product;

public class DispenseState implements VendingMachineState {

    private final VendingMachine vendingMachine;
    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(Product product) {
        System.out.println("Product is already selected.Please collect the dispense product");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Product is already selected.Please collect the dispense product");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Product is already selected.Please collect the dispense product");
    }

    @Override
    public void dispenseProduct() {
         Product product=vendingMachine.getSelectedProduct();
         vendingMachine.getInventory().updateProduct(product,vendingMachine.getInventory().getQuantity(product)-1);
        System.out.println("product dispensed "+product.getName());
        vendingMachine.setState(vendingMachine.getReturnChangeState());
    }

    @Override
    public void returnChange() {
        System.out.println("Product is already selected.Please collect the dispense product");
    }
}
