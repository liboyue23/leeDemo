package org.command;

import org.apache.commons.lang3.ArrayUtils;
import org.command.parameter.AuthParameter;
import org.command.util.StringFormat;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.stream.slf4j.Slf4jStream;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by lee on 16/4/7.
 */
public class MySqlCommander {

    private static final String MYSQL_SERVER = "mysql.server";

    public static String startup() {
        try {
            return new ProcessExecutor().command(new String[] { MYSQL_SERVER, "start" })
                    .redirectError(Slf4jStream.of(MySqlCommander.class).asInfo())
                    .redirectOutput(Slf4jStream.of(MySqlCommander.class).asInfo())
                    .readOutput(true)
                    .execute()
                    .outputUTF8();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String shutDown(AuthParameter parameter) {
        try {
            new ProcessExecutor().command(ArrayUtils.addAll(new String[] { MYSQL_SERVER, "stop" },
                    StringFormat.mysqlParameterFormat(parameter)))
                    .redirectError(Slf4jStream.of(MySqlCommander.class).asInfo())
                    .redirectOutput(Slf4jStream.of(MySqlCommander.class).asInfo())
                    .readOutput(true)
                    .execute()
                    .outputUTF8();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }
}
