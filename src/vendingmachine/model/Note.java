package vendingmachine.model;

public enum Note {
        ONE(1),
        FIVE(5),
        TEN(10),
        TWENTY(20);
        private int value;
        private Note(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
}
