package com.lyh.personal.demo.design.proxy.dynamic;

public class Caller implements Call{
    @Override
    public void call() {
        System.out.println("calling the moving tank...");
    }

    @Override
    public void recviced(String mess) {
        System.out.println("recivered the tank replaied: " + mess);
    }
}
