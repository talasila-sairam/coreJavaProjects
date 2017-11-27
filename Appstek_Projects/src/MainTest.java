import java.util.concurrent.FutureTask;
public class MainTest {
public static void main(String[] args) {
	ThreadTest tt=new ThreadTest();
	  FutureTask futureTask = new FutureTask(tt);
	  futureTask.run();
	  System.out.println("hi");
	  try {
	   System.out.println(futureTask.get());
	  } catch (Exception e) {
	  }
}
}
