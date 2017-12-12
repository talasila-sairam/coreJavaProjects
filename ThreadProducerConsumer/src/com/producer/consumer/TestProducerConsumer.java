package com.producer.consumer;

public class TestProducerConsumer {
   public static void main(String[] args) {
	   ProducerConsumer producerConsumer = new ProducerConsumer();
	Runnable runnable1 = new Runnable() {
		@Override
		public void run() {
			try {
				producerConsumer.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	};
	Runnable runnable2 = new Runnable() {
		@Override
		public void run() {
			try {
				producerConsumer.consume();
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
	};
	
	Thread producer = new Thread(runnable1);
	Thread consumer = new Thread(runnable2);
	producer.start();
	consumer.start();
	
}
}
