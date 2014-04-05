package taller.storm;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;


public class HelloWorldTopology {

	
	public static void main(String[] args) throws Exception {
		
		//Definición de la topología
		TopologyBuilder builder = new TopologyBuilder();
        
        builder.setSpout("randomHelloWorld", new HelloWorldSpout(), 1);        
        builder.setBolt("HelloWorldBolt", new HelloWorldBolt(), 1)
                .shuffleGrouping("randomHelloWorld");
        
        //Configuración
        Config conf = new Config();
        conf.setDebug(false);
        
        //Creamos el cluster local
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("prueba", conf, builder.createTopology());
           
        
	}

}