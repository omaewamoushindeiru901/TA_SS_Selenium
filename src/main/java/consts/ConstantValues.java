package consts;

public enum ConstantValues {
    IMPLICITLY_WAIT_VALUE(10);

    private final int value;
    ConstantValues(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }

}


