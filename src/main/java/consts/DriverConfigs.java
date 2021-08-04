package consts;

public enum DriverConfigs {
    CHROME("webdriver.chrome.driver","src/main/resources/chromedriver.exe","CHROME"),
    EDGE("webdriver.edge.driver","src/main/resources/msedgwdriver.exe","EDGE"),
    MOZILLA("webdriver.gecko.driver","src/main/resources/geckodriver.exe","MOZILLA")
    ;

    private final String browserName;
    private final String name;
    private final String path;
    DriverConfigs(String name, String path, String browserName){
        this.name=name;
        this.path=path;
        this.browserName=browserName;
    }


    public String getName() {
        return name;
    }
    public String getPath(){return path;}
    public String getBrowserName() {
        return browserName;
    }
}
