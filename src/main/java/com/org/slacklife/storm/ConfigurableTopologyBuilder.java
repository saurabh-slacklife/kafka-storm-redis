package com.org.slacklife.storm;

import org.apache.storm.generated.StormTopology;
import org.apache.storm.topology.BoltDeclarer;
import org.apache.storm.topology.IBasicBolt;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.IRichSpout;
import org.apache.storm.topology.IRichStateSpout;
import org.apache.storm.topology.SpoutDeclarer;
import org.apache.storm.topology.TopologyBuilder;

import java.util.Map;

public class ConfigurableTopologyBuilder {

    private Map<String, String> stormConfig;

    private TopologyBuilder topologyBuilderDelegator;

    public ConfigurableTopologyBuilder(Map<String, String> stormConfig) {
        stormConfig = stormConfig;
        topologyBuilderDelegator = new TopologyBuilder();
    }


    public StormTopology createTopology(){
        return topologyBuilderDelegator.createTopology();
    }

    public BoltDeclarer setIRichBolt(String boltId, IRichBolt bolt) {
        return this.topologyBuilderDelegator.setBolt(boltId, bolt, getDefaultBoltParallelismHint());
    }

    public BoltDeclarer setIRichBolt(String boltId, IRichBolt bolt, Number parallelismHint) {
        return this.topologyBuilderDelegator.setBolt(boltId, bolt, parallelismHint);
    }

    public BoltDeclarer setIBasicBolt(String boltId, IBasicBolt bolt) {
        return this.topologyBuilderDelegator.setBolt(boltId, bolt, getDefaultBoltParallelismHint());
    }

    public BoltDeclarer setIBasicBolt(String boltId, IRichBolt bolt, Number parallelismHint) {
        return this.topologyBuilderDelegator.setBolt(boltId, bolt, parallelismHint);
    }

    public SpoutDeclarer setIRichSpout(String spoutId, IRichSpout iRichSpout) {
        return this.topologyBuilderDelegator.setSpout(spoutId, iRichSpout, getDefaultSpoutParallelismHint());
    }

    public SpoutDeclarer seIRichSpout(String spoutId, IRichSpout iRichSpout, Number parallelismHint) {
        return this.topologyBuilderDelegator.setSpout(spoutId, iRichSpout, parallelismHint);
    }

    public void setStateSpout(String spoutId, IRichStateSpout iStateSpout) {
        this.topologyBuilderDelegator.setStateSpout(spoutId, iStateSpout, getDefaultSpoutParallelismHint());
    }

    public void seStateSpout(String spoutId, IRichStateSpout iStateSpout, Number parallelismHint) {
        this.topologyBuilderDelegator.setStateSpout(spoutId, iStateSpout, parallelismHint);
    }


    private Number getDefaultBoltParallelismHint() {
        return Integer.valueOf(this.stormConfig.get("topology.default.bolt.num.task"));
    }

    private Number getDefaultSpoutParallelismHint() {
        return Integer.valueOf(this.stormConfig.get("topology.default.spout.num.task"));
    }


}
