package dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name="nonValidEmails")
    public static Object[][]dataProviderMethod(){
        return new Object[][]{
                {"Without @ symbol .","1234.com"},
                {"@ in the beginning","@1234.com"},
                {"Without dot symbol","1234@gmailcom"},
                {"More than 64 symbols","123456789012345678901234567890123456789012345678901234567890@gmail.com"},
                {"Domain has 1 symbol","1234@gmail.u"}};
    }
    @DataProvider(name="validEmails")
    public static Object[][]dataProviderMethodForBoundaries(){
        return new Object[][]{
                {"64 characters .","1234567890123456789012345678901234567890123456789012345678901234@gmail.com"},
                {"63 characters .","123456789012345678901234567890123456789012345678901234567890123@gmail.com"},
                {"2 characters in domain .","1234@gmail.ua"},
                {"3 characters in domain .","1234@gmail.com"},
                {"9 characters in domain .","1234@gmail.uaaaaaaaa"},
                {"10 characters in domain .","1234@gmail.uaaaaaaaaa"}};
    }

    @DataProvider(name="validCredentials")
    public static Object[][] credentialsForSignIn(){
        return new Object[][]{
                {"ivanhorintest@gmail.com","ivanhorintestPassword"}
        };
    }

    @DataProvider(name="invalidCredentials")
    public static Object[][] invalidCredentialsForSignIn(){
        return new Object[][]{
                {"ivanhorintest@gmail.com","ivanhorintestPassworddd"}
        };
    }
}
