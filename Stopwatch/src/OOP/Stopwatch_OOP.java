package OOP;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Stopwatch_OOP {
	public static boolean flag_pause = false;
	public static boolean flag_stop = true;
	
	static Task task;
	static Thread taskThread;
	
	public static void checkState(String state){

		switch(state){
			case "start":
				startWatch();
				break;
			case "pause":
				pauseWatch();
				break;
			case "resume":
				resumeWatch();
				break;
			case "reset":
				resetWatch();
				break;
			case "stop":
				stopWatch();
				break;
			}
	}
		
	public static void startWatch(){
		if(flag_stop){
			flag_stop = false;
			flag_pause = false;
			
			task = new Task();
			taskThread = new Thread(task);
			taskThread.start();
		}
	}
	
	public static void pauseWatch(){
		if(!flag_stop){
			flag_pause = true;
			task.pause = true;
		}
	}
	
	public static void resumeWatch(){
		flag_pause = false;
		synchronized(task){
			task.pause = false;
			task.notifyAll();
		}
	}
	
	public static void resetWatch(){
		if(flag_stop || flag_pause){
			flag_stop = true;
			startWatch();
		}
	}
	
	public static void stopWatch(){
		if(!flag_stop)
		{
			flag_stop = true;
			flag_pause = false;

			taskThread.interrupt();
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Use the next commands to control the stopwatch: \n 1. start \n 2. pause \n 3. resume \n 4. reset \n 5. stop");
		
		while(true){
			String input = in.nextLine();
			checkState(input);
		}
		
	}

	public static class Task implements Runnable{
		public boolean pause = false;
		int count = 1;
		
		@Override
		public void run() {
			
			while(true){
				if(!pause){
					System.out.println(count++);
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						System.out.println("stopped!");
						count = 1;
						return;
					}
				}
				else if (pause){
					try {
						synchronized(this){
							wait();
						}
					} catch (InterruptedException e) {
						System.out.println("stopped!");
						count = 1;
						return;
					}
				}
			}
		}
		
	}
}