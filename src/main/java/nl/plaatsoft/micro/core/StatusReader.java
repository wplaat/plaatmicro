package nl.plaatsoft.micro.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import nl.plaatsoft.micro.dao.Status;
import nl.plaatsoft.micro.dao.Subscription;

/**
 * The Class StatusReader.
 * 
 * @author wplaat
 */
public class StatusReader implements Observer {
	
	/** The subscription. */
	private Subscription subscription;
	
	/** The config. */
	private Config config;
	
	/**
	 * Instantiates a new status reader.
	 *
	 * @param config the config
	 * @param subscription the subscription
	 */
	public StatusReader(Config config, Subscription subscription) {
		super();
		this.config = config;
		this.subscription = subscription;
	}
	
	/** The Constant log. */
	private static final Logger log = LogManager.getLogger( StatusReader.class);
	
	/**
	 * To json.
	 *
	 * @param config the config
	 * @param subscription the subscription
	 * @param status the status
	 * @return the string
	 */
	private static String toJson(Config config, Subscription subscription, Status status) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		JSONObject header = new JSONObject();
		header.put("msgId", UUID.randomUUID());
		header.put("source", config.getSourceId());
		header.put("destination", subscription.getDestination());
		header.put("created", simpleDateFormat.format(new Date()));
				
		JSONObject body = new JSONObject();
		body.put("dt", simpleDateFormat.format(status.getTimestamp()));
		body.put("status", status.getState());
		body.put("uid", status.getId());
	   		 	
		JSONObject msg = new JSONObject();
		msg.put("header", header);
		msg.put("body", body);
		
	   	JSONObject obj2 = new JSONObject();
		obj2.put("plaatmicro_status_publish", msg);
			 	   
	   	return obj2.toString();
	}
	
	/**
	 * Update.
	 *
	 * @param obj the obj
	 * @param arg the arg
	 */
	public void update(Observable obj, Object arg) {
		
		Status status = (Status) arg;
		
		String msg = toJson(config, subscription, status);
		log.info(msg);
    }
}
