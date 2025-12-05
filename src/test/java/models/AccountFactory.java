package models;

public class AccountFactory {

    public static Account get(){
        return Account.builder()
                .name("iuy")
                .sname("pkj;l")
                .lname(";klj")
                .phone("rtrtuy")
                .dolzn("o[dofkpdfkov")
                .inn("")
                .build();
    }
}
