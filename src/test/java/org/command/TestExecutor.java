package org.command;

import org.command.parameter.AuthParameter;
import org.junit.Test;

/**
 * Created by lee on 16/4/7.
 */
public class TestExecutor {

    @Test public void testStartup() {
        //        AuthParameter parameter=new AuthParameter();
        //        parameter.setUser("root");
        //        parameter.setPassword("");
        //        parameter.setPort(3306);
        //        parameter.setHost("localhost");
        System.out.println(MySqlCommander.startup());
    }

    @Test public void testStop() {
        AuthParameter parameter = new AuthParameter();
        parameter.setUser("root");
        parameter.setPassword("lbylbl23");
        parameter.setPort(3306);
        parameter.setHost("localhost");
        System.out.println(MySqlCommander.shutDown(parameter));
    }

}
