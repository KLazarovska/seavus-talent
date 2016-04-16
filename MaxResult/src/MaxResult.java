import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MaxResult {
	/**
	 * @param args
	 */
	private static final int NUMBER_OF_OPERATIONS = 10;

    public static void main(String[] args) throws Exception {
    	
    	final CountDownLatch latch = new CountDownLatch(NUMBER_OF_OPERATIONS);
        final ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_OPERATIONS);
    	ArrayList<Future<Integer>> complexCalculationFuture = new ArrayList<Future<Integer>>();
        for (int i = 1; i <= NUMBER_OF_OPERATIONS; i++) {
        	complexCalculationFuture.add(executorService.submit(new ComplexCalculation(i, latch)));
        }

        System.out.println("Waithing for all complex operations to finish...");
        latch.await();
        System.out.println("All complex operations finished.");
    	
    	int max = 0;
    	for(Future<Integer> future : complexCalculationFuture){
    		Integer complexCalculationResult = future.get();
            System.out.println("Complex calculation result is " + complexCalculationResult);
    		if (max < complexCalculationResult){
    			max = complexCalculationResult;
    		}
    	}
    	System.out.println("The max result is: " + max);

        executorService.shutdown();
    }

}
