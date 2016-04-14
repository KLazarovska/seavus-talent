package procedural;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Stopwatch {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		
		Task task = new Task();
		Thread taskThread = new Thread(task);
		
		System.out.println("Use the next commands to control the stopwatch: \n 1. start \n 2. pause \n 3. resume \n 4. stop");
		String input = in.nextLine();
		
		while(true){
			switch(input){
				case "start":
					taskThread.start();
					break;
				case "pause":
					task.pause = true;
					break;
				case "resume":
					synchronized(task){
						task.pause = false;
						task.notifyAll();
					}
					break;
				case "stop":
					synchronized(task){
						taskThread.interrupt();
					}
					return;
			}
			input = in.nextLine();
		}

	}

	
	public static class Task implements Runnable{

		public boolean pause = false;
		public int count = 1;
		
		@Override
		public void run() {
			
			while(true){
				if(!pause){
					System.out.println(count++);
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						System.out.println("stopped!");
						return;
					}
				}
				else if (pause){
					try {
						synchronized(this){
							wait();
						}
					} catch (InterruptedException e) {
						e.getMessage();
					}
				}
			}
		}
	}
}
