package consts;

public enum DriverConfigs {
    CHROME("webdriver.chrome.driver","src/main/resources/chromedriver.exe"),
    EDGE("webdriver.edge.driver","src/main/resources/msedgwdriver.exe"),
    MOZILLA("webdriver.gecko.driver","src/main/resources/geckodriver.exe")
    ;

    private String name;
    private String path;
    DriverConfigs(String name, String path){
        this.name=name;
        this.path=path;
    }


    public String getName() {
        return name;
    }
    public String getPath(){return path;}

}
