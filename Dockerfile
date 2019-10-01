FROM nimmis/java-centos:oracle-8-jdk
MAINTAINER Saurabh Saxena, sau.5rabh88@gmail.com

COPY target/kafka-storm-redis*.jar /opt/saurabh-slacklife/kafka-storm-redis.jar

ENV JVM_FLAGS ""

EXPOSE 9047

# CMD should use "shell" form (without []) otherwise environment variables won't be expanded
CMD java $JVM_FLAGS -jar /opt/saurabh-slacklife/kafka-storm-redis.jar
