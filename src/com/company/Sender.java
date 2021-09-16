package com.company;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
public class Sender {

	public static void get(String targetURL, String urlParameters) throws Exception {
		URL obj = new URL(targetURL + "?" + urlParameters);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept-Charset", "UTF-8");
		System.out.println("\nSending 'GET' request to URL : " + obj);
		System.out.println("Response Code : " + con.getResponseCode());
		System.out.println("Response Message : " + con.getResponseMessage());
		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String line;
		StringBuffer response = new StringBuffer();
		while ((line = in.readLine()) != null) {
			response.append(line);
		}
		in.close();
		System.out.println(response);
	}

	public static void post(String targetURL, String urlParameters) throws Exception {
		HttpURLConnection con = null;
		URL obj = new URL(targetURL);
		con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Accept-Language", "UTF-8");
		con.setDoOutput(true);
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(con.getOutputStream());
		outputStreamWriter.write(urlParameters);
		outputStreamWriter.flush();
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + obj);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		System.out.println(response);
	}

	public static void put(String targetURL, String urlParameters) throws Exception {
		HttpURLConnection con = null;
		URL obj = new URL(targetURL);
		con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("PUT");
		con.setRequestProperty("Accept-Language", "UTF-8");
		con.setDoOutput(true);
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(con.getOutputStream());
		outputStreamWriter.write(urlParameters);
		outputStreamWriter.flush();
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'PUT' request to URL : " + obj);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		System.out.println(response);
	}


	// Work but Did not use
	public static void send(String targetURL, String methodName) throws IOException {
		URL obj = new URL(targetURL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

//		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//		wr.writeBytes("Name: jone");
//		wr.flush();
//		wr.close();

		con.setRequestMethod(methodName);
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
			System.out.println(con.getResponseMessage());

		}
		else {
			System.out.println("GET request not worked");
		}

	}

	// Work but Did not use
	public static String executePost(String targetURL, String urlParameters, String method) {
		HttpURLConnection connection = null;
		try {
			//Create connection
			URL url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Content-Length", Integer.toString(urlParameters.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");
			connection.setUseCaches(false);
			connection.setDoOutput(true);

			//Send request
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			//Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\n');
			}
			rd.close();

			return response.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
}
