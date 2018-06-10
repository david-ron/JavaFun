package com.rest.tsdb;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class App {

	public static void main(String[] args) throws Exception {

		App http = new App();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();

		//System.out.println("\nTesting 2 - Send Http POST request");
	//	http.sendPost();

	}

	// HTTP GET request
	private void sendGet() throws Exception {

		String url = "https://reqres.in/api/users?page=2";

		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet request = new HttpGet(url);

		
		request.addHeader("Content-Type","application/json");

		HttpResponse response = client.execute(request);

		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + 
                       response.getStatusLine().getStatusCode());
		
		BufferedReader rd = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		//TODO
		ObjectMapper om = new ObjectMapper();
		JsonNode jN = om.readTree(result.toString());
		jN.get("first_name");
		System.out.println(jN.get("data"));
		System.out.println(result.toString());

	}

	// HTTP POST request
	private void sendPost() throws Exception {

		String url = "https://reqres.in/api/users";

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);

		// add header
		post.setHeader("Content-Type","application/JSON");

		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString((new Person(10,"dave",172)));
		//post.setEntity(new UrlEncodedFormEntity(json));
		StringEntity params =new StringEntity(json);
		post.setEntity(params);
		HttpResponse response = client.execute(post);
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + post.getEntity());
		System.out.println("Response Code : " + 
                                    response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());

	}

}
class Person{
	public Person(int age, String name, int height) {
		super();
		this.age = age;
		this.name = name;
		this.id = height;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return id;
	}
	public void setHeight(int height) {
		this.id = height;
	}
	private int age;
	private String name;
	private int id;
	
}