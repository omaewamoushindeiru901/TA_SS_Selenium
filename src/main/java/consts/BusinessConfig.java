package consts;

public enum BusinessConfig {
    BASE_URL("https://training.by"),HOME_PAGE_URL("https://training.by/#/Home");

    private String url;

    BusinessConfig(String url){
        this.url=url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
