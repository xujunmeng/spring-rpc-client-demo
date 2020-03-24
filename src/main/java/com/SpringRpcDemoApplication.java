package com;

import junmeng.common.IUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * @author james
 * @date 2020/3/24
 */
@SpringBootApplication
public class SpringRpcDemoApplication {

    /**
     * 客户端调用远程服务
     * @return
     */
    @Bean
    public RmiProxyFactoryBean userRmiServiceProxy() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        //接收的rmi协议
        rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:1199/userRmiService");
        //接收的rmi协议的接口
        rmiProxyFactoryBean.setServiceInterface(IUserService.class);
        return rmiProxyFactoryBean;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringRpcDemoApplication.class, args);
        IUserService userService = context.getBean(IUserService.class);
        System.out.println(userService.findByName("aa"));
    }

}
