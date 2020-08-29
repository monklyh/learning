package com.lyh.personal.demo.design.chain;

import java.util.Arrays;
import java.util.List;

public class Client {

    static  class HA extends ChainHandler{
        @Override
        public void handlerProcced() {
            System.out.println("procced by a");
        }
    }

    static  class HB extends ChainHandler{
        @Override
        public void handlerProcced() {
            System.out.println("procced by b");
        }
    }

    static  class HC extends ChainHandler{
        @Override
        public void handlerProcced() {
            System.out.println("procced by c");
        }
    }

    public  static void main(String[] args){
        List<ChainHandler> handlers = Arrays.asList(
                new HA(), new HB(), new HC()
        );
        Chain chain = new Chain(handlers);
        chain.excutedChain();

    }
}
