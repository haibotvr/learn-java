package com.simon.learn.designpattern.proxy.dynamic.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author simon.wei
 */
public class Client {

    public static void main(String[] args) {

        Asian asian = new Asian();
        InvocationHandler handlerAsian = new WorldInvestigation(asian);
        Skin iAsian = (Skin) Proxy.newProxyInstance(asian.getClass().getClassLoader(), Asian.class.getInterfaces(), handlerAsian);
        iAsian.color();

//        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{ Skin.class });
//        try {
//            FileOutputStream os = new FileOutputStream("/Users/weihaibo/Downloads/$Proxy0.class");
//            os.write(bytes);
//            os.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        African african = new African();
//        InvocationHandler handlerAfrican = new WorldInvestigation(african);
//        Skin iAfrican = (Skin) Proxy.newProxyInstance(african.getClass().getClassLoader(), African.class.getInterfaces(), handlerAfrican);
//        iAfrican.color();
//
//        European european = new European();
//        InvocationHandler handlerEuropean = new WorldInvestigation(european);
//        Stature iEuropean = (Stature) Proxy.newProxyInstance(european.getClass().getClassLoader(), European.class.getInterfaces(), handlerEuropean);
//        iEuropean.height();

//        $Proxy0 proxy0 = new $Proxy0(handlerAsian);
//        proxy0.color();



    }
}
