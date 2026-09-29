package org.mobileOp.main;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.mobileOp.config.AppConfig;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        int port = 8080;
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.getConnector();

        // Create docBase directory if it doesn't exist
        File docBase = new File("src/main/webapp");
        if (!docBase.exists()) {
            docBase.mkdirs();
        }

        Context ctx = tomcat.addContext("", docBase.getAbsolutePath());

        // Configure Spring Web Application Context
        AnnotationConfigWebApplicationContext appCtx = new AnnotationConfigWebApplicationContext();
        appCtx.register(AppConfig.class);

        // Register Spring DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(appCtx);
        Tomcat.addServlet(ctx, "dispatcher", dispatcherServlet);
        ctx.addServletMappingDecoded("/", "dispatcher");

        System.out.println("Starting Embedded Tomcat server on http://localhost:" + port + " ...");
        tomcat.start();
        System.out.println("Server started successfully! Spring MVC APIs available at http://localhost:" + port + "/api/...");
        tomcat.getServer().await();
    }
}
