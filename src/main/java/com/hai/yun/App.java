package com.hai.yun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {

    private static MinaTcpServer minaTcpServer;

    static Logger logger= LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        

        try {
            minaTcpServer = new MinaTcpServer();
            Thread.sleep(1000);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
