import com.apps.interfaces.LambdaInterface;

public class LambdaExpressionExample {
    public static void main(String[] args) {
		System.out.println("main method");
		LambdaInterface lamda = (a , b)->{
			System.out.println("add : "+(a+b));
			return a+b;
		};
		lamda.add(10, 20);
	}
}
