flume-ng-hornetq-channel
------------------------

Flume NG HornetQ Channel

Sample Flume config
-------------------

    agent.channels.cassandra-channel.type = com.btoddb.flume.channels.hornetq.HornetqChannel
    agent.channels.cassandra-channel.dataDir = /data/flume/server/flume-hornetq
    agent.channels.cassandra-channel.maxChannelSize = 10000000

Building HornetQ Channel
------------------------

The channel is built using Maven

   mvn clean package -P assemble-artifacts

... runs all junits and produces flume-ng-hornetq-channel-1.0.0-SNAPSHOT.jar and
    flume-ng-hornetq-channel-1.0.0-SNAPSHOT-dist.tar.gz

The tar contains all the dependencies needed, and then some.  See the list below regarding what is actually needed
to use the channel in the flume environment.

Runtime Dependencies
--------------------

* btoddb-utils* (found https://github.com/btoddb/btoddb-utils)
* hornetq-core*

