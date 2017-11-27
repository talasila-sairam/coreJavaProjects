import java.util.concurrent.Callable;


public class ThreadTest implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Task finished by another way of creating the thread");
		return "Task Finished";
	}

}
