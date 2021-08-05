package consts;

public enum Locations {
    LVIV("Ukraine","Lviv")
    ;

    private final String country;
    private final String city;

    Locations(String country, String city){
        this.country=country;
        this.city=city;
    }

    public String getCountry() {
        return country;
    }
    public String getCity() {
        return city;
    }
}
