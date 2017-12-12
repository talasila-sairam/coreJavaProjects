package com.producer.consumer;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {
public List<Integer> list;
int k = 0;
public ProducerConsumer() {
	list = new ArrayList<Integer>();
}
/*	public void produce() throws InterruptedException{ 
		synchronized (this) {
			System.out.println("producer starts producing the goods");
		for(int i = k;true;i++){
			
			if(list.size()>=4){
				wait();
				produce();
			}
			list.add(i);
			k++;
			System.out.println(list);
		}
		
	}
	}
	public void consume() throws InterruptedException{
		synchronized (this) {
			try{
				System.out.println("consumer starts consuming");
		for(int i=0;i<= list.size(); i++){
			list.remove(0);
			System.out.println(list);
		}	
		if(list.size() <= 1){
			notify();
			wait(2000);
			consume();
		}
	}catch(Exception e){
		}
  }
}*/

public void produce() throws InterruptedException{ 
	synchronized (this) {
	for(int i = 0;true;i++){
		if(list.size()>=4){
			System.out.println("producer  produces the goods");
			wait();
		}
		list.add(i);
		System.out.println(list);
	}	
}
}
public void consume() throws InterruptedException{
	Thread.sleep(1000);
	synchronized (this) {
		try{
	for(int i=0;true; i++){
		list.remove(0);
		System.out.println(list);
		if(list.size() <= 1){
			System.out.println("consumer consumed the goods");
			notify();
			wait(1000);
		}
	}	
}catch(Exception e){
	}
}
}
}