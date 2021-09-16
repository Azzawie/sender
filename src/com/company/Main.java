package com.company;

public class Main {

	public static void main(String[] args){

		try {
			Sender.get("http://localhost:9991/test", "name=ali");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Sender.post("http://localhost:9991/test", "name=ali");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Sender.put("http://localhost:9991/test", "name=ali");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
