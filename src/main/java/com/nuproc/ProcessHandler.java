package com.nuproc;

import com.zaxxer.nuprocess.NuAbstractProcessHandler;
import com.zaxxer.nuprocess.NuProcess;

import java.nio.ByteBuffer;

/**
 * Created by lee on 16/4/1.
 */
public class ProcessHandler extends NuAbstractProcessHandler {
    private NuProcess nuProcess;

    @Override public void onStart(NuProcess nuProcess) {
        this.nuProcess=nuProcess;
        System.out.println("on start!!!");
    }

//    @Override public boolean onStdinReady(ByteBuffer buffer) {
//        buffer.put("hello world !".getBytes());
//        buffer.flip();
//        return false;
//    }

    @Override public void onStdout(ByteBuffer buffer, boolean closed) {
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        System.out.println(new String(bytes));
        nuProcess.closeStdin(true);
    }
}
