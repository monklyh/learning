package com.lyh.personal.demo.design.chain;

import java.util.List;

public class Chain {

    List<ChainHandler> handlerList ;

    int index = 0;

    public Chain(List<ChainHandler> h){
        this.handlerList = h;
    }

    public void  excutedChain(){
        if (index >= handlerList.size()){
            return;
        }
        handlerList.get(index++).excecuted(this);

    }

}
