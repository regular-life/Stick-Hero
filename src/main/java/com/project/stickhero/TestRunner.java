package com.project.stickhero;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result1 = JUnitCore.runClasses(Test.class);
        for (Failure failure : result1.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}