package com.btoddb.flume.channels.hornetq;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.flume.Event;
import org.apache.flume.Transaction;
import org.apache.flume.event.EventBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.Files;

public class HornetqChannelTest {
    private static final String HORNETQ_DIR_HOME = "target/hornetq";

    @Test
    public void test() {
        HornetqChannel channel = new HornetqChannel();
        channel.setQueueName("junit");
        channel.setMaxChannelSize(1000);
        channel.setMaxPutWaitTime(1000);
        channel.setDataDir(HORNETQ_DIR_HOME);
        channel.configure(null);
        channel.start();

        Transaction tx = channel.getTransaction();
        tx.begin();
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("todd", "burruss");
        Event evt1 = EventBuilder.withBody("foo".getBytes(), headerMap);
        channel.put(evt1);
        tx.commit();
        tx.close();

        tx = channel.getTransaction();
        tx.begin();
        Event evt2 = channel.take();
        assertNotNull(evt2);
        tx.commit();
        tx.close();

        tx = channel.getTransaction();
        tx.begin();
        evt2 = channel.take();
        assertNull(evt2);
        tx.commit();
        tx.close();

        channel.stop();
    }

    // ----------

    @Before
    public void setup() throws Exception {
        cleanup();
    }

//    @After
    public void cleanup() throws Exception {
        try {
            Files.deleteRecursively(new File(HORNETQ_DIR_HOME));
        }
        catch (Throwable e) {
            // ignore
        }
    }
}
