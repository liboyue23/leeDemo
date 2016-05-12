package com.nuproc;

import com.zaxxer.nuprocess.NuProcess;
import com.zaxxer.nuprocess.NuProcessBuilder;
import com.zaxxer.nuprocess.NuProcessHandler;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * Created by lee on 16/4/1.
 */
public class TestNuProcess {

    @Test
    public void test() throws InterruptedException {
        NuProcessBuilder pb=new NuProcessBuilder("javac");

        NuProcessHandler handler=new ProcessHandler();
        pb.setProcessListener(handler);

        NuProcess process=pb.start();

        ByteBuffer buffer=ByteBuffer.wrap("Hello ,world !".getBytes());
        buffer.flip();

        process.writeStdin(buffer);

        process.waitFor(0, TimeUnit.SECONDS);
    }

}
