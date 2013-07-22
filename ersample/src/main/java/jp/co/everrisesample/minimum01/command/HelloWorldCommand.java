package jp.co.everrisesample.minimum01.command;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.S2ContainerFactory;

public class HelloWorldCommand{
    /**
     * @param args
     */
    public static void main(String[] args){
        //SingletonS2ContainerFactory.init();
        S2ContainerFactory.configure("app.dicon");
        S2Container container = S2ContainerFactory.getConfigurationContainer();
        HelloWorldCommand helloWorldCommand = (HelloWorldCommand) container.getComponent(HelloWorldCommand.class);
        helloWorldCommand.execute();
    }
    
    public void execute(){
        System.out.println("Hello world. Hello command");
    }
}
