package com.seawave.algorithms;

public class EmailRegExp implements IAlgorithm {
    @Override
    public void execute() {
        // ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
        String email = "test.email+alex@leetcode.com";
        email = email.split("@")[0]
                .replaceAll("\\+\\S*", "")
                .replaceAll("\\.", "")
                + "@" + email.split("@")[1];
        System.out.println(email);
    }
}
