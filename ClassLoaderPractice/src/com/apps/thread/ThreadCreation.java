package com.apps.thread;

import java.util.concurrent.Callable;

public class ThreadCreation implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("Thread started");
		return "Finished by Thread";
	}

}
