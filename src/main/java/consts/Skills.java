package consts;

public enum Skills {
    JAVA("Java","JAVA"),RUBY("Ruby","RUBY");

    private final String skillLowerCase;
    private final String skillUpperCase;
    Skills(String skillLowerCase,String skillUpperCase){
        this.skillLowerCase =skillLowerCase;
        this.skillUpperCase=skillUpperCase;
    }

    public String getSkillLowerCase() {
        return skillLowerCase;
    }
    public String getSkillUpperCase() {
        return skillUpperCase;
    }


}
