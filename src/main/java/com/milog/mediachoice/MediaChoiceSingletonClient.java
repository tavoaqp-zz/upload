package com.milog.mediachoice;

import com.sun.jersey.api.client.Client;

public class MediaChoiceSingletonClient {
	
	private static MediaChoiceSingletonClient client;
	private Client restClient;
	
	private MediaChoiceSingletonClient(){
		restClient = Client.create();
		restClient.setFollowRedirects(true);
	}
	
	public Client getRestClient() {
		return restClient;
	}

	public void setRestClient(Client restClient) {
		this.restClient = restClient;
	}

	public synchronized static MediaChoiceSingletonClient getInstance(){
		if (client==null)
			client=new MediaChoiceSingletonClient();
		return client;
	}

}
