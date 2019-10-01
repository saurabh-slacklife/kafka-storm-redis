# kafka-storm-redis

#### Configure Zookeeper

````
The number of milliseconds of each tick
**tickTime=2000**

The number of ticks that the initial 
synchronization phase can take
**initLimit=10**

The number of ticks that can pass between 
sending a request and getting an acknowledgement
**syncLimit=5**

the directory where the snapshot is stored.
do not use /tmp for storage, /tmp here is just 
example sakes.
**dataDir=/tmp/zookeeper**

the port at which the clients will connect
**clientPort=2181**
````

#### Run Zookeeper in supervision

````
zkServer.sh start-foreground
````

#### Setup Storm cluster

##### Create dedicated storm user
````
$ sudo groupadd -g 53001 storm
$ sudo mkdir -p /opt/home
$ sudo useradd -u 53001 -g 53001 -d /opt/home/storm -s /bin/bash storm -c "Storm service account"
$ sudo chmod 700 /opt/home/storm
$ sudo chage -I -1 -E -1 -m -1 -M -1 -W -1 -E -1 storm
````

##### Setup Storm Local Directory to be used by Nimbus and Storm
````
$ sudo chown -R storm:storm /opt/home/storm
$ sudo chmod 750 /opt/home/storm
````

