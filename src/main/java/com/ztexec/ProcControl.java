package com.ztexec;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.ProcessResult;
import org.zeroturnaround.exec.stream.slf4j.Slf4jStream;
import org.zeroturnaround.process.PidProcess;
import org.zeroturnaround.process.PidUtil;
import org.zeroturnaround.process.Processes;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by lee on 16/3/31.
 */
public class ProcControl {

    @Test
    public void testjVersion(){
        try {
//            new ProcessExecutor().command("open","/Users/lee/development/eclipse/Eclipse.app").execute();
            new ProcessExecutor().command("sh","/Users/lee/development/apache-tomcat-7.0.59/bin/startup.sh").execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testExit(){
        try {
            int exit = new ProcessExecutor().command("java", "-version")
                    .execute().getExitValue();
            System.out.println(exit);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testslf4j(){
        try {
            ProcessResult result = new ProcessExecutor().command("jps")
                    .redirectOutput(Slf4jStream.of(LoggerFactory.getLogger(getClass().getName() + ".MyProcess"))
                            .asInfo())
                    .execute();
            System.out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUtf(){
        try {
            new ProcessExecutor().command("java", "-version")
                    .redirectOutput(Slf4jStream.ofCaller().asInfo()).execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReturn(){
        try {
            String output = new ProcessExecutor().command("javac")
                    .redirectError(Slf4jStream.of(getClass()).asInfo())
                    .readOutput(true).execute()
                    .outputUTF8();
            System.out.println(output);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }


    public static Integer calc(Integer para){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return para*para;
    }

//    @Test
//    public void testCompleteFuture(){
//        final CompletedFuture
//    }

    @Test
    public void testKill(){
        int pid = PidUtil.getMyPid();
        System.out.println("My PID is " + pid);
    }

    @Test
    public void testcheckPid() throws IOException, InterruptedException {
        int pid = Integer.parseInt(FileUtils.readFileToString(new File("pidfile")));
        PidProcess process = Processes.newPidProcess(pid);
        boolean isAlive = process.isAlive();
        System.out.println("PID " + pid + " is alive: " + isAlive);
    }

    @Test
    public void testFuture() throws IOException, InterruptedException, ExecutionException, TimeoutException {
        Future<ProcessResult> future=new ProcessExecutor().command("java","version").readOutput(true)
                .start().getFuture();
        Thread.sleep(5000);
        System.out.println("doing");
        ProcessResult processResult = future.get(10, TimeUnit.SECONDS);
        System.out.println("finish "+processResult.outputUTF8());

    }

}
