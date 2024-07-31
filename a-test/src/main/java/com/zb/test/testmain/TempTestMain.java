package com.zb.test.testmain;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class TempTestMain {

    public static void main(String[] args) {
        Integer a= 9;
        Optional<Integer> result = Optional.ofNullable(a);
        log.info("over");
    }

}
