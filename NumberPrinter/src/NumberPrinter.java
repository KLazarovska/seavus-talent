
public class NumberPrinter {

	public static void main(String[] args) throws Exception{
		
		int number = Integer.parseInt(args[0]);
		int interval = Integer.parseInt(args[1]);
		
		final NumberTask task = new NumberTask(number);
		final Thread taskThread = new Thread(task);
		taskThread.start();
		
		System.out.println("Waiting for the task to finish");
		taskThread.join(interval);
		System.out.println("Interrupt task");
		taskThread.interrupt();
	}


	
	public static class NumberTask implements Runnable{

		int number;
		
		public NumberTask(int number){
			this.number = number;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			int i = 0;
			
			while(i < number){
				if(Thread.interrupted()){
					return;
				}
				else{
					System.out.println(i++);
				}
			}
		}

	}
}
