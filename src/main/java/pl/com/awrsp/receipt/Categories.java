package pl.com.awrsp.receipt;

public enum Categories {
    FOOD("Food"),
    BILLS("Bills"),
    FUEL("Fuel"),
    ENTERTAIMENT("Entertaiment"),
    CLOTHING("Clothing"),
    MEDICAL("Medical"),
    OTHER("Other");


    private String text;

    Categories(String text) {
        this.text = text;
    }

    public String getText(){
        return text;
    }
}
