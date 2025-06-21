package vendingmachine.state;

import vendingmachine.model.Coin;
import vendingmachine.model.Note;
import vendingmachine.model.Product;

public interface VendingMachineState {
    void selectProduct(Product product);
    void insertCoin(Coin coin);
    void insertNote(Note note);
    void dispenseProduct();
    void returnChange();
    //VendingMachineState getState();
}
