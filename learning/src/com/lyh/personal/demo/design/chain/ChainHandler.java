package com.lyh.personal.demo.design.chain;

public abstract class ChainHandler {

    public void excecuted(Chain chain){
        handlerProcced();
        chain.excutedChain();
    }


    public abstract void handlerProcced();

}
