package com.zb.test.testmain;

import org.springframework.lang.Nullable;

public class BaiLiNonNullDemo {
    public static void printString(@Nullable String str) {
        System.out.println(str.toString());
    }

    @Nullable
    public static String getString() {
        return null;
    }

    public static void main(String[] args) {
        String str = null;
        printString(str);
        getString().toString();

//        User user = new User(null, 5, null);
//        user.getAddress().getCity();
    }
}
